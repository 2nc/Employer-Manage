package com.wu.dao;

import com.wu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//Department Table
@Repository
public class DepartmentDao {

    //Simulate data of department
    private static Map<Integer, Department> departments;

    static{
        departments = new HashMap<>();
        departments.put(101, new Department(101, "Teaching"));
        departments.put(102, new Department(102, "Market"));
        departments.put(103, new Department(103, "Research"));
        departments.put(104, new Department(104, "DevOp"));
        departments.put(105, new Department(105, "Backing"));
    }

    //Get all department information
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //Get department by Id
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
