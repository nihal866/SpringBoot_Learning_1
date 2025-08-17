package com.nihal.cruddemo;

import java.util.List;

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
			createRecord(studentDAO);

			// findRecord(studentDAO);

			// fetchAllRecords(studentDAO);

			// fetchRecordsByLastName(studentDAO);

			// updateRecord(studentDAO);

			// updateRecordById(studentDAO);

			// deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		// delete all rows
		System.out.println("Deleting all rows...");
		int deletedRows = studentDAO.deleteAll();

		// checking the deleted data
		System.out.println("Number of rows deleted: " + deletedRows);
	}

	private void updateRecordById(StudentDAO studentDAO) {
		int queryId = 5;
		studentDAO.updatebyId(queryId);
	}

	private void updateRecord(StudentDAO studentDAO) {
		int queryId = 4;
		// fetching student with id = 4;
		System.out.println("Fetching student record with id: " + queryId);
		Student queryStudent = studentDAO.findById(queryId);

		// updating the lastName of this record
		System.out.println("Updating the first name and email of the record: " + queryStudent);
		queryStudent.setEmail("rahulgandhichor@gmail.com");
		queryStudent.setFirstName("Rahul");

		// updating in db
		studentDAO.update(queryStudent);

		// displaying reocrd for it
		System.out.println("Record changed. " + queryStudent);
	}

	private void fetchRecordsByLastName(StudentDAO studentDAO) {
		// fetching student list with last name as "Singhania"
		String queryLastName = "Singhania";
		List<Student> records = studentDAO.findByLastName(queryLastName);

		// displaying records
		for (Student record : records) {
			System.out.println("Found student: " + record + "\n");
		}
	}

	private void fetchAllRecords(StudentDAO studentDAO) {
		// fetching student lists
		System.out.println("Fetching all student records..");
		List<Student> records = studentDAO.findAll();

		// displaying records
		for (Student record : records) {
			System.out.println("Found student: " + record + "\n");
		}
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
		Student tempStudent1 = new Student("Kapil", "Sharma", "kapilsharma@gmail.com");
		Student tempStudent2 = new Student("Rajeev", "Singhania", "singhaniarajeev@gmail.com");
		Student tempStudent3 = new Student("Indira", "Singhania", "singhaniaindira@gmail.com");

		// save the student object
		System.out.println("Saving the student object");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display id of saved student
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());
	}

}
