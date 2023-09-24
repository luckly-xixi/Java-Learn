package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //这个不加会导致拦截器无用
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new UserInterceptor());
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/**") //拦截所有的请求
                .excludePathPatterns("/user/reg") //放行的接口
//                .excludePathPatterns("/image/**") //放行静态文件
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/editor.md/**")
                .excludePathPatterns("/reg.html")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/user/login")
        ;
    }

}
