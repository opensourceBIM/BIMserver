package org.bimserver.notifications;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.models.log.LogAction;

public class NotificationsManager {
	private final Set<NotificationListener> listeners = new HashSet<NotificationListener>();

	public NotificationsManager(BimServer bimServer) {
		register(new ProtocolBuffersNotificationDispatcher());
		register(new HttpCallbackNotificationDispatcher(bimServer));
	}
	
	public void register(NotificationListener notificationListener) {
		listeners.add(notificationListener);
	}
	
	public void notify(LogAction logAction) {
		for (NotificationListener listener : listeners) {
			listener.notify(logAction);
		}
	}
}
