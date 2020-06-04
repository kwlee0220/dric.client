package dric.store;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import dric.DricClientConfig;
import utils.func.Lazy;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClient {
	private final String m_id;
	private final DricClientConfig m_config;
	private final Lazy<IMqttClient> m_mqttClient = Lazy.of(this::createMqttClient);
	
	public DrICClient(String id, DricClientConfig config) {
		m_id = id;
		m_config = config;
	}
	
	public IMqttClient getIMqttClient() {
		return m_mqttClient.get();
	}
	
	private IMqttClient createMqttClient() {
		try {
			IMqttClient client = new MqttClient(m_config.mqttConfig().brokerUrl(), m_id);
			
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
