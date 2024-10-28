package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStream;

public class HelloWorldApp {
    public static void main(String[] args) throws Exception {
        // Create an HTTP server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Define the context and response for the root URL "/"
        server.createContext("/", exchange -> {
            String response = "Hello, World! This is Syed Umair Ali Giilani...";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        // Define the context to serve the image at "/image"
        server.createContext("/image", HelloWorldApp::handleImageRequest);
        
        // Start the server
        server.start();
        System.out.println("Server is listening on port 8080...");

        // Keep the application running indefinitely
        Thread.currentThread().join();
    }

    private static void handleImageRequest(HttpExchange exchange) {
        try (InputStream is = HelloWorldApp.class.getResourceAsStream("/umair.png")) {
            if (is == null) {
                String response = "Image not found";
                exchange.sendResponseHeaders(404, response.length());
                exchange.getResponseBody().write(response.getBytes());
            } else {
                exchange.getResponseHeaders().set("Content-Type", "image/png");
                byte[] imageBytes = is.readAllBytes();
                exchange.sendResponseHeaders(200, imageBytes.length);
                exchange.getResponseBody().write(imageBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }
}