package org.bimserver.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;

public class RestApplication extends Application {
	private final BimServer bimServer;

	public RestApplication(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ServiceInterface.class);
		return classes;
	}
	
	@Override
	public Set<Object> getSingletons() {
		Set<Object> objects = new HashSet<Object>();
		objects.add(bimServer.getServiceFactory().newService(AccessMethod.REST));
		return objects;
	}
}