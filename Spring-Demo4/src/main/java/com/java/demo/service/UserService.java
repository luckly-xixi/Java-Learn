package com.java.demo.service;


import com.java.demo.model.User;
import com.java.demo.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
                private UserRepositiry userRepositiry;

    public User getUser() {
        return userRepositiry.getUser();
    }
}
