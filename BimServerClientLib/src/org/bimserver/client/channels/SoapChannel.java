package org.bimserver.client.channels;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoapChannel extends Channel {
	private static final Logger LOGGER = LoggerFactory.getLogger(SoapChannel.class);
	private Client client;

	public SoapChannel() {
	}

	public void connect(String address, boolean useSoapHeaderSessions) {
		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
		cpfb.setServiceClass(ServiceInterface.class);
		cpfb.setAddress(address);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		cpfb.setProperties(properties);

		ServiceInterface serviceInterface = (ServiceInterface) cpfb.create();

		client = ClientProxy.getClient(serviceInterface);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		http.getClient().setConnectionTimeout(360000);
		http.getClient().setAllowChunking(false);
		http.getClient().setReceiveTimeout(320000);

		if (!useSoapHeaderSessions) {
			((BindingProvider) serviceInterface).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		}

		if (useSoapHeaderSessions) {
			try {
				SToken token = serviceInterface.getCurrentToken();
				List<Header> headers = new ArrayList<Header>();
				try {
					Header sessionHeader = new Header(new QName("uri:org.bimserver.interfaces.objects", "token"), token, new JAXBDataBinding(SToken.class));
					headers.add(sessionHeader);
				} catch (JAXBException e) {
					LOGGER.error("", e);
				}
				((BindingProvider) serviceInterface).getRequestContext().put(Header.HEADER_LIST, headers);
			} catch (ServiceException e) {
				LOGGER.error("", e);
			}
		}
		addServiceInterface(ServiceInterface.class, serviceInterface);
		notifyOfConnect();
	}

	@Override
	public void disconnect() {
		client.destroy();
		notifyOfDisconnect();
	}
}