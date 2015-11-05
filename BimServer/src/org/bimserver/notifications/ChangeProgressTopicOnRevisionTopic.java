package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnRevisionTopic extends Topic {

	private ChangeProgressTopicOnRevisionTopicKey key;

	public ChangeProgressTopicOnRevisionTopic(NotificationsManager notificationsManager, ChangeProgressTopicOnRevisionTopicKey key) {
		super(notificationsManager);
		this.key = key;
	}

	public void notifyOfNewTopic(final NewProgressTopicOnRevisionNotification notification) throws UserException, ServerException, BimserverDatabaseException {
		map(new Mapper(){
			@Override
			public void map(final EndPoint endPoint) throws UserException, ServerException {
				endPoint.getNotificationInterface().newProgressOnRevisionTopic(notification.getPoid(), notification.getRoid(), notification.getTopicId());
			}
		});
	}

	@Override
	public void remove() {
		getNotificationsManager().removeChangeProgressTopicOnRevision(key);
	}
}
