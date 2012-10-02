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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.bimserver.BimServer;
import org.bimserver.client.JsonChannel;
import org.bimserver.client.channels.Channel;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewProjectAdded;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.ServerDescriptor;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.servlets.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager extends Thread implements NotificationsManagerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Map<Long, Set<EndPoint>> endPoints = new HashMap<Long, Set<EndPoint>>();
	private final Map<String, Map<String, ServiceDescriptor>> internalServices = new HashMap<String, Map<String, ServiceDescriptor>>();
	private final Map<String, ServerDescriptor> internalServers = new HashMap<String, ServerDescriptor>();
	private final Map<String, NotificationInterface> x = new HashMap<String, NotificationInterface>();
	private final BlockingQueue<SLogAction> queue = new ArrayBlockingQueue<SLogAction>(1000);
	private final BimServer bimServer;
	private volatile boolean running;

	public NotificationsManager(BimServer bimServer) {
		setName("NotificationsManager");
		this.bimServer = bimServer;
	}

	public void register(long uoid, EndPoint endPoint) {
		synchronized(this.endPoints) {
			Set<EndPoint> endPoints = this.endPoints.get(uoid);
			if (endPoints == null) {
				endPoints = new HashSet<EndPoint>();
				this.endPoints.put(uoid, endPoints);
			}
			endPoints.add(endPoint);
		}
	}
	
	public void unregisterEndpoint(long uoid, EndPoint endPoint) {
		synchronized(this.endPoints) {
			Set<EndPoint> endPoints = this.endPoints.get(uoid);
			if (endPoints != null) {
				endPoints.remove(endPoint);
			}
		}
	}

	public void notify(SLogAction notification) {
		queue.add(notification);
	}

	@Override
	public void run() {
		running = true;
		try {
			while (running) {
				try {
					SLogAction notification = queue.take();
					DatabaseSession session = bimServer.getDatabase().createSession();
					try {
						for (Entry<Long, Set<EndPoint>> endPoints : this.endPoints.entrySet()) {
							for (EndPoint endPoint : endPoints.getValue()) {
								endPoint.getNotificationInterface().newLogAction(notification, null, null);
							}
						}
						if (notification instanceof SNewProjectAdded) {
						} else if (notification instanceof SNewRevisionAdded) {
							SNewRevisionAdded newRevisionNotification = (SNewRevisionAdded) notification;
							Project project = session.get(StorePackage.eINSTANCE.getProject(), newRevisionNotification.getProjectId(), false, null);
							for (Service service : project.getServices()) {
								if (service.getTrigger() == Trigger.NEW_REVISION) {
									Channel channel = getChannel(service);
									try {
										if (service.isReadRevision() || service.isReadExtendedData() || service.isWriteExtendedData() || service.getWriteRevision() != null) {
											// This service will be needing a token
											ServiceInterface newService = bimServer.getServiceFactory().newService(service.getNotificationProtocol(), "");
											((org.bimserver.webservices.Service)newService).setAuthorization(new TokenAuthorization(service.getUser().getOid(), service.isReadRevision() ? newRevisionNotification.getRevisionId() : -1, service.getWriteRevision().getOid(), service.isReadExtendedData() ? newRevisionNotification.getRevisionId() : -1, service.isWriteExtendedData() ? newRevisionNotification.getRevisionId() : -1));
											channel.getNotificationInterface().newLogAction(newRevisionNotification, newService.getCurrentToken(), bimServer.getServerSettings(session).getSiteAddress() + "/jsonapi");
										} else {
											channel.getNotificationInterface().newLogAction(newRevisionNotification, null, null);
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

	public void updateProgress(long id, LongActionState actionState) {
		for (Entry<Long, Set<EndPoint>> endPoints : this.endPoints.entrySet()) {
			for (EndPoint endPoint : endPoints.getValue()) {
				try {
					endPoint.getNotificationInterface().progress(id, new SConverter().convertToSObject(actionState));
				} catch (UserException e) {
					e.printStackTrace();
				} catch (ServerException e) {
					e.printStackTrace();
				}
			}
		}
	}
}