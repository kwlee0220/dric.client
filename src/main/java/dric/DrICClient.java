package dric;

import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import com.google.common.collect.Maps;

import dric.grpc.PBDrICPlatformProxy;
import dric.proto.EndPoint;
import dric.store.TopicException;
import dric.topic.TopicClient;
import dric.topic.mqtt.MqttTopicClient;
import dric.video.PBDrICVideoServerProxy;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import utils.stream.KVFStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClient implements AutoCloseable {
	private final PBDrICPlatformProxy m_platform;
	
	private final Map<EndPoint,ManagedChannel> m_channels = Maps.newHashMap();
	
	public static DrICClient connect(EndPoint platformEndPoint) {
		return new DrICClient(platformEndPoint);
	}
	
	private DrICClient(EndPoint ep) {
		ManagedChannel channel = openChannel(ep);
		m_platform = new PBDrICPlatformProxy(channel);
	}
	
	@Override
	public void close() {
		KVFStream.from(m_channels)
				.forEachOrIgnore(kv -> kv.value().shutdown());
	}
	
	public PBDrICPlatformProxy getPlatform() {
		return m_platform;
	}
	
	public PBDrICVideoServerProxy getVideoServer() {
		EndPoint ep = m_platform.getServiceEndPoint("video_server");
		
		ManagedChannel channel = openChannel(ep);
		return new PBDrICVideoServerProxy(channel);
	}
	
	public EndPoint getServiceEndPoint(String name) {
		return m_platform.getServiceEndPoint(name);
	}
	
	public TopicClient getTopicClient(String clientId) {
		return new MqttTopicClient(getIMqttClient(clientId));
	}
	
	private IMqttClient getIMqttClient(String id) {
		try {
			EndPoint ep = m_platform.getServiceEndPoint("topic_server");
			String brokerUrl = String.format("tcp://%s:%d", ep.getHost(), ep.getPort());
			
			IMqttClient client = new MqttClient(brokerUrl, id);
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
	
	private ManagedChannel openChannel(EndPoint ep) {
		ManagedChannel channel = m_channels.get(ep);
		if ( channel == null ) {
			channel = ManagedChannelBuilder.forAddress(ep.getHost(), ep.getPort())
											.usePlaintext()
											.build();
			m_channels.put(ep, channel);
		}
		
		return channel;
	}
}
