package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnServerTopic extends Topic {

	public ChangeProgressTopicOnServerTopic(NotificationsManager notificationsManager) {
		super(notificationsManager);
	}

	public void notifyOfNewTopic(final NewProgressTopicOnServerNotification notification) throws UserException, ServerException, BimserverDatabaseException {
		map(new Mapper(){
			@Override
			public void map(final EndPoint endPoint) throws UserException, ServerException {
				endPoint.getNotificationInterface().newProgressOnServerTopic(notification.getTopicId());
			}
		});
	}

	@Override
	public void remove() {
		// Do nothing, there is only one topic of this type
	}
}