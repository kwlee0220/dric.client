// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

public interface VideoStreamResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dric.proto.VideoStreamResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.dric.proto.VideoStream stream_info = 1;</code>
   */
  boolean hasStreamInfo();
  /**
   * <code>.dric.proto.VideoStream stream_info = 1;</code>
   */
  dric.proto.VideoStream getStreamInfo();
  /**
   * <code>.dric.proto.VideoStream stream_info = 1;</code>
   */
  dric.proto.VideoStreamOrBuilder getStreamInfoOrBuilder();

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

  public dric.proto.VideoStreamResponse.EitherCase getEitherCase();
}
