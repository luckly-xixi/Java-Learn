package com.bit.demo;

import com.bit.demo.model.ArticleInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

//建议使用Component

@Component //注意：Bean 注解必须配合着 五大类注解（Controller，Service，Component，Configuration，Repository）使用
//@Component(value = "aaa")
//通过五大类注解来获取对象只能指定一个名称，只有通过Bean方法获取对象的时候支持多个名称
public class Articles {

    @Bean("article") //将当前方法返回的对象存储到 IoC 容器
//    @Bean("name（什么都不加默认是name属性）")//如果对 @Bean 对象进行重命名可以在这里直接命名来让上下文对象获取
//    @Bean(name = {"name1","name2",.....})/@Bean(value = {"value1","value2",...})//都可以设置方法名，并且可以给Bean对象设置多个名称
//    但是如果通过name和value来设置方法名获取Bean对象的时候，就无法再通过方法名来获取Bean对象了
    public ArticleInfo articleInfo1() {
        //伪代码
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setAid(1);
        articleInfo.setTitle("这是标题1");
        articleInfo.setContent("这是正文1");
        articleInfo.setCreateTime(LocalDateTime.now());
        return articleInfo;
    }

//在同一个类当中，有多个相同的通过@Bean方法（设置的name相同）获取到对象的@Bean方法的时候，默认都会找到类中第一个声明/定义的方法
//不同类的时候，通过@Order（权重）来决定加载顺序，权重越大，越先加载， 只用在第一次创建 Bean 的时候会将 Bean 名称关联起来，后续再有相同名称的Bean，容器会自动忽略
    @Bean("articleInfo")
    public ArticleInfo articleInfo2(int i) {
        //由于加载的时候无法传递参数，导致该方法的对象无法注册，就会出现，在加载的时候系统读取上面的@Bean对象，哪怕是注册名字不同，
        //如果上方参数不存在，系统直接报错
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setAid(1);
        articleInfo.setTitle("这是标题2");
        articleInfo.setContent("这是正文2");
        articleInfo.setCreateTime(LocalDateTime.now());
        return articleInfo;
    }

//通过 @Bean 方法获取类的时候，本身的类也会托管到Spring容器中
    public void sayHi() {
        System.out.println("Hi~ Articles");
    }
}
