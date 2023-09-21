package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/getUser")
    public String getUser() {
        System.out.println("get User");
        return "get User";
    }

    @RequestMapping("/delUser")
    public String delUser() {
        System.out.println("del User");
        return "del User";
    }
}
