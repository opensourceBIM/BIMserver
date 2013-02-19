package org.bimserver.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.plugins.web.WebModulePlugin;

public class WebModuleServlet extends HttpServlet {
	private WebModulePlugin webModule;

	public WebModuleServlet(WebModulePlugin webModule) {
		this.webModule = webModule;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		webModule.service(request, response);
	}
}