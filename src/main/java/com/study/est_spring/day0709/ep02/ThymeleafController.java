package com.study.est_spring.day0709.ep02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "박사장");

        return "index";
    }
}
