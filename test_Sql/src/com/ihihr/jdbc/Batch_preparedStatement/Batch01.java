package com.ihihr.jdbc.Batch_preparedStatement;

import com.ihihr.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into news values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();

        for(int i=1;i<=5000;i++){
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,"新闻内容");
            // 将 sql语句加入批处理包中
            preparedStatement.addBatch();
            // 当有 1000条 sql语句时，将批处理包发送给 mysql执行
            if(i%1000 == 0){
                preparedStatement.executeBatch(); // 批量执行
                preparedStatement.clearBatch(); // 清空
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("执行时间: "+ (end - start) + "ms");

        JDBCUtils.close(null, preparedStatement, connection);
    }
}
