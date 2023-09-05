import com.bit.demo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        //获取上下文对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        //得到 bean 对象
//        User user = context.getBean("userinfo",User.class);
        User user = context.getBean("user",User.class);
        //使用 bean 对象
        user.sayHi();
    }
}
