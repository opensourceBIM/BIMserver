package org.bimserver.shared;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.shared.exceptions.ServiceException;

public interface NotificationInterface {
	void newProject(SNewProjectNotification newProjectNotification) throws ServiceException;
	void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException;
}