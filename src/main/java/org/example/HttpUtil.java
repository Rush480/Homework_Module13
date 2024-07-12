package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static User sendGet(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static User sendPost(URI uri, User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type","application/json")
                .build();
       HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println("response = "+ response.body());
       return GSON.fromJson(response.body(),User.class);
    }
    public static void sendPut(URI uri, User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type","application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = "+ response.body());
        System.out.println(response.statusCode());
        response.body();
    }
    public static void sendDelete(URI uri, User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .method("DELETE",HttpRequest.BodyPublishers.ofString(requestBody))
                //.header("Content-type","application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = "+ response.body());
        System.out.println(response.statusCode());
        response.body();
    }
}
