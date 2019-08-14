package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WelcomeServlet  extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String name = request.getParameter("username");
			out.println("<h1> <center> Response From WelcomeServlet ");
			out.println("Login Successfull <br> Welcome "+name+" .. </center></h1>");
			
		}

			@Override
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
					this.doGet(request, response);
			}
}
