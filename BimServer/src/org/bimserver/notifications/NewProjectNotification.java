package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewProjectNotification extends Notification {

	private long poid;

	public NewProjectNotification(long poid) {
		this.poid = poid;
	}
	
	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		NewProjectTopic newProjectTopic = notificationsManager.getNewProjectTopic();
		if (newProjectTopic != null) {
			newProjectTopic.process(session, poid, this);
		}
	}
}
