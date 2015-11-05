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

public class NewRevisionOnSpecificProjectTopic extends Topic {

	private NewRevisionOnSpecificProjectTopicKey key;

	public NewRevisionOnSpecificProjectTopic(NotificationsManager notificationsManager, NewRevisionOnSpecificProjectTopicKey key) {
		super(notificationsManager);
		this.key = key;
	}

	public void process(final DatabaseSession session, final long poid, final long roid, NewRevisionNotification newRevisionNotification) throws BimserverDatabaseException, UserException, ServerException {
		map(new Mapper(){
			@Override
			public void map(EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException {
				User user = session.get(StorePackage.eINSTANCE.getUser(), endPoint.getUoid(), Query.getDefault());
				Project notificationProject = session.get(StorePackage.eINSTANCE.getUser(), poid, Query.getDefault());
				Project registrationProject = session.get(StorePackage.eINSTANCE.getUser(), key.getPoid(), Query.getDefault());
				if (notificationProject.getOid() == registrationProject.getOid()) {
					if (user.getUserType() == UserType.ADMIN || user.getHasRightsOn().contains(notificationProject)) {
						endPoint.getNotificationInterface().newRevision(poid, roid);
					}
				}
			}});
	}

	@Override
	public void remove() {
		getNotificationsManager().removeNewRevisionOnSpecificProjectTopic(key);
	}
}
