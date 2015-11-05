package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnProjectTopic extends Topic {

	private ChangeProgressTopicOnProjectTopicKey key;

	public ChangeProgressTopicOnProjectTopic(NotificationsManager notificationsManager, ChangeProgressTopicOnProjectTopicKey key) {
		super(notificationsManager);
		this.key = key;
	}

	public void notifyOfNewTopic(final NewProgressTopicOnProjectNotification notification) throws UserException, ServerException, BimserverDatabaseException {
		map(new Mapper() {
			@Override
			public void map(final EndPoint endPoint) throws UserException, ServerException {
				endPoint.getNotificationInterface().newProgressOnProjectTopic(notification.getPoid(), notification.getTopicId());
			}
		});
	}

	@Override
	public void remove() {
		getNotificationsManager().removeChangeProgressTopicOnProject(key);
	}
	
	public ChangeProgressTopicOnProjectTopicKey getKey() {
		return key;
	}
}