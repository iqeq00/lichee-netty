// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.lichee.grpc.example.proto;

public final class StudentProto {
  private StudentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_HttpRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_HttpRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_HttpResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_HttpResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rStudent.proto\022\004grpc\"\037\n\013HttpRequest\022\020\n\010" +
      "username\030\001 \001(\t\" \n\014HttpResponse\022\020\n\010realna" +
      "me\030\002 \001(\t2R\n\016StudentService\022@\n\025getRealnam" +
      "eByUsername\022\021.grpc.HttpRequest\032\022.grpc.Ht" +
      "tpResponse\"\000B/\n\035com.lichee.grpc.example." +
      "protoB\014StudentProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_grpc_HttpRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpc_HttpRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_HttpRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_grpc_HttpResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpc_HttpResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_HttpResponse_descriptor,
        new java.lang.String[] { "Realname", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
