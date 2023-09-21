package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/art")
public class ArticleController {

    @RequestMapping("/article")
    public String article() {
        System.out.println("执行了article");
        return "article";
    }

}
