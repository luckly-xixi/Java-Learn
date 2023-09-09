package com.example.demo.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data //组合注解,相当于上方的注解+其他注解
//上面的标签是lombok插件提供的可直接替代掉自己去生产的 Getter 和 Setter ....方法
public class Student {
    private int id;
    private String name;
    private String password;
}
