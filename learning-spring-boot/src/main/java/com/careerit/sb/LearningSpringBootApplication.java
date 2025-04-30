package com.careerit.sb;

import com.careerit.sb.di.UserService;
import com.careerit.sb.domain.Greetings;
import com.careerit.sb.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class LearningSpringBootApplication implements  CommandLineRunner  {

	@Autowired
	private UserService userService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LearningSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> users = userService.getAllUsers();
		System.out.println("Users: " + users);
	}

}


