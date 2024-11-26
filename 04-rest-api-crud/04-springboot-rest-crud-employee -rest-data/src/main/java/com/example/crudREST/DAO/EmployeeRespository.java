package com.example.crudREST.DAO;

import com.example.crudREST.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "shiba")
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
