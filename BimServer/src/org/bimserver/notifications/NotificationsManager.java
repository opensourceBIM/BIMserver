package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.bimserver.BimServer;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.store.NewProjectNotification;
import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Notification;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;

public class NotificationsManager extends Thread {
	private final Set<NotificationContainer> listeners = new HashSet<NotificationContainer>();
	private final BlockingQueue<Notification> queue = new ArrayBlockingQueue<Notification>(1000);

	public NotificationsManager(BimServer bimServer, ProtocolBuffersMetaData protocolBuffersMetaData) {
	}

	public void register(User user, NotificationInterface notificationInterface) {
		listeners.add(new NotificationContainer(user, notificationInterface));
	}

	public void notify(Notification notification) {
		queue.add(notification);
	}
	
	@Override
	public void run() {
		SConverter sConverter = new SConverter();
		while (true) {
			try {
				Notification notification = queue.take();
				for (NotificationContainer notificationContainer : listeners) {
					NotificationInterface notificationInterface = notificationContainer.getNotificationInterface();
					boolean isAdmin = notificationContainer.getUser().getUserType() == UserType.ADMIN;
					if (notification instanceof NewProjectNotification) {
						if (isAdmin) {
							notificationInterface.newProject(sConverter.convertToSObject((NewProjectNotification)notification));
						}
					} else if (notification instanceof NewRevisionNotification) {
						NewRevisionNotification newRevisionNotification = (NewRevisionNotification)notification;
						if (isAdmin || newRevisionNotification.getRevision().getProject().getHasAuthorizedUsers().contains(notificationContainer.getUser())) {
							notificationInterface.newRevision(sConverter.convertToSObject(newRevisionNotification));
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}
}