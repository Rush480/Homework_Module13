package org.example;

import java.io.IOException;
import java.net.URI;

import java.util.List;

import static org.example.Constants.*;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //TODO Створення "Метод працює правильно, якщо у відповідь на JSON з об'єктом повернувся такий самий JSON, але зі значенням id більшим на 1, ніж найбільший id на сайті."

        //    User createdUser = HTTP_UTIL.createUser(URI.create(USERS_URL), DEFAULT_USER);
        //   System.out.println(createdUser);


        // TODO Список усіх користувачів

        //     List<User> allUsers = HTTP_UTIL.getListOfAllUsers(URI.create(USERS_URL));
        //   allUsers.forEach(System.out::println);


        //TODO Оновлення - "Вважаємо, що метод працює правильно, якщо у відповідь ви отримаєте оновлений JSON (він повинен бути таким самим, що ви відправили)."

        //    HTTP_UTIL.editUser(URI.create(USERS_URL + "/2"), DEFAULT_USER);


        //TODO Видалення - "Тут будемо вважати коректним результат - статус відповіді з групи 2xx (наприклад, 200)."

        //  HTTP_UTIL.deleteUser(URI.create(USERS_URL + "/10"), DEFAULT_USER);


        //TODO отримання інформації про користувача за id

        //   HTTP_UTIL.getUserById(URI.create(USERS_URL),3);


        //TODO отримання інформації про користувача за username

        //HTTP_UTIL.getUserByUsername(URI.create(USERS_URL_USERNAME),"Delphine");

        //TODO
    }


}