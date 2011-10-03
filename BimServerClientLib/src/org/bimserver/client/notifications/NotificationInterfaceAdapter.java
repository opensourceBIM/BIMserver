package org.bimserver.client.notifications;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class NotificationInterfaceAdapter implements NotificationInterface {

	@Override
	public void newProject(SNewProjectNotification newProjectNotification) throws ServiceException {
	}

	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException {
	}

	@Override
	public void serverHasStarted() {
	}

	@Override
	public void serverWillBeShutdown() {
	}
}