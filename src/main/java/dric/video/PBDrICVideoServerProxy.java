package dric.video;

import dric.proto.CameraInfo;
import dric.proto.CameraInfoResponse;
import dric.proto.DrICVideoServerGrpc;
import dric.proto.DrICVideoServerGrpc.DrICVideoServerBlockingStub;
import dric.proto.DrICVideoServerGrpc.DrICVideoServerStub;
import dric.proto.PlaybackStreamRequest;
import dric.proto.VideoStream;
import dric.proto.VideoStreamResponse;
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
			return handle(m_blockingStub.getCamera(PBUtils.STRING(cameraId)));
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
		return FStream.from(m_blockingStub.getCameraAll(PBUtils.VOID()))
						.map(this::handle);
	}

	@Override
	public VideoStream getPlaybackStream(PlaybackStreamRequest req) throws CameraNotFoundException, DrICVideoException {
		try {
			return handle(m_blockingStub.getPlaybackStream(req));
		}
		catch ( StatusRuntimeException e ) {
			switch ( e.getStatus().getCode() ) {
				case NOT_FOUND:
					throw new CameraNotFoundException(req.getCameraId());
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
	
	private VideoStream handle(VideoStreamResponse resp) {
		switch ( resp.getEitherCase() ) {
			case STREAM_INFO:
				return resp.getStreamInfo();
			case ERROR:
				throw Throwables.toRuntimeException(PBUtils.toException(resp.getError()));
			default:
				throw new AssertionError();
		}
	}
	
	private CameraInfo handle(CameraInfoResponse resp) {
		switch ( resp.getEitherCase() ) {
			case CAMERA_INFO:
				return resp.getCameraInfo();
			case ERROR:
				throw Throwables.toRuntimeException(PBUtils.toException(resp.getError()));
			default:
				throw new AssertionError();
		}
	}
}
