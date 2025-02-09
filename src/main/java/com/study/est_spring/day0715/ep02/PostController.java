package com.study.est_spring.day0715.ep02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private List<Post> posts = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/form";
    }

    @PostMapping
    public String savePost(
            @ModelAttribute Post post
    ) {
        post.setId(nextId++);
        post.setCreateAt(LocalDateTime.now());
        posts.add(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String detail(
            @PathVariable("id") Long id,
            Model model
    ) {
        Post post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        model.addAttribute("post", post);
        return "post/detail";
    }

    @PostMapping("/{id}/delete")
    public String delete(
            @PathVariable("id") Long id
    ) {
        posts.removeIf(post -> post.getId() == id);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editPostForm(
            @PathVariable("id") Long id,
            Model model
    ) {
        Post post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        model.addAttribute("post", post);
        return "/post/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(
            @PathVariable("id") Long id,
            @ModelAttribute Post updatedPost
    ) {
        Post post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        return "redirect:/posts/{id}";
    }
}
