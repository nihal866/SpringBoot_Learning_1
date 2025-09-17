package com.nihal.advancedemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nihal.advancedemo.dao.InstructorDAO;
import com.nihal.advancedemo.entity.Course;
import com.nihal.advancedemo.entity.Instructor;
import com.nihal.advancedemo.entity.InstructorDetail;
import com.nihal.advancedemo.entity.Review;

@SpringBootApplication
public class AdvancedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
			// createInsturctor(instructorDAO);
			// findInstructor(instructorDAO);
			// deleteInstructor(instructorDAO);
			// findInstructorDetail(instructorDAO);
			// deleteInstructorDetail(instructorDAO);
			// createInstructorWithCourses(instructorDAO);
			// findInstructorWithCourses(instructorDAO);
			// createCourseAndReviews(instructorDAO);
			// findCourseAndReviews(instructorDAO);
			deleteCourseAndReviews(instructorDAO);
		};
	}

	private void deleteCourseAndReviews(InstructorDAO instructorDAO) {
		int id = 10;
		instructorDAO.deleteCourseByCourseId(id);
		System.out.println("Deleted!!!");
	}

	private void findCourseAndReviews(InstructorDAO instructorDAO) {
		int id = 10;
		Course course = instructorDAO.findCourseAndReviewsByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Reviews for the course: " + course.getReviews());
	}

	private void createCourseAndReviews(InstructorDAO instructorDAO) {
		Course course = new Course("Embrace Stoicism.");
		Review review1 = new Review("Helped me a lot.");
		Review review2 = new Review("Great Course, enjoyed a lot.");
		Review review3 = new Review("What a dumb course, I am a feminist.");
		course.add(review1);
		course.add(review2);
		course.add(review3);

		System.out.println("Saving course" + course);
		System.out.println("Reviews for the courses: " + course.getReviews());

		instructorDAO.saveCourse(course);
		System.out.println("Done!!!");
	}

	private void findInstructorWithCourses(InstructorDAO instructorDAO) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println("Instructor details: " + instructor);
		List<Course> courses = instructorDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("Emraan", "Hashmi", "emraan@hashmi.com");
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/emraan_hashmi", "Kissing People");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Spring-boot Basics to Advanced");
		Course course2 = new Course("Java End-2-End");
		instructor.add(course1);
		instructor.add(course2);
		System.out.println("Saving instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());

		instructorDAO.save(instructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(InstructorDAO instructorDAO) {
		int id = 4;
		instructorDAO.deleteInstructorDetailById(id);

		System.out.println("Delete Successful.");
	}

	private void findInstructorDetail(InstructorDAO instructorDAO) {
		int id = 2;
		InstructorDetail instructorDetail = instructorDAO.findinInstructorDetailById(id);

		System.out.println("Instructor Detail: " + instructorDetail);
		System.out.println("Instructor Assosciated: " + instructorDetail.getInstructor());
	}

	private void createInsturctor(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("Emraan", "Hashmi", "emraan@hashmi.com");
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/emraan_hashmi", "Kissing People");
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		instructorDAO.save(instructor);
	}

	private void findInstructor(InstructorDAO instructorDAO) {
		int id = 3;
		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println(instructor);
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int id = 1;
		instructorDAO.deleteInstructorById(id);
		System.out.println("Delete successfull!");
	}

}
