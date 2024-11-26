package com.example.crudREST.sevices;

import com.example.crudREST.entity.Employee;

import java.util.List;

public interface EmployeeSevice {
    List<Employee> findAll();

    Employee findByID(int theID);

    Employee save(Employee theEmplyee);

    void DeleteByID(int theID);
}
