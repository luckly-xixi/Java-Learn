import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLiefText {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        BeanLifeComponent beanLifeComponent =
                context.getBean("myBean",BeanLifeComponent.class);
        beanLifeComponent.sayHi();
        context.close();
    }
}
