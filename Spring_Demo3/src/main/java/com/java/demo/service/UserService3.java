package com.java.demo.service;


import com.java.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//setter注入
//优点:完全符合单一职责的设计原则
//缺点：1、不能注入不可变对象（final修饰对象）
//     2、注入的对象可被修改



public class UserService3 {

    private UserRepository userRepository;

//  使用setter注入的时候@Autowired不可省略
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void sayHi() {
        System.out.println("Do UserService3 sayHi");
        userRepository.add();
    }
}
