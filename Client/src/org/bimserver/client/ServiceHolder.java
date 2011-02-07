package org.bimserver.client;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.bimserver.shared.ServiceException;
import org.bimserver.shared.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceHolder {
	private ServiceInterface service;
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceHolder.class);
	private String username = "anonymous";
	private String password = "anonymous";
	private String address = "http://localhost:8082/soap";

	public ServiceInterface getService() {
		return service;
	}

	public boolean connect(final String address, final String username, final String password) {
		this.address = address;
		this.username = username;
		this.password = password;
		LOGGER.info("Connecting to " + address);
		createClient(address);

		boolean connected = false;
		try {
			if (service.ping("test").equals("test")) {
				connected = true;
			}
		} catch (Exception e) {
			LOGGER.info("Error connecting to " + address);
		}

		if (connected) {
			try {
				LOGGER.info("Logging in as " + username);
				if (service.login(username, password)) {
					LOGGER.info("Successfully logged on as " + username);
					return true;
				} else {
					this.service = null;
					LOGGER.info("Error logging in as " + username);
					return false;
				}
			} catch (SOAPFaultException e) {
				this.service = null;
				LOGGER.info("Error connecting to " + address);
				return false;
			} catch (ServiceException e) {
				LOGGER.info("Error " + e.getMessage());
				return false;
			}
		} else {
			return false;
		}
	}

	private void createClient(final String address) {
		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
		cpfb.setServiceClass(ServiceInterface.class);
		cpfb.setAddress(address);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		cpfb.setProperties(properties);

		service = (ServiceInterface) cpfb.create();

		Client client = ClientProxy.getClient(service);
		client.getInInterceptors().add(new LoggingInInterceptor(ConsoleAppender.getPrintWriter()));
		client.getOutInterceptors().add(new LoggingOutInterceptor(ConsoleAppender.getPrintWriter()));
		HTTPConduit http = (HTTPConduit) client.getConduit();
		((BindingProvider) service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		http.getClient().setConnectionTimeout(360000);
		http.getClient().setAllowChunking(false);
		http.getClient().setReceiveTimeout(320000);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public void disconnect() {
		service = null;
	}

	public boolean isConnected() {
		return service != null;
	}
}