package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnRevisionTopic extends Topic {

	private ChangeProgressTopicOnRevisionTopicKey key;

	public ChangeProgressTopicOnRevisionTopic(ChangeProgressTopicOnRevisionTopicKey key) {
		this.key = key;
	}
	
	public void notifyOfNewTopic(long topicId) throws UserException, ServerException {
		for (EndPoint endpoint : getEndPoints()) {
			endpoint.getNotificationInterface().newProgressOnRevisionTopic(key.getPoid(), key.getRoid(), topicId);
		}
	}
}
