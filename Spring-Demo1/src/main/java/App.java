import com.spring.demo.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {

    public static void main(String[] args) {
        //1、先得到 Spring 上下文对象
        BeanFactory context = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        //2、得到bean 【依赖查找 -> IoC 实现的一种】
        UserService userService = (UserService) context.getBean("user");
        //3、使用 Bean 对象（非必须）
        userService.sayHi();
    }


    public static void main1(String[] args) {
        //1、先得到 Spring 上下文对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        //2、得到bean 【依赖查找 -> IoC 实现的一种】
//        UserService userService = (UserService) context.getBean("user");
//        UserService userService = context.getBean(UserService.class);//有弊端，当同一个类型注入到Spring多个的时候报错
        UserService userService = context.getBean("user",UserService.class);
        //3、使用 Bean 对象（非必须）
        userService.sayHi();
    }
}
