package dric;

import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import com.google.common.collect.Maps;

import dric.grpc.PBDrICPlatformProxy;
import dric.proto.EndPoint;
import dric.proto.EndPointResponse;
import dric.store.TopicException;
import dric.topic.TopicClient;
import dric.topic.mqtt.MqttTopicClient;
import dric.video.PBDrICVideoServerProxy;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import utils.Throwables;
import utils.Utilities;
import utils.grpc.PBUtils;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClient {
	private static final String PLATFORM = "platform";
	private static final String VIDEO_SERVER = "video_server";
	private static final String TOPIC_SERVER = "topic_server";
	
	private final Map<String,EndPoint> m_serviceEndPoints = Maps.newHashMap();
	
	public static DrICClient connect(EndPoint platformEndPoint) {
		return new DrICClient(platformEndPoint);
	}
	
	private DrICClient(EndPoint ep) {
		Utilities.checkNotNullArgument(ep);
		
		m_serviceEndPoints.put(PLATFORM, ep);
	}
	
	public PBDrICPlatformProxy getPlatform() {
		return new PBDrICPlatformProxy(openChannel(m_serviceEndPoints.get(PLATFORM)));
	}
	
	public PBDrICVideoServerProxy getVideoServer() {
		EndPoint ep = getServiceEndPoint(VIDEO_SERVER);
		return new PBDrICVideoServerProxy(openChannel(ep));
	}
	
	private EndPoint getServiceEndPoint(String name) {
		EndPoint ep = m_serviceEndPoints.get(name);
		if ( ep == null ) {
			try ( PBDrICPlatformProxy platform = getPlatform() ) {
				ep = handle(platform.getServiceEndPoint(name));
				m_serviceEndPoints.put(name, ep);
			}
		}
		
		return ep;
	}
	
	public TopicClient getTopicClient(String clientId) {
		return new MqttTopicClient(getIMqttClient(clientId));
	}
	
	private IMqttClient getIMqttClient(String id) {
		try {
			EndPoint ep = getServiceEndPoint(TOPIC_SERVER);
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
		return ManagedChannelBuilder.forAddress(ep.getHost(), ep.getPort())
											.usePlaintext()
											.build();
	}
	
	private static EndPoint handle(EndPointResponse resp) {
		switch ( resp.getEitherCase() ) {
			case END_POINT:
				return resp.getEndPoint();
			case ERROR:
				throw Throwables.toRuntimeException(PBUtils.toException(resp.getError()));
			default:
				throw new AssertionError();
		}
	}
}
