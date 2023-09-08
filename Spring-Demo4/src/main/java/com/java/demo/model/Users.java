package com.java.demo.model;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 公共类
 */
@Component
public class Users {
    /**
     * 公共对象 -> 默认是单例模式（singleton）
     * @return
     */
    @Bean(name = "user")
//    @Scope("prototype")//原型模式（多例模式）每次使用注解的时候都会new一个新的对象,
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//作用和上面的@Scope("prototype")一样

//    @Scope("singleton")//单例模式（默认作用域）
//    @Scope("prototype")//原型模式（多例模式）
//    @Scope("request")//请求作用域，只适用于 Spring MVC 项目(Spring Web)
//    @Scope("session")//会话作用域，一个Http会话共享一个 Bean ，只适用于 Spring MVC 项目(Spring Web)
//    @Scope("application")//应用作用域，表示的是一个 Context 容器共享一个作用域，只适用于 Spring MVC 项目 （Spring Web）
//    @Scope("websocket")//websocket作用域，只适用于websocket作用域
    public User getUser() {
        User user = new User();
        user.setId(22);
        user.setName("法外狂徒");
        return user;
    }
}
