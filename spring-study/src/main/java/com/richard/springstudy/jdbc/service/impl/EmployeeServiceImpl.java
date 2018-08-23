package com.richard.springstudy.jdbc.service.impl;

import com.richard.springstudy.jdbc.beans.Employee;
import com.richard.springstudy.jdbc.dao.EmployeeDao;
import com.richard.springstudy.jdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: myself_study
 * @description:
 * @author: Mr.Wang
 * @create: 2018-08-23 15:40
 **/
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployees()
    {
        return employeeDao.getEmployees();
    }
}
