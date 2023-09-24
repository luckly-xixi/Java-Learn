package com.example.demo.controller;


import com.example.demo.common.ResultAjax;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getuser")
    public ResultAjax getUser () {
        System.out.println("do getUser()");
        return ResultAjax.success("user");
    }

    @RequestMapping("/reg")
    public ResultAjax reg () {
        System.out.println("do reg()");
        Object obj = null;
        System.out.println(obj.hashCode());  //报空指针异常
        return ResultAjax.success("reg");

    }

    @RequestMapping("/login")
    public ResultAjax login () {
        System.out.println("do login()");
        return ResultAjax.success("login");

    }
}
