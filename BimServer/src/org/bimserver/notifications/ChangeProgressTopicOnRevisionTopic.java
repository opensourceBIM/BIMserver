package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnRevisionTopic extends Topic {

	public void notifyOfNewTopic(NewProgressTopicOnRevisionNotification notification) throws UserException, ServerException {
		for (EndPoint endpoint : getEndPoints()) {
			endpoint.getNotificationInterface().newProgressOnRevisionTopic(notification.getPoid(), notification.getRoid(), notification.getTopicId());
		}
	}
}
