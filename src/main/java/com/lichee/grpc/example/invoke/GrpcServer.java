package com.lichee.grpc.example.invoke;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * server报错，回去用mac再试试
 * io.grpc.netty.NettyServerTransport notifyTerminated
 */
public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();
        System.out.println("Server started!");
    }

    private void stop() {
        if(null != this.server) {
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException {
        if(null != this.server) {
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.awaitTermination();
    }

}
