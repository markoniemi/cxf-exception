package com.example.demo;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.server.HelloWorldImpl;

import jakarta.xml.ws.Endpoint;

@Configuration
public class ServiceConfiguration {
    @Autowired
    private Bus bus;
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloWorldImpl());
        endpoint.setAddress("/soap");
        endpoint.publish("/soap");
        return endpoint;
    }
}