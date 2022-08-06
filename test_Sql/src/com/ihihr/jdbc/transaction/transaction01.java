package com.ihihr.jdbc.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class transaction01 {

    public static void use_transaction() {

        Connection connection = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            connection.setAutoCommit(false); // connection执行 sql语句默认自动提交。设置为 false开启事务

            String sql1 = "update account set balance = balance - 100 where id = 3";
            String sql2 = "update account set balance = balance + 100 where id = 4";

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate(); // 执行第一条

//            int i = 1/0; 异常

            preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement1.executeUpdate(); // 执行第二条

            connection.commit();
        } catch (Exception e) {
            try {
                System.out.println("执行发生异常，回滚sql语句");
                connection.rollback(); // 当出现异常时，catch捕获，执行回滚操作默认回滚到事务开始的,可以设置保存点(connection.setSavepoint("a保存点");)
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                preparedStatement1.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        use_transaction();
    }
}
