// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

/**
 * Protobuf type {@code dric.proto.ObjectBBoxTrackProto}
 */
public  final class ObjectBBoxTrackProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dric.proto.ObjectBBoxTrackProto)
    ObjectBBoxTrackProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ObjectBBoxTrackProto.newBuilder() to construct.
  private ObjectBBoxTrackProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ObjectBBoxTrackProto() {
    cameraId_ = "";
    luid_ = "";
    objectClass_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ObjectBBoxTrackProto();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ObjectBBoxTrackProto(
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

            luid_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            objectClass_ = s;
            break;
          }
          case 34: {
            dric.proto.BoundingBoxProto.Builder subBuilder = null;
            if (bbox_ != null) {
              subBuilder = bbox_.toBuilder();
            }
            bbox_ = input.readMessage(dric.proto.BoundingBoxProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(bbox_);
              bbox_ = subBuilder.buildPartial();
            }

            break;
          }
          case 45: {

            heading_ = input.readFloat();
            break;
          }
          case 48: {

            ts_ = input.readInt64();
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
    return dric.proto.Dric.internal_static_dric_proto_ObjectBBoxTrackProto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dric.proto.Dric.internal_static_dric_proto_ObjectBBoxTrackProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dric.proto.ObjectBBoxTrackProto.class, dric.proto.ObjectBBoxTrackProto.Builder.class);
  }

  public static final int CAMERA_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object cameraId_;
  /**
   * <pre>
   * 영상을 취득한 카메라 식별자
   * </pre>
   *
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
   * <pre>
   * 영상을 취득한 카메라 식별자
   * </pre>
   *
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

  public static final int LUID_FIELD_NUMBER = 2;
  private volatile java.lang.Object luid_;
  /**
   * <pre>
   * 인지된 객체의 식별자
   * </pre>
   *
   * <code>string luid = 2;</code>
   */
  public java.lang.String getLuid() {
    java.lang.Object ref = luid_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      luid_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 인지된 객체의 식별자
   * </pre>
   *
   * <code>string luid = 2;</code>
   */
  public com.google.protobuf.ByteString
      getLuidBytes() {
    java.lang.Object ref = luid_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      luid_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OBJECT_CLASS_FIELD_NUMBER = 3;
  private volatile java.lang.Object objectClass_;
  /**
   * <pre>
   * 인지된 객체의 종류
   * </pre>
   *
   * <code>string object_class = 3;</code>
   */
  public java.lang.String getObjectClass() {
    java.lang.Object ref = objectClass_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      objectClass_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 인지된 객체의 종류
   * </pre>
   *
   * <code>string object_class = 3;</code>
   */
  public com.google.protobuf.ByteString
      getObjectClassBytes() {
    java.lang.Object ref = objectClass_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      objectClass_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BBOX_FIELD_NUMBER = 4;
  private dric.proto.BoundingBoxProto bbox_;
  /**
   * <pre>
   * 인지된 객체의 영상 내 영역
   * </pre>
   *
   * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
   */
  public boolean hasBbox() {
    return bbox_ != null;
  }
  /**
   * <pre>
   * 인지된 객체의 영상 내 영역
   * </pre>
   *
   * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
   */
  public dric.proto.BoundingBoxProto getBbox() {
    return bbox_ == null ? dric.proto.BoundingBoxProto.getDefaultInstance() : bbox_;
  }
  /**
   * <pre>
   * 인지된 객체의 영상 내 영역
   * </pre>
   *
   * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
   */
  public dric.proto.BoundingBoxProtoOrBuilder getBboxOrBuilder() {
    return getBbox();
  }

  public static final int HEADING_FIELD_NUMBER = 5;
  private float heading_;
  /**
   * <pre>
   * 인지된 객체의 방향
   * </pre>
   *
   * <code>float heading = 5;</code>
   */
  public float getHeading() {
    return heading_;
  }

  public static final int TS_FIELD_NUMBER = 6;
  private long ts_;
  /**
   * <pre>
   * 이미지 취득 시각
   * </pre>
   *
   * <code>int64 ts = 6;</code>
   */
  public long getTs() {
    return ts_;
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
    if (!getLuidBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, luid_);
    }
    if (!getObjectClassBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, objectClass_);
    }
    if (bbox_ != null) {
      output.writeMessage(4, getBbox());
    }
    if (heading_ != 0F) {
      output.writeFloat(5, heading_);
    }
    if (ts_ != 0L) {
      output.writeInt64(6, ts_);
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
    if (!getLuidBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, luid_);
    }
    if (!getObjectClassBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, objectClass_);
    }
    if (bbox_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getBbox());
    }
    if (heading_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(5, heading_);
    }
    if (ts_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, ts_);
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
    if (!(obj instanceof dric.proto.ObjectBBoxTrackProto)) {
      return super.equals(obj);
    }
    dric.proto.ObjectBBoxTrackProto other = (dric.proto.ObjectBBoxTrackProto) obj;

    if (!getCameraId()
        .equals(other.getCameraId())) return false;
    if (!getLuid()
        .equals(other.getLuid())) return false;
    if (!getObjectClass()
        .equals(other.getObjectClass())) return false;
    if (hasBbox() != other.hasBbox()) return false;
    if (hasBbox()) {
      if (!getBbox()
          .equals(other.getBbox())) return false;
    }
    if (java.lang.Float.floatToIntBits(getHeading())
        != java.lang.Float.floatToIntBits(
            other.getHeading())) return false;
    if (getTs()
        != other.getTs()) return false;
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
    hash = (37 * hash) + LUID_FIELD_NUMBER;
    hash = (53 * hash) + getLuid().hashCode();
    hash = (37 * hash) + OBJECT_CLASS_FIELD_NUMBER;
    hash = (53 * hash) + getObjectClass().hashCode();
    if (hasBbox()) {
      hash = (37 * hash) + BBOX_FIELD_NUMBER;
      hash = (53 * hash) + getBbox().hashCode();
    }
    hash = (37 * hash) + HEADING_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getHeading());
    hash = (37 * hash) + TS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTs());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dric.proto.ObjectBBoxTrackProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.ObjectBBoxTrackProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dric.proto.ObjectBBoxTrackProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.ObjectBBoxTrackProto parseFrom(
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
  public static Builder newBuilder(dric.proto.ObjectBBoxTrackProto prototype) {
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
   * Protobuf type {@code dric.proto.ObjectBBoxTrackProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dric.proto.ObjectBBoxTrackProto)
      dric.proto.ObjectBBoxTrackProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dric.proto.Dric.internal_static_dric_proto_ObjectBBoxTrackProto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dric.proto.Dric.internal_static_dric_proto_ObjectBBoxTrackProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dric.proto.ObjectBBoxTrackProto.class, dric.proto.ObjectBBoxTrackProto.Builder.class);
    }

    // Construct using dric.proto.ObjectBBoxTrackProto.newBuilder()
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

      luid_ = "";

      objectClass_ = "";

      if (bboxBuilder_ == null) {
        bbox_ = null;
      } else {
        bbox_ = null;
        bboxBuilder_ = null;
      }
      heading_ = 0F;

      ts_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dric.proto.Dric.internal_static_dric_proto_ObjectBBoxTrackProto_descriptor;
    }

    @java.lang.Override
    public dric.proto.ObjectBBoxTrackProto getDefaultInstanceForType() {
      return dric.proto.ObjectBBoxTrackProto.getDefaultInstance();
    }

    @java.lang.Override
    public dric.proto.ObjectBBoxTrackProto build() {
      dric.proto.ObjectBBoxTrackProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dric.proto.ObjectBBoxTrackProto buildPartial() {
      dric.proto.ObjectBBoxTrackProto result = new dric.proto.ObjectBBoxTrackProto(this);
      result.cameraId_ = cameraId_;
      result.luid_ = luid_;
      result.objectClass_ = objectClass_;
      if (bboxBuilder_ == null) {
        result.bbox_ = bbox_;
      } else {
        result.bbox_ = bboxBuilder_.build();
      }
      result.heading_ = heading_;
      result.ts_ = ts_;
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
      if (other instanceof dric.proto.ObjectBBoxTrackProto) {
        return mergeFrom((dric.proto.ObjectBBoxTrackProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dric.proto.ObjectBBoxTrackProto other) {
      if (other == dric.proto.ObjectBBoxTrackProto.getDefaultInstance()) return this;
      if (!other.getCameraId().isEmpty()) {
        cameraId_ = other.cameraId_;
        onChanged();
      }
      if (!other.getLuid().isEmpty()) {
        luid_ = other.luid_;
        onChanged();
      }
      if (!other.getObjectClass().isEmpty()) {
        objectClass_ = other.objectClass_;
        onChanged();
      }
      if (other.hasBbox()) {
        mergeBbox(other.getBbox());
      }
      if (other.getHeading() != 0F) {
        setHeading(other.getHeading());
      }
      if (other.getTs() != 0L) {
        setTs(other.getTs());
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
      dric.proto.ObjectBBoxTrackProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dric.proto.ObjectBBoxTrackProto) e.getUnfinishedMessage();
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
     * <pre>
     * 영상을 취득한 카메라 식별자
     * </pre>
     *
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
     * <pre>
     * 영상을 취득한 카메라 식별자
     * </pre>
     *
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
     * <pre>
     * 영상을 취득한 카메라 식별자
     * </pre>
     *
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
     * <pre>
     * 영상을 취득한 카메라 식별자
     * </pre>
     *
     * <code>string camera_id = 1;</code>
     */
    public Builder clearCameraId() {
      
      cameraId_ = getDefaultInstance().getCameraId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 영상을 취득한 카메라 식별자
     * </pre>
     *
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

    private java.lang.Object luid_ = "";
    /**
     * <pre>
     * 인지된 객체의 식별자
     * </pre>
     *
     * <code>string luid = 2;</code>
     */
    public java.lang.String getLuid() {
      java.lang.Object ref = luid_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        luid_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 인지된 객체의 식별자
     * </pre>
     *
     * <code>string luid = 2;</code>
     */
    public com.google.protobuf.ByteString
        getLuidBytes() {
      java.lang.Object ref = luid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        luid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 인지된 객체의 식별자
     * </pre>
     *
     * <code>string luid = 2;</code>
     */
    public Builder setLuid(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      luid_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 식별자
     * </pre>
     *
     * <code>string luid = 2;</code>
     */
    public Builder clearLuid() {
      
      luid_ = getDefaultInstance().getLuid();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 식별자
     * </pre>
     *
     * <code>string luid = 2;</code>
     */
    public Builder setLuidBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      luid_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object objectClass_ = "";
    /**
     * <pre>
     * 인지된 객체의 종류
     * </pre>
     *
     * <code>string object_class = 3;</code>
     */
    public java.lang.String getObjectClass() {
      java.lang.Object ref = objectClass_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        objectClass_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 인지된 객체의 종류
     * </pre>
     *
     * <code>string object_class = 3;</code>
     */
    public com.google.protobuf.ByteString
        getObjectClassBytes() {
      java.lang.Object ref = objectClass_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        objectClass_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 인지된 객체의 종류
     * </pre>
     *
     * <code>string object_class = 3;</code>
     */
    public Builder setObjectClass(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      objectClass_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 종류
     * </pre>
     *
     * <code>string object_class = 3;</code>
     */
    public Builder clearObjectClass() {
      
      objectClass_ = getDefaultInstance().getObjectClass();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 종류
     * </pre>
     *
     * <code>string object_class = 3;</code>
     */
    public Builder setObjectClassBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      objectClass_ = value;
      onChanged();
      return this;
    }

    private dric.proto.BoundingBoxProto bbox_;
    private com.google.protobuf.SingleFieldBuilderV3<
        dric.proto.BoundingBoxProto, dric.proto.BoundingBoxProto.Builder, dric.proto.BoundingBoxProtoOrBuilder> bboxBuilder_;
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public boolean hasBbox() {
      return bboxBuilder_ != null || bbox_ != null;
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public dric.proto.BoundingBoxProto getBbox() {
      if (bboxBuilder_ == null) {
        return bbox_ == null ? dric.proto.BoundingBoxProto.getDefaultInstance() : bbox_;
      } else {
        return bboxBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public Builder setBbox(dric.proto.BoundingBoxProto value) {
      if (bboxBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        bbox_ = value;
        onChanged();
      } else {
        bboxBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public Builder setBbox(
        dric.proto.BoundingBoxProto.Builder builderForValue) {
      if (bboxBuilder_ == null) {
        bbox_ = builderForValue.build();
        onChanged();
      } else {
        bboxBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public Builder mergeBbox(dric.proto.BoundingBoxProto value) {
      if (bboxBuilder_ == null) {
        if (bbox_ != null) {
          bbox_ =
            dric.proto.BoundingBoxProto.newBuilder(bbox_).mergeFrom(value).buildPartial();
        } else {
          bbox_ = value;
        }
        onChanged();
      } else {
        bboxBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public Builder clearBbox() {
      if (bboxBuilder_ == null) {
        bbox_ = null;
        onChanged();
      } else {
        bbox_ = null;
        bboxBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public dric.proto.BoundingBoxProto.Builder getBboxBuilder() {
      
      onChanged();
      return getBboxFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    public dric.proto.BoundingBoxProtoOrBuilder getBboxOrBuilder() {
      if (bboxBuilder_ != null) {
        return bboxBuilder_.getMessageOrBuilder();
      } else {
        return bbox_ == null ?
            dric.proto.BoundingBoxProto.getDefaultInstance() : bbox_;
      }
    }
    /**
     * <pre>
     * 인지된 객체의 영상 내 영역
     * </pre>
     *
     * <code>.dric.proto.BoundingBoxProto bbox = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        dric.proto.BoundingBoxProto, dric.proto.BoundingBoxProto.Builder, dric.proto.BoundingBoxProtoOrBuilder> 
        getBboxFieldBuilder() {
      if (bboxBuilder_ == null) {
        bboxBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            dric.proto.BoundingBoxProto, dric.proto.BoundingBoxProto.Builder, dric.proto.BoundingBoxProtoOrBuilder>(
                getBbox(),
                getParentForChildren(),
                isClean());
        bbox_ = null;
      }
      return bboxBuilder_;
    }

    private float heading_ ;
    /**
     * <pre>
     * 인지된 객체의 방향
     * </pre>
     *
     * <code>float heading = 5;</code>
     */
    public float getHeading() {
      return heading_;
    }
    /**
     * <pre>
     * 인지된 객체의 방향
     * </pre>
     *
     * <code>float heading = 5;</code>
     */
    public Builder setHeading(float value) {
      
      heading_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 인지된 객체의 방향
     * </pre>
     *
     * <code>float heading = 5;</code>
     */
    public Builder clearHeading() {
      
      heading_ = 0F;
      onChanged();
      return this;
    }

    private long ts_ ;
    /**
     * <pre>
     * 이미지 취득 시각
     * </pre>
     *
     * <code>int64 ts = 6;</code>
     */
    public long getTs() {
      return ts_;
    }
    /**
     * <pre>
     * 이미지 취득 시각
     * </pre>
     *
     * <code>int64 ts = 6;</code>
     */
    public Builder setTs(long value) {
      
      ts_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 이미지 취득 시각
     * </pre>
     *
     * <code>int64 ts = 6;</code>
     */
    public Builder clearTs() {
      
      ts_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:dric.proto.ObjectBBoxTrackProto)
  }

  // @@protoc_insertion_point(class_scope:dric.proto.ObjectBBoxTrackProto)
  private static final dric.proto.ObjectBBoxTrackProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dric.proto.ObjectBBoxTrackProto();
  }

  public static dric.proto.ObjectBBoxTrackProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ObjectBBoxTrackProto>
      PARSER = new com.google.protobuf.AbstractParser<ObjectBBoxTrackProto>() {
    @java.lang.Override
    public ObjectBBoxTrackProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ObjectBBoxTrackProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ObjectBBoxTrackProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ObjectBBoxTrackProto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dric.proto.ObjectBBoxTrackProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

