package com.richard.springstudy.jdbc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: myself_study
 * @description:
 * @author: Mr.Wang
 * @create: 2018-08-23 11:16
 **/
public class JDBCTest
{
    //创建IOC容器对象
    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-jdbc.xml");
    //获取JdbcTemplate对象
    JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");

    @Test
    void test() throws SQLException {
        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    //通用增删改的方法
    @Test
    void testUpdate()
    {
        //写sql语句
        String sql = "insert into employees(last_name,email,salary,dept_id) values(?,?,?,?)";
        jdbcTemplate.update(sql,"李玉婷","lyting@atguigu");
    }
}
