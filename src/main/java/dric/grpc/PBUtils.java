package dric.grpc;

import dric.proto.ErrorProto;
import dric.proto.VoidProto;
import dric.proto.VoidResponse;
import io.grpc.stub.StreamObserver;
import utils.Throwables;
import utils.Utilities;
import utils.func.CheckedRunnable;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class PBUtils {
	private PBUtils() {
		throw new AssertionError("Should not be called: " + getClass());
	}
	
	public static final VoidProto VOID = VoidProto.newBuilder().build();
	private static final VoidResponse VOID_RESPONSE = VoidResponse.newBuilder()
																	.setVoid(VOID)
																	.build();
	
	public static void handle(VoidResponse resp) {
		switch ( resp.getEitherCase() ) {
			case VOID:
				return;
			case ERROR:
				throw Throwables.toRuntimeException(toException(resp.getError()));
			default:
				throw new AssertionError();
		}
	}
	
	public static void replyVoid(CheckedRunnable runnable,
									StreamObserver<VoidResponse> response) {
		try {
			runnable.run();
			response.onNext(VoidResponse.newBuilder()
										.setVoid(VOID)
										.build());
		}
		catch ( Throwable e ) {
			response.onNext(VoidResponse.newBuilder()
										.setError(PBUtils.toErrorProto(e))
										.build());
		}
		response.onCompleted();
	}
	
	public static ErrorProto toErrorProto(Throwable e) {
		Throwable cause = Throwables.unwrapThrowable(e);

		ErrorProto.Builder builder = ErrorProto.newBuilder()
												.setCode(cause.getClass().getName());
		if ( cause.getMessage() != null ) {
			builder = builder.setDetails(cause.getMessage());
		}
		return builder.build();
	}
	
	public static Exception toException(ErrorProto proto) {
		String exceptClsName = proto.getCode();
		try {
			Class<?> exceptCls = Class.forName(exceptClsName);
			
			switch ( proto.getOptionalDetailsCase() ) {
				case DETAILS:
					return (Exception)Utilities.callPrivateConstructor(exceptCls, proto.getDetails());
				case OPTIONALDETAILS_NOT_SET:
					return (Exception)Utilities.callPrivateConstructor(exceptCls);
				default:
					throw new AssertionError();
			}
		}
		catch ( ClassNotFoundException e ) {
			throw new DrICGrpcException("exception class not found: " + exceptClsName);
		}
		catch ( Exception e ) {
			throw new DrICGrpcException("fails to load exception object: " + proto);
		}
	}
}
