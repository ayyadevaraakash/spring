package com.tcs.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcs.main.entity.User;

@Controller
public class MainController {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@GetMapping("/")
	public String landingPage() {
		return "index";
	}
	
	@PostMapping("/register")
	public String handleRegister(@ModelAttribute User user) {
		String sql = "insert into student values (?,?,?,?)";
		int cnt = jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
		if (cnt>0) {
			System.out.println("User insert successfully");
		}
		return "index";
	}
}
