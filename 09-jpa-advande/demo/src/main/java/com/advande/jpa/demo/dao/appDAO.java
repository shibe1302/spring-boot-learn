package com.advande.jpa.demo.dao;

import com.advande.jpa.demo.enity.Instructor;

public interface appDAO {
    public void save(Instructor instructor);

    Instructor FindInstructorByID(int ID);

}
