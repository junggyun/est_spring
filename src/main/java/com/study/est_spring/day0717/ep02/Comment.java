package com.study.est_spring.day0717.ep02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Comment {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private BoardPost boardPost;
}
