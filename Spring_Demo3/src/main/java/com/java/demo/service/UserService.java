package com.java.demo.service;


import com.java.demo.dao.UserRepository;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    //1.属性注入
//    @Autowired  //DI(依赖注入)，来自spring
    @Resource//@Resource来自Jdk，有些场景Resource比Autowired更方便
    private UserRepository userRepository;

    public int add() {

        System.out.println("Do UserService add method");
//        //传统型写法
//        UserRepository userRepository = new UserRepository();
//        return userRepository.add();

//        //Spring 1.0
//        ApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("spring-config.xml");
//        UserRepository userRepository =
//                applicationContext.getBean("userRepository",UserRepository.class);
//        return userRepository.add();


        //Spring 2.0
        return userRepository.add();
    }

}
