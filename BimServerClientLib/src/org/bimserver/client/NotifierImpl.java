package org.bimserver.client;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class NotifierImpl implements NotificationInterface{

	@Override
	public void newProject(SNewProjectNotification newProjectNotification) throws ServiceException {
		System.out.println("New project " + newProjectNotification.getProjectId());
	}

	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException {
		System.out.println("New revision " + newRevisionNotification.getRevisionId());
	}
}