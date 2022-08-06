package com.ihihr.jdbc.datasourse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class c3p0_test {

    public static void test1() throws IOException, PropertyVetoException, SQLException {
        // 1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        // 2.通过配置文件(mysql.properties)获取相关的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("test_sql\\src\\mysql.properties"));

        // 3.获取相关的属性值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // 4.给数据源 comboPooledDataSource设置参数(连接的创建和管理交给comboPooledDataSource)
        comboPooledDataSource.setJdbcUrl(url); // url
        comboPooledDataSource.setUser(user); // user
        comboPooledDataSource.setPassword(password); // password
        comboPooledDataSource.setDriverClass(driver); // driver

        comboPooledDataSource.setInitialPoolSize(5); // 设置初始化连接数
        comboPooledDataSource.setMaxPoolSize(50); // 设置最大连接数(超出最大连接数时的连接，会进入等待队列。不会创建新的连接)

        // 5.获得连接
        Connection connection = comboPooledDataSource.getConnection();// getConnection()方法是实现 DataSource接口的方法
        System.out.println("连接成功" + connection);

        connection.close();
    }

    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
        test1();
    }
}
