package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewProgressTopicOnProjectNotification extends Notification {

	private long topicId;
	private long poid;

	public NewProgressTopicOnProjectNotification(long poid, long topicId) {
		this.poid = poid;
		this.topicId = topicId;
	}

	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = notificationsManager.getChangeProgressOnProjectTopic(poid);
		changeProgressOnProjectTopic.notifyOfNewTopic(topicId);
	}
}