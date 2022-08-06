package com.ihihr.jdbc.dbutils_druid;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class dbutils_druid03 {
    public static void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        String sql = "update news set content = ? where id = ?";
        String sql2 = "insert into news values (?, ?)";
        String sql3 = "delete from news where id =?";

        //(1) 执行 DML操作的是 update()方法
        //(2) 返回影响行数(affected: 受影响)
        int affectedRow = queryRunner.update(connection, sql, "新闻", 1);
        System.out.println(affectedRow>0?"执行成功":"执行没有影响到表");

        int affectedRow2 = queryRunner.update(connection, sql2, 3, "内容3");
        System.out.println(affectedRow2>0?"执行成功":"执行没有影响到表");

        int affectedRow3 = queryRunner.update(connection, sql3, 3);
        System.out.println(affectedRow2>0?"执行成功":"执行没有影响到表");

        JDBCUtilsByDruid.close(null, null, connection);
    }

    public static void main(String[] args) throws SQLException {
        testDML();
    }
}
