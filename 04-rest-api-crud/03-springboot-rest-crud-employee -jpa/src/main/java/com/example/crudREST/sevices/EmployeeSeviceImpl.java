package com.example.crudREST.sevices;

import com.example.crudREST.DAO.EmployeeRespository;

import com.example.crudREST.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeSeviceImpl implements EmployeeSevice{
    private EmployeeRespository employeeRespository;

    @Autowired
    public EmployeeSeviceImpl(EmployeeRespository theEmployeeRespository){
        this.employeeRespository=theEmployeeRespository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee findByID(int theID) {
        Optional<Employee> result = employeeRespository.findById(theID);
        Employee employee=null;
        if(result.isPresent()){
            employee=result.get();
        }else{
            throw new RuntimeException("ID khong ton tai - "+theID);
        }
        return employee;
    }


    @Override
    public Employee save(Employee theEmplyee) {
        return employeeRespository.save(theEmplyee);
    }


    @Override
    public void DeleteByID(int theID) {
        employeeRespository.deleteById(theID);

    }
}
