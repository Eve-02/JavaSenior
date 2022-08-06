package com.ihihr.jdbc.practise;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

@SuppressWarnings({"all"})
public class practise02 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test_sql\\src\\mysql.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // 加载驱动...

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "update news set content = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "s");
        preparedStatement.setInt(2, 1);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
