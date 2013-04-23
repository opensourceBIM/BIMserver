package org.bimserver.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.BimServer;

public abstract class SubServlet {

	private BimServer bimServer;
	private ServletContext servletContext;

	public SubServlet(BimServer bimServer, ServletContext servletContext) {
		this.bimServer = bimServer;
		this.servletContext = servletContext;
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
	
	public abstract void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public ServletContext getServletContext() {
		return servletContext;
	}
}
