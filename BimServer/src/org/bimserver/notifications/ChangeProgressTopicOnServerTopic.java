package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnServerTopic extends Topic {

	public void notifyOfNewTopic(NewProgressTopicOnServerNotification notification) throws UserException, ServerException {
		for (EndPoint endpoint : getEndPoints()) {
			endpoint.getNotificationInterface().newProgressOnServerTopic(notification.getTopicId());
		}
	}
}