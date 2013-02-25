package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;

public class NewRevisionTopic extends Topic {
	@Override
	public void register(EndPoint endPoint) throws TopicRegisterException {
		// TODO check rights here too
		super.register(endPoint);
	}
}
