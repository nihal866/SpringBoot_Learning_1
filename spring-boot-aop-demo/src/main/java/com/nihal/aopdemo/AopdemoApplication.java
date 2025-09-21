package com.nihal.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nihal.aopdemo.dao.AccountDAO;
import com.nihal.aopdemo.dao.StringDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, StringDAO stringDAO) {
		return runner -> {
			doBeforeAdvice(accountDAO, stringDAO);
		};
	}

	private void doBeforeAdvice(AccountDAO accountDAO, StringDAO stringDAO) {
		accountDAO.addAccount();
	}

}
