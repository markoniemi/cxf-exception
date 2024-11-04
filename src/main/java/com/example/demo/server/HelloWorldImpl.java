package com.example.demo.server;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.example.demo.server.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHi(String text) throws IllegalArgumentException {
        throw new IllegalArgumentException("kissa");
    }
}