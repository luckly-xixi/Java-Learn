package com.bit.demo;

public class Student {
    public void sayHi() {
//        无法得到对象，因为并未注入到IoC当中
        System.out.println("Hi Student");
    }
}
