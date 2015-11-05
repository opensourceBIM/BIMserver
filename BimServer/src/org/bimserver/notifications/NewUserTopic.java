package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewUserTopic extends Topic {
	public NewUserTopic(NotificationsManager notificationsManager) {
		super(notificationsManager);
	}

	public void process(final DatabaseSession session, final long uoid, NewUserNotification newUserNotification) throws BimserverDatabaseException, UserException, ServerException {
		map(new Mapper(){
			@Override
			public void map(EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException {
				User actingUser = session.get(StorePackage.eINSTANCE.getUser(), endPoint.getUoid(), Query.getDefault());
				if (actingUser.getUserType() == UserType.ADMIN) {
					endPoint.getNotificationInterface().newUser(uoid);
				}
			}});
	}

	@Override
	public void remove() {
		// Do nothing, there is only one topic of this type
	}
}
