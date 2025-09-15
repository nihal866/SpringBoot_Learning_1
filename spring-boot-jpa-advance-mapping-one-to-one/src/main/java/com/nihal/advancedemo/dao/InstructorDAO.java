package com.nihal.advancedemo.dao;

import com.nihal.advancedemo.entity.Instructor;
import com.nihal.advancedemo.entity.InstructorDetail;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findinInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
