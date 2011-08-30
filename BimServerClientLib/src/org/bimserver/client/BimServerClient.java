package org.bimserver.client;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.bimserver.shared.ServiceInterface;

public class BimServerClient {
	private ServiceInterface serviceInterface;

	public BimServerClient(String address) {
		serviceInterface = createClient(address);
	}

	public BimServerClient(ServiceInterface serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	private ServiceInterface createClient(final String address) {
		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
		cpfb.setServiceClass(ServiceInterface.class);
		cpfb.setAddress(address);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		cpfb.setProperties(properties);

		ServiceInterface service = (ServiceInterface) cpfb.create();

		Client client = ClientProxy.getClient(service);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		((BindingProvider) service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		http.getClient().setConnectionTimeout(360000);
		http.getClient().setAllowChunking(false);
		http.getClient().setReceiveTimeout(320000);
		
		return service;
	}

	
	public Session createSession() {
		Session session = new Session(serviceInterface);
		return session;
	}
}