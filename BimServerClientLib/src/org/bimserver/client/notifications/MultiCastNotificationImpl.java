package org.bimserver.client.notifications;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class MultiCastNotificationImpl implements NotificationInterface {
	private final NotificationInterface[] notificationInterfaces;

	public MultiCastNotificationImpl(NotificationInterface... notificationInterfaces) {
		this.notificationInterfaces = notificationInterfaces;
	}

	@Override
	public void serverHasStarted() throws ServiceException {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			notificationInterface.serverHasStarted();
		}
	}

	@Override
	public void serverWillBeShutdown() throws ServiceException {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			notificationInterface.serverWillBeShutdown();
		}
	}

	@Override
	public void newProject(SNewProjectNotification newProjectNotification) throws ServiceException {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			notificationInterface.newProject(newProjectNotification);
		}
	}

	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			notificationInterface.newRevision(newRevisionNotification);
		}
	}
}