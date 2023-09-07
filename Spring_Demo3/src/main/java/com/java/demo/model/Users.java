package com.java.demo.model;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Users {

    @Bean("user1")
    public User user1() {
        User user = new User();
        user.setName("张三");
        return user;
    }

    @Bean("user2")
    public User user2() {
        User user = new User();
        user.setName("李四");
        return user;
    }
}
