package com.nihal.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
if we want to include packages, out of this directory
then we explicitly scan packages like this

<--

@SpringBootApplication(scanBasePackages = { "com.nihal.springcoredemo", "com.nihal.util" })

-->
*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
