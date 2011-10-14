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

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.bimserver.BimServer;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.webservices.CustomInvoker;
import org.bimserver.webservices.RestAuthentication;

public class RestServlet extends CXFNonSpringJaxrsServlet {
	private static final long serialVersionUID = 6288864278630843847L;
	
	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);

		final BimServer bimServer = (BimServer) servletConfig.getServletContext().getAttribute("bimserver");
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
		JAXRSServerFactoryBean serverFactoryBean = new JAXRSServerFactoryBean();
		serverFactoryBean.setServiceClass(ServiceInterface.class);
		serverFactoryBean.setInvoker(new CustomInvoker(bimServer.getServiceFactory()));
		serverFactoryBean.setAddress("/");
		serverFactoryBean.create();
		
		getBus().getInInterceptors().add(new RestAuthentication(bimServer));
	}
}