package com.nihal.cruddemo.dao;

import java.util.List;

import com.nihal.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void updatebyId(Integer id);

    Integer deleteAll();
}
