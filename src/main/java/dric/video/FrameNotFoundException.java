package dric.video;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class FrameNotFoundException extends DrICVideoException {
	private static final long serialVersionUID = 1L;

	public FrameNotFoundException(String details) {
		super(details);
	}

	public FrameNotFoundException(String cameraId, long ts) {
		this(String.format("camera=%s, ts=%d", cameraId, ts));
	}
}
