package com.example;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class HelloWorldApp {
    public static void main(String[] args) throws Exception {
        // Create an HTTP server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Define the context and response for the root URL "/"
        server.createContext("/", exchange -> {
            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });
        
        // Start the server
        server.start();
        System.out.println("Server is listening on port 8080...");

        // Keep the application running indefinitely
        Thread.currentThread().join();
    }
}