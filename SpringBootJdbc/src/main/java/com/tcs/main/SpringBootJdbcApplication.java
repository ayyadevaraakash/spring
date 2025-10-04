package com.tcs.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.main.entity.User;
import com.tcs.main.repository.Dao;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
	
	@Autowired
	private Dao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dao.insertStudent(new User("akash", "ayyadevara", "ayyadevaraakash@gmail.com", "akash123"));
		System.out.println("New user inserted successfully");
	}
}
