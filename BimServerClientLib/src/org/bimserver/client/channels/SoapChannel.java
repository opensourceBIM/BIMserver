package org.bimserver.client.channels;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.bimserver.shared.ServiceInterface;

public class SoapChannel extends Channel {
	private Client client;

	public SoapChannel() {
	}

	public void connect(String address) {
		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
		cpfb.setServiceClass(ServiceInterface.class);
		cpfb.setAddress(address);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		cpfb.setProperties(properties);
		
		ServiceInterface serviceInterface = (ServiceInterface) cpfb.create();
		
		client = ClientProxy.getClient(serviceInterface);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		((BindingProvider) serviceInterface).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		http.getClient().setConnectionTimeout(360000);
		http.getClient().setAllowChunking(false);
		http.getClient().setReceiveTimeout(320000);
		
		setServiceInterface(serviceInterface);
		notifyOfConnect();
	}

	@Override
	public void disconnect() {
		client.destroy();
		notifyOfDisconnect();
	}
}