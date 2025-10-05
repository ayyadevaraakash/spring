package com.tcs.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.main.entity.User;
import com.tcs.main.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public void insertStudent(User user) {
		repo.save(user);
	}
	
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
}
