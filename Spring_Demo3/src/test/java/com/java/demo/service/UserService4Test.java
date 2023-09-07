package com.java.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserService4Test {

    @Test
    void sauHi() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        UserService4 userService4 =
                context.getBean("userService4",UserService4.class);
        userService4.sauHi();
    }
}