package com.richard.springstudy.jdbc.dao;

import com.richard.springstudy.jdbc.beans.Employee;

import java.util.List;

public interface EmployeeDao
{
    public List<Employee> getEmployees();
}
