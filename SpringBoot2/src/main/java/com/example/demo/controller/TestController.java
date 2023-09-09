package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("/test")//@RequestMapping 既能修饰类也能修饰方法
public class TestController {

    //方法上一定要加这个注解,否则不能建立客户端与服务器之间连接
    @RequestMapping(value = "/sayhi",method = RequestMethod.GET)
//    @RequestMapping(path = "/sayhi",method = RequestMethod.GET)   value 和 path 作用相同
//    设置method的方法,使服务器只支持客户端访问的类型
    public String sayHi() {
        return "你好, Spring MVC";
    }


    @GetMapping("/sayhi2")
//    创建 Http 连接,并且只支持 Get 类型请求
    public String sayHi2() {
        return "你好, Spring MVC2";
    }



    @PostMapping("/sayhi3")
    //    创建 Http 连接,并且只支持 Post 类型请求
    public String sayHi3() {
        return "你好, Spring MVC3";
    }
}
