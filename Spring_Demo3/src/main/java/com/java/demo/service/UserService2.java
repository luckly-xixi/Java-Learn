package com.java.demo.service;


import com.java.demo.model.User;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//属性注入
public class UserService2 {

    //属性注入
    //优点：使用实现简单
//    缺点：
//    1、功能性问题：无法注入一个不可变的对象（final修饰的对象）
//    2、通用性问题：只能适用于IoC容器
//    3、设计原则问题：更容易违背单一原则
    @Autowired
    @Qualifier("user2") //方法二：通过筛选器配个Autowired
//    private User user1; //方法一：更改名字
    private User user;

    public void sayHi() {
        System.out.println(user.toString());
//        System.out.println(user1.toString());
    }
}
