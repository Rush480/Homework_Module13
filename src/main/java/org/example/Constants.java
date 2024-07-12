package org.example;

import com.google.gson.Gson;

import java.net.http.HttpClient;

public final class Constants {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    static final String USERS_URL_USERNAME = "https://jsonplaceholder.typicode.com/users?username=";

    static final HttpClient CLIENT = HttpClient.newHttpClient();
    static final Gson GSON = new Gson();
    static final HttpUtil HTTP_UTIL = new HttpUtil();

    static final User DEFAULT_USER = new User(9, "Denys", "Rush", "email@com", new Address("someStreet", "some suite",
            "Nova-Kakhovka", "8500", new Geo(236.2, 657.2)), "+351 966 354 856", "some website",
            new Company("Company name", "some phrase", "bsbsbs"));

}
