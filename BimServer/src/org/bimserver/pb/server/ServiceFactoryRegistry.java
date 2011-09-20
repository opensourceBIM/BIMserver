package org.bimserver.pb.server;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.shared.ServiceFactory;

public class ServiceFactoryRegistry {
	private final Map<String, ServiceFactory> factories = new HashMap<String, ServiceFactory>();
	
	public void registerServiceFactory(ServiceFactory serviceFactory) {
		factories.put(serviceFactory.getName(), serviceFactory);
	}
	
	public ServiceFactory createServiceFactory(String name) {
		return factories.get(name);
	}
}