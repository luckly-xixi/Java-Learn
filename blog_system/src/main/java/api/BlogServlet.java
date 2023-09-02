package api;

/*
 *通过这个类，来实现一些后端提供的接口
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends  HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        从 query string 中查询一下看是否有 blogId ，如果有就认为是查询指定的博客， 如果没有就查询所有的博客
        BlogDao blogDao = new BlogDao();
        String blogId = req.getParameter("blogId");

        if(blogId == null) {
            List<Blog> blogs = blogDao.selectAll();
            //把从数据库中拿到的数据转为一个json格式的字符串
            String respSting = objectMapper.writeValueAsString(blogs);
            resp.setContentType("application/json;charset=uft8");//设置格式
            resp.getWriter().write(respSting);//写入
        } else {
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            String respSting = objectMapper.writeValueAsString(blog);
            resp.setContentType("application/json;charset=uft8");//设置格式
            resp.getWriter().write(respSting);//写入
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf8");
        //1、从请求中拿到标题和正文
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(title==null || title.equals("") || content==null || content.equals("")) {
            String html = "<h3>tltle 或者 content 为空！插入失败！</h3> ";
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        //  2、从会话中拿到作者Id
        HttpSession session = req.getSession(false);
        if(session == null) {
            String html = "<h3>当前用户未登录 插入失败！</h3> ";
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        User user = (User)session.getAttribute("user");
        if(user == null) {
            String html = "<h3>当前用户未登录 插入失败！</h3> ";
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        //3、构造 blog 对象
        Blog blog = new Blog();
        blog.setUserId(user.getUserId());
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        //4、插入 blog 对象到数据库
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);
        //5、跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }
}
