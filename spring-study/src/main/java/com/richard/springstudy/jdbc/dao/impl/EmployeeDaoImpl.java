package com.richard.springstudy.jdbc.dao.impl;

import com.richard.springstudy.jdbc.dao.EmployeeDao;
import com.richard.springstudy.jdbc.beans.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: myself_study
 * @description:
 * @author: Mr.Wang
 * @create: 2018-08-23 15:30
 **/
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployees() {
        //写sql语句
        String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees";
        //创建rowMapper独享
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
        return employees;
    }
}
