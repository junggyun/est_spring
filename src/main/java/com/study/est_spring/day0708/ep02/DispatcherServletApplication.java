package com.study.est_spring.day0708.ep02;

import jakarta.servlet.ServletException;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

public class DispatcherServletApplication {
    public static void main(String[] args) throws IOException, ServletException {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        String url = "/hello";

        MockHttpServletRequest request = new MockHttpServletRequest(url);
        MockHttpServletResponse response = new MockHttpServletResponse();

        dispatcherServlet.service(request, response);

        System.out.println(response.getContent());
        System.out.println("응답 내용" + response.getContent());
    }
}
