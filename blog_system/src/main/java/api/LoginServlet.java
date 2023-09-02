package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        //解决获取的数据中有中文会乱码
        req.setCharacterEncoding("utf8");
    //1、从请求中获取用户名和密码
        String uesrname = req.getParameter("uesrname");
        String password = req.getParameter("password");
        if(uesrname==null || uesrname.equals("") || password==null || password.equals("")) {
    //用户名密码残缺，登录必然失败
         String html = "<h3> 登陆失败！缺少用户名或者密码 </h3>";
         resp.setContentType("text/html;charset=utf8");
         resp.getWriter().write(html);
         return;
        }
        //2、读取数据库，看看这里的用户名和密码，是否和数据库中的匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectUserByName(uesrname);
        if(user == null) {
            //用户名不存在
            String html = "<h3> 登陆失败！用户名错误或不存在 </h3>";
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        if(!password.equals(user.getPassword())) {
            //密码错误
            String html = "<h3> 登陆失败！密码错误 </h3>";
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        //3、用户名密码正确，登陆成功,创建会话
        HttpSession session = req.getSession(true);
        // 此处把用户对象存储到 session 中，下次用户访问其他页面，直接拿着会话，进一步找到 user 对象
        session.setAttribute("user", user);
        //4、返回一个重定向响应，能够跳转到博客列表页面
        resp.sendRedirect("blog_list.html");
    }


//    这个方法，判定用户的登陆状态，已登陆返回200，未登录返回403
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    看当前的请求是否已经存在会话，并且当前的会话是否包含 user 对象
    HttpSession session = req.getSession(false);
    if(session == null) {
        //
//        会话不存在，未登录状态
        resp.setStatus(403);
        return;
    }
    User user = (User) session.getAttribute("user");
    if(user == null) {
        //虽然会话对象存在，但是用户对象没有，未登录
        resp.setStatus(403);
        return;
    }
    //已经登陆，  200  是默认状态码 ，此处 不写也可以
    resp.setStatus(200);
    resp.setContentType("application/json;charset=utf8");
    user.setPassword("");     //避免把密码也返回给前端
    String respJson = objectMapper.writeValueAsString(user);
    resp.getWriter().write(respJson);
    }
}
