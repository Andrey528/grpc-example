package com.example.grpcclient.grpc;

import hello.HelloServiceGrpc;
import hello.HelloServiceOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceGrpcImpl {
    @GrpcClient("GLOBAL")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public String hello(String name) {
        return helloServiceBlockingStub.hello(generatedHelloRequest(name)).getHello();
    }

    private HelloServiceOuterClass.HelloRequest generatedHelloRequest(String name) {
        return HelloServiceOuterClass.HelloRequest.newBuilder()
                .setName(name)
                .build();
    }
}
