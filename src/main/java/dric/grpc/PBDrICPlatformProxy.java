package dric.grpc;

import dric.proto.DrICPlatformGrpc;
import dric.proto.DrICPlatformGrpc.DrICPlatformBlockingStub;
import dric.proto.DrICPlatformGrpc.DrICPlatformStub;
import dric.proto.EndPointResponse;
import io.grpc.ManagedChannel;
import utils.grpc.PBUtils;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class PBDrICPlatformProxy implements AutoCloseable {
	private final DrICPlatformBlockingStub m_blockingStub;
	@SuppressWarnings("unused")
	private final DrICPlatformStub m_stub;

	public PBDrICPlatformProxy(ManagedChannel channel) {
		m_stub = DrICPlatformGrpc.newStub(channel);
		m_blockingStub = DrICPlatformGrpc.newBlockingStub(channel);
	}

	@Override
	public void close() {
		((ManagedChannel)m_stub.getChannel()).shutdown();
	}
	
	public EndPointResponse getServiceEndPoint(String serviceName) {
		return m_blockingStub.getServiceEndPoint(PBUtils.STRING(serviceName));
	}
}
