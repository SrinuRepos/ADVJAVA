package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			String username = request.getParameter("username");
			
			out.println("<h1> <center> Welcome "+username+"</center>  </h1> ");
			
			out.close();
		
	}
	
	

}
