package com.bit.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

//@Controller(value = "userinfo")
@Controller//默认使用类名的小驼峰来找到该对象
public class User {

    public void sayHi() {
        System.out.println("Hi,User~");
    }


    @Bean
    public User USer1 () {
        //伪代码
        User user = new User();
        user.sayHi();
        return user;
    }
}
