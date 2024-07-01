package com.study.est_spring.day0701.ep06;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    Map<String, User> users = new HashMap<>();

    public User getUser() {
        users.put("max", new User("max@gmail.com", "max", 30));
        return users.get("max");
    }
}
