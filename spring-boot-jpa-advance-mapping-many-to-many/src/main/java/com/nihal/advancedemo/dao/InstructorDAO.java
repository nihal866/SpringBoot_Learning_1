package com.nihal.advancedemo.dao;

import java.util.List;

import com.nihal.advancedemo.entity.Course;
import com.nihal.advancedemo.entity.Instructor;
import com.nihal.advancedemo.entity.InstructorDetail;
import com.nihal.advancedemo.entity.Student;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findinInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    void deleteCourseByCourseId(int id);

    void deleteStudentByStudentId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCourseByStudentId(int id);

    void update(Student student);
}
