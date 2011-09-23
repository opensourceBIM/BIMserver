package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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