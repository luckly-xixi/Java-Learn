package com.example.demo.controller;


import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@Component
@ResponseBody

@RequestMapping("/user")
public class UserController {
//获取配置文件里面的对象属性并在启动时赋值
//    @Value("${myobj.name}")
//    private String name;

    @Autowired //注入
    private User user;

    @PostConstruct
    public void doPostConstruct() {
//        System.out.println("------->" + name);
        System.out.println(user.toString());
    }
}
