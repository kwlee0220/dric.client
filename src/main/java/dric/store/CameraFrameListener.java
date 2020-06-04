package dric.store;

import dric.type.CameraFrame;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface CameraFrameListener {
	public void onMessageArrived(String topic, CameraFrame frame);
}
