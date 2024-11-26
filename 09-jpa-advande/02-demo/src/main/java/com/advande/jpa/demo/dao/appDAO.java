package com.advande.jpa.demo.dao;

import com.advande.jpa.demo.enity.Instructor;
import com.advande.jpa.demo.enity.InstructorDetail;

public interface appDAO {
    public void save(Instructor instructor);

    Instructor FindInstructorByID(int ID);

    InstructorDetail FindInstructorDetailByID(int ID);

    void deleteInstructorDetail(int ID);

}
