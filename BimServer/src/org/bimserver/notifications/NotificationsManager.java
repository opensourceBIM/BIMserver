package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonChannel;
import org.bimserver.client.JsonSocketReflectorFactory;
import org.bimserver.client.SimpleTokenHolder;
import org.bimserver.client.channels.Channel;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SExtendedDataAddedToRevision;
import org.bimserver.interfaces.objects.SImmediateNotificationResult;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewProjectAdded;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.shared.NotificationInterfaceAdapter;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager extends Thread implements NotificationsManagerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Map<String, RunningExternalService> runningServices = new HashMap<String, RunningExternalService>();
	private final Map<Long, Set<EndPoint>> endPoints = new HashMap<Long, Set<EndPoint>>();
	private final Map<String, ServiceDescriptor> internalServices = new HashMap<String, ServiceDescriptor>();
	private final Map<String, NotificationInterface> x = new HashMap<String, NotificationInterface>();
	private final BlockingQueue<SLogAction> queue = new ArrayBlockingQueue<SLogAction>(1000);
	private final JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private final BimServer bimServer;
	private volatile boolean running;
	private String url;

	public NotificationsManager(BimServer bimServer, JsonSocketReflectorFactory jsonSocketReflectorFactory) {
		setName("NotificationsManager");
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
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
						synchronized(this.endPoints) {
							for (Entry<Long, Set<EndPoint>> endPoints : this.endPoints.entrySet()) {
								for (EndPoint endPoint : endPoints.getValue()) {
									endPoint.getNotificationInterface().newLogAction(UUID.randomUUID().toString(), notification, null, null, null, null);
								}
							}
						}
						if (notification instanceof SNewProjectAdded) {
						} else if (notification instanceof SNewRevisionAdded) {
							SNewRevisionAdded newRevisionNotification = (SNewRevisionAdded) notification;
							Project project = session.get(StorePackage.eINSTANCE.getProject(), newRevisionNotification.getProjectId(), Query.getDefault());
							triggerNewRevision(bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), newRevisionNotification, project, newRevisionNotification.getRevisionId(), Trigger.NEW_REVISION);
						} else if (notification instanceof SExtendedDataAddedToRevision) {
							SExtendedDataAddedToRevision action = (SExtendedDataAddedToRevision) notification;
							Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), action.getRevisionId(), Query.getDefault());
							Project project = revision.getProject();
							triggerNewRevision(bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), action, project, action.getRevisionId(), Trigger.NEW_EXTENDED_DATA);
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
		ServerSettings serverSettings = bimServer.getServerSettingsCache().getServerSettings();
		this.url = serverSettings.getSiteAddress() + "/json";
		for (String s : internalServices.keySet()) {
			internalServices.get(s).setUrl(url);
		}
	}

	public void triggerNewRevision(String siteAddress, SLogAction action, Project project, long roid, Trigger trigger) throws UserException, ServerException {
		for (Service service : project.getServices()) {
			triggerNewRevision(siteAddress, action, project, roid, trigger, service);
		}
	}

	public void triggerNewRevision(String siteAddress, SLogAction action, Project project, long roid, Trigger trigger, Service service) throws UserException, ServerException {
		if (service.getTrigger() == trigger) {
			Channel channel = null;
			try {
				channel = getChannel(service);
				NotificationInterface notificationInterface = channel.getNotificationInterface();
				String uuid = UUID.randomUUID().toString();
				runningServices.put(uuid, new RunningExternalService());
				if (service.isReadRevision() || service.getReadExtendedData() != null || service.getWriteExtendedData() != null || service.getWriteRevision() != null) {
					// This service will be needing a token
					long writeProjectPoid = service.getWriteRevision() == null ? -1 : service.getWriteRevision().getOid();
					long writeExtendedDataRoid = service.getWriteExtendedData() != null ? roid : -1;
					long readRevisionRoid = service.isReadRevision() ? roid : -1;
					long readExtendedDataRoid = service.getReadExtendedData() != null ? roid : -1;
					ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(readRevisionRoid, writeProjectPoid, readExtendedDataRoid, writeExtendedDataRoid);
					authorization.setUoid(service.getUser().getOid());
					ServiceInterface newService = bimServer.getServiceFactory().getService(ServiceInterface.class, authorization, AccessMethod.INTERNAL);
					((org.bimserver.webservices.Service)newService).setAuthorization(authorization);
					notificationInterface.newLogAction(uuid, action, service.getServiceIdentifier(), service.getProfileIdentifier(), authorization.asHexToken(bimServer.getEncryptionKey()), siteAddress);
				} else {
					notificationInterface.newLogAction(uuid, action, service.getServiceIdentifier(), service.getProfileIdentifier(), null, null);
				}
			} catch (ChannelConnectionException e) {
				LOGGER.error("", e);
			} finally {
				if (channel != null) {
					channel.disconnect();
				}
			}
		}
	}
	
	public RunningExternalService getRunningExternalService(String uuid) {
		return runningServices.get(uuid);
	}
	
	private Channel getChannel(Service service) throws ChannelConnectionException {
		if (service.getInternalService() != null) {
			// Overrule definition
			return new InternalChannel(x.get(service.getServiceIdentifier()));
		}
		switch (service.getNotificationProtocol()) {
		case JSON:
			JsonChannel jsonChannel = new JsonChannel(bimServer.getReflectorFactory(), jsonSocketReflectorFactory);
			jsonChannel.connect(service.getUrl(), new SimpleTokenHolder());
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
		synchronized(this.endPoints) {
			for (Entry<Long, Set<EndPoint>> endPoints : this.endPoints.entrySet()) {
				for (EndPoint endPoint : endPoints.getValue()) {
					try {
						endPoint.getNotificationInterface().progress(id, new SConverter().convertToSObject(actionState));
					} catch (Exception e) {
						LOGGER.error("", e);
					}
				}
			}
		}
	}

	public SImmediateNotificationResult notify(SLogAction logAction, String serviceIdentifier, String profileIdentifier, String token, String apiUrl) {
		try {
			NotificationInterface notificationInterface = x.get(serviceIdentifier);
			return notificationInterface.newLogAction(UUID.randomUUID().toString(), logAction, serviceIdentifier, profileIdentifier, token, apiUrl);
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (ServerException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public void registerNewRevisionHandler(ServiceDescriptor serviceDescriptor, final NewRevisionHandler newRevisionHandler) {
		register(serviceDescriptor, new NotificationInterfaceAdapter(){
			@Override
			public SImmediateNotificationResult newLogAction(String uuid, SLogAction logAction, String serviceIdentifier, String profileIdentifier, String token, String apiUrl) throws UserException, ServerException {
				if (logAction instanceof SNewRevisionAdded) {
					SNewRevisionAdded newRevisionAdded = (SNewRevisionAdded)logAction;
					InternalChannel internalChannel = new InternalChannel(x.get(serviceIdentifier));
					ServiceInterface object = bimServer.getServiceFactory().getService(ServiceInterface.class, token, AccessMethod.JSON);
					internalChannel.addServiceInterface(ServiceInterface.class, object);
					ServiceInterface serviceInterface = internalChannel.getServiceInterface();
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