package dric.dataset.mqtt;

import java.util.List;

import javax.annotation.concurrent.GuardedBy;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import utils.func.Try;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttSessionFactory {
	private static final Logger s_logger = LoggerFactory.getLogger(MqttSessionFactory.class);
	private static final int DEFAULT_CONNECT_TIMEOUT = 10;
	
	private final String m_brokerHost;
	private final int m_brokerPort;
	private final String m_clientId;
	private final MqttConnectOptions m_opts;
	private boolean m_autoReconnect = false;
	
	private static final List<MqttSession> s_shutdownHooks = Lists.newCopyOnWriteArrayList();
	static {
    	Runtime.getRuntime().addShutdownHook(new Thread() {
    		public void run() {
    			List<MqttSession> sessions = Lists.newArrayList();
    			synchronized ( s_shutdownHooks ) {
    				sessions.addAll(s_shutdownHooks);
    			}
    			
    			s_logger.info("starting cleaning up {} Mqtt Sessions...", sessions.size());
    			for ( MqttSession session: sessions ) {
    				Try.run(session::close);
    			}
    			s_logger.info("finished Mqtt Session cleanup...");
    		}
    	});
	}
	
	public MqttSessionFactory(String host, int port, String clientId) {
		m_brokerHost = host;
		m_brokerPort = port;
		m_clientId = clientId;
		
		m_opts = new MqttConnectOptions();
		m_opts.setCleanSession(true);
		m_opts.setConnectionTimeout(DEFAULT_CONNECT_TIMEOUT);
	}
	
	public MqttSessionFactory setAutoReconnect(boolean flag) {
		m_opts.setAutomaticReconnect(flag);
		m_autoReconnect = flag;
		return this;
	}
	
	public MqttSessionFactory setConnectTimeout(int nsecs) {
		m_opts.setConnectionTimeout(nsecs);
		return this;
	}
	
	public MqttSession create() throws MqttException {
		return new MqttSession();
	}
	
	@Override
	public String toString() {
		return String.format("MqttServer: %s:%d, client=%s", m_brokerHost, m_brokerPort, m_clientId);
	}
	
	public class MqttSession implements AutoCloseable {
		@GuardedBy("this") private IMqttClient m_client;
		@GuardedBy("this") private String m_topic;
		@GuardedBy("this") private IMqttMessageListener m_listener;
		
		public MqttSession() throws MqttException {
			String brokerUrl = String.format("tcp://%s:%d", m_brokerHost, m_brokerPort);
			m_client = new MqttClient(brokerUrl, m_clientId);
			m_client.setCallback(m_callback);
			
			while ( true ) {
				s_logger.debug("connecting to {}...", MqttSessionFactory.this);
				try {
					m_client.connect(m_opts);
					s_logger.info("connected to {}", MqttSessionFactory.this);
					
					synchronized ( s_shutdownHooks ) {
						s_shutdownHooks.add(this);
					}
					break;
				}
				catch ( MqttException e ) {
					if ( !m_autoReconnect ) {
						throw e;
					}
				}
			}
		}

		@Override
		public synchronized void close() throws Exception {
			if ( m_client != null ) {
				IMqttClient client = m_client;
				m_client = null;
				
				s_logger.info("cleaning-up MqttSession: {}...", this);
				Try.run(() -> {
					client.disconnect();
					client.close();
				});
				synchronized ( s_shutdownHooks ) {
					s_shutdownHooks.remove(this);
				}
			}
		}
		
		public synchronized boolean isConnected() {
			return m_client != null && m_client.isConnected();
		}
		
		public synchronized void subscribe(String topic, IMqttMessageListener msgListener) throws MqttException {
			m_client.subscribe(topic, msgListener);
			m_topic = topic;
			m_listener = msgListener;
		}

		public synchronized void publish(String topic, MqttMessage msg) throws MqttException {
			m_client.publish(topic, msg);
			m_topic = topic;
		}
		
		@Override
		public String toString() {
			return String.format("MqttSession: %s:%d, client=%s, topic=%s", m_brokerHost, m_brokerPort,
									m_clientId, m_topic);
		}
		
		private final MqttCallbackExtended m_callback = new MqttCallbackExtended() {
			@Override
			public void connectionLost(Throwable cause) {
				if ( s_logger.isInfoEnabled() ) {
					s_logger.info("connection lost: {}, cause={}", MqttSession.this, ""+cause);
				}
			}
			
			@Override
			public void connectComplete(boolean reconnect, String serverURI) {
				s_logger.info("connected: {}", MqttSession.this);
				
				if ( m_topic != null ) {
					try {
						m_client.subscribe(m_topic, m_listener);
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
}
