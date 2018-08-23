package com.richard.springstudy.jdbc.test;

import com.richard.springstudy.jdbc.beans.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        jdbcTemplate.update(sql,"李玉婷","lyting@atguigu",15000,2);
    }

    //批处理的方法
    @Test
    void testBatchUpdate(){
        String sql = "insert into employees(last_name,email,salary,dept_id) values(?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"李小璐","lxl@126.com",100000,6});
        batchArgs.add(new Object[]{"PGOne","pg1@126.com",100000,6});
        batchArgs.add(new Object[]{"贾乃亮","jnl@126.com",100000,6});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /*
    * 获取一个单一值的方法
    * 调用的是jdbcTemplate.queryForObject()方法
    * */
    @Test
    void testGetSingleValue(){
        String sql = "select count(*) from employees";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    /*
    * 获取一个对象的方法
    * 调用的是jdbcTemplate.queryForObject
    * RowMapper的实现类使用的是BeanPropertyRowMapper
    * */
    @Test
    void testGetBean(){
        String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees WHERE id=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,4);
        System.out.println(employee);

    }

    /*
    * 获取一个集合的方法
    * 调用的是jdbcTemplate的query方法
    * RowMapper的实现类使用的是BeanPropertyRowMapper
    * */
    @Test
    void testGetBeanList(){
        String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
        for (Employee employee:employees)
        {
            System.out.println(employee);
        }
    }

}
