package dric.grpc;

import dric.proto.DrICPlatformGrpc;
import dric.proto.DrICPlatformGrpc.DrICPlatformBlockingStub;
import dric.proto.DrICPlatformGrpc.DrICPlatformStub;
import dric.proto.ServiceEndPoint;
import dric.proto.ServiceEndPointResponse;
import io.grpc.ManagedChannel;
import utils.Throwables;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class PBDrICPlatformProxy {
	private final DrICPlatformBlockingStub m_blockingStub;
	private final DrICPlatformStub m_stub;

	public PBDrICPlatformProxy(ManagedChannel channel) {
		m_stub = DrICPlatformGrpc.newStub(channel);
		m_blockingStub = DrICPlatformGrpc.newBlockingStub(channel);
	}
	
	public ServiceEndPoint getDataStoreEndPoint() {
		return toServiceEndPoint(m_blockingStub.getDataStoreEndPoint(PBUtils.VOID));
	}
	
	public ServiceEndPoint getTopicServerEndPoint() {
		return toServiceEndPoint(m_blockingStub.getTopicServerEndPoint(PBUtils.VOID));
	}
	
	public ServiceEndPoint getVideoServerEndPoint() {
		return toServiceEndPoint(m_blockingStub.getVideoServerEndPoint(PBUtils.VOID));
	}
	
	ServiceEndPoint toServiceEndPoint(ServiceEndPointResponse resp) {
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
