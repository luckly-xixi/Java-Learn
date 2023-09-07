package com.java.demo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void add() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService =
                context.getBean("userService",UserService.class);
        userService.add();
    }
}