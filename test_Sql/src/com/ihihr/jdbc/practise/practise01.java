package com.ihihr.jdbc.practise;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

@SuppressWarnings({"all"})
public class practise01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test_sql\\src\\mysql.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // 加载驱动...

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "insert into news values (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // (1, a, b),(2, c, d),(3, e, f)
        String[] arr = new String[]{"ab", "cd", "ef"};

        for(int i=1;i<=3;i++) {
            preparedStatement.setInt(1,  i);
            preparedStatement.setString(2, arr[i-1].charAt(0)+"");
            preparedStatement.setString(3, arr[i-1].charAt(1)+"");

            preparedStatement.executeUpdate();
        }

        preparedStatement.close();
        connection.close();
    }
}
