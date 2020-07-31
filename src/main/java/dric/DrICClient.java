package dric;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import dric.dataset.mqtt.MqttAvroDataSet;
import dric.grpc.PBDrICPlatformProxy;
import dric.proto.EndPoint;
import dric.proto.EndPointResponse;
import dric.video.PBDrICVideoServerProxy;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
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
	
	private final String m_clientId;
	private final EndPoint m_platformEndpoint;
	private final Map<String,EndPoint> m_endPointCache = Maps.newHashMap();
	
	public static DrICClient connect(String host, int port, String clientId) {
		return new DrICClient(EndPoint.newBuilder()
										.setHost(host)
										.setPort(port)
										.build(), clientId);
	}
	
	public static DrICClient connect(EndPoint ep, String clientId) {
		return new DrICClient(ep, clientId);
	}
	
	private DrICClient(EndPoint ep, String clientId) {
		Utilities.checkNotNullArgument(ep);
		
		m_clientId = clientId;
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
			return new MqttAvroDataSet(ds.getDataSetInfo(), parts.get(0), Integer.parseInt(parts.get(1)),
										m_clientId, parts.get(2));
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
			catch ( StatusRuntimeException e ) {
				throw new IllegalStateException("fails to connect to dric-platform: end-point=" + m_platformEndpoint);
			}
		}
		
		return ep;
	}
	
	public DataSet getDataSet(String dsId) {
		try ( GrpcMarmotRuntimeProxy marmot = getMarmotServer() ) {
			return marmot.getDataSetServer().getDataSet(dsId);
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
