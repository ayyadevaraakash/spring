package com.tcs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tcs.entity.Student;

@Repository
public class CrudOperations {

	@Autowired
	private JdbcTemplate jt;

	public boolean insertStudent(Student s) {
		String sql = "insert into student(id,firstName,lastName,city,marks) values(?,?,?,?,?)";
		int cnt = jt.update(sql, s.getId(), s.getFirstName(), s.getLastName(), s.getCity(), s.getMarks());
		if (cnt > 0) {
			return true;
		}
		return false;
	}

	public boolean updateStudentMarks(int id, int marks) {
		String sql = "update student set marks=? where id=?";
		int cnt = jt.update(sql, marks, id);
		if (cnt > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteStudent(int id) {
		String sql = "delete from student where id=?";
		int cnt = jt.update(sql, id);
		if (cnt > 0) {
			return true;
		}
		return false;
	}
	
	public List<Student> getAllStudent() {
		String sql = "select * from student";
		List<Student> list = jt.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFirstName(rs.getString("firstName"));
				s.setLastName(rs.getString("lastName"));
				s.setCity(rs.getString("city"));
				s.setMarks(rs.getInt("marks"));
				return s;
			}
			
		});
		return list;
	}
}
