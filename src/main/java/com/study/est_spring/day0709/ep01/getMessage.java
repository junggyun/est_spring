package com.study.est_spring.day0709.ep01;

import org.springframework.stereotype.Component;

@Component
public class getMessage implements Message {
    @Override
    public void print() {
        System.out.println("Hello, World!2");
    }
}
