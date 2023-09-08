package com.java.demo;

import com.java.demo.controller.UserController;
import com.java.demo.controller.UserController2;
import com.java.demo.controller.UserController3;
import com.java.demo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
//        UserController userController = context.getBean("userController",UserController.class);
//        System.out.println(userController.getUser());

        UserController2 userController2 =
                context.getBean("userController2",UserController2.class);
        userController2.doMethod();

        UserController3 userController3 =
                context.getBean("userController3",UserController3.class);
        userController3.doMethod();
    }
}
