package com.study.est_spring.day0715.ep01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @GetMapping("/members")
    public String getMember(Model model) {
        List<Member> members = new ArrayList<>();
        members.add(new Member("park", "park@gmail.com", true));
        members.add(new Member("hwang", "hwang@gmail.com", false));
        model.addAttribute("members", members);

        return "index";
    }

    @PostMapping("/members")
    public String members(@ModelAttribute Member member) {
        System.out.println(member.getName());
        System.out.println(member.getEmail());

        return "index2";
    }

    @GetMapping("/index/2")
    public String goIndex2() {

        return "index2";
    }

    @GetMapping("/index/3")
    public String goIndex3() {
        return "index3";
    }
}
