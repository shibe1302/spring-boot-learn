package com.example.crudREST.dao;

import com.example.crudREST.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImp(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }
    


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuerry = this.entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employeeList=theQuerry.getResultList();
        return employeeList;
    }

    @Override
    public Employee findByID(int theID) {
        //get Employee
        Employee theemployee = this.entityManager.find(Employee.class,theID);

        //return the Employee
        return theemployee;
    }

    @Override
    public Employee save(Employee theEmplyee) {
        // save employee
        Employee DBemployee = this.entityManager.merge(theEmplyee);

        //return the Employee
        return DBemployee;
    }

    @Override
    public void DeleteByID(int theID) {
        Employee theemployee = this.entityManager.find(Employee.class,theID);

        entityManager.remove(theemployee);

    }
}
