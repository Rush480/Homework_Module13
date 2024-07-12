package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class Main {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = defaultUser();

        //User createdUser = HttpUtil.sendPost(URI.create(BASE_URL), user);
        // System.out.println(createdUser);

        // Get all Users
        // List<User> allUsers = HttpUtil.sendGet(URI.create(BASE_URL));
        //System.out.println(allUsers);

        // PUT Method
        // HttpUtil.sendPut(URI.create(BASE_URL),user);

        // DELETE Method
        //HttpUtil.sendDelete(URI.create(BASE_URL),user);
    }

    private static User defaultUser() {
        Company company = new Company("Company name", "Phrase", "bsbsbsbs");
        Geo geo = new Geo(2332.3, 233.3);
        Address address = new Address("someStreet", "some suite", "Nova-Kakhovka", "8500", geo);
        return new User(9, "Denys", "Rush", "email@com", address, geo, "some website", "some site", company);
    }
}