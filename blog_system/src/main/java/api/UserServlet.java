package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
    //1、先读取处 blogId
        resp.setContentType("application/json;charset=utf8");
        String blogId = req.getParameter("blogId");
        if(blogId == null || blogId.equals("")) {
            //返回一个Id为0的对象,因为最终返回一个json格式的数据，所以再次直接返回json格式
            String respJson = objectMapper.writeValueAsString(new User());
            resp.getWriter().write(respJson);
            System.out.println("参数给定的 blogId 为空");
            return;
        }
        //2、查询数据库，查询对应的 Blog 对象
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
        if(blog == null) {
            String respJson = objectMapper.writeValueAsString(new User());
            resp.getWriter().write(respJson);
            System.out.println("参数给定的 blogId 不存在");
            return;
        }
        //3、根据 blog 中的 userId ，查询作者信息
        UserDao userDao = new UserDao();
        User user = userDao.selectUserById(blog.getUserId());
        if(user == null) {
            String respJson = objectMapper.writeValueAsString(new User());
            resp.getWriter().write(respJson);
            System.out.println("该博客对应的作者不存在");
            return;
        }
        //4、 把 user 对象返回给页面
        String respJson = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJson);
    }
}
