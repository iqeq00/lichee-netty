// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.lichee.grpc.example.proto;

public interface StreamResponseListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.StreamResponseList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  java.util.List<StreamResponse>
      getStreamResponseList();
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  StreamResponse getStreamResponse(int index);
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  int getStreamResponseCount();
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  java.util.List<? extends StreamResponseOrBuilder>
      getStreamResponseOrBuilderList();
  /**
   * <code>repeated .grpc.StreamResponse streamResponse = 1;</code>
   */
  StreamResponseOrBuilder getStreamResponseOrBuilder(
          int index);
}
