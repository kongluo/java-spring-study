package com.richard.springstudy.jdbc.test;

import com.richard.springstudy.jdbc.beans.Employee;
import com.richard.springstudy.jdbc.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @program: myself_study
 * @description:
 * @author: Mr.Wang
 * @create: 2018-08-23 15:41
 **/
public class EmployeeServiceTest
{
    //创建IOC容器对象
    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-jdbc.xml");
    //获取JdbcTemplate对象
    JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");

    @Test
    void test()
    {
        EmployeeService employeeService = (EmployeeService) ioc.getBean("employeeService");
        List<Employee> employees = employeeService.getEmployees();
        for (Employee employee:employees)
        {
            System.out.println(employee);
        }
    }
}
