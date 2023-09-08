package com.java.demo.repository;


import com.java.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositiry {

    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
}

