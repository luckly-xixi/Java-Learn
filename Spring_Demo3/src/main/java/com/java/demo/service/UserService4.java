package com.java.demo.service;


import com.java.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//构造方法注入
//优点：1、可注入不可变对象
//     2、注入对象不会被修改
//     3、注入对象会被完全初始化
//     4、通用性更好（不仅仅适用于IoC容器）
//缺点：1、写法比属性注入更复杂
//     2、无法解决循环依赖

@Service
public class UserService4 {

    private UserRepository userRepository;

    @Autowired//标准写法需要加上 @Autowired ，但是只有在当前类中只有一个构造方法时，可以省略
    public UserService4(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService4(UserRepository userRepository,Integer num) {
        this.userRepository = userRepository;
    }


    public void sauHi() {
        System.out.println("Do UserService4 sayHi method");
        userRepository.add();
    }
}
