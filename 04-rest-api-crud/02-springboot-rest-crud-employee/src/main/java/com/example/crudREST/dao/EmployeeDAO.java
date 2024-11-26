package com.example.crudREST.dao;

import com.example.crudREST.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findByID(int theID);

    Employee save(Employee theEmplyee);

    void DeleteByID(int theID);

}
