package com.ihihr.jdbc.dbutils_druid;

import com.ihihr.jdbc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class dbutils_druid01 {

    // 返回多条结果
    public static void testQueryMany() throws SQLException {
        // 1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2.使用DBUtils类和接口，先引入DBUtils相关的jar,加入到本Project
        // 3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.执行相关的方法，返回ArrayList结果集
        String sql = "select * from news where id >= ?";
        //(1) query方法就是执行sgL语句，得到resultset---封装到-->ArrayList集合中
        //(2) 返回集合
        //(3) connection:连接
        //(4) sgL:执行的sgL语句
        //(5) new BeanListHandler<>(Actor,class):在将resultset-> Actor对象->封装到ArrayList
        // 底层使用反射机制 去获取Actor进行封装
        //(6) 1是给sqL语句中的？赋值，可以有多个值，因为是可变参数
        //(7) 底层得到的resultSet方法，会在query方法中关闭, 还会关闭PreparedStatement,因为底层就是用PreparedStatement完成dml
        List<news> list = queryRunner.query(connection, sql, new BeanListHandler<>(news.class), 1);
        for(news n:list){
            System.out.println(n);
        }

        JDBCUtils.close(null, null, connection);
    }

    public static void main(String[] args) throws SQLException {
        testQueryMany();
    }
}
