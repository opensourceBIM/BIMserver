package org.bimserver.notifications;

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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.bimserver.BimServer;
import org.bimserver.client.JsonChannel;
import org.bimserver.client.channels.Channel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.NotificationInterfaceReflectorImpl;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.NewProjectNotification;
import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Notification;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.models.store.User;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.pb.ProtocolBuffersReflector;
import org.bimserver.shared.pb.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Set<NotificationContainer> listeners = new HashSet<NotificationContainer>();
	private final BlockingQueue<Notification> queue = new ArrayBlockingQueue<Notification>(1000);
	private final BimServer bimServer;
	private volatile boolean running;

	public NotificationsManager(BimServer bimServer) {
		setName("NotificationsManager");
		this.bimServer = bimServer;
	}

	public void register(User user, NotificationInterface notificationInterface) {
		listeners.add(new NotificationContainer(user, notificationInterface));
	}

	public void notify(Notification notification) {
		queue.add(notification);
	}

	@Override
	public void run() {
		initConnections();
		SConverter sConverter = new SConverter();
		running = true;
		try {
			while (running) {
				try {
					Notification notification = queue.take();
					DatabaseSession session = bimServer.getDatabase().createSession();
					try {
						IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getService(), false, null);
						for (Service service : allOfType.getAll(Service.class)) {
							service.getProject();
						}
						if (notification instanceof NewProjectNotification) {
							NewProjectNotification newProjectNotification = (NewProjectNotification) notification;
						} else if (notification instanceof NewRevisionNotification) {
							NewRevisionNotification newRevisionNotification = (NewRevisionNotification) notification;
							Project project = newRevisionNotification.getRevision().getProject();
							for (Service service : project.getServices()) {
								if (service.getTrigger() == Trigger.NEW_REVISION) {
									Channel channel = getChannel(service);
									channel.getNotificationInterface().newRevision(sConverter.convertToSObject(newRevisionNotification));
								}
							}
						}
					} finally {
						session.close();
					}
				} catch (InterruptedException e) {
					throw e;
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		} catch (InterruptedException e) {
			if (running) {
				LOGGER.error("", e);
			}
		}
	}

	private Channel getChannel(Service service) {
		switch (service.getNotificationProtocol()) {
		case JSON: {
			JsonChannel jsonChannel = new JsonChannel(bimServer.getServiceInterfaces());
			jsonChannel.connect(service.getUrl(), true, null);
			return jsonChannel;
		} default: 
			LOGGER.error("Unimplemented AccessMethod: " + service.getNotificationProtocol());
			return null;
		}
	}

	private void initConnections() {
		DatabaseSession databaseSession = bimServer.getDatabase().createSession();
		try {
			IfcModelInterface allOfType = databaseSession.getAllOfType(StorePackage.eINSTANCE.getUser(), false, null);
			for (IdEObject idEObject : allOfType.getValues()) {
				if (idEObject instanceof User) {
					User user = (User) idEObject;
					String url = ""; // TODO
					if (url != null && !url.isEmpty()) {
						InetSocketAddress address = new InetSocketAddress(url.substring(0, url.indexOf(":")), Integer.parseInt(url.substring(url.indexOf(":") + 1)));
						try {
							SocketChannel channel = new SocketChannel();
							channel.connect(address);
							register(user,
									new NotificationInterfaceReflectorImpl(new ProtocolBuffersReflector(bimServer.getProtocolBuffersMetaData(), bimServer.getServiceInterfaces(),
											channel)));
						} catch (IOException e) {
							LOGGER.info("Notification host seems down: " + url);
						}
					}
				}
			}
			databaseSession.commit();
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			databaseSession.close();
		}
	}

	public void shutdown() {
		running = false;
		this.interrupt();
	}
}