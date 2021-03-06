// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

/**
 * Protobuf type {@code dric.proto.ObjectTrackProto}
 */
public  final class ObjectTrackProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dric.proto.ObjectTrackProto)
    ObjectTrackProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ObjectTrackProto.newBuilder() to construct.
  private ObjectTrackProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ObjectTrackProto() {
    cameraId_ = "";
    luid_ = "";
    objectClass_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ObjectTrackProto();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ObjectTrackProto(
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
            dric.proto.CoordinateProto.Builder subBuilder = null;
            if (coordinate_ != null) {
              subBuilder = coordinate_.toBuilder();
            }
            coordinate_ = input.readMessage(dric.proto.CoordinateProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(coordinate_);
              coordinate_ = subBuilder.buildPartial();
            }

            break;
          }
          case 45: {

            azimuth_ = input.readFloat();
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
    return dric.proto.Dric.internal_static_dric_proto_ObjectTrackProto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dric.proto.Dric.internal_static_dric_proto_ObjectTrackProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dric.proto.ObjectTrackProto.class, dric.proto.ObjectTrackProto.Builder.class);
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

  public static final int COORDINATE_FIELD_NUMBER = 4;
  private dric.proto.CoordinateProto coordinate_;
  /**
   * <pre>
   * 위경도 좌표계
   * </pre>
   *
   * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
   */
  public boolean hasCoordinate() {
    return coordinate_ != null;
  }
  /**
   * <pre>
   * 위경도 좌표계
   * </pre>
   *
   * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
   */
  public dric.proto.CoordinateProto getCoordinate() {
    return coordinate_ == null ? dric.proto.CoordinateProto.getDefaultInstance() : coordinate_;
  }
  /**
   * <pre>
   * 위경도 좌표계
   * </pre>
   *
   * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
   */
  public dric.proto.CoordinateProtoOrBuilder getCoordinateOrBuilder() {
    return getCoordinate();
  }

  public static final int AZIMUTH_FIELD_NUMBER = 5;
  private float azimuth_;
  /**
   * <pre>
   * 방위각
   * </pre>
   *
   * <code>float azimuth = 5;</code>
   */
  public float getAzimuth() {
    return azimuth_;
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
    if (coordinate_ != null) {
      output.writeMessage(4, getCoordinate());
    }
    if (azimuth_ != 0F) {
      output.writeFloat(5, azimuth_);
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
    if (coordinate_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getCoordinate());
    }
    if (azimuth_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(5, azimuth_);
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
    if (!(obj instanceof dric.proto.ObjectTrackProto)) {
      return super.equals(obj);
    }
    dric.proto.ObjectTrackProto other = (dric.proto.ObjectTrackProto) obj;

    if (!getCameraId()
        .equals(other.getCameraId())) return false;
    if (!getLuid()
        .equals(other.getLuid())) return false;
    if (!getObjectClass()
        .equals(other.getObjectClass())) return false;
    if (hasCoordinate() != other.hasCoordinate()) return false;
    if (hasCoordinate()) {
      if (!getCoordinate()
          .equals(other.getCoordinate())) return false;
    }
    if (java.lang.Float.floatToIntBits(getAzimuth())
        != java.lang.Float.floatToIntBits(
            other.getAzimuth())) return false;
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
    if (hasCoordinate()) {
      hash = (37 * hash) + COORDINATE_FIELD_NUMBER;
      hash = (53 * hash) + getCoordinate().hashCode();
    }
    hash = (37 * hash) + AZIMUTH_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getAzimuth());
    hash = (37 * hash) + TS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTs());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dric.proto.ObjectTrackProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.ObjectTrackProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.ObjectTrackProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.ObjectTrackProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.ObjectTrackProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.ObjectTrackProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.ObjectTrackProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.ObjectTrackProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.ObjectTrackProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dric.proto.ObjectTrackProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.ObjectTrackProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.ObjectTrackProto parseFrom(
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
  public static Builder newBuilder(dric.proto.ObjectTrackProto prototype) {
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
   * Protobuf type {@code dric.proto.ObjectTrackProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dric.proto.ObjectTrackProto)
      dric.proto.ObjectTrackProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dric.proto.Dric.internal_static_dric_proto_ObjectTrackProto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dric.proto.Dric.internal_static_dric_proto_ObjectTrackProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dric.proto.ObjectTrackProto.class, dric.proto.ObjectTrackProto.Builder.class);
    }

    // Construct using dric.proto.ObjectTrackProto.newBuilder()
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

      if (coordinateBuilder_ == null) {
        coordinate_ = null;
      } else {
        coordinate_ = null;
        coordinateBuilder_ = null;
      }
      azimuth_ = 0F;

      ts_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dric.proto.Dric.internal_static_dric_proto_ObjectTrackProto_descriptor;
    }

    @java.lang.Override
    public dric.proto.ObjectTrackProto getDefaultInstanceForType() {
      return dric.proto.ObjectTrackProto.getDefaultInstance();
    }

    @java.lang.Override
    public dric.proto.ObjectTrackProto build() {
      dric.proto.ObjectTrackProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dric.proto.ObjectTrackProto buildPartial() {
      dric.proto.ObjectTrackProto result = new dric.proto.ObjectTrackProto(this);
      result.cameraId_ = cameraId_;
      result.luid_ = luid_;
      result.objectClass_ = objectClass_;
      if (coordinateBuilder_ == null) {
        result.coordinate_ = coordinate_;
      } else {
        result.coordinate_ = coordinateBuilder_.build();
      }
      result.azimuth_ = azimuth_;
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
      if (other instanceof dric.proto.ObjectTrackProto) {
        return mergeFrom((dric.proto.ObjectTrackProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dric.proto.ObjectTrackProto other) {
      if (other == dric.proto.ObjectTrackProto.getDefaultInstance()) return this;
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
      if (other.hasCoordinate()) {
        mergeCoordinate(other.getCoordinate());
      }
      if (other.getAzimuth() != 0F) {
        setAzimuth(other.getAzimuth());
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
      dric.proto.ObjectTrackProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dric.proto.ObjectTrackProto) e.getUnfinishedMessage();
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

    private dric.proto.CoordinateProto coordinate_;
    private com.google.protobuf.SingleFieldBuilderV3<
        dric.proto.CoordinateProto, dric.proto.CoordinateProto.Builder, dric.proto.CoordinateProtoOrBuilder> coordinateBuilder_;
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public boolean hasCoordinate() {
      return coordinateBuilder_ != null || coordinate_ != null;
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public dric.proto.CoordinateProto getCoordinate() {
      if (coordinateBuilder_ == null) {
        return coordinate_ == null ? dric.proto.CoordinateProto.getDefaultInstance() : coordinate_;
      } else {
        return coordinateBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public Builder setCoordinate(dric.proto.CoordinateProto value) {
      if (coordinateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        coordinate_ = value;
        onChanged();
      } else {
        coordinateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public Builder setCoordinate(
        dric.proto.CoordinateProto.Builder builderForValue) {
      if (coordinateBuilder_ == null) {
        coordinate_ = builderForValue.build();
        onChanged();
      } else {
        coordinateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public Builder mergeCoordinate(dric.proto.CoordinateProto value) {
      if (coordinateBuilder_ == null) {
        if (coordinate_ != null) {
          coordinate_ =
            dric.proto.CoordinateProto.newBuilder(coordinate_).mergeFrom(value).buildPartial();
        } else {
          coordinate_ = value;
        }
        onChanged();
      } else {
        coordinateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public Builder clearCoordinate() {
      if (coordinateBuilder_ == null) {
        coordinate_ = null;
        onChanged();
      } else {
        coordinate_ = null;
        coordinateBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public dric.proto.CoordinateProto.Builder getCoordinateBuilder() {
      
      onChanged();
      return getCoordinateFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    public dric.proto.CoordinateProtoOrBuilder getCoordinateOrBuilder() {
      if (coordinateBuilder_ != null) {
        return coordinateBuilder_.getMessageOrBuilder();
      } else {
        return coordinate_ == null ?
            dric.proto.CoordinateProto.getDefaultInstance() : coordinate_;
      }
    }
    /**
     * <pre>
     * 위경도 좌표계
     * </pre>
     *
     * <code>.dric.proto.CoordinateProto coordinate = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        dric.proto.CoordinateProto, dric.proto.CoordinateProto.Builder, dric.proto.CoordinateProtoOrBuilder> 
        getCoordinateFieldBuilder() {
      if (coordinateBuilder_ == null) {
        coordinateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            dric.proto.CoordinateProto, dric.proto.CoordinateProto.Builder, dric.proto.CoordinateProtoOrBuilder>(
                getCoordinate(),
                getParentForChildren(),
                isClean());
        coordinate_ = null;
      }
      return coordinateBuilder_;
    }

    private float azimuth_ ;
    /**
     * <pre>
     * 방위각
     * </pre>
     *
     * <code>float azimuth = 5;</code>
     */
    public float getAzimuth() {
      return azimuth_;
    }
    /**
     * <pre>
     * 방위각
     * </pre>
     *
     * <code>float azimuth = 5;</code>
     */
    public Builder setAzimuth(float value) {
      
      azimuth_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 방위각
     * </pre>
     *
     * <code>float azimuth = 5;</code>
     */
    public Builder clearAzimuth() {
      
      azimuth_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:dric.proto.ObjectTrackProto)
  }

  // @@protoc_insertion_point(class_scope:dric.proto.ObjectTrackProto)
  private static final dric.proto.ObjectTrackProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dric.proto.ObjectTrackProto();
  }

  public static dric.proto.ObjectTrackProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ObjectTrackProto>
      PARSER = new com.google.protobuf.AbstractParser<ObjectTrackProto>() {
    @java.lang.Override
    public ObjectTrackProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ObjectTrackProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ObjectTrackProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ObjectTrackProto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dric.proto.ObjectTrackProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

