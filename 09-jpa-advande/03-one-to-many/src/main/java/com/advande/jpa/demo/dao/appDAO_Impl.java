package com.advande.jpa.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advande.jpa.demo.enity.Course;
import com.advande.jpa.demo.enity.Instructor;
import com.advande.jpa.demo.enity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
        
        return entityManager.find(Instructor.class, ID);
    }


    @Override
    public InstructorDetail FindInstructorDetailByID(int ID) {
        
        return entityManager.find(InstructorDetail.class, ID);
    }


    @Override
    @Transactional
    public void deleteInstructorDetail(int ID) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class, ID);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
        
    }


    @Override
    public List<Course> listCourseByID(int ID) {
        TypedQuery<Course> querry= entityManager.createQuery("from Course where instructor.id=:data",Course.class);
        querry.setParameter("data", ID);
        List<Course> listCourses=querry.getResultList();
        return listCourses;
    }


    @Override
    public Instructor findInstructorByIDJoinFetch(int theID) {
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i "+
        "join fetch i.courses where i.id= :data",Instructor.class);
        query.setParameter("data", theID);
        Instructor instructor=query.getSingleResult();
        
        return instructor;
    }


    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }


    @Override
    @Transactional
    public void deleteInstructorByID(int ID) {
        Instructor tempInstructor=entityManager.find(Instructor.class, ID);
        List<Course> listCourses=tempInstructor.getCourses();
        for (Course x : listCourses) {
            x.setInstructor(null);
        }
        entityManager.remove(tempInstructor);
    }


    @Override
    @Transactional
    public void deleteCourseByID(int theID) {
        Course tempCourse=entityManager.find(Course.class, theID);
        entityManager.remove(tempCourse);
    }

}
