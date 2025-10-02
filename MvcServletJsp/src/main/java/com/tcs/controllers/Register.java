package com.tcs.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tcs.dao.DatabaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitRegister")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("registerFirstName");
		String lastName = req.getParameter("registerLastName");
		String email = req.getParameter("registerEmail");
		String password = req.getParameter("registerPassword");

		String query = "insert into student(firstName,lastName,email,password) values(?,?,?,?)";

		try (
				Connection con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
			)
		{
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, password);
			int cnt = ps.executeUpdate();
			if (cnt > 0) {
				System.out.println("Row inserted in table");
			} else {
				System.out.println("Some Error Occurred");
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
