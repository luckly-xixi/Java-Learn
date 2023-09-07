import com.bit.demo.Articles;
import com.bit.demo.User;
import com.bit.demo.model.ArticleInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        //获取上下文对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");



        //得到 bean 对象
//        User user = context.getBean("userinfo",User.class);
//        User user = context.getBean("user",User.class);
//        User user =  (User) context.getBean("user");

        ArticleInfo articleInfo = context.getBean("articleInfo",ArticleInfo.class);
//        ArticleInfo articleInfo = context.getBean("article",ArticleInfo.class);


        //Bean 获取时的注意事项： @Bean 的默认命名 = 方法名
//        Articles articles = context.getBean("articles",Articles.class);

        //使用 bean 对象
//        user.sayHi();
//        user.sayHi();
        System.out.println(articleInfo.toString());
//        articles.sayHi();

    }

}
