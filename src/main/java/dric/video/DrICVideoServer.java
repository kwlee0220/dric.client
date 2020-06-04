package dric.video;

import dric.type.CameraFrame;
import utils.stream.FStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface DrICVideoServer {
	public CameraFrame getCameraFrame(String cameraId, long ts)
		throws FrameNotFoundException, DrICVideoException;
	public FStream<CameraFrame> queryCameraFrames(String cameraId, long start, long stop)
		throws DrICVideoException;
}
