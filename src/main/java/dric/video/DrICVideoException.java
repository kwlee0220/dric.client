package dric.video;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICVideoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DrICVideoException(String details) {
		super(details);
	}

	public DrICVideoException(Throwable cause) {
		super(cause);
	}
}
