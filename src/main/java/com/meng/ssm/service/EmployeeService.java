package com.meng.ssm.service;

import com.github.pagehelper.PageInfo;
import com.meng.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeeList(Integer pageNum);
}
