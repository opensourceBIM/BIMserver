package org.bimserver.plugins.services;

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
	
	public ServiceInterface getServiceInterface(SToken token) throws UserException {
		return pluginManager.getServiceFactory().getService(ServiceInterface.class, token);
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
	}
	
	public void register(ServiceDescriptor serviceDescriptor, NotificationInterface notificationInterface) {
		pluginManager.register(serviceDescriptor, notificationInterface);
	}
}