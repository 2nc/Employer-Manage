package com.wu.dao;

import com.wu.pojo.Department;
import com.wu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees;

    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "AA", "aabc@gmail.com", 1, new Department(101, "Teaching")));
        employees.put(1002, new Employee(1002, "BB", "babc@gmail.com", 0, new Department(102, "Market")));
        employees.put(1003, new Employee(1003, "CC", "cabc@gmail.com", 1, new Department(103, "Research")));
        employees.put(1004, new Employee(1004, "DD", "dabc@gmail.com", 0, new Department(104, "DevOp")));
        employees.put(1005, new Employee(1005, "EE", "eabc@gmail.com", 1, new Department(105, "Backing")));
    }

    //primary key
    private static Integer initId = 1006;

    //add employee
    public void addEmployee(Employee employee){
        if(null == employee.getId())
            employee.setId(initId++);

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //get all information
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //get employee by Id
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //delete employee
    public void delete(Integer id){
        employees.remove(id);
    }
}
