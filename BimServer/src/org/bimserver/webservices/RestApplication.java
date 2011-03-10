package org.bimserver.webservices;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.bimserver.database.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;

public class RestApplication extends Application {
	private static ServiceFactory serviceFactory;

	public static void setServiceFactory(ServiceFactory serviceFactory) {
		RestApplication.serviceFactory = serviceFactory;
	}
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		if (serviceFactory != null) {
			classes.add(ServiceInterface.class);
		}
		return classes;
	}
	
	@Override
	public Set<Object> getSingletons() {
		Set<Object> objects = new HashSet<Object>();
		if (serviceFactory != null) {
			objects.add(serviceFactory.newService(AccessMethod.REST));
		}
		return objects;
	}
}