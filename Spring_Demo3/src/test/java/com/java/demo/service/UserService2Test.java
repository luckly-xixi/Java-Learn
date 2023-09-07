package com.java.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserService2Test {

    @Test
    void sayHi() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        UserService2 userService2 =
                context.getBean("userService2",UserService2.class);
        userService2.sayHi();
    }
}