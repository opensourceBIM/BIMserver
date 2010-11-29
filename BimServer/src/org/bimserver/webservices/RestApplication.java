package org.bimserver.webservices;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;

public class RestApplication extends Application {
	public static ServiceFactory serviceFactory;
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ServiceInterface.class);
		return classes;
	}
	
	@Override
	public Set<Object> getSingletons() {
		Set<Object> objects = new HashSet<Object>();
		objects.add(serviceFactory.newService(AccessMethod.REST));
		return objects;
	}
}