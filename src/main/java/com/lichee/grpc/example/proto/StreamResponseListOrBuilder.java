// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.lichee.grpc.example.proto;

public interface StreamResponseListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.StreamResponseList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  java.util.List<com.lichee.grpc.example.proto.StreamResponse> 
      getStreamResponseList();
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  com.lichee.grpc.example.proto.StreamResponse getStreamResponse(int index);
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  int getStreamResponseCount();
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  java.util.List<? extends com.lichee.grpc.example.proto.StreamResponseOrBuilder> 
      getStreamResponseOrBuilderList();
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  com.lichee.grpc.example.proto.StreamResponseOrBuilder getStreamResponseOrBuilder(
      int index);
}
