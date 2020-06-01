package dric.grpc;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICGrpcException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DrICGrpcException(String details) {
		super(details);
	}
}
