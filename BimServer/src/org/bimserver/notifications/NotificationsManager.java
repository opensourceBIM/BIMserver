package org.bimserver.notifications;

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
		while (true) {
			try {
				SConverter sConverter = new SConverter();
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