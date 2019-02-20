package com.lichee.grpc.example.invoke;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.time.LocalDateTime;

public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();
        System.out.println("GRPC java server started!");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Close JVM!");
            GrpcServer.this.stop();
        }));
        System.out.println(LocalDateTime.now());
    }

    private void stop() {
        if(null != this.server) {
            this.server.shutdown();
        }
    }

    /**
     * 触发jvm钩子
     *
     * this.server.awaitTermination(3000, TimeUnit.MILLISECONDS);
     */
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
