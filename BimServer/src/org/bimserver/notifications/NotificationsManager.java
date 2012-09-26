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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SNotification;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.ServerDescriptor;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.models.store.User;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.pb.ProtocolBuffersReflector;
import org.bimserver.shared.pb.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager extends Thread implements NotificationsManagerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Set<NotificationContainer> listeners = new HashSet<NotificationContainer>();
	private final Map<String, Map<String, ServiceDescriptor>> internalServices = new HashMap<String, Map<String, ServiceDescriptor>>();
	private final Map<String, ServerDescriptor> internalServers = new HashMap<String, ServerDescriptor>();
	private final Map<String, NotificationInterface> x = new HashMap<String, NotificationInterface>();
	private final BlockingQueue<SNotification> queue = new ArrayBlockingQueue<SNotification>(1000);
	private final BimServer bimServer;
	private volatile boolean running;

	public NotificationsManager(BimServer bimServer) {
		setName("NotificationsManager");
		this.bimServer = bimServer;
	}

	public void register(User user, NotificationInterface notificationInterface) {
		listeners.add(new NotificationContainer(user, notificationInterface));
	}

	public void notify(SNotification notification) {
		queue.add(notification);
	}

	@Override
	public void run() {
		initConnections();
		running = true;
		try {
			while (running) {
				try {
					SNotification notification = queue.take();
					DatabaseSession session = bimServer.getDatabase().createSession();
					try {
						if (notification instanceof SNewProjectNotification) {
							SNewProjectNotification newProjectNotification = (SNewProjectNotification) notification;
						} else if (notification instanceof SNewRevisionNotification) {
							SNewRevisionNotification newRevisionNotification = (SNewRevisionNotification) notification;
							Project project = session.get(StorePackage.eINSTANCE.getProject(), newRevisionNotification.getProjectId(), false, null);
							for (Service service : project.getServices()) {
								if (service.getTrigger() == Trigger.NEW_REVISION) {
									Channel channel = getChannel(service);
									try {
										if (service.isReadRevision() || service.isReadExtendedData() || service.isWriteExtendedData() || service.getWriteRevision() != null) {
											// This service will be needing a token
											ServiceInterface newService = bimServer.getServiceFactory().newService(service.getNotificationProtocol(), "");
											((org.bimserver.webservices.Service)newService).setAuthorization(new TokenAuthorization(service.getUser().getOid(), service.isReadRevision() ? newRevisionNotification.getRevisionId() : -1, service.getWriteRevision().getOid(), service.isReadExtendedData() ? newRevisionNotification.getRevisionId() : -1, service.isWriteExtendedData() ? newRevisionNotification.getRevisionId() : -1));
											channel.getNotificationInterface().newRevision(newRevisionNotification, newService.getCurrentToken(), bimServer.getServerSettings(session).getSiteAddress() + "/jsonapi");
										} else {
											channel.getNotificationInterface().newRevision(newRevisionNotification, null, null);
										}
									} finally {
										channel.disconnect();
									}
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
		case JSON:
			JsonChannel jsonChannel = new JsonChannel(bimServer.getServiceInterfaces());
			jsonChannel.connect(service.getUrl(), true, null);
			return jsonChannel;
		case INTERNAL:
			return new InternalChannel(x.get(service.getName()));
		default: 
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

	public void register(ServerDescriptor serverDescriptor) {
		internalServers.put(serverDescriptor.getTitle(), serverDescriptor);
		internalServices.put(serverDescriptor.getTitle(), new HashMap<String, ServiceDescriptor>());
	}
	
	@Override
	public void register(ServerDescriptor serverDescriptor, ServiceDescriptor serviceDescriptor, NotificationInterface notificationInterface) {
		if (!internalServices.containsKey(serverDescriptor.getTitle())) {
			register(serverDescriptor);
		}
		internalServices.get(serverDescriptor.getTitle()).put(serviceDescriptor.getName(), serviceDescriptor);
		x.put(serviceDescriptor.getName(), notificationInterface);
	}
	
	public Map<String, ServiceDescriptor> getInternalServices(String serverName) {
		return internalServices.get(serverName);
	}

	public Collection<ServerDescriptor> getInternalServers() {
		return internalServers.values();
	}
}