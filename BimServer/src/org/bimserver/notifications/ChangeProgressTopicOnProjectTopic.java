package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnProjectTopic extends Topic {

	public void notifyOfNewTopic(NewProgressTopicOnProjectNotification notification) throws UserException, ServerException {
		for (EndPoint endpoint : getEndPoints()) {
			endpoint.getNotificationInterface().newProgressOnProjectTopic(notification.getPoid(), notification.getTopicId());
		}
	}
}