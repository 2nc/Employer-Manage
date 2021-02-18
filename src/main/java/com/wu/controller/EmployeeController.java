package com.wu.controller;

import com.wu.dao.DepartmentDao;
import com.wu.dao.EmployeeDao;
import com.wu.pojo.Department;
import com.wu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;


    @RequestMapping("/employ")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("allEmployees", employees);
        return "tables";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "addEmployee";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("save=>" + employee);
        employeeDao.addEmployee(employee);
        return "redirect:/employ";
    }
}
