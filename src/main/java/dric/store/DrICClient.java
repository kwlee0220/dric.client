package dric.store;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.reactivestreams.Publisher;

import utils.func.Lazy;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClient {
	private final String m_id;
	private final DrICClientConfig m_config;
	private final Lazy<IMqttClient> m_mqttClient = Lazy.of(this::getMqttClient);
	
	public DrICClient(String id, DrICClientConfig config) {
		m_id = id;
		m_config = config;
	}
	
	public Publisher getPublisher() {
		return null;
	}
	
	private IMqttClient getMqttClient() {
		try {
			IMqttClient client = new MqttClient(m_config.messageBrokerUrl(), m_id);
			
			MqttConnectOptions options = new MqttConnectOptions();
			options.setAutomaticReconnect(true);
			options.setCleanSession(true);
			options.setConnectionTimeout(10);
			client.connect(options);
			
			return client;
		}
		catch ( MqttException e ) {
			throw new TopicException("" + e);
		}
	}
}
