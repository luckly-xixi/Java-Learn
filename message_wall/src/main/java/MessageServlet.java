import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Message {
//从此处属性必须让外界可以获取到
    public String form;
    public String to;
    public String message;

    @Override
    public String toString() {
        return "Message{" +
                "form='" + form + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messageList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    通过这个方法来处理”获取所有消息“
//      需要返回一个json字符串数组
        List<Message> messagelist = load();
        String respSteing = objectMapper.writeValueAsString(messageList);
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(respSteing);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    通过这个方法来处理”提交新消息“\
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
//        messageList.add(message);
        save(message);
        System.out.println("消息提交成功！ massage=" + message);

//        响应只是返回200的报文，body为空，此时不需要额外处理，默认是返回200
    }

//    这个方法用来向数据库存一条记录
    private void save(Message message) {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://129.0.0.1:3306/java107?characterEncoding=utf8&&useSSl=flase");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setUrl("123456");

        try {
            Connection connection = dataSource.getConnection();
            String sql = "insert into message values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,message.form);
            statement.setString(2,message.to);
            statement.setString(3,message.message);
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    这个方法用来从数据库查询所有记录
    private List<Message> load() {

        List<Message> messageList = new ArrayList<>();

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://129.0.0.1:3306/java107?characterEncoding=utf8&&useSSl=flase");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setUrl("123456");

        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from message";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Message message = new Message();
                message.form = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message= resultSet.getString("message");
                messageList.add(message);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }
}



