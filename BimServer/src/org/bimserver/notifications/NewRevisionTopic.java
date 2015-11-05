package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
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
	public NewRevisionTopic(NotificationsManager notificationsManager) {
		super(notificationsManager);
	}

	public void process(final DatabaseSession session, final long poid, final long roid, NewRevisionNotification newRevisionNotification) throws BimserverDatabaseException, UserException, ServerException {
		map(new Mapper(){
			@Override
			public void map(final EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException {
				User user = session.get(StorePackage.eINSTANCE.getUser(), endPoint.getUoid(), Query.getDefault());
				Project project = session.get(StorePackage.eINSTANCE.getUser(), poid, Query.getDefault());
				if (user.getUserType() == UserType.ADMIN || user.getHasRightsOn().contains(project)) {
					endPoint.getNotificationInterface().newRevision(poid, roid);
				}
			}
		});
	}

	@Override
	public void remove() {
		// Do nothing, there is only one topic of this type
	}
}
