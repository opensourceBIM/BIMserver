package org.bimserver.notifications;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
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
		// TODO this should also trigger the generic new revisions topic
		if (newRevisionNotification.getProjectId() == poid) {
			for (EndPoint endPoint : getEndPoints()) {
				try {
					endPoint.getNotificationInterface().newRevision(newRevisionNotification.getProjectId(), newRevisionNotification.getRevisionId());
				} catch (UserException e) {
					e.printStackTrace();
				} catch (ServerException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void process(DatabaseSession session, long poid, long roid, NewRevisionNotification newRevisionNotification) throws BimserverDatabaseException, UserException, ServerException {
		for (EndPoint endPoint : getEndPoints()) {
			User user = session.get(StorePackage.eINSTANCE.getUser(), endPoint.getUoid(), Query.getDefault());
			Project notificationProject = session.get(StorePackage.eINSTANCE.getUser(), poid, Query.getDefault());
			Project registrationProject = session.get(StorePackage.eINSTANCE.getUser(), this.poid, Query.getDefault());
			if (notificationProject.getOid() == registrationProject.getOid()) {
				if (user.getUserType() == UserType.ADMIN || user.getHasRightsOn().contains(notificationProject)) {
					endPoint.getNotificationInterface().newRevision(poid, roid);
				}
			}
		}
	}
}
