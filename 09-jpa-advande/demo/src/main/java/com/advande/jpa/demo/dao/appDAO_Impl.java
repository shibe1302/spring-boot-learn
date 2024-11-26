package com.advande.jpa.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advande.jpa.demo.enity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class appDAO_Impl implements appDAO{

    private EntityManager entityManager;

    
    @Autowired
    public appDAO_Impl(EntityManager entityManager1) {
        this.entityManager = entityManager1;
    }


    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }


    @Override
    public Instructor FindInstructorByID(int ID) {
        // TODO Auto-generated method stub
        return entityManager.find(Instructor.class, ID);
    }

}
