package com.example;


import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class HelloWorldApp {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });
        server.start();
        System.out.println("Server is listening on port 8080...");

        // Keep the application running indefinitely
        Thread.currentThread().join();
    }
}
