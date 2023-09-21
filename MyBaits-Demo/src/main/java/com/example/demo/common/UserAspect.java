package com.example.demo.common;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  //定义切面
@Component

public class UserAspect {

    //切点
    @Pointcut("execution(*com.example.demo.controller.UserController.*(..))")
    public void pointCut() {}

    //通知
    @Before("pointCut()")
    public void doBefore() {
        System.out.println("执行了doBefore");
    }

    @After("pointCut")
    public void doAfter() {
        System.out.println("执行了doAfter");
    }
}
