package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import javax.xml.ws.soap.SOAPFaultException;

import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceHolder {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceHolder.class);
	private String username = "admin@bimserver.org";
	private String password = "admin";
	private String address = "http://localhost:8080/soap";
	private BimServerClient bimServerClient;

	public ServiceInterface getService() {
		return bimServerClient.getServiceInterface();
	}

	public boolean connect(final String address, final String username, final String password) {
		bimServerClient = new BimServerClient(address, null);
		this.address = address;
		this.username = username;
		this.password = password;
		LOGGER.info("Connecting to " + address);
		try {
			bimServerClient.connectSoap(true);
		} catch (ConnectionException e) {
			LOGGER.error("", e);
		}

		boolean connected = false;
		try {
			if (bimServerClient.getServiceInterface().ping("test").equals("test")) {
				connected = true;
			}
		} catch (Exception e) {
			LOGGER.info("Error connecting to " + address);
		}

		if (connected) {
			try {
				LOGGER.info("Logging in as " + username);
				if (bimServerClient.getServiceInterface().login(username, password) != null) {
					LOGGER.info("Successfully logged on as " + username);
					return true;
				} else {
					LOGGER.info("Error logging in as " + username);
					return false;
				}
			} catch (SOAPFaultException e) {
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

//	private void createClient(final String address, boolean useSoapHeaderForSession) {
//		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
//		cpfb.setServiceClass(ServiceInterface.class);
//		cpfb.setAddress(address);
//		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put("mtom-enabled", Boolean.TRUE);
//		cpfb.setProperties(properties);
//
//		service = (ServiceInterface) cpfb.create();
//
//		Client client = ClientProxy.getClient(service);
//		client.getInInterceptors().add(new LoggingInInterceptor(ConsoleAppender.getPrintWriter()));
//		client.getOutInterceptors().add(new LoggingOutInterceptor(ConsoleAppender.getPrintWriter()));
//		HTTPConduit http = (HTTPConduit) client.getConduit();
//		if (!useSoapHeaderForSession) {
//			((BindingProvider) service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
//		}
//		http.getClient().setConnectionTimeout(360000);
//		http.getClient().setAllowChunking(false);
//		http.getClient().setReceiveTimeout(320000);
//		
//		if (useSoapHeaderForSession) {
//			try {
//				Token token = service.getCurrentToken();
//				List<Header> headers = new ArrayList<Header>();
//				try {
//					Header sessionHeader = new Header(new QName("uri:org.bimserver", "token"), token, new JAXBDataBinding(Token.class));
//					headers.add(sessionHeader);
//				} catch (JAXBException e) {
//					e.printStackTrace();
//				}
//				((BindingProvider) service).getRequestContext().put(Header.HEADER_LIST, headers);
//			} catch (ServiceException e1) {
//				e1.printStackTrace();
//			}
//		}
//	}

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
		bimServerClient.disconnect();
	}

	public boolean isConnected() {
		return bimServerClient.isConnected();
	}
}