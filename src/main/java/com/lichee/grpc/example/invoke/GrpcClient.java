package com.lichee.grpc.example.invoke;

import com.lichee.grpc.example.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class GrpcClient {

    public static void main(String[] args) {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899)
                .usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc
                .newBlockingStub(managedChannel);


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


        //关闭channel，不然服务端会报错“远程主机强迫关闭了一个现有的连接。”
        managedChannel.shutdown();

    }
}
