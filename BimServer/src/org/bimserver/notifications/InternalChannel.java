package org.bimserver.notifications;

import org.bimserver.client.channels.Channel;
import org.bimserver.shared.interfaces.NotificationInterface;

public class InternalChannel extends Channel {

	public InternalChannel(NotificationInterface notificationInterface) {
		addServiceInterface(NotificationInterface.class, notificationInterface);
	}
	
	@Override
	public void disconnect() {
	}
}