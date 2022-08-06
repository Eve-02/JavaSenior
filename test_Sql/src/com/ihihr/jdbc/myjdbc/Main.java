package com.ihihr.jdbc.myjdbc;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //前置工作，在项目创建文件夹，如 libs，复制 mysql-connector-java.jar到该文件夹下，并加入到项目中
        // 1.注册驱动
//        Driver driver = new Driver(); // 创建driver对象


        // 2.得到连接
            // (1) jdbc:mysql:// 【规定好的，协议，通过jdbc的方式来连接mysql】
            // (2) localhost: 【localhost表示本机，主机。可以是ip地址(非本机)】
            // (3) 3306 【端口号，可能有不同的端口号。如3307】
            // (4) /db1_test 【要操作的具体数据库】
//        String url = "jdbc:mysql://localhost:3306/db1_test";
//            // 将用户名和密码放入到Properties对象中
//        Properties properties = new Properties();
//            // 关键字：user、password
//        properties.setProperty("user","root"); // 设置用户
//        properties.setProperty("password","abc123"); // 密码
//
//        Connection connect = driver.connect(url, properties);
//
//        // 3.执行sql
//        String sql = "INSERT INTO employees() VALUES(12,'小明','15000','男'),(11,'小红','10000','女'),(12,'小琪','12000','女')";
//            // Statement对象(操作数据库的对象) 用于执行静态sql语句，并返回其生成的结果的对象
//        Statement statement = connect.createStatement();
//        int rows = statement.executeUpdate(sql); // 大于0，返回影响行数。否则执行失败
//
//        System.out.println(rows>0?"成功":"失败");
//
//        // 4.关闭连接资源
//        statement.close();
//        connect.close();
    }
}
