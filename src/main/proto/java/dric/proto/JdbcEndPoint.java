// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dric.proto

package dric.proto;

/**
 * Protobuf type {@code dric.proto.JdbcEndPoint}
 */
public  final class JdbcEndPoint extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dric.proto.JdbcEndPoint)
    JdbcEndPointOrBuilder {
private static final long serialVersionUID = 0L;
  // Use JdbcEndPoint.newBuilder() to construct.
  private JdbcEndPoint(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private JdbcEndPoint() {
    system_ = "";
    host_ = "";
    dbName_ = "";
    user_ = "";
    password_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new JdbcEndPoint();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private JdbcEndPoint(
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

            system_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            host_ = s;
            break;
          }
          case 24: {

            port_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            dbName_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            user_ = s;
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            password_ = s;
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
    return dric.proto.Dric.internal_static_dric_proto_JdbcEndPoint_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dric.proto.Dric.internal_static_dric_proto_JdbcEndPoint_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dric.proto.JdbcEndPoint.class, dric.proto.JdbcEndPoint.Builder.class);
  }

  public static final int SYSTEM_FIELD_NUMBER = 1;
  private volatile java.lang.Object system_;
  /**
   * <code>string system = 1;</code>
   */
  public java.lang.String getSystem() {
    java.lang.Object ref = system_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      system_ = s;
      return s;
    }
  }
  /**
   * <code>string system = 1;</code>
   */
  public com.google.protobuf.ByteString
      getSystemBytes() {
    java.lang.Object ref = system_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      system_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOST_FIELD_NUMBER = 2;
  private volatile java.lang.Object host_;
  /**
   * <code>string host = 2;</code>
   */
  public java.lang.String getHost() {
    java.lang.Object ref = host_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      host_ = s;
      return s;
    }
  }
  /**
   * <code>string host = 2;</code>
   */
  public com.google.protobuf.ByteString
      getHostBytes() {
    java.lang.Object ref = host_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      host_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PORT_FIELD_NUMBER = 3;
  private int port_;
  /**
   * <code>int32 port = 3;</code>
   */
  public int getPort() {
    return port_;
  }

  public static final int DB_NAME_FIELD_NUMBER = 4;
  private volatile java.lang.Object dbName_;
  /**
   * <code>string db_name = 4;</code>
   */
  public java.lang.String getDbName() {
    java.lang.Object ref = dbName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dbName_ = s;
      return s;
    }
  }
  /**
   * <code>string db_name = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDbNameBytes() {
    java.lang.Object ref = dbName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dbName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USER_FIELD_NUMBER = 5;
  private volatile java.lang.Object user_;
  /**
   * <code>string user = 5;</code>
   */
  public java.lang.String getUser() {
    java.lang.Object ref = user_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      user_ = s;
      return s;
    }
  }
  /**
   * <code>string user = 5;</code>
   */
  public com.google.protobuf.ByteString
      getUserBytes() {
    java.lang.Object ref = user_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      user_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PASSWORD_FIELD_NUMBER = 6;
  private volatile java.lang.Object password_;
  /**
   * <code>string password = 6;</code>
   */
  public java.lang.String getPassword() {
    java.lang.Object ref = password_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      password_ = s;
      return s;
    }
  }
  /**
   * <code>string password = 6;</code>
   */
  public com.google.protobuf.ByteString
      getPasswordBytes() {
    java.lang.Object ref = password_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      password_ = b;
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
    if (!getSystemBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, system_);
    }
    if (!getHostBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, host_);
    }
    if (port_ != 0) {
      output.writeInt32(3, port_);
    }
    if (!getDbNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, dbName_);
    }
    if (!getUserBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, user_);
    }
    if (!getPasswordBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, password_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getSystemBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, system_);
    }
    if (!getHostBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, host_);
    }
    if (port_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, port_);
    }
    if (!getDbNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, dbName_);
    }
    if (!getUserBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, user_);
    }
    if (!getPasswordBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, password_);
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
    if (!(obj instanceof dric.proto.JdbcEndPoint)) {
      return super.equals(obj);
    }
    dric.proto.JdbcEndPoint other = (dric.proto.JdbcEndPoint) obj;

    if (!getSystem()
        .equals(other.getSystem())) return false;
    if (!getHost()
        .equals(other.getHost())) return false;
    if (getPort()
        != other.getPort()) return false;
    if (!getDbName()
        .equals(other.getDbName())) return false;
    if (!getUser()
        .equals(other.getUser())) return false;
    if (!getPassword()
        .equals(other.getPassword())) return false;
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
    hash = (37 * hash) + SYSTEM_FIELD_NUMBER;
    hash = (53 * hash) + getSystem().hashCode();
    hash = (37 * hash) + HOST_FIELD_NUMBER;
    hash = (53 * hash) + getHost().hashCode();
    hash = (37 * hash) + PORT_FIELD_NUMBER;
    hash = (53 * hash) + getPort();
    hash = (37 * hash) + DB_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getDbName().hashCode();
    hash = (37 * hash) + USER_FIELD_NUMBER;
    hash = (53 * hash) + getUser().hashCode();
    hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
    hash = (53 * hash) + getPassword().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dric.proto.JdbcEndPoint parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.JdbcEndPoint parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.JdbcEndPoint parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.JdbcEndPoint parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.JdbcEndPoint parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dric.proto.JdbcEndPoint parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dric.proto.JdbcEndPoint parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.JdbcEndPoint parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.JdbcEndPoint parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dric.proto.JdbcEndPoint parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dric.proto.JdbcEndPoint parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dric.proto.JdbcEndPoint parseFrom(
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
  public static Builder newBuilder(dric.proto.JdbcEndPoint prototype) {
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
   * Protobuf type {@code dric.proto.JdbcEndPoint}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dric.proto.JdbcEndPoint)
      dric.proto.JdbcEndPointOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dric.proto.Dric.internal_static_dric_proto_JdbcEndPoint_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dric.proto.Dric.internal_static_dric_proto_JdbcEndPoint_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dric.proto.JdbcEndPoint.class, dric.proto.JdbcEndPoint.Builder.class);
    }

    // Construct using dric.proto.JdbcEndPoint.newBuilder()
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
      system_ = "";

      host_ = "";

      port_ = 0;

      dbName_ = "";

      user_ = "";

      password_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dric.proto.Dric.internal_static_dric_proto_JdbcEndPoint_descriptor;
    }

    @java.lang.Override
    public dric.proto.JdbcEndPoint getDefaultInstanceForType() {
      return dric.proto.JdbcEndPoint.getDefaultInstance();
    }

    @java.lang.Override
    public dric.proto.JdbcEndPoint build() {
      dric.proto.JdbcEndPoint result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dric.proto.JdbcEndPoint buildPartial() {
      dric.proto.JdbcEndPoint result = new dric.proto.JdbcEndPoint(this);
      result.system_ = system_;
      result.host_ = host_;
      result.port_ = port_;
      result.dbName_ = dbName_;
      result.user_ = user_;
      result.password_ = password_;
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
      if (other instanceof dric.proto.JdbcEndPoint) {
        return mergeFrom((dric.proto.JdbcEndPoint)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dric.proto.JdbcEndPoint other) {
      if (other == dric.proto.JdbcEndPoint.getDefaultInstance()) return this;
      if (!other.getSystem().isEmpty()) {
        system_ = other.system_;
        onChanged();
      }
      if (!other.getHost().isEmpty()) {
        host_ = other.host_;
        onChanged();
      }
      if (other.getPort() != 0) {
        setPort(other.getPort());
      }
      if (!other.getDbName().isEmpty()) {
        dbName_ = other.dbName_;
        onChanged();
      }
      if (!other.getUser().isEmpty()) {
        user_ = other.user_;
        onChanged();
      }
      if (!other.getPassword().isEmpty()) {
        password_ = other.password_;
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
      dric.proto.JdbcEndPoint parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dric.proto.JdbcEndPoint) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object system_ = "";
    /**
     * <code>string system = 1;</code>
     */
    public java.lang.String getSystem() {
      java.lang.Object ref = system_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        system_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string system = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSystemBytes() {
      java.lang.Object ref = system_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        system_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string system = 1;</code>
     */
    public Builder setSystem(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      system_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string system = 1;</code>
     */
    public Builder clearSystem() {
      
      system_ = getDefaultInstance().getSystem();
      onChanged();
      return this;
    }
    /**
     * <code>string system = 1;</code>
     */
    public Builder setSystemBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      system_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object host_ = "";
    /**
     * <code>string host = 2;</code>
     */
    public java.lang.String getHost() {
      java.lang.Object ref = host_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        host_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string host = 2;</code>
     */
    public com.google.protobuf.ByteString
        getHostBytes() {
      java.lang.Object ref = host_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        host_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string host = 2;</code>
     */
    public Builder setHost(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      host_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string host = 2;</code>
     */
    public Builder clearHost() {
      
      host_ = getDefaultInstance().getHost();
      onChanged();
      return this;
    }
    /**
     * <code>string host = 2;</code>
     */
    public Builder setHostBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      host_ = value;
      onChanged();
      return this;
    }

    private int port_ ;
    /**
     * <code>int32 port = 3;</code>
     */
    public int getPort() {
      return port_;
    }
    /**
     * <code>int32 port = 3;</code>
     */
    public Builder setPort(int value) {
      
      port_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 port = 3;</code>
     */
    public Builder clearPort() {
      
      port_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object dbName_ = "";
    /**
     * <code>string db_name = 4;</code>
     */
    public java.lang.String getDbName() {
      java.lang.Object ref = dbName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dbName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string db_name = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDbNameBytes() {
      java.lang.Object ref = dbName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dbName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string db_name = 4;</code>
     */
    public Builder setDbName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dbName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string db_name = 4;</code>
     */
    public Builder clearDbName() {
      
      dbName_ = getDefaultInstance().getDbName();
      onChanged();
      return this;
    }
    /**
     * <code>string db_name = 4;</code>
     */
    public Builder setDbNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dbName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object user_ = "";
    /**
     * <code>string user = 5;</code>
     */
    public java.lang.String getUser() {
      java.lang.Object ref = user_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        user_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string user = 5;</code>
     */
    public com.google.protobuf.ByteString
        getUserBytes() {
      java.lang.Object ref = user_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        user_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string user = 5;</code>
     */
    public Builder setUser(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      user_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string user = 5;</code>
     */
    public Builder clearUser() {
      
      user_ = getDefaultInstance().getUser();
      onChanged();
      return this;
    }
    /**
     * <code>string user = 5;</code>
     */
    public Builder setUserBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      user_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object password_ = "";
    /**
     * <code>string password = 6;</code>
     */
    public java.lang.String getPassword() {
      java.lang.Object ref = password_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        password_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string password = 6;</code>
     */
    public com.google.protobuf.ByteString
        getPasswordBytes() {
      java.lang.Object ref = password_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        password_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string password = 6;</code>
     */
    public Builder setPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      password_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string password = 6;</code>
     */
    public Builder clearPassword() {
      
      password_ = getDefaultInstance().getPassword();
      onChanged();
      return this;
    }
    /**
     * <code>string password = 6;</code>
     */
    public Builder setPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      password_ = value;
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


    // @@protoc_insertion_point(builder_scope:dric.proto.JdbcEndPoint)
  }

  // @@protoc_insertion_point(class_scope:dric.proto.JdbcEndPoint)
  private static final dric.proto.JdbcEndPoint DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dric.proto.JdbcEndPoint();
  }

  public static dric.proto.JdbcEndPoint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<JdbcEndPoint>
      PARSER = new com.google.protobuf.AbstractParser<JdbcEndPoint>() {
    @java.lang.Override
    public JdbcEndPoint parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new JdbcEndPoint(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<JdbcEndPoint> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<JdbcEndPoint> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dric.proto.JdbcEndPoint getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

