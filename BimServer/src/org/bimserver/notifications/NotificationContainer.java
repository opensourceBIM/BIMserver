package org.bimserver.notifications;

import org.bimserver.models.store.User;
import org.bimserver.shared.NotificationInterface;

public class NotificationContainer {

	private final User user;
	private final NotificationInterface notificationInterface;

	public NotificationContainer(User user, NotificationInterface notificationInterface) {
		this.user = user;
		this.notificationInterface = notificationInterface;
	}
	
	public User getUser() {
		return user;
	}
	
	public NotificationInterface getNotificationInterface() {
		return notificationInterface;
	}
}
