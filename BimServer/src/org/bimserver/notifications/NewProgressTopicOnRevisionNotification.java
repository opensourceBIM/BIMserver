package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewProgressTopicOnRevisionNotification extends Notification {

	private long poid;
	private long roid;
	private long topicId;

	public NewProgressTopicOnRevisionNotification(long poid, long roid, long topicId) {
		this.poid = poid;
		this.roid = roid;
		this.topicId = topicId;
	}

	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnRevisionTopic = notificationsManager.getChangeProgressOnRevisionTopic(poid, roid);
		changeProgressOnRevisionTopic.notifyOfNewTopic(topicId);
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = notificationsManager.getChangeProgressOnProjectTopic(poid);
		changeProgressOnProjectTopic.notifyOfNewTopic(topicId);

		// TODO also notify bimserver-wide listeners
	}
}