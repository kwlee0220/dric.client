package dric.grpc;

import com.google.protobuf.Empty;

import dric.proto.EmptyResponse;
import dric.proto.ErrorProto;
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
	
	public static final Empty VOID = Empty.newBuilder().build(); 
	private static final EmptyResponse VOID_RESPONSE = EmptyResponse.newBuilder()
																	.setVoid(VOID)
																	.build();
	
	public static void handle(EmptyResponse resp) {
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
									StreamObserver<EmptyResponse> response) {
		try {
			runnable.run();
			response.onNext(VOID_RESPONSE);
		}
		catch ( Throwable e ) {
			response.onNext(EmptyResponse.newBuilder()
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
