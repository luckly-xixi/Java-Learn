package model;

/*
   通过这个类，封装数据库的连接操作
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
//    这个类中要提供  DataSource ，DataSource 对于一个项目来说，有一个就够了，（单例）
    private static volatile DataSource dataSource = null;

    private static DataSource getDataSource() {
        if(dataSource == null) {
            synchronized(DBUtil.class) {
                if(dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java107_blog_system?characterEncoding=utf7&useSSL=false");
                    ((MysqlDataSource)dataSource).setUser("root");
                    ((MysqlDataSource)dataSource).setPassword("123456");
                }
            }
        }
    return dataSource;
    }

//    获取连接
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

//    关闭资源
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
