package com.meng.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.meng.ssm.pojo.Employee;
import com.meng.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * restful style
 *  * 查询所有的员工信息-->/employee-->get
 *  * 跳转到添加页面-->/to/add-->get
 *  * 新增员工信息-->/employee-->post
 *  * 跳转到修改页面-->/employee/1-->get
 *  * 修改员工信息-->/employee-->put
 *  * 删除员工信息-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeeList(Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Employee> page = employeeService.getEmployeeList(pageNum);
        model.addAttribute("page", page);
        return "employee_list";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list",list);
        return "employee_list";

    }
}
