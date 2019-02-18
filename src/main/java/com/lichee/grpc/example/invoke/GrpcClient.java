package com.lichee.grpc.example.invoke;

import com.lichee.grpc.example.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;

public class GrpcClient {

    public static void main(String[] args) {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899)
                .usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc
                .newBlockingStub(managedChannel);

        StudentServiceGrpc.StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(managedChannel);


        System.out.println("-------------基础模式-------------");
        HttpRequest request = HttpRequest.newBuilder().setUsername("lichee").build();
        HttpResponse response = studentServiceBlockingStub.getRealnameByUsername(request);
        System.out.println("收到服务器的返回信息：" + response.getRealname());
        System.out.println("-------------基础模式-------------");


        System.out.println("-------------服务器返回Stream-------------");
        StreamRequest streamRequest = StreamRequest.newBuilder().setAge(20).build();
        Iterator<StreamResponse> iterator = studentServiceBlockingStub.getStudentsByAge(streamRequest);
        while (iterator.hasNext()){
            StreamResponse streamResponse = iterator.next();
            System.out.println(streamResponse.getName() + ", " + streamResponse.getAge() + ", " + streamResponse.getCity());
        }
        System.out.println("-------------服务器返回Stream-------------");


        System.out.println("-------------客户端请求Stream-------------");
        //第一步，新建一个获取服务器端回调的对象
        StreamObserver<StreamResponseList> streamResponseListStreamObserver = new StreamObserver<StreamResponseList>() {
            @Override
            public void onNext(StreamResponseList value) {
                value.getStreamResponseList().forEach(streamResponse -> {
                    System.out.println(streamResponse.getName() + ", " + streamResponse.getAge() + ", " + streamResponse.getCity());
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed!");
            }
        };
        //第二步，构建发送数据(客户端流式发送请求，这种请求一定是异步的，就必须使用studentServiceStub这个异步的stub)
        StreamObserver<StreamRequest> streamRequestStreamObserver = studentServiceStub.getStudentsWrapperByAges(streamResponseListStreamObserver);
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setAge(20).build());
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setAge(30).build());
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setAge(40).build());
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setAge(50).build());
        streamRequestStreamObserver.onCompleted();

        try {
            //防止异步线程过早结束，而观察不到返回结果！
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------客户端请求Stream-------------");

        System.out.println("-------------双向Stream-------------");
        StreamObserver<StreamRequestInfo> streamRequestObserver = studentServiceStub.biTalk(new StreamObserver<StreamResponseInfo>(){

            @Override
            public void onNext(StreamResponseInfo value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onComleted!");
            }
        });

        for (int i = 0; i < 10; i++) {
            streamRequestObserver.onNext(StreamRequestInfo.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-------------双向Stream-------------");


        //关闭channel，不然服务端会报错“远程主机强迫关闭了一个现有的连接。”
        managedChannel.shutdown();

    }
}
