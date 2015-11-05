package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewExtendedDataOnRevisionTopic extends Topic {

	private NewExtendedDataOnRevisionTopicKey key;

	public NewExtendedDataOnRevisionTopic(NotificationsManager notificationsManager, NewExtendedDataOnRevisionTopicKey key) {
		super(notificationsManager);
		this.key = key;
	}
	
	public void process(final NewExtendedDataOnRevisionNotification newExtendedDataOnRevisionNotification) throws BimserverDatabaseException, UserException, ServerException {
		map(new Mapper(){
			@Override
			public void map(EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException {
				endPoint.getNotificationInterface().newExtendedData(key.getRoid(), newExtendedDataOnRevisionNotification.getEdid());
			}});
	}

	@Override
	public void remove() {
		getNotificationsManager().removeNewExtendedDataOnRevisionTopic(key);
	}
}
