package dric.video;

import dric.proto.CameraFrameRangeRequest;
import dric.proto.CameraFrameRequest;
import dric.proto.CameraFrameResponse;
import dric.proto.CameraInfo;
import dric.proto.DrICVideoServerGrpc;
import dric.proto.DrICVideoServerGrpc.DrICVideoServerBlockingStub;
import dric.proto.DrICVideoServerGrpc.DrICVideoServerStub;
import dric.type.CameraFrame;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import utils.Throwables;
import utils.grpc.PBUtils;
import utils.stream.FStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class PBDrICVideoServerProxy implements DrICVideoServer, AutoCloseable {
	private final ManagedChannel m_channel;
	private final DrICVideoServerBlockingStub m_blockingStub; 
	@SuppressWarnings("unused")
	private final DrICVideoServerStub m_stub;
	
	public PBDrICVideoServerProxy(ManagedChannel channel) {
		m_channel = channel;
		m_stub = DrICVideoServerGrpc.newStub(channel);
		m_blockingStub = DrICVideoServerGrpc.newBlockingStub(channel);
	}

	@Override
	public void close() {
		m_channel.shutdown();
	}

	@Override
	public CameraInfo getCamera(String cameraId) throws CameraNotFoundException, DrICVideoException {
		try {
			return m_blockingStub.getCamera(PBUtils.STRING(cameraId));
		}
		catch ( StatusRuntimeException e ) {
			switch ( e.getStatus().getCode() ) {
				case NOT_FOUND:
					throw new CameraNotFoundException(cameraId);
				case INTERNAL:
					throw new DrICVideoException(e.getStatus().getDescription());
				default:
					throw new AssertionError("" + e);
			}
		}
	}

	@Override
	public FStream<CameraInfo> getCameraAll() throws DrICVideoException {
		try {
			return FStream.from(m_blockingStub.getCameraAll(PBUtils.VOID()));
		}
		catch ( StatusRuntimeException e ) {
			switch ( e.getStatus().getCode() ) {
				case INTERNAL:
					throw new DrICVideoException(e.getStatus().getDescription());
				default:
					throw new AssertionError("" + e);
			}
		}
	}

	@Override
	public void addCamera(CameraInfo info) throws CameraExistsException, DrICVideoException {
		try {
			m_blockingStub.addCamera(info);
		}
		catch ( StatusRuntimeException e ) {
			switch ( e.getStatus().getCode() ) {
				case ALREADY_EXISTS:
					throw new CameraExistsException(info.getId());
				case INTERNAL:
					throw new DrICVideoException(e.getStatus().getDescription());
				default:
					throw new AssertionError("" + e);
			}
		}
	}

	@Override
	public void removeCamera(String cameraId) throws DrICVideoException {
		try {
			m_blockingStub.removeCamera(PBUtils.STRING(cameraId));
		}
		catch ( StatusRuntimeException e ) {
			switch ( e.getStatus().getCode() ) {
				case INTERNAL:
					throw new DrICVideoException(e.getStatus().getDescription());
				default:
					throw new AssertionError("" + e);
			}
		}
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
				return CameraFrame.fromProto(resp.getFrame());
			case ERROR:
				throw Throwables.toRuntimeException(PBUtils.toException(resp.getError()));
			default:
				throw new AssertionError();
		}
	}

	@Override
	public FStream<CameraFrame> queryCameraFrames(String cameraId, long start, long stop)
		throws DrICVideoException {
		CameraFrameRangeRequest req = CameraFrameRangeRequest.newBuilder()
															.setCameraId(cameraId)
															.setStartTs(start)
															.setStopTs(stop)
															.build();
		
		return FStream.from(m_blockingStub.queryCameraFrames(req))
						.map(this::toCameraFrame);
	}
	
	private CameraFrame toCameraFrame(CameraFrameResponse resp) {
		switch ( resp.getEitherCase() ) {
			case FRAME:
				return CameraFrame.fromProto(resp.getFrame());
			case ERROR:
				throw Throwables.toRuntimeException(PBUtils.toException(resp.getError()));
			default:
				throw new AssertionError();
		}
	}
}
