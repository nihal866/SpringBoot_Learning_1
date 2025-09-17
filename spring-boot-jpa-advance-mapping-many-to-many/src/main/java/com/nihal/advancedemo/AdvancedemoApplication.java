package com.nihal.advancedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nihal.advancedemo.dao.InstructorDAO;
import com.nihal.advancedemo.entity.Course;
import com.nihal.advancedemo.entity.Student;

@SpringBootApplication
public class AdvancedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
			// createCourseAndStudents(instructorDAO);
			// findCourseAndStudentsByCourseId(instructorDAO);
			// findStudentAndCourses(instructorDAO);
			// addMoreCoursesForStudent(instructorDAO);
			// deleteCourse(instructorDAO);
			deleteStudent(instructorDAO);
		};
	}

	private void deleteStudent(InstructorDAO instructorDAO) {
		int id = 2;
		System.out.println("Deleteing student.");
		instructorDAO.deleteStudentByStudentId(id);
		System.out.println("DONE!!!");
	}

	private void deleteCourse(InstructorDAO instructorDAO) {
		int id = 12;
		System.out.println("Deleting Course");
		instructorDAO.deleteCourseByCourseId(id);
		System.out.println("DONE!!!");
	}

	private void addMoreCoursesForStudent(InstructorDAO instructorDAO) {
		int id = 2;
		Student student = instructorDAO.findStudentAndCourseByStudentId(id);
		student.addCourse(new Course("How to influence friends"));
		student.addCourse(new Course("System Design"));

		System.out.println("Saving courses into db.");
		instructorDAO.update(student);
		System.out.println("DONE!!!");
	}

	private void findStudentAndCourses(InstructorDAO instructorDAO) {
		int id = 2;
		Student student = instructorDAO.findStudentAndCourseByStudentId(id);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudentsByCourseId(InstructorDAO instructorDAO) {
		int id = 10;
		Course course = instructorDAO.findCourseAndStudentsByCourseId(id);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void createCourseAndStudents(InstructorDAO instructorDAO) {
		Course course = new Course("Stoicism");
		course.addStudent(new Student("Yogi", "AdityaNath", "yogi@bulldozer.com"));
		course.addStudent(new Student("Narendra", "Modi", "modi@bulldozer.com"));

		System.out.println("Saving the courses and students");
		instructorDAO.saveCourse(course);
		System.out.println("DONE!!!");
	}
}
