// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

public interface CameraInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dric.proto.CameraInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.dric.proto.CameraInfo camera_info = 1;</code>
   */
  boolean hasCameraInfo();
  /**
   * <code>.dric.proto.CameraInfo camera_info = 1;</code>
   */
  dric.proto.CameraInfo getCameraInfo();
  /**
   * <code>.dric.proto.CameraInfo camera_info = 1;</code>
   */
  dric.proto.CameraInfoOrBuilder getCameraInfoOrBuilder();

  /**
   * <code>.marmot.proto.ErrorProto error = 2;</code>
   */
  boolean hasError();
  /**
   * <code>.marmot.proto.ErrorProto error = 2;</code>
   */
  marmot.proto.ErrorProto getError();
  /**
   * <code>.marmot.proto.ErrorProto error = 2;</code>
   */
  marmot.proto.ErrorProtoOrBuilder getErrorOrBuilder();

  public dric.proto.CameraInfoResponse.EitherCase getEitherCase();
}
