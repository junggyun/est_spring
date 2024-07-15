package com.study.est_spring.day0715.ep01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String name;
    private String email;
    private boolean admin;
}
