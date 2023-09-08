package com.java.demo.controller;

import com.java.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
* 张三
* */
@Controller
public class UserController2 {

@Autowired
    private User user;

    public void doMethod() {
        User user2 = user;
        System.out.println("UserController2 修改之前 ->" + user);
        user2.setName("张三");
        System.out.println("UserController2 修改之后 ->" + user);
    }

}
