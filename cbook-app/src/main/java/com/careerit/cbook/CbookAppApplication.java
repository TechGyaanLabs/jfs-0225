package com.careerit.cbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CbookAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CbookAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String message = "Cbook Application started successfully";
		System.out.println(message);
		System.out.println("Cbook application will help you to manage your contacts");
	}
}
