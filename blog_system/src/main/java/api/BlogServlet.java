package api;

/*
 *通过这个类，来实现一些后端提供的接口
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
}
