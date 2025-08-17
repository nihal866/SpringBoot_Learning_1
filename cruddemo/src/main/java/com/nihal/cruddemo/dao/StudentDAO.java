package com.nihal.cruddemo.dao;

import java.util.List;

import com.nihal.cruddemo.entity.Student;

public interface StudentDAO {
    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    void update(Student student);

    void updatebyId(Integer id);
}
