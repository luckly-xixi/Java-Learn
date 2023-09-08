package com.java.demo.controller;


import com.java.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/*
* 李四
* */
@Controller
public class UserController3 {

    @Autowired
    private User user;

    public void doMethod() {
        System.out.println("UserController3  ->" + user);
    }


}
