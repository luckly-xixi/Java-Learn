package com.java.demo.service;


import com.java.demo.model.User;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService2 {

    //属性注入
    @Autowired
    @Qualifier("user2") //方法二：通过筛选器配个Autowired
//    private User user1; //方法一：更改名字
    private User user;

    public void sayHi() {
        System.out.println(user.toString());
//        System.out.println(user1.toString());
    }
}
