package com.study.est_spring.day0628.ep1;

import org.springframework.stereotype.Service;

@Service
public class UserService1 {
    private UserRepositoryInterface userRepository;

    public UserService1(UserRepositoryInterface userRepository1) {
        this.userRepository = userRepository1;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
