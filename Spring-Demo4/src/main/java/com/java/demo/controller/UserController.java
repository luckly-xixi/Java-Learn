package com.java.demo.controller;


import com.java.demo.model.User;
import com.java.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public User getUser() {
        return userService.getUser();
    }
}
