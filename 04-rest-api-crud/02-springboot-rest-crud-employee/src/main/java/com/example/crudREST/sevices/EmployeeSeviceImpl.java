package com.example.crudREST.sevices;

import com.example.crudREST.dao.EmployeeDAO;
import com.example.crudREST.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class EmployeeSeviceImpl implements EmployeeSevice{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeSeviceImpl(EmployeeDAO TheEmployeeDAO){
        this.employeeDAO=TheEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findByID(int theID) {
        return employeeDAO.findByID(theID);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmplyee) {
        return employeeDAO.save(theEmplyee);
    }

    @Transactional
    @Override
    public void DeleteByID(int theID) {
        employeeDAO.DeleteByID(theID);

    }
}
