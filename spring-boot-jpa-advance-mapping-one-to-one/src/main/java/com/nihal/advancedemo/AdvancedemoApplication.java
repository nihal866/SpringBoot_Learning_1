package com.nihal.advancedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nihal.advancedemo.dao.InstructorDAO;
import com.nihal.advancedemo.entity.Instructor;
import com.nihal.advancedemo.entity.InstructorDetail;

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
			deleteInstructor(instructorDAO);
		};
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
