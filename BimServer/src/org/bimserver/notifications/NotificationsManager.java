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
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;

public class NotificationsManager extends Thread {
	private final Set<NotificationInterface> listeners = new HashSet<NotificationInterface>();
	private final BlockingQueue<Notification> queue = new ArrayBlockingQueue<Notification>(1000);

	public NotificationsManager(BimServer bimServer, ProtocolBuffersMetaData protocolBuffersMetaData) {
	}

	public void register(NotificationInterface notificationInterface) {
		listeners.add(notificationInterface);
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
				for (NotificationInterface notificationInterface : listeners) {
					if (notification instanceof NewProjectNotification) {
						notificationInterface.newProject(sConverter.convertToSObject((NewProjectNotification)notification));
					} else if (notification instanceof NewRevisionNotification) {
						notificationInterface.newRevision(sConverter.convertToSObject((NewRevisionNotification)notification));
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