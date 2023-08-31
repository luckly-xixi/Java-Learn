package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//这个类用来实现登录时的校验
@WebServlet("/login")
public class loginServlet extends HttpServlet {

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //  super.doPost(req, resp);
//      1、先从请求中拿出用户名和密码
//      为了保持读出来的参数也能支持中文，记得设置编码方式utf8
      req.setCharacterEncoding("utf8");
      String username = req.getParameter("username");
      String password = req.getParameter("password");
//      2、验证用户名和密码是否正确
      if(username==null || password==null || username.equals("") || password.equals("")){
       resp.setContentType("text/html;charset=utf8");
       resp.getWriter().write("当前输入的用户名和密码不能为空！");
       return;
      }

//      此处假设用户名只能是zhangsan或者lisi，密码都是123
//      正常来说用户名和密码都是从数据库中读取的

//      if(username.equals("zhangsan") || username.equals("lisi")) {
//       if(password.equals("123")) {
////        密码错误
//       }
//      }
//      else {
////     用户名有误
//      }


      if(!username.equals("zhangsan") && !username.equals("lisi")) {
//       用户名有误
       resp.setContentType("text/html;charset=utf8");
       resp.getWriter().write("用户名有误");
       return;
      }
      if(!password.equals("123")) {
//       密码错误
       resp.setContentType("text/html;charset=utf8");
       resp.getWriter().write("密码有误");
       return;
      }
//      3、用户名和密码验证成功，接下来创建一个会话
//      当前用户是未登录的状态，此时请求的cookie中没有sessionId
//      此处的getsession是无法从服务器的 哈希表中 找到 session对象的
//      由于此处把参数设为true,所以允许getsession在查询不到的时候,创建新的 session 对象和 sessionId
//      并且自动把 sessionId 和 session 对象存储到哈希表中
//      同时返回这个 session 对象，并且在接下来的响应中会自动把这个 sessionId 返回给客户端浏览器
      HttpSession session = req.getSession(true);
      session.setAttribute("username",username);

//      4、登陆成功之后自动跳转到主页
      resp.sendRedirect("index");
     }
}
