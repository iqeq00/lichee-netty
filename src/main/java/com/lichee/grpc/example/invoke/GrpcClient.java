package com.lichee.grpc.example.invoke;

import com.lichee.grpc.example.proto.HttpRequest;
import com.lichee.grpc.example.proto.HttpResponse;
import com.lichee.grpc.example.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899)
                .usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc
                .newBlockingStub(managedChannel);
        HttpRequest request = HttpRequest.newBuilder().setUsername("lichee").build();
        HttpResponse response = studentServiceBlockingStub.getRealnameByUsername(request);
        System.out.println("收到服务器的返回信息：" + response.getRealname());
        //关闭channel，不然服务端会报错“远程主机强迫关闭了一个现有的连接。”
        managedChannel.shutdown();

    }
}
