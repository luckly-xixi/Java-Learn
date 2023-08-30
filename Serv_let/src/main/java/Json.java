import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


class User {
    public String username;
    public String password;
}

@WebServlet("/Json")
public class Json extends HttpServlet {

    //    使用jackson最核心的是ObjectMapper
//        通过这个对象可以把Json字符串解析为java对象，也可以把java对象转为json格式字符串
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        User user = objectMapper.readValue(req.getInputStream(),User.class);
        System.out.println("username=" + user.username + "password=" + user.password);

        resp.getWriter().write("ok");
    }
}
