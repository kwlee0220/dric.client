// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

/**
 * Protobuf type {@code dric.proto.CameraFrameResponse}
 */
public  final class CameraFrameResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dric.proto.CameraFrameResponse)
    CameraFrameResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CameraFrameResponse.newBuilder() to construct.
  private CameraFrameResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CameraFrameResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CameraFrameResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CameraFrameResponse(
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
            dric.proto.CameraFrameProto.Builder subBuilder = null;
            if (eitherCase_ == 1) {
              subBuilder = ((dric.proto.CameraFrameProto) either_).toBuilder();
            }
            either_ =
                input.readMessage(dric.proto.CameraFrameProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((dric.proto.CameraFrameProto) either_);
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
    return dric.proto.Dric.internal_static_dric_proto_CameraFrameResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dric.proto.Dric.internal_static_dric_proto_CameraFrameResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dric.proto.CameraFrameResponse.class, dric.proto.CameraFrameResponse.Builder.class);
  }

  private int eitherCase_ = 0;
  private java.lang.Object either_;
  public enum EitherCase
      implements com.google.protobuf.Internal.EnumLite {
    FRAME(1),
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
        case 1: return FRAME;
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

  public static final int FRAME_FIELD_NUMBER = 1;
  /**
   * <code>.dric.proto.CameraFrameProto frame = 1;</code>
   */
  public boolean hasFrame() {
    return eitherCase_ == 1;
  }
  /**
   * <code>.dric.proto.CameraFrameProto frame = 1;</code>
   */
  public dric.proto.CameraFrameProto getFrame() {
    if (eitherCase_ == 1) {
       return (dric.proto.CameraFrameProto) either_;
    }
    return dric.proto.CameraFrameProto.getDefaultInstance();
  }
  /**
   * <code>.dric.proto.CameraFrameProto frame = 1;</code>
   */
  public dric.proto.CameraFrameProtoOrBuilder getFrameOrBuilder() {
    if (eitherCase_ == 1) {
       return (dric.proto.CameraFrameProto) either_;
    }
    return dric.proto.CameraFrameProto.getDefaultInstance();
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
      output.writeMessage(1, (dric.proto.CameraFrameProto) either_);
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
        .computeMessageSize(1, (dric.proto.CameraFrameProto) either_);
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
    if (!(obj instanceof dric.proto.CameraFrameResponse)) {
      return super.equals(obj);
    }
    dric.proto.CameraFrameResponse other = (dric.proto.CameraFrameResponse) obj;

    if (!getEitherCase().equals(other.getEitherCase())) return false;
    switch (eitherCase_) {
      case 1:
        if (!getFrame()
            .equals(other.getFrame())) return false;
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
        hash = (37 * hash) + FRAME_FIELD_NUMBER;
        hash = (53 * hash) + getFrame().hashCode();
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

  public static dric.proto.CameraFrameResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.CameraFrameResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.CameraFrameResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.CameraFrameResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.CameraFrameResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.CameraFrameResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.CameraFrameResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.CameraFrameResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.CameraFrameResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dric.proto.CameraFrameResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.CameraFrameResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.CameraFrameResponse parseFrom(
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
  public static Builder newBuilder(dric.proto.CameraFrameResponse prototype) {
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
   * Protobuf type {@code dric.proto.CameraFrameResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dric.proto.CameraFrameResponse)
      dric.proto.CameraFrameResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dric.proto.Dric.internal_static_dric_proto_CameraFrameResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dric.proto.Dric.internal_static_dric_proto_CameraFrameResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dric.proto.CameraFrameResponse.class, dric.proto.CameraFrameResponse.Builder.class);
    }

    // Construct using dric.proto.CameraFrameResponse.newBuilder()
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
      return dric.proto.Dric.internal_static_dric_proto_CameraFrameResponse_descriptor;
    }

    @java.lang.Override
    public dric.proto.CameraFrameResponse getDefaultInstanceForType() {
      return dric.proto.CameraFrameResponse.getDefaultInstance();
    }

    @java.lang.Override
    public dric.proto.CameraFrameResponse build() {
      dric.proto.CameraFrameResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dric.proto.CameraFrameResponse buildPartial() {
      dric.proto.CameraFrameResponse result = new dric.proto.CameraFrameResponse(this);
      if (eitherCase_ == 1) {
        if (frameBuilder_ == null) {
          result.either_ = either_;
        } else {
          result.either_ = frameBuilder_.build();
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
      if (other instanceof dric.proto.CameraFrameResponse) {
        return mergeFrom((dric.proto.CameraFrameResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dric.proto.CameraFrameResponse other) {
      if (other == dric.proto.CameraFrameResponse.getDefaultInstance()) return this;
      switch (other.getEitherCase()) {
        case FRAME: {
          mergeFrame(other.getFrame());
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
      dric.proto.CameraFrameResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dric.proto.CameraFrameResponse) e.getUnfinishedMessage();
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
        dric.proto.CameraFrameProto, dric.proto.CameraFrameProto.Builder, dric.proto.CameraFrameProtoOrBuilder> frameBuilder_;
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public boolean hasFrame() {
      return eitherCase_ == 1;
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public dric.proto.CameraFrameProto getFrame() {
      if (frameBuilder_ == null) {
        if (eitherCase_ == 1) {
          return (dric.proto.CameraFrameProto) either_;
        }
        return dric.proto.CameraFrameProto.getDefaultInstance();
      } else {
        if (eitherCase_ == 1) {
          return frameBuilder_.getMessage();
        }
        return dric.proto.CameraFrameProto.getDefaultInstance();
      }
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public Builder setFrame(dric.proto.CameraFrameProto value) {
      if (frameBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        either_ = value;
        onChanged();
      } else {
        frameBuilder_.setMessage(value);
      }
      eitherCase_ = 1;
      return this;
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public Builder setFrame(
        dric.proto.CameraFrameProto.Builder builderForValue) {
      if (frameBuilder_ == null) {
        either_ = builderForValue.build();
        onChanged();
      } else {
        frameBuilder_.setMessage(builderForValue.build());
      }
      eitherCase_ = 1;
      return this;
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public Builder mergeFrame(dric.proto.CameraFrameProto value) {
      if (frameBuilder_ == null) {
        if (eitherCase_ == 1 &&
            either_ != dric.proto.CameraFrameProto.getDefaultInstance()) {
          either_ = dric.proto.CameraFrameProto.newBuilder((dric.proto.CameraFrameProto) either_)
              .mergeFrom(value).buildPartial();
        } else {
          either_ = value;
        }
        onChanged();
      } else {
        if (eitherCase_ == 1) {
          frameBuilder_.mergeFrom(value);
        }
        frameBuilder_.setMessage(value);
      }
      eitherCase_ = 1;
      return this;
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public Builder clearFrame() {
      if (frameBuilder_ == null) {
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
        frameBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public dric.proto.CameraFrameProto.Builder getFrameBuilder() {
      return getFrameFieldBuilder().getBuilder();
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    public dric.proto.CameraFrameProtoOrBuilder getFrameOrBuilder() {
      if ((eitherCase_ == 1) && (frameBuilder_ != null)) {
        return frameBuilder_.getMessageOrBuilder();
      } else {
        if (eitherCase_ == 1) {
          return (dric.proto.CameraFrameProto) either_;
        }
        return dric.proto.CameraFrameProto.getDefaultInstance();
      }
    }
    /**
     * <code>.dric.proto.CameraFrameProto frame = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        dric.proto.CameraFrameProto, dric.proto.CameraFrameProto.Builder, dric.proto.CameraFrameProtoOrBuilder> 
        getFrameFieldBuilder() {
      if (frameBuilder_ == null) {
        if (!(eitherCase_ == 1)) {
          either_ = dric.proto.CameraFrameProto.getDefaultInstance();
        }
        frameBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            dric.proto.CameraFrameProto, dric.proto.CameraFrameProto.Builder, dric.proto.CameraFrameProtoOrBuilder>(
                (dric.proto.CameraFrameProto) either_,
                getParentForChildren(),
                isClean());
        either_ = null;
      }
      eitherCase_ = 1;
      onChanged();;
      return frameBuilder_;
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


    // @@protoc_insertion_point(builder_scope:dric.proto.CameraFrameResponse)
  }

  // @@protoc_insertion_point(class_scope:dric.proto.CameraFrameResponse)
  private static final dric.proto.CameraFrameResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dric.proto.CameraFrameResponse();
  }

  public static dric.proto.CameraFrameResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CameraFrameResponse>
      PARSER = new com.google.protobuf.AbstractParser<CameraFrameResponse>() {
    @java.lang.Override
    public CameraFrameResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CameraFrameResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CameraFrameResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CameraFrameResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dric.proto.CameraFrameResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

