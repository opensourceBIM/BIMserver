package org.bimserver.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.ws.rs.core.Application;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.apache.cxf.jaxrs.utils.ResourceUtils;
import org.bimserver.BimServer;
import org.bimserver.web.RestApplication;
import org.bimserver.web.RestAuthentication;

public class RestServlet extends CXFNonSpringJaxrsServlet {
	private static final long serialVersionUID = 6288864278630843847L;
	
	@Override
	protected void createServerFromApplication(String arg0, ServletConfig servletConfig) throws ServletException {
		BimServer bimServer = (BimServer) servletConfig.getServletContext().getAttribute("bimserver");
        Application app = new RestApplication(bimServer);
        JAXRSServerFactoryBean bean = ResourceUtils.createApplication(app, true);
        bean.setBus(getBus());
        bean.create();
	}
	
	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		BimServer bimServer = (BimServer) servletConfig.getServletContext().getAttribute("bimserver");
		getBus().getInInterceptors().add(new RestAuthentication(bimServer));
	}
}