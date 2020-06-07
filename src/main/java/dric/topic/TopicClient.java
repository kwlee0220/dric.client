package dric.topic;

import dric.type.CameraFrame;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface TopicClient {
	public Topic<CameraFrame> getCameraFrameTopic();
}
