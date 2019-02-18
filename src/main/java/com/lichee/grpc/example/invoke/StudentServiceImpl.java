package com.lichee.grpc.example.invoke;

import com.lichee.grpc.example.proto.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealnameByUsername(HttpRequest request, StreamObserver<HttpResponse> responseObserver) {

        System.out.println("基础类型的example");
        System.out.println("收到客户端的信息：" + request.getUsername());
        HttpResponse response = HttpResponse.newBuilder().setRealname("里奇").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StreamRequest request, StreamObserver<StreamResponse> responseObserver) {

        System.out.println("服务器端流式example");
        System.out.println("收到客户端的年龄信息：" + request.getAge());
        responseObserver.onNext(StreamResponse.newBuilder().setName("张三").setAge(20).setCity("北京").build());
        responseObserver.onNext(StreamResponse.newBuilder().setName("李四").setAge(30).setCity("上海").build());
        responseObserver.onNext(StreamResponse.newBuilder().setName("王五").setAge(40).setCity("广州").build());
        responseObserver.onNext(StreamResponse.newBuilder().setName("赵六").setAge(50).setCity("深圳").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StreamRequest> getStudentsWrapperByAges(StreamObserver<StreamResponseList> responseObserver) {

        System.out.println("客户端流式example");
        return new StreamObserver<StreamRequest>(){
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("onNext: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                StreamResponse streamResponse = StreamResponse.newBuilder().setName("张三").setAge(18).setCity("北京").build();
                StreamResponse streamResponse2 = StreamResponse.newBuilder().setName("李四").setAge(25).setCity("上海").build();
                StreamResponseList streamResponseList = StreamResponseList.newBuilder().addStreamResponse(streamResponse)
                        .addStreamResponse(streamResponse2).build();
                responseObserver.onNext(streamResponseList);
                responseObserver.onCompleted();
            }
        };
    }

//    @Override
//    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
//        //服务器接收到客户端的消息后，返回一个消息给客户端
//        return new StreamObserver<StreamRequest>() {
//            @Override
//            public void onNext(StreamRequest value) {
//                System.out.println("收到客户端的信息：" + value.getAge());
//                responseObserver.onNext(StreamResponse.newBuilder().setName("里奇").setAge(18).setCity("成都").build());
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println(t.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                responseObserver.onCompleted();
//            }
//        };
//    }


    @Override
    public StreamObserver<StreamRequestInfo> biTalk(StreamObserver<StreamResponseInfo> responseObserver) {
        return new StreamObserver<StreamRequestInfo>() {
            @Override
            public void onNext(StreamRequestInfo value) {
                System.out.println("收到客户端的信息：" + value.getRequestInfo());
                responseObserver.onNext(StreamResponseInfo.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
