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
    //方法三：使用@Resource（name = "name "）来直接在里面设置name



//    @Autowired VS @Resource 区别：
//    1、出身不同：@Autowired来自于spring框架 ， @Resource 来自于JDK注解
//    2、支持参数不同：@Resource支持很多参数设置，例如name设置，@Autowried支支持一个参数（@Qualifier）
//    3、使用上的不同：@Resource不支持构造方法注入，而@Autowried支持构造方法注入
//    4、idea兼容不同：使用@Autowried在idea专业版下可能会误报，@Resource不存在误报问题
    @Qualifier("user2") //方法二：通过筛选器配个Autowired
//    private User user1; //方法一：更改名字
    private User user;

    public void sayHi() {
        System.out.println(user.toString());
//        System.out.println(user1.toString());
    }
}
