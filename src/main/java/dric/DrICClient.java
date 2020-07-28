package dric;

import java.util.List;
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
import dric.topic.mqtt.MqttAvroDataSet;
import dric.topic.mqtt.MqttTopicClient;
import dric.video.PBDrICVideoServerProxy;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import marmot.dataset.DataSet;
import marmot.dataset.DataSetType;
import marmot.remote.client.GrpcDataSetServerProxy;
import marmot.remote.client.GrpcMarmotRuntimeProxy;
import utils.CSV;
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
	private static final String MARMOT_SERVER = "marmot_server";
	
	private final EndPoint m_platformEndpoint;
	private final Map<String,EndPoint> m_endPointCache = Maps.newHashMap();
	
	public static DrICClient connect(String host, int port) {
		return new DrICClient(EndPoint.newBuilder()
										.setHost(host)
										.setPort(port)
										.build());
	}
	
	public static DrICClient connect(EndPoint ep) {
		return new DrICClient(ep);
	}
	
	private DrICClient(EndPoint ep) {
		Utilities.checkNotNullArgument(ep);
		
		m_platformEndpoint = ep;
		m_endPointCache.put(PLATFORM, ep);
	}
	
	public PBDrICPlatformProxy getPlatform() {
		return new PBDrICPlatformProxy(openChannel(m_platformEndpoint));
	}
	
	public PBDrICVideoServerProxy getVideoServer() {
		EndPoint ep = getServiceEndPoint(VIDEO_SERVER);
		return new PBDrICVideoServerProxy(openChannel(ep));
	}
	
	private DataSet intercept(DataSet ds) {
		if ( ds.getType() == DataSetType.MQTT ) {
			List<String> parts = CSV.parseCsv(ds.getParameter(), ':').toList();
			return new MqttAvroDataSet(ds.getDataSetInfo(), parts.get(0), Integer.parseInt(parts.get(1)), parts.get(2));
		}
		
		return ds;
	}
	
	public GrpcMarmotRuntimeProxy getMarmotServer() {
		EndPoint ep = getServiceEndPoint(MARMOT_SERVER);
		GrpcMarmotRuntimeProxy marmot = GrpcMarmotRuntimeProxy.connect(ep.getHost(), ep.getPort());
		GrpcDataSetServerProxy dsServer = marmot.getDataSetServer();
		dsServer.setDataSetInterceptor(this::intercept);
		
		return marmot;
	}
	
	private EndPoint getServiceEndPoint(String name) {
		EndPoint ep = m_endPointCache.get(name);
		if ( ep == null ) {
			try ( PBDrICPlatformProxy platform = getPlatform() ) {
				ep = handle(platform.getServiceEndPoint(name));
				m_endPointCache.put(name, ep);
			}
		}
		
		return ep;
	}
	
	public DataSet getDataSet(String dsId) {
		try ( GrpcMarmotRuntimeProxy marmot = getMarmotServer() ) {
			return marmot.getDataSetServer().getDataSet(dsId);
		}
	}
	
	public TopicClient getTopicClient(String host, int port, String clientId) {
		return new MqttTopicClient(getIMqttClient(host, port, clientId));
	}
	
	public TopicClient getTopicClient(String clientId) {
		EndPoint ep = getServiceEndPoint(TOPIC_SERVER);
		return getTopicClient(ep.getHost(), ep.getPort(), clientId);
	}
	
	public static IMqttClient getIMqttClient(String host, int port, String id) {
		try {
			String brokerUrl = String.format("tcp://%s:%d", host, port);
			
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
