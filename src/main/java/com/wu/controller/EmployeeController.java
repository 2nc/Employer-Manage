package com.wu.controller;

import com.wu.dao.EmployeeDao;
import com.wu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("employ")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("allEmployees", employees);
        return "tables";
    }
}
