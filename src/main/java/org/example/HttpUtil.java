package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.Constants.*;


public class HttpUtil {


    public List<User> getListOfAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        List<User> users = GSON.fromJson(response.body(), listType);
        return users;
    }

    public User createUser(User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response status = " + response.statusCode());
        return GSON.fromJson(response.body(), User.class);
    }

    public void editUser(User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "/2"))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response = " + response.body());
        System.out.println("Status code: " + response.statusCode());
        response.body();
    }

    public void deleteUser(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "/" + id))
                .DELETE()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + response.statusCode());
    }

    public void getUserById(URI uri, int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }

    public void getUserByUsername(URI uri, String username) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + username))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }

    public void getUserCommentsOfLastPost(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "/" + userId + "/posts"))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        Type listType = new TypeToken<List<Post>>() {
        }.getType();
        List<Post> posts = GSON.fromJson(response.body(), listType);

        Post maxIdPost = posts.stream()
                .max(Comparator.comparing(Post::getId))
                .get();
        int postMaxId = maxIdPost.getId();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/" + postMaxId + "/comments"))
                .GET()
                .build();
        HttpResponse<String> response1 = CLIENT.send(request2, HttpResponse.BodyHandlers.ofString());

        String filename = "user-" + userId + "-post-" + postMaxId + "-comments.json"; //user-X-post-Y-comments.json, де Х - id користувача, Y - номер посту.
        writeJsonToFile(response1.body(), filename);
    }

    public void getUncompletedTasks(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "/" + userId + "/todos"))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        //  System.out.println(response.body());
        Type listType = new TypeToken<List<Todos>>() {
        }.getType();
        List<Todos> todos = GSON.fromJson(response.body(), listType);
        List<Todos> uncompleted = todos.stream()
                .filter((unc) -> (!unc.isCompleted()))
                .toList();
        uncompleted.forEach(System.out::println);
    }

    private void writeJsonToFile(String data, String filename) {
        File file = new File(filename);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(data);
            System.out.println("Data saved to Json file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

