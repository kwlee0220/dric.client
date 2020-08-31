// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

/**
 * Protobuf type {@code dric.proto.VideoStream}
 */
public  final class VideoStream extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dric.proto.VideoStream)
    VideoStreamOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VideoStream.newBuilder() to construct.
  private VideoStream(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VideoStream() {
    cameraId_ = "";
    rtspUrl_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VideoStream();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VideoStream(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            cameraId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            rtspUrl_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return dric.proto.Dric.internal_static_dric_proto_VideoStream_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dric.proto.Dric.internal_static_dric_proto_VideoStream_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dric.proto.VideoStream.class, dric.proto.VideoStream.Builder.class);
  }

  public static final int CAMERA_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object cameraId_;
  /**
   * <code>string camera_id = 1;</code>
   */
  public java.lang.String getCameraId() {
    java.lang.Object ref = cameraId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cameraId_ = s;
      return s;
    }
  }
  /**
   * <code>string camera_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCameraIdBytes() {
    java.lang.Object ref = cameraId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cameraId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RTSP_URL_FIELD_NUMBER = 2;
  private volatile java.lang.Object rtspUrl_;
  /**
   * <code>string rtsp_url = 2;</code>
   */
  public java.lang.String getRtspUrl() {
    java.lang.Object ref = rtspUrl_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      rtspUrl_ = s;
      return s;
    }
  }
  /**
   * <code>string rtsp_url = 2;</code>
   */
  public com.google.protobuf.ByteString
      getRtspUrlBytes() {
    java.lang.Object ref = rtspUrl_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      rtspUrl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getCameraIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, cameraId_);
    }
    if (!getRtspUrlBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, rtspUrl_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCameraIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, cameraId_);
    }
    if (!getRtspUrlBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, rtspUrl_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof dric.proto.VideoStream)) {
      return super.equals(obj);
    }
    dric.proto.VideoStream other = (dric.proto.VideoStream) obj;

    if (!getCameraId()
        .equals(other.getCameraId())) return false;
    if (!getRtspUrl()
        .equals(other.getRtspUrl())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CAMERA_ID_FIELD_NUMBER;
    hash = (53 * hash) + getCameraId().hashCode();
    hash = (37 * hash) + RTSP_URL_FIELD_NUMBER;
    hash = (53 * hash) + getRtspUrl().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dric.proto.VideoStream parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.VideoStream parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.VideoStream parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.VideoStream parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.VideoStream parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.VideoStream parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.VideoStream parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.VideoStream parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.VideoStream parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dric.proto.VideoStream parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.VideoStream parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.VideoStream parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(dric.proto.VideoStream prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code dric.proto.VideoStream}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dric.proto.VideoStream)
      dric.proto.VideoStreamOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dric.proto.Dric.internal_static_dric_proto_VideoStream_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dric.proto.Dric.internal_static_dric_proto_VideoStream_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dric.proto.VideoStream.class, dric.proto.VideoStream.Builder.class);
    }

    // Construct using dric.proto.VideoStream.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      cameraId_ = "";

      rtspUrl_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dric.proto.Dric.internal_static_dric_proto_VideoStream_descriptor;
    }

    @java.lang.Override
    public dric.proto.VideoStream getDefaultInstanceForType() {
      return dric.proto.VideoStream.getDefaultInstance();
    }

    @java.lang.Override
    public dric.proto.VideoStream build() {
      dric.proto.VideoStream result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dric.proto.VideoStream buildPartial() {
      dric.proto.VideoStream result = new dric.proto.VideoStream(this);
      result.cameraId_ = cameraId_;
      result.rtspUrl_ = rtspUrl_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof dric.proto.VideoStream) {
        return mergeFrom((dric.proto.VideoStream)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dric.proto.VideoStream other) {
      if (other == dric.proto.VideoStream.getDefaultInstance()) return this;
      if (!other.getCameraId().isEmpty()) {
        cameraId_ = other.cameraId_;
        onChanged();
      }
      if (!other.getRtspUrl().isEmpty()) {
        rtspUrl_ = other.rtspUrl_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      dric.proto.VideoStream parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dric.proto.VideoStream) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object cameraId_ = "";
    /**
     * <code>string camera_id = 1;</code>
     */
    public java.lang.String getCameraId() {
      java.lang.Object ref = cameraId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cameraId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string camera_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCameraIdBytes() {
      java.lang.Object ref = cameraId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cameraId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string camera_id = 1;</code>
     */
    public Builder setCameraId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      cameraId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string camera_id = 1;</code>
     */
    public Builder clearCameraId() {
      
      cameraId_ = getDefaultInstance().getCameraId();
      onChanged();
      return this;
    }
    /**
     * <code>string camera_id = 1;</code>
     */
    public Builder setCameraIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      cameraId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object rtspUrl_ = "";
    /**
     * <code>string rtsp_url = 2;</code>
     */
    public java.lang.String getRtspUrl() {
      java.lang.Object ref = rtspUrl_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        rtspUrl_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string rtsp_url = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRtspUrlBytes() {
      java.lang.Object ref = rtspUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        rtspUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string rtsp_url = 2;</code>
     */
    public Builder setRtspUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      rtspUrl_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string rtsp_url = 2;</code>
     */
    public Builder clearRtspUrl() {
      
      rtspUrl_ = getDefaultInstance().getRtspUrl();
      onChanged();
      return this;
    }
    /**
     * <code>string rtsp_url = 2;</code>
     */
    public Builder setRtspUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      rtspUrl_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:dric.proto.VideoStream)
  }

  // @@protoc_insertion_point(class_scope:dric.proto.VideoStream)
  private static final dric.proto.VideoStream DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dric.proto.VideoStream();
  }

  public static dric.proto.VideoStream getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VideoStream>
      PARSER = new com.google.protobuf.AbstractParser<VideoStream>() {
    @java.lang.Override
    public VideoStream parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VideoStream(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VideoStream> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VideoStream> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dric.proto.VideoStream getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
