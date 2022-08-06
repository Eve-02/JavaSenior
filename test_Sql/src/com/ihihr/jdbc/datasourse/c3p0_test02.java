package com.ihihr.jdbc.datasourse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class c3p0_test02 {

    public static void test() throws SQLException {
        // 1.将c3p0提供的c3p0.config.XmL拷贝到src目录下(该文件指定了连接数据库和连接池的相关参数)
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("ihihr");

        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);

        String sql = "insert into news values (1, '123')";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i=1;i<=100;i++){
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.clearBatch();

        preparedStatement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        test();
    }
}
