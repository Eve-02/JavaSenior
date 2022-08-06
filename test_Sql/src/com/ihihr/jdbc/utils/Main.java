package com.ihihr.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    
    public  void testDML(){ // insert、update、delete

        Connection connection = null;

        String sql = "update news set content = ? where id = ?";

        PreparedStatement preparedStatement = null;


        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "q");
            preparedStatement.setInt(2, 1);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
