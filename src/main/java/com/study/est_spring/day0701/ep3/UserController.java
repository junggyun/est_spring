package com.study.est_spring.day0701.ep3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserController {
    private User model;
    private UserView view;

    public void updateView() {
        view.printUserDetails(model);
    }

    public void setUserName(String name) {
        model.setName(name);
    }

    public void setUserAge(int age) {
        model.setAge(age);
    }
}
