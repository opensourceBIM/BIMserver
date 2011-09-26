package org.bimserver.client;

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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.bimserver.pb.ServiceInterfaceReflectorImpl;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.Reflector;
import org.bimserver.shared.pb.SocketChannel;

public class BimServerClient {
	private ServiceInterface serviceInterface;

	public BimServerClient() {
	}

	public void connectDirect(ServiceInterface serviceInterface) {
		this.serviceInterface = serviceInterface;
	}
	
	public void connectProtocolBuffers(String address, int port) {
		SocketChannel channel = new SocketChannel(new InetSocketAddress(address, port));
		ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("service.desc"));
			Reflector reflector = new Reflector(protocolBuffersMetaData, new SService(ServiceInterface.class), channel);
			serviceInterface = new ServiceInterfaceReflectorImpl(reflector);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void connectSoap(final String address) {
		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
		cpfb.setServiceClass(ServiceInterface.class);
		cpfb.setAddress(address);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		cpfb.setProperties(properties);

		serviceInterface = (ServiceInterface) cpfb.create();

		Client client = ClientProxy.getClient(serviceInterface);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		((BindingProvider) serviceInterface).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		http.getClient().setConnectionTimeout(360000);
		http.getClient().setAllowChunking(false);
		http.getClient().setReceiveTimeout(320000);
	}

	public void login(String username, String password) throws ServiceException {
		serviceInterface.login(username, password);
	}
	
	public ServiceInterface getServiceInterface() {
		return serviceInterface;
	}
	
	public Session createSession() {
		if (serviceInterface == null) {
			throw new RuntimeException("Connect first");
		}
		Session session = new Session(serviceInterface);
		return session;
	}
}