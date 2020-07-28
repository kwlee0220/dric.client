package dric.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.1)",
    comments = "Source: dric.proto")
public final class DrICPlatformGrpc {

  private DrICPlatformGrpc() {}

  public static final String SERVICE_NAME = "dric.proto.DrICPlatform";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<marmot.proto.StringProto,
      dric.proto.EndPointResponse> getGetServiceEndPointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getServiceEndPoint",
      requestType = marmot.proto.StringProto.class,
      responseType = dric.proto.EndPointResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<marmot.proto.StringProto,
      dric.proto.EndPointResponse> getGetServiceEndPointMethod() {
    io.grpc.MethodDescriptor<marmot.proto.StringProto, dric.proto.EndPointResponse> getGetServiceEndPointMethod;
    if ((getGetServiceEndPointMethod = DrICPlatformGrpc.getGetServiceEndPointMethod) == null) {
      synchronized (DrICPlatformGrpc.class) {
        if ((getGetServiceEndPointMethod = DrICPlatformGrpc.getGetServiceEndPointMethod) == null) {
          DrICPlatformGrpc.getGetServiceEndPointMethod = getGetServiceEndPointMethod =
              io.grpc.MethodDescriptor.<marmot.proto.StringProto, dric.proto.EndPointResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getServiceEndPoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  marmot.proto.StringProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dric.proto.EndPointResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DrICPlatformMethodDescriptorSupplier("getServiceEndPoint"))
              .build();
        }
      }
    }
    return getGetServiceEndPointMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DrICPlatformStub newStub(io.grpc.Channel channel) {
    return new DrICPlatformStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DrICPlatformBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DrICPlatformBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DrICPlatformFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DrICPlatformFutureStub(channel);
  }

  /**
   */
  public static abstract class DrICPlatformImplBase implements io.grpc.BindableService {

    /**
     */
    public void getServiceEndPoint(marmot.proto.StringProto request,
        io.grpc.stub.StreamObserver<dric.proto.EndPointResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetServiceEndPointMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetServiceEndPointMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                marmot.proto.StringProto,
                dric.proto.EndPointResponse>(
                  this, METHODID_GET_SERVICE_END_POINT)))
          .build();
    }
  }

  /**
   */
  public static final class DrICPlatformStub extends io.grpc.stub.AbstractStub<DrICPlatformStub> {
    private DrICPlatformStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrICPlatformStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrICPlatformStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrICPlatformStub(channel, callOptions);
    }

    /**
     */
    public void getServiceEndPoint(marmot.proto.StringProto request,
        io.grpc.stub.StreamObserver<dric.proto.EndPointResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetServiceEndPointMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DrICPlatformBlockingStub extends io.grpc.stub.AbstractStub<DrICPlatformBlockingStub> {
    private DrICPlatformBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrICPlatformBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrICPlatformBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrICPlatformBlockingStub(channel, callOptions);
    }

    /**
     */
    public dric.proto.EndPointResponse getServiceEndPoint(marmot.proto.StringProto request) {
      return blockingUnaryCall(
          getChannel(), getGetServiceEndPointMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DrICPlatformFutureStub extends io.grpc.stub.AbstractStub<DrICPlatformFutureStub> {
    private DrICPlatformFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrICPlatformFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrICPlatformFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrICPlatformFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dric.proto.EndPointResponse> getServiceEndPoint(
        marmot.proto.StringProto request) {
      return futureUnaryCall(
          getChannel().newCall(getGetServiceEndPointMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SERVICE_END_POINT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DrICPlatformImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DrICPlatformImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SERVICE_END_POINT:
          serviceImpl.getServiceEndPoint((marmot.proto.StringProto) request,
              (io.grpc.stub.StreamObserver<dric.proto.EndPointResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DrICPlatformBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DrICPlatformBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dric.proto.Dric.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DrICPlatform");
    }
  }

  private static final class DrICPlatformFileDescriptorSupplier
      extends DrICPlatformBaseDescriptorSupplier {
    DrICPlatformFileDescriptorSupplier() {}
  }

  private static final class DrICPlatformMethodDescriptorSupplier
      extends DrICPlatformBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DrICPlatformMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DrICPlatformGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DrICPlatformFileDescriptorSupplier())
              .addMethod(getGetServiceEndPointMethod())
              .build();
        }
      }
    }
    return result;
  }
}
