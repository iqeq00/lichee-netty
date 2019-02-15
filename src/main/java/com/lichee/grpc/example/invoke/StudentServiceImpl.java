package com.lichee.grpc.example.invoke;

import com.lichee.grpc.example.proto.HttpRequest;
import com.lichee.grpc.example.proto.HttpResponse;
import com.lichee.grpc.example.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealnameByUsername(HttpRequest request, StreamObserver<HttpResponse> responseObserver) {

        System.out.println("收到客户端的信息：" + request.getUsername());
        HttpResponse response = HttpResponse.newBuilder().setRealname("里奇").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
