package com.luv2code.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/list")
    public String listEmployees(Model thModel){
        List<Employee> thEmployees=employeeService.findAll();

        thModel.addAttribute("employee", thEmployees);
        return "list-employees";

    }

    @GetMapping("/addUser")
    public String addUser(Model thModel){
        Employee employee=new Employee();
        thModel.addAttribute("employee1", employee);
        return "employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee1") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update1")
    public String updateEmployee(@RequestParam("employeeID") int employeeID,Model thModel){
        Employee employee= employeeService.findById(employeeID);
        thModel.addAttribute("employee1", employee);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String Delete(@RequestParam("employeeID") int employeeID){
        employeeService.deleteById(employeeID);
        return "redirect:/employees/list";
    }


}
