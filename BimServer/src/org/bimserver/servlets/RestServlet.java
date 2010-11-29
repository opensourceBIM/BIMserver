package org.bimserver.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.bimserver.services.RestAuthentication;

public class RestServlet extends CXFNonSpringJaxrsServlet {
	private static final long serialVersionUID = 6288864278630843847L;
	
	@Override
	public void loadBus(ServletConfig servletConfig) throws ServletException {
		super.loadBus(servletConfig);
		getBus().getInInterceptors().add(new RestAuthentication());
	}
}