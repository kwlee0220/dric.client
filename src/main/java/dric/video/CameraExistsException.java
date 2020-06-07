package dric.video;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class CameraExistsException extends DrICVideoException {
	private static final long serialVersionUID = 1L;

	public CameraExistsException(String cameraId) {
		super("camera=" + cameraId);
	}
}
