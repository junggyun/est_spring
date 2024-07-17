package com.study.est_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study.est_spring.day0717.ep02")
public class EstSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstSpringApplication.class, args);
    }

}
