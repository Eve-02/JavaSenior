package com.ihihr.jdbc.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid01 {

    public static void test() throws Exception {
        //1.加入Druid jar包
        //2.加入配置文件dru1d.properties,将该文件拷贝项目的src目录
        //3.创建properties对象读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("test_sql\\src\\druid.properties"));

        //4.创建一个指定配置文件参数的数据源(数据库连接池)
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //5.得到连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
