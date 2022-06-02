package com.hossain.threadbackgroundcheck.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class ThreadController {

    /**
     * I'll cancel the request from postman/browser and check if the work still ongoing or not
     */
    @GetMapping(value = "helloThread")
    public String helloThread() throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8089/test/slow-api"))
                .build();
        System.out.println("Call started");
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
}
