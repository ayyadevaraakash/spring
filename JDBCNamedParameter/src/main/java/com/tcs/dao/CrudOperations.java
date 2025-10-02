package com.tcs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.entity.Student;

@Repository
public class CrudOperations {

	@Autowired
	private NamedParameterJdbcTemplate jt;

	public boolean insertStudent(Student s) {
		String sql = "insert into student(id,firstName,lastName,city,marks) values(:id,:firstName,:lastName,:city,:marks)";
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("id", s.getId());
		mp.put("firstName", s.getFirstName());
		mp.put("lastName", s.getLastName());
		mp.put("city", s.getCity());
		mp.put("marks", s.getMarks());
		int cnt = jt.update(sql, mp);
		if (cnt > 0) {
			return true;
		}
		return false;
	}

	public boolean updateStudentMarks(int id, int marks) {
		String sql = "update student set marks=:marks where id=:id";
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("id", id);
		mp.put("marks", marks);
		int cnt = jt.update(sql, mp);
		if (cnt > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteStudent(int id) {
		String sql = "delete from student where id=:id";
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("id", id);
		int cnt = jt.update(sql, mp);
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
