package org.bimwebserver;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class NotificationInterfaceImpl implements NotificationInterface {

	@Override
	public void serverHasStarted() throws ServiceException {
	}

	@Override
	public void serverWillBeShutdown() throws ServiceException {
	}

	@Override
	public void newProject(SNewProjectNotification newProjectNotification) throws ServiceException {
	}

	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification, SToken token, String apiUrl) throws ServiceException {
	}
}