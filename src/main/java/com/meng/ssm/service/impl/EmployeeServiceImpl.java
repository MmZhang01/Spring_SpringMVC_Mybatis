package com.meng.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meng.ssm.mapper.EmployeeMapper;
import com.meng.ssm.pojo.Employee;
import com.meng.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getAllEmployee() {

        return employeeMapper.getAllEmployee();
    }

    public PageInfo<Employee> getEmployeeList(Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Employee> list = employeeMapper.getAllEmployee();
        PageInfo<Employee> page = new PageInfo<Employee>(list,5);
        return page;
    }
}
