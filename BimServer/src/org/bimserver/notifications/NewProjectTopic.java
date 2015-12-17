package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewProjectTopic extends Topic {

	public NewProjectTopic(NotificationsManager notificationsManager) {
		super(notificationsManager);
	}

	public void process(final DatabaseSession session, final long poid, NewProjectNotification newProjectNotification) throws BimserverDatabaseException, UserException, ServerException {
		map(new Mapper(){
			@Override
			public void map(final EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException {
				User user = session.get(StorePackage.eINSTANCE.getUser(), endPoint.getUoid(), OldQuery.getDefault());
				Project project = session.get(StorePackage.eINSTANCE.getUser(), poid, OldQuery.getDefault());
				if (user.getUserType() == UserType.ADMIN || user.getHasRightsOn().contains(project)) {
					endPoint.getNotificationInterface().newProject(poid);
				}
			}
		});
	}

	@Override
	public void remove() {
		// Do nothing, there is only one topic of this type
	}
}