package api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        HttpSession session = req.getSession(false);
        if(session == null) {
            //用户本来就未登录，直接跳转到登录页
            resp.sendRedirect("login.html");
            return;
        }
        //user存在，就删除，不存在，也不会有副作用
        session.removeAttribute("user");
        resp.sendRedirect("login.html");
    }
}
