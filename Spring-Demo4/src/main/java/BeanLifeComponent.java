import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifeComponent implements BeanNameAware {

    //通知
    @Override
    public void setBeanName(String s) {
        System.out.println("执行了 BeanNameAware ->" + s);
    }

    //初始化方法(通过注解)
    @PostConstruct
    public void doPostConstruct() {
        System.out.println("执行了 doPostConstruct ");
    }

    //初始化方法(通过XML)
    public void myInit() {
        System.out.println("执行了 myinit");
    }

    // 销毁
    @PreDestroy
    public void doPreDestroy() {
        System.out.println("执行了 @PreDestroy ");
    }

    //执行类里的方法
    public void sayHi() {
        System.out.println("Hi~");
    }
}
