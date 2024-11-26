package com.example.crudREST.rest;


import com.example.crudREST.dao.EmployeeDAO;
import com.example.crudREST.entity.Employee;
import com.example.crudREST.sevices.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeSevice employeeSevice;


    @Autowired
    public EmployeeRestController(EmployeeSevice TheEmployeeSevice){
        this.employeeSevice=TheEmployeeSevice;
    }

    @GetMapping("/employee")
    public List<Employee> findAll(){
        return this.employeeSevice.findAll();
    }

    @GetMapping("/employee/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID){
        Employee theemployee = employeeSevice.findByID(employeeID);
        if (theemployee==null){
            throw new RuntimeException("Employee id khong ton tai ! - "+employeeID);
        }
        return theemployee;
    }

    @PostMapping("/employee")
    public Employee AddEmployee(@RequestBody Employee The_employee){
        The_employee.setID(0);

        Employee dbEmployee = employeeSevice.save(The_employee);

        return dbEmployee;

    }

    @PutMapping("/employee")
    public Employee putEmployee(@RequestBody Employee The_employee){
        Employee dbEmployee = employeeSevice.save(The_employee);
        return dbEmployee;
    }

    @DeleteMapping("/employee/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        employeeSevice.DeleteByID(employeeID);
        return "deleted succesful "+employeeID;
    }


}
