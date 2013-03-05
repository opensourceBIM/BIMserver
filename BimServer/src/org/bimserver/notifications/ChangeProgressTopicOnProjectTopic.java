package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnProjectTopic extends Topic {

	private ChangeProgressTopicOnProjectTopicKey key;

	public ChangeProgressTopicOnProjectTopic(ChangeProgressTopicOnProjectTopicKey key) {
		this.key = key;
	}
	
	public void notifyOfNewTopic(long topicId) throws UserException, ServerException {
		for (EndPoint endpoint : getEndPoints()) {
			endpoint.getNotificationInterface().newProgressOnProjectTopic(key.getPoid(), topicId);
		}
	}
}
