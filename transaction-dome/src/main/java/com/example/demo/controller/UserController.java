package com.example.demo.controller;


import com.example.demo.model.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @Transactional
    public int add() {
        //非空判断
//        if(userinfo == null
//                || userinfo.getPassword() == null
//                || userinfo.getPassword().equals("")
//                || userinfo.getUsername() == null
//                || userinfo.getUsername().equals("")) {
//        }
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("法外狂徒");
        userinfo.setPassword("123");
        //调用 Service 执行添加
        int row = userService.add(userinfo);
        System.out.println("row" + row);
        int num = 10 / 0;
        //返回结果
        return 0;
    }
}
