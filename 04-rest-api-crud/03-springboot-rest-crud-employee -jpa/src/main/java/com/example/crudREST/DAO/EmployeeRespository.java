package com.example.crudREST.DAO;

import com.example.crudREST.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
