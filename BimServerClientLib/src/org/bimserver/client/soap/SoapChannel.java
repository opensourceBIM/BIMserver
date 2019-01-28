package org.bimserver.client.soap;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.http.impl.client.CloseableHttpClient;
import org.bimserver.client.Channel;
import org.bimserver.shared.Token;
import org.bimserver.shared.TokenChangeListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.json.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoapChannel extends Channel implements TokenChangeListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(SoapChannel.class);
	private Client client;
	private boolean useSoapHeaderSessions;
	private String address;
	private Set<Class<? extends PublicInterface>> interfaces;

	public SoapChannel(CloseableHttpClient httpClient, String address, boolean useSoapHeaderSessions, Set<Class<? extends PublicInterface>> interfaces) {
		super(httpClient);
		this.address = address;
		this.useSoapHeaderSessions = useSoapHeaderSessions;
		this.interfaces = interfaces;
	}

	public void connect(TokenHolder tokenHolder) {
		for (Class<? extends PublicInterface> interface1 : interfaces) {
			JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
			cpfb.setServiceClass(interface1);
			cpfb.setAddress(address + "/" + interface1.getSimpleName());
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("mtom-enabled", Boolean.TRUE);
			cpfb.setProperties(properties);
			
			PublicInterface serviceInterface = (PublicInterface) cpfb.create();
			
			client = ClientProxy.getClient(serviceInterface);
			HTTPConduit http = (HTTPConduit) client.getConduit();
			http.getClient().setConnectionTimeout(360000);
			http.getClient().setAllowChunking(false);
			http.getClient().setReceiveTimeout(320000);
			
			if (!useSoapHeaderSessions) {
				((BindingProvider) serviceInterface).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
			}
			add(interface1.getName(), serviceInterface);
		}
		tokenHolder.registerTokenChangeListener(this);
		notifyOfConnect();
	}

	@Override
	public void newToken(String token) {
		if (useSoapHeaderSessions) {
			for (PublicInterface p : getServiceInterfaces().values()) {
				List<Header> headers = new ArrayList<Header>();
				try {
					Token tokenObject = new Token(token);
					Header sessionHeader = new Header(new QName("uri:org.bimserver.shared", "token"), tokenObject, new JAXBDataBinding(Token.class));
					headers.add(sessionHeader);
				} catch (JAXBException e) {
					LOGGER.error("", e);
				}
				((BindingProvider) p).getRequestContext().put(Header.HEADER_LIST, headers);
			}
		}
	}
	
	@Override
	public void disconnect() {
		client.destroy();
		notifyOfDisconnect();
	}
}