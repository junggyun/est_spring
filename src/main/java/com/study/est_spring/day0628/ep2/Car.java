package com.study.est_spring.day0628.ep2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}
Sun Jun 30 22:40:53 2024 +0900
8aaa3873f732a614877afc38c74cf4e089ba9f48

