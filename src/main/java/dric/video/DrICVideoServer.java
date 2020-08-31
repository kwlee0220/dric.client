package dric.video;

import dric.proto.CameraInfo;
import dric.proto.PlaybackStreamRequest;
import dric.proto.VideoStream;
import utils.stream.FStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface DrICVideoServer {
	public void addCamera(CameraInfo info) throws CameraExistsException, DrICVideoException;
	public void removeCamera(String cameraId) throws DrICVideoException;
	public CameraInfo getCamera(String cameraId) throws CameraNotFoundException, DrICVideoException;
	public FStream<CameraInfo> getCameraAll() throws DrICVideoException;
	
	public VideoStream getPlaybackStream(PlaybackStreamRequest req) throws CameraNotFoundException, DrICVideoException;
	
//	public CameraFrame getCameraFrame(String cameraId, long ts)
//		throws FrameNotFoundException, DrICVideoException;
//	public FStream<CameraFrame> queryCameraFrames(String cameraId, long start, long stop)
//		throws DrICVideoException;
}
