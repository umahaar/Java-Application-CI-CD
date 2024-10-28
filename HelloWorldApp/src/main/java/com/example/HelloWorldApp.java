package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloWorldApp {
    public static void main(String[] args) throws Exception {
        // Create an HTTP server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Define the context and response for the root URL "/"
        server.createContext("/", exchange -> {
            String response = "<html>" +
                    "<head>" +
                    "<title>Syed Umair Ali Gilani</title>" +
                    "<style>" +
                    "body { background-color: white; display: flex; flex-direction: column; align-items: center; justify-content: center; height: 100vh; margin: 0; font-family: Arial, sans-serif; }" +
                    "h1 { color: black; font-size: 48px; font-family: 'Comic Sans MS', cursive, sans-serif; }" +
                    "h2 { color: black; font-size: 24px; font-family: 'Comic Sans MS', cursive, sans-serif; }" +
		    "button { padding: 10px 20px; font-size: 18px; margin-top: 20px; cursor: pointer; }" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<h1>My Name is Syed Umair Ali Gilani</h1>" +
		    "<h2>This is my Java Application</h2>" +
                    "<button onclick=\"window.location.href='/image'\">Click Me</button>" +
                    "</body>" +
                    "</html>";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        // Define a context to serve the image
        server.createContext("/image", new ImageHandler());

        // Start the server
        server.start();
        System.out.println("Server is listening on port 8080...");

        // Keep the application running indefinitely
        Thread.currentThread().join();
    }

    // Handler to serve the image
    static class ImageHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            File file = new File("src/main/resources/static/umair.png"); // Adjust path if necessary

            if (!file.exists()) {
                String response = "Image not found.";
                exchange.sendResponseHeaders(404, response.length());
                exchange.getResponseBody().write(response.getBytes());
            } else {
                exchange.sendResponseHeaders(200, file.length());
                try (FileInputStream fis = new FileInputStream(file);
                     OutputStream os = exchange.getResponseBody()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
            }
            exchange.close();
        }
    }
}
