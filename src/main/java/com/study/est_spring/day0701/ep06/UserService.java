package com.study.est_spring.day0701.ep06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser() {
        User user = userRepository.getUser();
        System.out.println("오오오오징어");
        return user.getName();
    }
}
