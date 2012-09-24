package org.bimserver.notifications;

import org.bimserver.client.channels.Channel;
import org.bimserver.shared.NotificationInterface;

public class InternalChannel extends Channel {

	public InternalChannel(NotificationInterface notificationInterface) {
		addServiceInterface(NotificationInterface.class.getSimpleName(), notificationInterface);
	}

	@Override
	public void disconnect() {
	}
}