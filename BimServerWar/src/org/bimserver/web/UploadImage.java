package org.bimserver.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadImage extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		  System.out.println("inside servlet");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		out.print("successfully uploaded");  
	}
}
