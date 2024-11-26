package com.advande.jpa.demo.dao;

import java.util.List;

import com.advande.jpa.demo.enity.Course;
import com.advande.jpa.demo.enity.Instructor;
import com.advande.jpa.demo.enity.InstructorDetail;

public interface appDAO {
    public void save(Instructor instructor);

    Instructor FindInstructorByID(int ID);

    InstructorDetail FindInstructorDetailByID(int ID);

    void deleteInstructorByID(int ID);

    void deleteInstructorDetail(int ID);
    
    List<Course>listCourseByID(int ID);

    Instructor findInstructorByIDJoinFetch(int theID);

    void updateInstructor(Instructor instructor);

    void deleteCourseByID(int theID);

}
