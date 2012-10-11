package org.bimserver.notifications;

import org.bimserver.client.channels.Channel;
import org.bimserver.models.store.Service;
import org.bimserver.shared.interfaces.NotificationInterface;

public class InternalChannel extends Channel {

	private Service service;

	public InternalChannel(NotificationInterface notificationInterface, Service service) {
		this.service = service;
		addServiceInterface(NotificationInterface.class, notificationInterface);
	}
	
	public Service getService() {
		return service;
	}

	@Override
	public void disconnect() {
	}
}