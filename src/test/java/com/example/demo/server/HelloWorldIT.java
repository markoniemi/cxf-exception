package com.example.demo.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.demo.DemoApplication;

import jakarta.xml.ws.Service;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloWorldIT {
    @Test
    public void sayHi() {
        try {
            getHelloWorldService().sayHi("World");
            fail();
        } catch (Exception e) {
            System.out.println(e);
            assertEquals("kissa", e.getMessage());
        }
    }
    
    public HelloWorld getHelloWorldService() throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8080/api/soap?wsdl");
        QName qname = new QName("http://server.demo.example.com/", "HelloWorld");
        Service service = Service.create(wsdlURL, qname);
        HelloWorld port = service.getPort(HelloWorld.class);
        return port;
    }
}