package dric.video;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class CameraNotFoundException extends DrICVideoException {
	private static final long serialVersionUID = 1L;

	public CameraNotFoundException(String cameraId) {
		super("camera=" + cameraId);
	}
}
