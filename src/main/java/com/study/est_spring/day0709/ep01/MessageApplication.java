//package com.study.est_spring.day0709.ep01;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class MessageApplication {
//    @Value("${server.port}")
//    private int port;
//
//    @Value("${spring.application.name}")
//    private String appName;
//
//    @PostConstruct
//    public void printConfig() {
//        System.out.println("포트번호: " + port);
//        System.out.println("애플리케이션 이름: " + appName);
//    }
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(MessageApplication.class, args);
//    }
//}
