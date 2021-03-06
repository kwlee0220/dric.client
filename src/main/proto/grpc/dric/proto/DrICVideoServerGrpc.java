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
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: dric.proto")
public final class DrICVideoServerGrpc {

  private DrICVideoServerGrpc() {}

  public static final String SERVICE_NAME = "dric.proto.DrICVideoServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dric.proto.CameraInfo,
      marmot.proto.VoidResponse> getAddCameraMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCamera",
      requestType = dric.proto.CameraInfo.class,
      responseType = marmot.proto.VoidResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dric.proto.CameraInfo,
      marmot.proto.VoidResponse> getAddCameraMethod() {
    io.grpc.MethodDescriptor<dric.proto.CameraInfo, marmot.proto.VoidResponse> getAddCameraMethod;
    if ((getAddCameraMethod = DrICVideoServerGrpc.getAddCameraMethod) == null) {
      synchronized (DrICVideoServerGrpc.class) {
        if ((getAddCameraMethod = DrICVideoServerGrpc.getAddCameraMethod) == null) {
          DrICVideoServerGrpc.getAddCameraMethod = getAddCameraMethod = 
              io.grpc.MethodDescriptor.<dric.proto.CameraInfo, marmot.proto.VoidResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dric.proto.DrICVideoServer", "addCamera"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dric.proto.CameraInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  marmot.proto.VoidResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DrICVideoServerMethodDescriptorSupplier("addCamera"))
                  .build();
          }
        }
     }
     return getAddCameraMethod;
  }

  private static volatile io.grpc.MethodDescriptor<marmot.proto.StringProto,
      marmot.proto.VoidResponse> getRemoveCameraMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeCamera",
      requestType = marmot.proto.StringProto.class,
      responseType = marmot.proto.VoidResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<marmot.proto.StringProto,
      marmot.proto.VoidResponse> getRemoveCameraMethod() {
    io.grpc.MethodDescriptor<marmot.proto.StringProto, marmot.proto.VoidResponse> getRemoveCameraMethod;
    if ((getRemoveCameraMethod = DrICVideoServerGrpc.getRemoveCameraMethod) == null) {
      synchronized (DrICVideoServerGrpc.class) {
        if ((getRemoveCameraMethod = DrICVideoServerGrpc.getRemoveCameraMethod) == null) {
          DrICVideoServerGrpc.getRemoveCameraMethod = getRemoveCameraMethod = 
              io.grpc.MethodDescriptor.<marmot.proto.StringProto, marmot.proto.VoidResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dric.proto.DrICVideoServer", "removeCamera"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  marmot.proto.StringProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  marmot.proto.VoidResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DrICVideoServerMethodDescriptorSupplier("removeCamera"))
                  .build();
          }
        }
     }
     return getRemoveCameraMethod;
  }

  private static volatile io.grpc.MethodDescriptor<marmot.proto.StringProto,
      dric.proto.CameraInfoResponse> getGetCameraMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCamera",
      requestType = marmot.proto.StringProto.class,
      responseType = dric.proto.CameraInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<marmot.proto.StringProto,
      dric.proto.CameraInfoResponse> getGetCameraMethod() {
    io.grpc.MethodDescriptor<marmot.proto.StringProto, dric.proto.CameraInfoResponse> getGetCameraMethod;
    if ((getGetCameraMethod = DrICVideoServerGrpc.getGetCameraMethod) == null) {
      synchronized (DrICVideoServerGrpc.class) {
        if ((getGetCameraMethod = DrICVideoServerGrpc.getGetCameraMethod) == null) {
          DrICVideoServerGrpc.getGetCameraMethod = getGetCameraMethod = 
              io.grpc.MethodDescriptor.<marmot.proto.StringProto, dric.proto.CameraInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dric.proto.DrICVideoServer", "getCamera"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  marmot.proto.StringProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dric.proto.CameraInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DrICVideoServerMethodDescriptorSupplier("getCamera"))
                  .build();
          }
        }
     }
     return getGetCameraMethod;
  }

  private static volatile io.grpc.MethodDescriptor<marmot.proto.VoidProto,
      dric.proto.CameraInfoResponse> getGetCameraAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCameraAll",
      requestType = marmot.proto.VoidProto.class,
      responseType = dric.proto.CameraInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<marmot.proto.VoidProto,
      dric.proto.CameraInfoResponse> getGetCameraAllMethod() {
    io.grpc.MethodDescriptor<marmot.proto.VoidProto, dric.proto.CameraInfoResponse> getGetCameraAllMethod;
    if ((getGetCameraAllMethod = DrICVideoServerGrpc.getGetCameraAllMethod) == null) {
      synchronized (DrICVideoServerGrpc.class) {
        if ((getGetCameraAllMethod = DrICVideoServerGrpc.getGetCameraAllMethod) == null) {
          DrICVideoServerGrpc.getGetCameraAllMethod = getGetCameraAllMethod = 
              io.grpc.MethodDescriptor.<marmot.proto.VoidProto, dric.proto.CameraInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "dric.proto.DrICVideoServer", "getCameraAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  marmot.proto.VoidProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dric.proto.CameraInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DrICVideoServerMethodDescriptorSupplier("getCameraAll"))
                  .build();
          }
        }
     }
     return getGetCameraAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dric.proto.PlaybackStreamRequest,
      dric.proto.VideoStreamResponse> getGetPlaybackStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPlaybackStream",
      requestType = dric.proto.PlaybackStreamRequest.class,
      responseType = dric.proto.VideoStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dric.proto.PlaybackStreamRequest,
      dric.proto.VideoStreamResponse> getGetPlaybackStreamMethod() {
    io.grpc.MethodDescriptor<dric.proto.PlaybackStreamRequest, dric.proto.VideoStreamResponse> getGetPlaybackStreamMethod;
    if ((getGetPlaybackStreamMethod = DrICVideoServerGrpc.getGetPlaybackStreamMethod) == null) {
      synchronized (DrICVideoServerGrpc.class) {
        if ((getGetPlaybackStreamMethod = DrICVideoServerGrpc.getGetPlaybackStreamMethod) == null) {
          DrICVideoServerGrpc.getGetPlaybackStreamMethod = getGetPlaybackStreamMethod = 
              io.grpc.MethodDescriptor.<dric.proto.PlaybackStreamRequest, dric.proto.VideoStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dric.proto.DrICVideoServer", "getPlaybackStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dric.proto.PlaybackStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dric.proto.VideoStreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DrICVideoServerMethodDescriptorSupplier("getPlaybackStream"))
                  .build();
          }
        }
     }
     return getGetPlaybackStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DrICVideoServerStub newStub(io.grpc.Channel channel) {
    return new DrICVideoServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DrICVideoServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DrICVideoServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DrICVideoServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DrICVideoServerFutureStub(channel);
  }

  /**
   */
  public static abstract class DrICVideoServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void addCamera(dric.proto.CameraInfo request,
        io.grpc.stub.StreamObserver<marmot.proto.VoidResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCameraMethod(), responseObserver);
    }

    /**
     */
    public void removeCamera(marmot.proto.StringProto request,
        io.grpc.stub.StreamObserver<marmot.proto.VoidResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveCameraMethod(), responseObserver);
    }

    /**
     */
    public void getCamera(marmot.proto.StringProto request,
        io.grpc.stub.StreamObserver<dric.proto.CameraInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCameraMethod(), responseObserver);
    }

    /**
     */
    public void getCameraAll(marmot.proto.VoidProto request,
        io.grpc.stub.StreamObserver<dric.proto.CameraInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCameraAllMethod(), responseObserver);
    }

    /**
     */
    public void getPlaybackStream(dric.proto.PlaybackStreamRequest request,
        io.grpc.stub.StreamObserver<dric.proto.VideoStreamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPlaybackStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddCameraMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                dric.proto.CameraInfo,
                marmot.proto.VoidResponse>(
                  this, METHODID_ADD_CAMERA)))
          .addMethod(
            getRemoveCameraMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                marmot.proto.StringProto,
                marmot.proto.VoidResponse>(
                  this, METHODID_REMOVE_CAMERA)))
          .addMethod(
            getGetCameraMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                marmot.proto.StringProto,
                dric.proto.CameraInfoResponse>(
                  this, METHODID_GET_CAMERA)))
          .addMethod(
            getGetCameraAllMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                marmot.proto.VoidProto,
                dric.proto.CameraInfoResponse>(
                  this, METHODID_GET_CAMERA_ALL)))
          .addMethod(
            getGetPlaybackStreamMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                dric.proto.PlaybackStreamRequest,
                dric.proto.VideoStreamResponse>(
                  this, METHODID_GET_PLAYBACK_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class DrICVideoServerStub extends io.grpc.stub.AbstractStub<DrICVideoServerStub> {
    private DrICVideoServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrICVideoServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrICVideoServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrICVideoServerStub(channel, callOptions);
    }

    /**
     */
    public void addCamera(dric.proto.CameraInfo request,
        io.grpc.stub.StreamObserver<marmot.proto.VoidResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCameraMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeCamera(marmot.proto.StringProto request,
        io.grpc.stub.StreamObserver<marmot.proto.VoidResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveCameraMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCamera(marmot.proto.StringProto request,
        io.grpc.stub.StreamObserver<dric.proto.CameraInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCameraMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCameraAll(marmot.proto.VoidProto request,
        io.grpc.stub.StreamObserver<dric.proto.CameraInfoResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCameraAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPlaybackStream(dric.proto.PlaybackStreamRequest request,
        io.grpc.stub.StreamObserver<dric.proto.VideoStreamResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPlaybackStreamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DrICVideoServerBlockingStub extends io.grpc.stub.AbstractStub<DrICVideoServerBlockingStub> {
    private DrICVideoServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrICVideoServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrICVideoServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrICVideoServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public marmot.proto.VoidResponse addCamera(dric.proto.CameraInfo request) {
      return blockingUnaryCall(
          getChannel(), getAddCameraMethod(), getCallOptions(), request);
    }

    /**
     */
    public marmot.proto.VoidResponse removeCamera(marmot.proto.StringProto request) {
      return blockingUnaryCall(
          getChannel(), getRemoveCameraMethod(), getCallOptions(), request);
    }

    /**
     */
    public dric.proto.CameraInfoResponse getCamera(marmot.proto.StringProto request) {
      return blockingUnaryCall(
          getChannel(), getGetCameraMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<dric.proto.CameraInfoResponse> getCameraAll(
        marmot.proto.VoidProto request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCameraAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public dric.proto.VideoStreamResponse getPlaybackStream(dric.proto.PlaybackStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPlaybackStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DrICVideoServerFutureStub extends io.grpc.stub.AbstractStub<DrICVideoServerFutureStub> {
    private DrICVideoServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrICVideoServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrICVideoServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrICVideoServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<marmot.proto.VoidResponse> addCamera(
        dric.proto.CameraInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCameraMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<marmot.proto.VoidResponse> removeCamera(
        marmot.proto.StringProto request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveCameraMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dric.proto.CameraInfoResponse> getCamera(
        marmot.proto.StringProto request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCameraMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dric.proto.VideoStreamResponse> getPlaybackStream(
        dric.proto.PlaybackStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPlaybackStreamMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CAMERA = 0;
  private static final int METHODID_REMOVE_CAMERA = 1;
  private static final int METHODID_GET_CAMERA = 2;
  private static final int METHODID_GET_CAMERA_ALL = 3;
  private static final int METHODID_GET_PLAYBACK_STREAM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DrICVideoServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DrICVideoServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CAMERA:
          serviceImpl.addCamera((dric.proto.CameraInfo) request,
              (io.grpc.stub.StreamObserver<marmot.proto.VoidResponse>) responseObserver);
          break;
        case METHODID_REMOVE_CAMERA:
          serviceImpl.removeCamera((marmot.proto.StringProto) request,
              (io.grpc.stub.StreamObserver<marmot.proto.VoidResponse>) responseObserver);
          break;
        case METHODID_GET_CAMERA:
          serviceImpl.getCamera((marmot.proto.StringProto) request,
              (io.grpc.stub.StreamObserver<dric.proto.CameraInfoResponse>) responseObserver);
          break;
        case METHODID_GET_CAMERA_ALL:
          serviceImpl.getCameraAll((marmot.proto.VoidProto) request,
              (io.grpc.stub.StreamObserver<dric.proto.CameraInfoResponse>) responseObserver);
          break;
        case METHODID_GET_PLAYBACK_STREAM:
          serviceImpl.getPlaybackStream((dric.proto.PlaybackStreamRequest) request,
              (io.grpc.stub.StreamObserver<dric.proto.VideoStreamResponse>) responseObserver);
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

  private static abstract class DrICVideoServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DrICVideoServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dric.proto.Dric.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DrICVideoServer");
    }
  }

  private static final class DrICVideoServerFileDescriptorSupplier
      extends DrICVideoServerBaseDescriptorSupplier {
    DrICVideoServerFileDescriptorSupplier() {}
  }

  private static final class DrICVideoServerMethodDescriptorSupplier
      extends DrICVideoServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DrICVideoServerMethodDescriptorSupplier(String methodName) {
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
      synchronized (DrICVideoServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DrICVideoServerFileDescriptorSupplier())
              .addMethod(getAddCameraMethod())
              .addMethod(getRemoveCameraMethod())
              .addMethod(getGetCameraMethod())
              .addMethod(getGetCameraAllMethod())
              .addMethod(getGetPlaybackStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
