package org.bimserver.plugins.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;

public abstract class ServicePlugin implements Plugin {

	public abstract String getTitle();
	private PluginManager pluginManager;
	private final Map<String, ServiceDescriptor> serviceDescriptors = new HashMap<String, ServiceDescriptor>();
	
	public ServiceInterface getServiceInterface(SToken token) throws UserException {
		return pluginManager.getServiceFactory().getService(ServiceInterface.class, token);
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
	}
	
	public void register(ServiceDescriptor serviceDescriptor, NotificationInterface notificationInterface) {
		serviceDescriptor.setUrl(getUrl());
		pluginManager.register(serviceDescriptor, notificationInterface);
		serviceDescriptors.put(serviceDescriptor.getUrl(), serviceDescriptor);
	}
	
	public String getUrl() {
		return getClass().getName();
	}

	public Collection<ServiceDescriptor> getServices() {
		return serviceDescriptors.values();
	}
}