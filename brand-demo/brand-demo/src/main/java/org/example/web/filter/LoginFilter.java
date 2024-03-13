package org.example.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求对象强转
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        // 设置放行路径
        String[] urls = {"/login.jsp", "/css/", "/imgs/", "/loginServlet", "/register.jsp", "/registerServlet", "/checkCodeServlet","/ajaxServlet"};
        // 获取请求路径
        String url = req.getRequestURL().toString();
        // 对比
        for (String u : urls) {
            if(url.contains(u)) {
                // 放行
                filterChain.doFilter(req, servletResponse);
                // 返回
                return;
            }
        }

        // 判断 session中是否有 user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user != null) {
            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.setAttribute("login_msg", "请先登录");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {

    }
}
