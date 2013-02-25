package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewUserNotification extends Notification {

	private long uoid;

	public NewUserNotification(long uoid) {
		this.uoid = uoid;
	}

	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		NewUserTopic newUserTopic = notificationsManager.getNewUserTopic();
		if (newUserTopic != null) {
			newUserTopic.process(session, uoid, this);
		}
	}
}
