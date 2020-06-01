package dric.video;

import java.io.IOException;

import dric.grpc.PBUtils;
import dric.proto.CameraFrame;
import dric.proto.CameraFrameRequest;
import dric.proto.CameraFrameResponse;
import dric.proto.DrICVideoServerGrpc;
import dric.proto.DrICVideoServerGrpc.DrICVideoServerBlockingStub;
import dric.proto.DrICVideoServerGrpc.DrICVideoServerStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import utils.Throwables;
import utils.stream.FStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICVideoServerClient implements DrICVideoServer {
	private final Server m_server;
	private final ManagedChannel m_channel;
	private final DrICVideoServerBlockingStub m_blockingStub; 
	private final DrICVideoServerStub m_stub;
	
	public static DrICVideoServerClient connect(String host, int port) throws IOException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
													.usePlaintext()
													.build();
		
		return new DrICVideoServerClient(channel);
	}
	
	protected DrICVideoServerClient(ManagedChannel channel) throws IOException {
		m_channel = channel;
		
		m_stub = DrICVideoServerGrpc.newStub(channel);
		m_blockingStub = DrICVideoServerGrpc.newBlockingStub(channel);

		m_server = ServerBuilder.forPort(0).build();
		m_server.start();
	}

	@Override
	public CameraFrame getCameraFrame(String cameraId, long ts)
		throws FrameNotFoundException, DrICVideoException {
		CameraFrameRequest req = CameraFrameRequest.newBuilder()
													.setCameraId(cameraId)
													.setTs(ts)
													.build();
		
		CameraFrameResponse resp = m_blockingStub.getCameraFrame(req);
		switch ( resp.getEitherCase() ) {
			case FRAME:
				return resp.getFrame();
			case ERROR:
				throw Throwables.toRuntimeException(PBUtils.toException(resp.getError()));
			default:
				throw new AssertionError();
		}
	}

	@Override
	public FStream<CameraFrame> queryCameraFrames(String cameraId, long start, long stop)
			throws DrICVideoException {
		return null;
	}
}
