package com.example.demo.model;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Userinfo {
    private int id;
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;

    private List<Articleinfo> aList;
}
