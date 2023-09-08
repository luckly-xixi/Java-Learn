package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //添加了此注解的类叫做 Spring Boot 的启动类
public class DemoApplication {
//@Value("${自定义配置的变量名}")  //注意不加${}会把变量名原样输出
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
