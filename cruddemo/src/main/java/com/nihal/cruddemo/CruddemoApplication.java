package com.nihal.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nihal.cruddemo.dao.StudentDAO;
import com.nihal.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createRecord(studentDAO);

			findRecord(studentDAO);
		};
	}

	private void findRecord(StudentDAO studentDAO) {
		int tempId = 1;

		// fetch student based on the id
		System.out.println("Fetching student with id: " + tempId);
		Student fetchedStudent = studentDAO.findById(tempId);

		// display name for the reocrd, if present
		if (fetchedStudent != null) {
			System.out.println("Found student" + fetchedStudent);
		} else {
			System.out.println("No student found with this id");
		}
	}

	private void createRecord(StudentDAO studentDAO) {
		// creating student object
		System.out.println("Creating student object...");
		Student tempStudent = new Student("Atul", "Singhania", "singhaniaatul@gmail.com");

		// save the student object
		System.out.println("Saving the student object");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
