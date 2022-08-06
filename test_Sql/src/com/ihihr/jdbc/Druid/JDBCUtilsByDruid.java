package com.ihihr.jdbc.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {

    private static DataSource dataSource;

    // 静态代码块完成初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("test_sql\\src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 得到连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 关闭连接(放回连接池)(Connection是接口! 这里的connection方法并不是原来mysql实现的connection方法，而是Druid(德鲁伊)实现的connection方法)
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
