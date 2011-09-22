package org.bimserver.notifications;

import java.net.Socket;

import org.bimserver.models.store.User;
import org.bimserver.shared.NotificationInterface;

public class NotificationSocketHandler extends NotificationContainer implements Runnable {

	public NotificationSocketHandler(User user, NotificationInterface notificationInterface, Socket socket) {
		super(user, notificationInterface);
	}

	@Override
	public void run() {
	}
}