package com.ihihr.jdbc.Resultset;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@SuppressWarnings({"all"})
public class resultset {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        // 通过Properties,对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("test_sql\\src\\mysql.properties"));

        // 获取相关的值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // 1.注册驱动，建议写上
//        Class.forName(driver);

        // 2.得到连接
        Connection connection = DriverManager.getConnection(url,user,password);

        // 3.得到statement
        Statement statement = connection.createStatement();

        // 4.执行查询语句
        String sql = "select * from news";
        // 执行给定的sql语句，返回 resultset对象
        /* ResultSet是接口类型 */
        ResultSet resultSet = statement.executeQuery(sql);
        // 使用while循环取出数据
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String salary  = resultSet.getString(3);
            System.out.println(id + "\t" + "name" + "\t" + salary);
        }

        // 5.关闭连接资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
