package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.xml.bind.JAXBException;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.headers.HeaderManager;
import org.apache.cxf.headers.HeaderProcessor;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.webservices.CustomInvoker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceServlet extends CXFNonSpringServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceServlet.class);
	private static final long serialVersionUID = 3633266184012679113L;

	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		BimServer bimServer = (BimServer) servletConfig.getServletContext().getAttribute("bimserver");
		Bus bus = getBus();
		HeaderManager headerManager = bus.getExtension(HeaderManager.class);
		headerManager.registerHeaderProcessor(new HeaderProcessor() {
			@Override
			public String getNamespace() {
				return "uri:org.bimserver.interfaces.objects";
			}
			
			@Override
			public InterceptorProvider getInterceptorProvider() {
				return null;
			}
			
			@Override
			public DataBinding getDataBinding() {
				try {
					return new JAXBDataBinding(SToken.class);
				} catch (JAXBException e) {
					LOGGER.error("", e);
				}
				return null;
			}
		});
		BusFactory.setDefaultBus(bus);
		JaxWsServerFactoryBean serverFactoryBean = new JaxWsServerFactoryBean();
		Map<String,Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		serverFactoryBean.setProperties(properties);
		serverFactoryBean.setServiceClass(ServiceInterface.class);
		serverFactoryBean.setInvoker(new CustomInvoker(bimServer.getServiceFactory()));
		serverFactoryBean.setAddress("/");
		serverFactoryBean.setTransportId("http://schemas.xmlsoap.org/soap/http");
		serverFactoryBean.create();
	}
}