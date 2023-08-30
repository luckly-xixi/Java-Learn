import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getParameter")
public class GetParameter extends HelloServtel{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        前端通过url的 query string 传递 username 和 password 两个属性
    String uersname = req.getParameter("uesername");
    if(uersname == null) {
        System.out.println("uersname 这个值在 query string 中不存在!");
    }
    String password = req.getParameter("password");
    if(password == null) {
        System.out.println("password 这个值在 query string 中不存在!");
    }
    System.out.println("uersname=" + uersname + "password=" + password);

    resp.getWriter().write("ok");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        前端通过body，以 form 表单 将username和password属性传给服务器
        resp.setCharacterEncoding("utf8");
        String uersname = req.getParameter("uesername");
        if(uersname == null) {
            System.out.println("uersname 这个值在 query string 中不存在!");
        }
        String password = req.getParameter("password");
        if(password == null) {
            System.out.println("password 这个值在 query string 中不存在!");
        }
        System.out.println("uersname=" + uersname + "password=" + password);

        resp.getWriter().write("ok");
    }
}

