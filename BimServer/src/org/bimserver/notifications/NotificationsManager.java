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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.bimserver.BimServer;
import org.bimserver.client.JsonChannel;
import org.bimserver.client.channels.Channel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SImmediateNotificationResult;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewProjectAdded;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.servlets.EndPoint;
import org.bimserver.shared.NotificationInterfaceAdapter;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager extends Thread implements NotificationsManagerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Map<String, RunningExternalService> runningServices = new HashMap<String, RunningExternalService>();
	private final Map<Long, Set<EndPoint>> endPoints = new HashMap<Long, Set<EndPoint>>();
	private final Map<String, ServiceDescriptor> internalServices = new HashMap<String, ServiceDescriptor>();
	private final Map<String, NotificationInterface> x = new HashMap<String, NotificationInterface>();
	private final BlockingQueue<SLogAction> queue = new ArrayBlockingQueue<SLogAction>(1000);
	private final BimServer bimServer;
	private volatile boolean running;
	private String url;

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
								endPoint.getNotificationInterface().newLogAction(UUID.randomUUID().toString(), notification, null, null, null, null);
							}
						}
						if (notification instanceof SNewProjectAdded) {
						} else if (notification instanceof SNewRevisionAdded) {
							SNewRevisionAdded newRevisionNotification = (SNewRevisionAdded) notification;
							Project project = session.get(StorePackage.eINSTANCE.getProject(), newRevisionNotification.getProjectId(), false, null);
							for (Service service : project.getServices()) {
								trigger(bimServer.getServerSettings(session).getSiteAddress(), newRevisionNotification, service);
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

	public void init() {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings serverSettings = session.getAllOfType(StorePackage.eINSTANCE.getServerSettings(), false, null).getAll(ServerSettings.class).get(0);
			this.url = serverSettings.getSiteAddress() + "/json";
			for (String s : internalServices.keySet()) {
				internalServices.get(s).setUrl(url);
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void trigger(String siteAddress, SNewRevisionAdded newRevisionNotification, Service service) throws UserException, ServerException {
		if (service.getTrigger() == Trigger.NEW_REVISION) {
			Channel channel = getChannel(service);
			try {
				NotificationInterface notificationInterface = channel.getNotificationInterface();
				String uuid = UUID.randomUUID().toString();
				runningServices.put(uuid, new RunningExternalService());
				if (service.isReadRevision() || service.getReadExtendedData() != null || service.getWriteExtendedData() != null || service.getWriteRevision() != null) {
					// This service will be needing a token
					ServiceInterface newService = bimServer.getServiceFactory().newServiceMap(service.getNotificationProtocol(), "").get(ServiceInterface.class);
					long writeProjectPoid = service.getWriteRevision() == null ? -1 : service.getWriteRevision().getOid();
					long writeExtendedDataRoid = service.getWriteExtendedData() != null ? newRevisionNotification.getRevisionId() : -1;
					long readRevisionRoid = service.isReadRevision() ? newRevisionNotification.getRevisionId() : -1;
					long readExtendedDataRoid = service.getReadExtendedData() != null ? newRevisionNotification.getRevisionId() : -1;
					TokenAuthorization authorization = new TokenAuthorization(service.getUser().getOid(), readRevisionRoid, writeProjectPoid, readExtendedDataRoid, writeExtendedDataRoid);
					((org.bimserver.webservices.Service)newService).setAuthorization(authorization);
					notificationInterface.newLogAction(uuid, newRevisionNotification, service.getServiceIdentifier(), service.getProfileIdentifier(), newService.getCurrentToken(), siteAddress + "/jsonapi");
				} else {
					notificationInterface.newLogAction(uuid, newRevisionNotification, service.getServiceIdentifier(), service.getProfileIdentifier(), null, null);
				}
			} finally {
				channel.disconnect();
			}
		}
	}

	public RunningExternalService getRunningExternalService(String uuid) {
		return runningServices.get(uuid);
	}
	
	private Channel getChannel(Service service) {
		if (service.getInternalService() != null) {
			// Overrule definition
			return new InternalChannel(x.get(service.getServiceIdentifier()));
		}
		switch (service.getNotificationProtocol()) {
		case JSON:
			JsonChannel jsonChannel = new JsonChannel(bimServer.getServicesMap(), bimServer.getReflectorFactory());
			jsonChannel.connect(service.getUrl(), true, null);
			return jsonChannel;
		case INTERNAL:
			return new InternalChannel(x.get(service.getServiceIdentifier()));
		default: 
			LOGGER.error("Unimplemented AccessMethod: " + service.getNotificationProtocol());
			return null;
		}
	}

	public void shutdown() {
		running = false;
		this.interrupt();
	}

	@Override
	public void register(ServiceDescriptor serviceDescriptor, NotificationInterface notificationInterface) {
		serviceDescriptor.setUrl(url);
		internalServices.put(serviceDescriptor.getName(), serviceDescriptor);
		x.put(serviceDescriptor.getIdentifier(), notificationInterface);
	}
	
	public Map<String, ServiceDescriptor> getInternalServices() {
		return internalServices;
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

	public SImmediateNotificationResult notify(SLogAction logAction, String serviceIdentifier, String profileIdentifier, SToken token, String apiUrl) {
		try {
			NotificationInterface notificationInterface = x.get(serviceIdentifier);
			return notificationInterface.newLogAction(UUID.randomUUID().toString(), logAction, serviceIdentifier, profileIdentifier, token, apiUrl);
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void registerNewRevisionHandler(ServiceDescriptor serviceDescriptor, final NewRevisionHandler newRevisionHandler) {
		register(serviceDescriptor, new NotificationInterfaceAdapter(){
			@Override
			public SImmediateNotificationResult newLogAction(String uuid, SLogAction logAction, String serviceIdentifier, String profileIdentifier, SToken token, String apiUrl) throws UserException, ServerException {
				if (logAction instanceof SNewRevisionAdded) {
					SNewRevisionAdded newRevisionAdded = (SNewRevisionAdded)logAction;
					InternalChannel internalChannel = new InternalChannel(x.get(serviceIdentifier));
					ServiceInterface object = bimServer.getServiceFactory().getService(ServiceInterface.class, token);
					internalChannel.addServiceInterface(ServiceInterface.class, object);
					ServiceInterface serviceInterface = internalChannel.getServiceInterface();
//					JsonReflector jsonReflector = new JsonSocketReflector(bimServer.getServicesMap(), apiUrl, false, new TokenAuthentication(token));
//					ServiceInterface serviceInterfaceReflectorImpl = bimServer.getReflectorFactory().createReflector(ServiceInterface.class, jsonReflector);
					SService service = serviceInterface.getService(Long.parseLong(profileIdentifier));
					SObjectType settings = serviceInterface.getPluginSettings(service.getInternalServiceId());
					runningServices.put(uuid, new RunningExternalService());
					newRevisionHandler.newRevision(uuid, serviceInterface, newRevisionAdded, settings);
				}
				return null;
			}
		});
	}
}