package com.study.est_spring.day0628.ep1;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository1 implements UserRepositoryInterface {

    @Override
    public void save(User user) {
        System.out.println("User1 saved");
    }

    @Override
    public void delete(User user) {
        System.out.println("User1 deleted");
    }
}