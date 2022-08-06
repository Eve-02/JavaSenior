package com.ihihr.jdbc.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcconn {

    // 第一种:
//    public void connect01() throws SQLException {
//        Driver driver = new Driver();
//
//        String url = "jdbc:mysql://localhost:3306/db1_test";
//
//        Properties info = new Properties();
//        info.setProperty("user","root");
//        info.setProperty("password","abc123");
//
//        Connection conn = driver.connect(url, info);
//        System.out.println(conn);
//    }

    // 第二种:
//    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver)aClass.newInstance();
//
//        String url = "jdbc:mysql://localhost:3306/db1_test";
//
//        Properties info = new Properties();
//        info.setProperty("user","root");
//        info.setProperty("password","abc123");
//
//        Connection conn = driver.connect(url,info);
//        System.out.println(conn);
//    }

    // 第三种:
//    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        // 使用反射加载Driver
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) aClass.newInstance();
//
//        // 创建 url 和 user 和 password
//        String url = "jdbc:mysql://localhost:3306/db1_test";
//        String user = "root";
//        String password = "abc123";
//
//        DriverManager.registerDriver(driver); // 注册Driver驱动
//
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
//    }

//    public void connect04() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/db1_test";
//        String user = "root";
//        String password = "abc123";
//        Connection conn = DriverManager.getConnection(url,user,password);
//        System.out.println(conn);
//    }

    public static void connect05() throws IOException, ClassNotFoundException, SQLException {
        // 通过Properties,对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("test_sql\\src\\mysql.properties"));

        // 获取相关的值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        connect05();
    }
}
