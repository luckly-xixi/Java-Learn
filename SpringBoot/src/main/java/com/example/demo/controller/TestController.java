package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController//相当于 @Controller 和 @ResponseBody
public class TestController {
    @RequestMapping("/sayhi")
    public String sayHi() {
        return "你好,Spring Boot";
    }

}
