package org.example.web;

import org.example.pojo.User;
import org.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LonginServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 获取复选框数据
        String remember = req.getParameter("remember");

        // 调用方法查询
        User user = service.login(username, password);

        // 判断
        if (user != null) {
            // 判断用户是否勾选记住我
            if ("1".equals(remember)) {
                // 创建 Cookie 对象
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                // 设置存活时间
                c_username.setMaxAge(60 * 60 * 24);
                c_password.setMaxAge(60 * 60 * 24);

                // 发送
                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }

            // 登录成功，存储User对象后，跳转到查询所有
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/selectAllServlet ");
        } else {
            // 登陆失败，存储错误信息到request中，后跳转到login.jsp
            req.setAttribute("login_msg", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
