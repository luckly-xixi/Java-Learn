import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/showRequest")
public class ShowRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        StringBuilder result = new StringBuilder();
        result.append(req.getProtocol());
        result.append("<br>");
        result.append(req.getMethod());
        result.append("<br>");
        result.append(req.getQueryString());
        result.append("<br>");
        result.append(req.getRequestURI());
        result.append("<br>");
        result.append(req.getContextPath());
        result.append("<br>");

        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            result.append(headerName+ ":" + headerValue + "<br>");
        }

//        在响应中设置body类型，方便浏览器解析
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write(result.toString());
    }
}
