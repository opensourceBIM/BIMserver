package org.bimserver.notifications;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewRevisionTopic extends Topic {
	@Override
	public void register(EndPoint endPoint) throws TopicRegisterException {
		// TODO check rights here too
		super.register(endPoint);
	}

	public void process(DatabaseSession session, long poid, long roid, NewRevisionNotification newRevisionNotification) throws BimserverDatabaseException, UserException, ServerException {
		for (EndPoint endPoint : getEndPoints()) {
			User user = session.get(StorePackage.eINSTANCE.getUser(), endPoint.getUoid(), Query.getDefault());
			Project project = session.get(StorePackage.eINSTANCE.getUser(), poid, Query.getDefault());
			if (user.getUserType() == UserType.ADMIN || user.getHasRightsOn().contains(project)) {
				endPoint.getNotificationInterface().newRevision(poid, roid);
			}
		}
	}
}
