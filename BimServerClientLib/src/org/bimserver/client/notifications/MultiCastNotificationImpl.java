package org.bimserver.client.notifications;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashSet;
import java.util.Set;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class MultiCastNotificationImpl implements NotificationInterface {
	private final Set<NotificationInterface> notificationInterfaces = new HashSet<NotificationInterface>();

	public MultiCastNotificationImpl(NotificationInterface... notificationInterfaces) {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			this.notificationInterfaces.add(notificationInterface);
		}
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

	public void add(NotificationInterface notificationInterface) {
		notificationInterfaces.add(notificationInterface);
	}
}