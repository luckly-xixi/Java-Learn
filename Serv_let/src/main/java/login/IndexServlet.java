package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//这个类用来动态生成主页面
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        此处禁止创建会话，没找到默认用户未登录
    HttpSession session = req.getSession(false);
    if(session == null) {
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("用户未登录");
        return;
    }
    String username = (String) session.getAttribute("username");
    if(username == null) {
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("用户未登录");
        return;
    }

//    上述校验检查成功，直接生成一个动态页面
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("欢迎你" + username);
    }
}
