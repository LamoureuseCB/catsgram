package com.practice.catsgram.request_param.task_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task1")
public class Task1UserController {
    List<User> users = new ArrayList<>() {{
        add(new User("David", 25, "London"));
        add(new User("Alice", 30, "Paris"));
        add(new User("John", 22, "New York"));
        add(new User("Maria", 25, "Madrid"));
        add(new User("Alex", 35, "Berlin"));
        add(new User("Sophie", 28, "Paris"));
        add(new User("Michael", 30, "New York"));
        add(new User("Emma", 40, "Rome"));
        add(new User("Thomas", 22, "Berlin"));
        add(new User("Olivia", 33, "London"));
        add(new User("Christopher", 28, "London"));
        add(new User("Emily", 32, "Paris"));
        add(new User("William", 26, "New York"));
        add(new User("Isabella", 29, "Madrid"));
        add(new User("Ethan", 31, "Berlin"));
        add(new User("Ava", 24, "London"));
        add(new User("James", 36, "Paris"));
        add(new User("Sophia", 27, "New York"));
        add(new User("Daniel", 34, "Madrid"));
        add(new User("Mia", 23, "Berlin"));
        add(new User("Benjamin", 30, "Rome"));
        add(new User("Charlotte", 26, "London"));
        add(new User("Henry", 32, "Paris"));
        add(new User("Evelyn", 25, "New York"));
    }};

    //   /task1/users?city=Berlin&age=23
    //   /task1/users?city=Berlin
    //   /task1/users?age=23
    //   /task1/users
    @GetMapping("/users")
    public List<User> filterUsers(@RequestParam(required = false) String city,
                                  @RequestParam(required = false) Integer age) {
        if (city != null && age != null) {
            return users.stream().filter(user -> user.getCity().equals(city) && user.getAge() == age).toList();
        } else if (city != null) {
            return users.stream().filter(user -> user.getCity().equals(city)).toList();
        } else if (age != null) {
            return users.stream().filter(user -> user.getAge() == age).toList();
        }
        return users;
    }
}