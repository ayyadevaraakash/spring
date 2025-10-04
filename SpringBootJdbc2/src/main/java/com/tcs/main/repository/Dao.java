package com.tcs.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.main.entity.User;

@Repository
public class Dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertStudent(User user) {
		String sql = "insert into student values(?,?,?,?)";
		int count = jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPassword());
		return count > 0;
	}
}
