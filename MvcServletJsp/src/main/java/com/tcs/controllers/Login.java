package com.tcs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.dao.DatabaseConnection;
import com.tcs.entity.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/submitLogin")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("loginEmail");
		String password = req.getParameter("loginPassword");

		String query = "select * from student where email=?";

		try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			String password_from_database = "";
			Student s = new Student();
			while (rs.next()) {
				password_from_database = rs.getString("password");
				s.setFirstName(rs.getString("firstName"));
				s.setLastName(rs.getString("lastName"));
				s.setEmail(rs.getString("email"));
			}

			RequestDispatcher rd = null;
			PrintWriter out = resp.getWriter();

			if (password_from_database.equals(password)) {
				
				HttpSession session = req.getSession();
				session.setAttribute("firstName", s.getFirstName());
				session.setAttribute("lastName", s.getLastName());
				session.setAttribute("email", s.getEmail());
				
				rd = req.getRequestDispatcher("profile.jsp");
				rd.forward(req, resp);
			} else {
				resp.setContentType("text/html");
				out.println("<h2>Credentials Mismatch</h2>");
				rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
