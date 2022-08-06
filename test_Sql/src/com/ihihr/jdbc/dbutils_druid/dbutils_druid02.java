package com.ihihr.jdbc.dbutils_druid;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class dbutils_druid02 {
    public static void testQuerySingle() throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();

        String sql = "select * from news where id = ?";

        QueryRunner queryRunner = new QueryRunner();

        // 因为返回的是单个记录， 使用的 Handler是 BeanHandler
        news n = queryRunner.query(connection, sql, new BeanHandler<>(news.class), 2);

        System.out.println(n);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    public static void main(String[] args) throws SQLException {
        testQuerySingle();
    }
}
