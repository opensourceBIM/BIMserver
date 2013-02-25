package org.bimserver.notifications;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewUserTopic extends Topic {

	@Override
	public void register(EndPoint endPoint) throws TopicRegisterException {
		// TODO check rights here too
		super.register(endPoint);
	}
	
	public void process(DatabaseSession session, long uoid, NewUserNotification newUserNotification) throws BimserverDatabaseException, UserException, ServerException {
		for (EndPoint endPoint : getEndPoints()) {
			User actingUser = session.get(StorePackage.eINSTANCE.getUser(), endPoint.getUoid(), Query.getDefault());
			if (actingUser.getUserType() == UserType.ADMIN) {
				endPoint.getNotificationInterface().newUser(uoid);
			}
		}
	}
}
