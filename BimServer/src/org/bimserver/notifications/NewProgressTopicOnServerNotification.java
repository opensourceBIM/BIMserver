package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewProgressTopicOnServerNotification extends Notification {

	private long topicId;

	public NewProgressTopicOnServerNotification(long topicId) {
		this.topicId = topicId;
	}

	public long getTopicId() {
		return topicId;
	}
	
	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		ChangeProgressTopicOnServerTopic changeProgressTopicOnServerTopic = notificationsManager.getChangeProgressTopicOnServerTopic();
		changeProgressTopicOnServerTopic.notifyOfNewTopic(this);
	}
}