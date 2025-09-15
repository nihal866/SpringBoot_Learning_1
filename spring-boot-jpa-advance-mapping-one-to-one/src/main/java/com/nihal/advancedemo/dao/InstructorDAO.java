package com.nihal.advancedemo.dao;

import com.nihal.advancedemo.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
