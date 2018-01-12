package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DatabaseConnection;


public class OperationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String id = request.getParameter("id");
		try
		{
			DatabaseConnection connection = DatabaseConnection.getConnection();
			String sql = "INSERT INTO EMPLOYEE VALUES(?,?);";
			java.sql.PreparedStatement statement = connection.getCon().prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, id);
			statement.executeUpdate();
			
			RequestDispatcher rd= request.getRequestDispatcher("Servlet2");
			rd.forward(request, response);
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String id = request.getParameter("id");
		
		try
		{
			DatabaseConnection connection = DatabaseConnection.getConnection();
			String sql = "INSERT INTO EMPLOYEE VALUES(?,?);";
			java.sql.PreparedStatement statement = connection.getCon().prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2,id);
			statement.executeUpdate();

			RequestDispatcher rd= request.getRequestDispatcher("Servlet2");
			rd.forward(request, response);
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}		
}

