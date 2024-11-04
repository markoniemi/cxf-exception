package com.example.demo.server;

import jakarta.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text) throws IllegalArgumentException;
}