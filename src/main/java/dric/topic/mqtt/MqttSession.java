package dric.topic.mqtt;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import javax.annotation.concurrent.GuardedBy;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.async.Guard;
import utils.func.Unchecked;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttSession implements AutoCloseable {
	private static final Logger s_logger = LoggerFactory.getLogger(MqttSession.class);
	private static final int DEFAULT_CONNECT_TIMEOUT = 10;
	
	private final String m_brokerHost;
	private final int m_brokerPort;
	private final String m_clientId;
	private final MqttConnectOptions m_opts;
	
	private final Guard m_guard = Guard.create();
	@GuardedBy("m_guard") public IMqttClient m_client;
	private String m_topic;
	private IMqttMessageListener m_msgListener;
	
	public MqttSession(String host, int port, String clientId) {
		m_brokerHost = host;
		m_brokerPort = port;
		m_clientId = clientId;
		
		m_opts = new MqttConnectOptions();
		m_opts.setCleanSession(true);
		m_opts.setConnectionTimeout(DEFAULT_CONNECT_TIMEOUT);
	}

	@Override
	public void close() throws Exception {
		m_guard.lock();
		try {
			if ( m_client != null ) {
				m_client.close();
				m_client = null;
			}
		}
		finally {
			m_guard.unlock();
		}
	}
	
	public MqttSession(String host, int port) {
		this(host, port, UUID.randomUUID().toString());
	}
	
	public boolean isConnected() {
		return m_client.isConnected();
	}
	
	public MqttSession setAutoReconnect(boolean flag) {
		m_opts.setAutomaticReconnect(flag);
		return this;
	}
	
	public MqttSession setConnectTimeout(int nsecs) {
		m_opts.setConnectionTimeout(nsecs);
		return this;
	}
	
	public void create() throws MqttException {
		m_guard.lock();
		try {
			if ( m_client == null ) {
				String brokerUrl = String.format("tcp://%s:%d", m_brokerHost, m_brokerPort);
				m_client = new MqttClient(brokerUrl, m_clientId);
				m_client.setCallback(m_callback);
			}
		}
		finally {
			m_guard.unlock();
		}
	}
	
	public void connect(boolean retry) throws MqttException {
		create();
		
		while ( true ) {
			try {
				getClient().connect(m_opts);
				break;
			}
			catch ( MqttException e ) {
				if ( !retry ) {
					throw e;
				}
			}
		}
	}
	
	public void connectAsync(boolean retry) {
		CompletableFuture.runAsync(Unchecked.sneakyThrow(() -> connect(retry)));
	}
	
	public void setCallback(MqttCallback cb) {
		getClient().setCallback(cb);
	}
	
	public void subscribe(String topic, IMqttMessageListener msgListener) throws MqttException {
		getClient().subscribe(topic, msgListener);
		
		m_topic = topic;
		m_msgListener = msgListener;
	}

	public void publish(String topic, MqttMessage msg) throws MqttException {
		getClient().publish(topic, msg);
	}
	
	@Override
	public String toString() {
		return String.format("MQTTSession[%s:%d, client=%s]", m_brokerHost, m_brokerPort, m_clientId);
	}
	
	private IMqttClient getClient() {
		m_guard.lock();
		try {
			if ( m_client == null ) {
				throw new IllegalArgumentException("MqttSession is not connected");
			}
			
			return m_client;
		}
		finally {
			m_guard.unlock();
		}
	}
	
	public IMqttClient awaitClient() throws InterruptedException {
		return m_guard.awaitUntilAndGet(() -> m_client != null, () -> m_client);
	}
	
	private final MqttCallbackExtended m_callback = new MqttCallbackExtended() {
		@Override
		public void connectionLost(Throwable cause) {
			if ( s_logger.isInfoEnabled() ) {
				s_logger.info("connection lost: cause=" + cause);
			}
		}
		
		@Override
		public void connectComplete(boolean reconnect, String serverURI) {
			s_logger.info("connected: " + this);
			
			if ( m_topic != null ) {
				try {
					m_client.subscribe(m_topic, m_msgListener);
				}
				catch ( MqttException e ) {
					s_logger.error("fails to subscribe: " + this, e);
				}
			}
		}
		
		@Override public void messageArrived(String topic, MqttMessage msg) throws Exception { }
		@Override public void deliveryComplete(IMqttDeliveryToken token) { }
	};
}
