package com.study.est_spring.day0701.ep06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{key}")
    public String getUserResult(@PathVariable String key) {
        return userService.getUser();
    }

    @GetMapping("/users")
    public String getUser() {
        return "Hello";
    }
}
