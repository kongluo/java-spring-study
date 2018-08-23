package com.richard.springstudy.jdbc.service;

import com.richard.springstudy.jdbc.beans.Employee;

import java.util.List;

public interface EmployeeService
{
    public List<Employee> getEmployees();
}
