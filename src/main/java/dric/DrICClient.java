package dric;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import dric.grpc.PBDrICPlatformProxy;
import dric.proto.ServiceEndPoint;
import dric.store.TopicException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import utils.func.Lazy;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClient {
	private final String m_id;
	private final ClientConfig m_config;
	private final PBDrICPlatformProxy m_platform;
	private final Lazy<IMqttClient> m_mqttClient = Lazy.of(this::createMqttClient);
	
	public static DrICClient connect(String id, ClientConfig config) {
		ServiceEndPoint sep = config.dricPlatformEndPoint();
		ManagedChannel channel = ManagedChannelBuilder.forAddress(sep.getHost(), sep.getPort())
													.usePlaintext()
													.build();
		PBDrICPlatformProxy proxy = new PBDrICPlatformProxy(channel);
		return new DrICClient(id, proxy, config);
	}
	
	private DrICClient(String id, PBDrICPlatformProxy proxy, ClientConfig config) {
		m_id = id;
		m_config = config;
		m_platform = proxy;
	}
	
	public IMqttClient getIMqttClient() {
		return m_mqttClient.get();
	}
	
	private IMqttClient createMqttClient() {
		try {
			ServiceEndPoint ep = m_platform.getTopicServerEndPoint();
			String brokerUrl = String.format("tcp://%s:%d", ep.getHost(), ep.getPort());
			
			IMqttClient client = new MqttClient(brokerUrl, m_id);
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
