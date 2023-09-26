package com.example.demo.controller;


import com.example.demo.model.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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


        //如果使用tey  catch捕获异常并不向外抛出，会导致事务不会回滚
        //因为AOP机制是通过动态代理的方式来感知到程序的报错的，当在程序中自己捕获了异常还不向外抛出，就会让AOP感知不到
        try {
            int num = 10 / 0; //报异常

        }catch (Exception e) {
            //解决方案：
            //1.抛出异常
            //throw e;
            //2.手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        //返回结果
        return row;
    }
}
