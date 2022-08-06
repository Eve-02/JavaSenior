package com.ihihr.dao_.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    // 定义相关的属性(4个)，因为只需要一份，因此，我们做出static
    public static String url; // url
    public static String user; // 用户
    public static String password; // 密码
    public static String driver; // 驱动

    // static 代码块初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("test_sql\\src\\mysql.properties"));

            // 读取属性值
             url = properties.getProperty("url");
             user = properties.getProperty("user");
             password = properties.getProperty("password");
             driver = properties.getProperty("driver");
        } catch (IOException e) {
            // 实际开发可以这样处理
            // 1.将编译异常转为运行异常
            // 2.这时候调用者 可以选择捕获该异常，也可以选择默认处理该异常，比较方便。
            throw new RuntimeException(e);
        }
    }

    // 连接数据库，返回 Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        1.resultSet 结果集
        2.Statement 或者 PreparedStatement
        3.Connection
        4.需要关闭传入 null，否则传入对象
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
