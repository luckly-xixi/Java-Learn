package com.java.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserService3Test {

    @Test
    void sayHi() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        UserService3 userService3 =
                context.getBean("userService3",UserService3.class);
        userService3.sayHi();
    }
}