package com.java.demo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public int add() {

        System.out.println("Do UserRepository Add method");
        return 1;
    }
}
