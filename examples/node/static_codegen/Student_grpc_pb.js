// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('grpc');
var Student_pb = require('./Student_pb.js');

function serialize_grpc_HttpRequest(arg) {
  if (!(arg instanceof Student_pb.HttpRequest)) {
    throw new Error('Expected argument of type grpc.HttpRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_grpc_HttpRequest(buffer_arg) {
  return Student_pb.HttpRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_grpc_HttpResponse(arg) {
  if (!(arg instanceof Student_pb.HttpResponse)) {
    throw new Error('Expected argument of type grpc.HttpResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_grpc_HttpResponse(buffer_arg) {
  return Student_pb.HttpResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_grpc_StreamRequest(arg) {
  if (!(arg instanceof Student_pb.StreamRequest)) {
    throw new Error('Expected argument of type grpc.StreamRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_grpc_StreamRequest(buffer_arg) {
  return Student_pb.StreamRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_grpc_StreamRequestInfo(arg) {
  if (!(arg instanceof Student_pb.StreamRequestInfo)) {
    throw new Error('Expected argument of type grpc.StreamRequestInfo');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_grpc_StreamRequestInfo(buffer_arg) {
  return Student_pb.StreamRequestInfo.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_grpc_StreamResponse(arg) {
  if (!(arg instanceof Student_pb.StreamResponse)) {
    throw new Error('Expected argument of type grpc.StreamResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_grpc_StreamResponse(buffer_arg) {
  return Student_pb.StreamResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_grpc_StreamResponseInfo(arg) {
  if (!(arg instanceof Student_pb.StreamResponseInfo)) {
    throw new Error('Expected argument of type grpc.StreamResponseInfo');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_grpc_StreamResponseInfo(buffer_arg) {
  return Student_pb.StreamResponseInfo.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_grpc_StreamResponseList(arg) {
  if (!(arg instanceof Student_pb.StreamResponseList)) {
    throw new Error('Expected argument of type grpc.StreamResponseList');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_grpc_StreamResponseList(buffer_arg) {
  return Student_pb.StreamResponseList.deserializeBinary(new Uint8Array(buffer_arg));
}


var StudentServiceService = exports.StudentServiceService = {
  getRealnameByUsername: {
    path: '/grpc.StudentService/getRealnameByUsername',
    requestStream: false,
    responseStream: false,
    requestType: Student_pb.HttpRequest,
    responseType: Student_pb.HttpResponse,
    requestSerialize: serialize_grpc_HttpRequest,
    requestDeserialize: deserialize_grpc_HttpRequest,
    responseSerialize: serialize_grpc_HttpResponse,
    responseDeserialize: deserialize_grpc_HttpResponse,
  },
  getStudentsByAge: {
    path: '/grpc.StudentService/getStudentsByAge',
    requestStream: false,
    responseStream: true,
    requestType: Student_pb.StreamRequest,
    responseType: Student_pb.StreamResponse,
    requestSerialize: serialize_grpc_StreamRequest,
    requestDeserialize: deserialize_grpc_StreamRequest,
    responseSerialize: serialize_grpc_StreamResponse,
    responseDeserialize: deserialize_grpc_StreamResponse,
  },
  getStudentsWrapperByAges: {
    path: '/grpc.StudentService/getStudentsWrapperByAges',
    requestStream: true,
    responseStream: false,
    requestType: Student_pb.StreamRequest,
    responseType: Student_pb.StreamResponseList,
    requestSerialize: serialize_grpc_StreamRequest,
    requestDeserialize: deserialize_grpc_StreamRequest,
    responseSerialize: serialize_grpc_StreamResponseList,
    responseDeserialize: deserialize_grpc_StreamResponseList,
  },
  biTalk: {
    path: '/grpc.StudentService/biTalk',
    requestStream: true,
    responseStream: true,
    requestType: Student_pb.StreamRequestInfo,
    responseType: Student_pb.StreamResponseInfo,
    requestSerialize: serialize_grpc_StreamRequestInfo,
    requestDeserialize: deserialize_grpc_StreamRequestInfo,
    responseSerialize: serialize_grpc_StreamResponseInfo,
    responseDeserialize: deserialize_grpc_StreamResponseInfo,
  },
};

exports.StudentServiceClient = grpc.makeGenericClientConstructor(StudentServiceService);
