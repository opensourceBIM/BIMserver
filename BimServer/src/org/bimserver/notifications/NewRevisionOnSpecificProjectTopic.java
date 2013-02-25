package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewRevisionOnSpecificProjectTopic extends Topic {

	private long poid;

	public NewRevisionOnSpecificProjectTopic(long poid) {
		this.poid = poid;
	}
	
	public void register(EndPoint endPoint) throws TopicRegisterException {
		// TODO check rights here too
		super.register(endPoint);
	}

	public void process(SNewRevisionAdded newRevisionNotification) {
		if (newRevisionNotification.getProjectId() == poid) {
			for (EndPoint endPoint : getEndPoints()) {
				try {
					endPoint.getNotificationInterface().newRevision(newRevisionNotification.getRevisionId());
				} catch (UserException e) {
					e.printStackTrace();
				} catch (ServerException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
