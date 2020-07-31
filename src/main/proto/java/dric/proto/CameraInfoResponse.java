// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

/**
 * Protobuf type {@code dric.proto.CameraInfoResponse}
 */
public  final class CameraInfoResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dric.proto.CameraInfoResponse)
    CameraInfoResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CameraInfoResponse.newBuilder() to construct.
  private CameraInfoResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CameraInfoResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CameraInfoResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CameraInfoResponse(
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
            dric.proto.CameraInfo.Builder subBuilder = null;
            if (eitherCase_ == 1) {
              subBuilder = ((dric.proto.CameraInfo) either_).toBuilder();
            }
            either_ =
                input.readMessage(dric.proto.CameraInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((dric.proto.CameraInfo) either_);
              either_ = subBuilder.buildPartial();
            }
            eitherCase_ = 1;
            break;
          }
          case 18: {
            marmot.proto.ErrorProto.Builder subBuilder = null;
            if (eitherCase_ == 2) {
              subBuilder = ((marmot.proto.ErrorProto) either_).toBuilder();
            }
            either_ =
                input.readMessage(marmot.proto.ErrorProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((marmot.proto.ErrorProto) either_);
              either_ = subBuilder.buildPartial();
            }
            eitherCase_ = 2;
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
    return dric.proto.Dric.internal_static_dric_proto_CameraInfoResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dric.proto.Dric.internal_static_dric_proto_CameraInfoResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dric.proto.CameraInfoResponse.class, dric.proto.CameraInfoResponse.Builder.class);
  }

  private int eitherCase_ = 0;
  private java.lang.Object either_;
  public enum EitherCase
      implements com.google.protobuf.Internal.EnumLite {
    CAMERA_INFO(1),
    ERROR(2),
    EITHER_NOT_SET(0);
    private final int value;
    private EitherCase(int value) {
      this.value = value;
    }
    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static EitherCase valueOf(int value) {
      return forNumber(value);
    }

    public static EitherCase forNumber(int value) {
      switch (value) {
        case 1: return CAMERA_INFO;
        case 2: return ERROR;
        case 0: return EITHER_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public EitherCase
  getEitherCase() {
    return EitherCase.forNumber(
        eitherCase_);
  }

  public static final int CAMERA_INFO_FIELD_NUMBER = 1;
  /**
   * <code>.dric.proto.CameraInfo camera_info = 1;</code>
   */
  public boolean hasCameraInfo() {
    return eitherCase_ == 1;
  }
  /**
   * <code>.dric.proto.CameraInfo camera_info = 1;</code>
   */
  public dric.proto.CameraInfo getCameraInfo() {
    if (eitherCase_ == 1) {
       return (dric.proto.CameraInfo) either_;
    }
    return dric.proto.CameraInfo.getDefaultInstance();
  }
  /**
   * <code>.dric.proto.CameraInfo camera_info = 1;</code>
   */
  public dric.proto.CameraInfoOrBuilder getCameraInfoOrBuilder() {
    if (eitherCase_ == 1) {
       return (dric.proto.CameraInfo) either_;
    }
    return dric.proto.CameraInfo.getDefaultInstance();
  }

  public static final int ERROR_FIELD_NUMBER = 2;
  /**
   * <code>.marmot.proto.ErrorProto error = 2;</code>
   */
  public boolean hasError() {
    return eitherCase_ == 2;
  }
  /**
   * <code>.marmot.proto.ErrorProto error = 2;</code>
   */
  public marmot.proto.ErrorProto getError() {
    if (eitherCase_ == 2) {
       return (marmot.proto.ErrorProto) either_;
    }
    return marmot.proto.ErrorProto.getDefaultInstance();
  }
  /**
   * <code>.marmot.proto.ErrorProto error = 2;</code>
   */
  public marmot.proto.ErrorProtoOrBuilder getErrorOrBuilder() {
    if (eitherCase_ == 2) {
       return (marmot.proto.ErrorProto) either_;
    }
    return marmot.proto.ErrorProto.getDefaultInstance();
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
    if (eitherCase_ == 1) {
      output.writeMessage(1, (dric.proto.CameraInfo) either_);
    }
    if (eitherCase_ == 2) {
      output.writeMessage(2, (marmot.proto.ErrorProto) either_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (eitherCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (dric.proto.CameraInfo) either_);
    }
    if (eitherCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (marmot.proto.ErrorProto) either_);
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
    if (!(obj instanceof dric.proto.CameraInfoResponse)) {
      return super.equals(obj);
    }
    dric.proto.CameraInfoResponse other = (dric.proto.CameraInfoResponse) obj;

    if (!getEitherCase().equals(other.getEitherCase())) return false;
    switch (eitherCase_) {
      case 1:
        if (!getCameraInfo()
            .equals(other.getCameraInfo())) return false;
        break;
      case 2:
        if (!getError()
            .equals(other.getError())) return false;
        break;
      case 0:
      default:
    }
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
    switch (eitherCase_) {
      case 1:
        hash = (37 * hash) + CAMERA_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getCameraInfo().hashCode();
        break;
      case 2:
        hash = (37 * hash) + ERROR_FIELD_NUMBER;
        hash = (53 * hash) + getError().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dric.proto.CameraInfoResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.CameraInfoResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.CameraInfoResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.CameraInfoResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.CameraInfoResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.CameraInfoResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.CameraInfoResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.CameraInfoResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.CameraInfoResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dric.proto.CameraInfoResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.CameraInfoResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.CameraInfoResponse parseFrom(
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
  public static Builder newBuilder(dric.proto.CameraInfoResponse prototype) {
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
   * Protobuf type {@code dric.proto.CameraInfoResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dric.proto.CameraInfoResponse)
      dric.proto.CameraInfoResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dric.proto.Dric.internal_static_dric_proto_CameraInfoResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dric.proto.Dric.internal_static_dric_proto_CameraInfoResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dric.proto.CameraInfoResponse.class, dric.proto.CameraInfoResponse.Builder.class);
    }

    // Construct using dric.proto.CameraInfoResponse.newBuilder()
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
      eitherCase_ = 0;
      either_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dric.proto.Dric.internal_static_dric_proto_CameraInfoResponse_descriptor;
    }

    @java.lang.Override
    public dric.proto.CameraInfoResponse getDefaultInstanceForType() {
      return dric.proto.CameraInfoResponse.getDefaultInstance();
    }

    @java.lang.Override
    public dric.proto.CameraInfoResponse build() {
      dric.proto.CameraInfoResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dric.proto.CameraInfoResponse buildPartial() {
      dric.proto.CameraInfoResponse result = new dric.proto.CameraInfoResponse(this);
      if (eitherCase_ == 1) {
        if (cameraInfoBuilder_ == null) {
          result.either_ = either_;
        } else {
          result.either_ = cameraInfoBuilder_.build();
        }
      }
      if (eitherCase_ == 2) {
        if (errorBuilder_ == null) {
          result.either_ = either_;
        } else {
          result.either_ = errorBuilder_.build();
        }
      }
      result.eitherCase_ = eitherCase_;
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
      if (other instanceof dric.proto.CameraInfoResponse) {
        return mergeFrom((dric.proto.CameraInfoResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dric.proto.CameraInfoResponse other) {
      if (other == dric.proto.CameraInfoResponse.getDefaultInstance()) return this;
      switch (other.getEitherCase()) {
        case CAMERA_INFO: {
          mergeCameraInfo(other.getCameraInfo());
          break;
        }
        case ERROR: {
          mergeError(other.getError());
          break;
        }
        case EITHER_NOT_SET: {
          break;
        }
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
      dric.proto.CameraInfoResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dric.proto.CameraInfoResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int eitherCase_ = 0;
    private java.lang.Object either_;
    public EitherCase
        getEitherCase() {
      return EitherCase.forNumber(
          eitherCase_);
    }

    public Builder clearEither() {
      eitherCase_ = 0;
      either_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        dric.proto.CameraInfo, dric.proto.CameraInfo.Builder, dric.proto.CameraInfoOrBuilder> cameraInfoBuilder_;
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public boolean hasCameraInfo() {
      return eitherCase_ == 1;
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public dric.proto.CameraInfo getCameraInfo() {
      if (cameraInfoBuilder_ == null) {
        if (eitherCase_ == 1) {
          return (dric.proto.CameraInfo) either_;
        }
        return dric.proto.CameraInfo.getDefaultInstance();
      } else {
        if (eitherCase_ == 1) {
          return cameraInfoBuilder_.getMessage();
        }
        return dric.proto.CameraInfo.getDefaultInstance();
      }
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public Builder setCameraInfo(dric.proto.CameraInfo value) {
      if (cameraInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        either_ = value;
        onChanged();
      } else {
        cameraInfoBuilder_.setMessage(value);
      }
      eitherCase_ = 1;
      return this;
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public Builder setCameraInfo(
        dric.proto.CameraInfo.Builder builderForValue) {
      if (cameraInfoBuilder_ == null) {
        either_ = builderForValue.build();
        onChanged();
      } else {
        cameraInfoBuilder_.setMessage(builderForValue.build());
      }
      eitherCase_ = 1;
      return this;
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public Builder mergeCameraInfo(dric.proto.CameraInfo value) {
      if (cameraInfoBuilder_ == null) {
        if (eitherCase_ == 1 &&
            either_ != dric.proto.CameraInfo.getDefaultInstance()) {
          either_ = dric.proto.CameraInfo.newBuilder((dric.proto.CameraInfo) either_)
              .mergeFrom(value).buildPartial();
        } else {
          either_ = value;
        }
        onChanged();
      } else {
        if (eitherCase_ == 1) {
          cameraInfoBuilder_.mergeFrom(value);
        }
        cameraInfoBuilder_.setMessage(value);
      }
      eitherCase_ = 1;
      return this;
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public Builder clearCameraInfo() {
      if (cameraInfoBuilder_ == null) {
        if (eitherCase_ == 1) {
          eitherCase_ = 0;
          either_ = null;
          onChanged();
        }
      } else {
        if (eitherCase_ == 1) {
          eitherCase_ = 0;
          either_ = null;
        }
        cameraInfoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public dric.proto.CameraInfo.Builder getCameraInfoBuilder() {
      return getCameraInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    public dric.proto.CameraInfoOrBuilder getCameraInfoOrBuilder() {
      if ((eitherCase_ == 1) && (cameraInfoBuilder_ != null)) {
        return cameraInfoBuilder_.getMessageOrBuilder();
      } else {
        if (eitherCase_ == 1) {
          return (dric.proto.CameraInfo) either_;
        }
        return dric.proto.CameraInfo.getDefaultInstance();
      }
    }
    /**
     * <code>.dric.proto.CameraInfo camera_info = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        dric.proto.CameraInfo, dric.proto.CameraInfo.Builder, dric.proto.CameraInfoOrBuilder> 
        getCameraInfoFieldBuilder() {
      if (cameraInfoBuilder_ == null) {
        if (!(eitherCase_ == 1)) {
          either_ = dric.proto.CameraInfo.getDefaultInstance();
        }
        cameraInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            dric.proto.CameraInfo, dric.proto.CameraInfo.Builder, dric.proto.CameraInfoOrBuilder>(
                (dric.proto.CameraInfo) either_,
                getParentForChildren(),
                isClean());
        either_ = null;
      }
      eitherCase_ = 1;
      onChanged();;
      return cameraInfoBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        marmot.proto.ErrorProto, marmot.proto.ErrorProto.Builder, marmot.proto.ErrorProtoOrBuilder> errorBuilder_;
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public boolean hasError() {
      return eitherCase_ == 2;
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public marmot.proto.ErrorProto getError() {
      if (errorBuilder_ == null) {
        if (eitherCase_ == 2) {
          return (marmot.proto.ErrorProto) either_;
        }
        return marmot.proto.ErrorProto.getDefaultInstance();
      } else {
        if (eitherCase_ == 2) {
          return errorBuilder_.getMessage();
        }
        return marmot.proto.ErrorProto.getDefaultInstance();
      }
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public Builder setError(marmot.proto.ErrorProto value) {
      if (errorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        either_ = value;
        onChanged();
      } else {
        errorBuilder_.setMessage(value);
      }
      eitherCase_ = 2;
      return this;
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public Builder setError(
        marmot.proto.ErrorProto.Builder builderForValue) {
      if (errorBuilder_ == null) {
        either_ = builderForValue.build();
        onChanged();
      } else {
        errorBuilder_.setMessage(builderForValue.build());
      }
      eitherCase_ = 2;
      return this;
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public Builder mergeError(marmot.proto.ErrorProto value) {
      if (errorBuilder_ == null) {
        if (eitherCase_ == 2 &&
            either_ != marmot.proto.ErrorProto.getDefaultInstance()) {
          either_ = marmot.proto.ErrorProto.newBuilder((marmot.proto.ErrorProto) either_)
              .mergeFrom(value).buildPartial();
        } else {
          either_ = value;
        }
        onChanged();
      } else {
        if (eitherCase_ == 2) {
          errorBuilder_.mergeFrom(value);
        }
        errorBuilder_.setMessage(value);
      }
      eitherCase_ = 2;
      return this;
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public Builder clearError() {
      if (errorBuilder_ == null) {
        if (eitherCase_ == 2) {
          eitherCase_ = 0;
          either_ = null;
          onChanged();
        }
      } else {
        if (eitherCase_ == 2) {
          eitherCase_ = 0;
          either_ = null;
        }
        errorBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public marmot.proto.ErrorProto.Builder getErrorBuilder() {
      return getErrorFieldBuilder().getBuilder();
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    public marmot.proto.ErrorProtoOrBuilder getErrorOrBuilder() {
      if ((eitherCase_ == 2) && (errorBuilder_ != null)) {
        return errorBuilder_.getMessageOrBuilder();
      } else {
        if (eitherCase_ == 2) {
          return (marmot.proto.ErrorProto) either_;
        }
        return marmot.proto.ErrorProto.getDefaultInstance();
      }
    }
    /**
     * <code>.marmot.proto.ErrorProto error = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        marmot.proto.ErrorProto, marmot.proto.ErrorProto.Builder, marmot.proto.ErrorProtoOrBuilder> 
        getErrorFieldBuilder() {
      if (errorBuilder_ == null) {
        if (!(eitherCase_ == 2)) {
          either_ = marmot.proto.ErrorProto.getDefaultInstance();
        }
        errorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            marmot.proto.ErrorProto, marmot.proto.ErrorProto.Builder, marmot.proto.ErrorProtoOrBuilder>(
                (marmot.proto.ErrorProto) either_,
                getParentForChildren(),
                isClean());
        either_ = null;
      }
      eitherCase_ = 2;
      onChanged();;
      return errorBuilder_;
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


    // @@protoc_insertion_point(builder_scope:dric.proto.CameraInfoResponse)
  }

  // @@protoc_insertion_point(class_scope:dric.proto.CameraInfoResponse)
  private static final dric.proto.CameraInfoResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dric.proto.CameraInfoResponse();
  }

  public static dric.proto.CameraInfoResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CameraInfoResponse>
      PARSER = new com.google.protobuf.AbstractParser<CameraInfoResponse>() {
    @java.lang.Override
    public CameraInfoResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CameraInfoResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CameraInfoResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CameraInfoResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dric.proto.CameraInfoResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
