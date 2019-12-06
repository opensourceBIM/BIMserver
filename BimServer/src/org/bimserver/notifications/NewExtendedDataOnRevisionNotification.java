package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.client.Channel;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.async.AsyncRemoteServiceInterface;
import org.bimserver.shared.interfaces.async.AsyncRemoteServiceInterface.NewExtendedDataOnRevisionCallback;
import org.bimserver.shared.interfaces.async.AsyncRemoteServiceInterface.NewRevisionCallback;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewExtendedDataOnRevisionNotification extends Notification {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewExtendedDataOnRevisionNotification.class);

	private Long roid;
	private Long edid;
	private long soid;
	private long poid;

	public NewExtendedDataOnRevisionNotification(BimServer bimServer, Long edid, long poid, Long roid, long soid) {
		super(bimServer);
		this.edid = edid;
		this.poid = poid;
		this.roid = roid;
		this.soid = soid;
	}

	public long getRoid() {
		return roid;
	}

	public long getEdid() {
		return edid;
	}
	
	public long getPoid() {
		return poid;
	}

	@Override
	public void process() throws BimserverDatabaseException, UserException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, OldQuery.getDefault());
			for (Service service : project.getServices()) {
				if (soid == -1 || service.getOid() == soid) {
					triggerNewExtendedData(session, getBimServer().getNotificationsManager(), getBimServer(), getBimServer().getNotificationsManager().getSiteAddress(), project, roid, Trigger.NEW_EXTENDED_DATA, service);
				}
			}
			if (soid == -1) {
				// Only execute if we are not triggering a specific service with this notification
				NewExtendedDataOnRevisionTopic topic = getBimServer().getNotificationsManager().getNewExtendedDataOnRevisionTopic(new NewExtendedDataOnRevisionTopicKey(roid));
				if (topic != null) {
					topic.process(this);
				}
			}
		} finally {
			session.close();
		}
	}
	
	public void triggerNewExtendedData(DatabaseSession session, NotificationsManager notificationsManager, final BimServer bimServer, String siteAddress, Project project, final long roid, Trigger trigger, final Service service) throws UserException, ServerException {
		if (service.getTrigger() == trigger) {
			Channel channel = null;
			try {
				channel = notificationsManager.getChannel(service);
				final RemoteServiceInterface remoteServiceInterface = channel.get(RemoteServiceInterface.class);
				long writeProjectPoid = service.getWriteRevision() == null ? -1 : service.getWriteRevision().getOid();
				long writeExtendedDataRoid = service.getWriteExtendedData() != null ? roid : -1;
				long readRevisionRoid = service.isReadRevision() ? roid : -1;
				long readExtendedDataRoid = service.getReadExtendedData() != null ? roid : -1;
				final ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(bimServer, service.getUser().getOid(), service.getOid(), new long[]{readRevisionRoid}, writeProjectPoid, readExtendedDataRoid, writeExtendedDataRoid);
				ServiceInterface newService = bimServer.getServiceFactory().get(authorization, AccessMethod.INTERNAL).get(ServiceInterface.class);
				((org.bimserver.webservices.impl.ServiceImpl)newService).setAuthorization(authorization); // TODO redundant?
				
				AsyncRemoteServiceInterface asyncRemoteServiceInterface = new AsyncRemoteServiceInterface(remoteServiceInterface, bimServer.getExecutorService());
				asyncRemoteServiceInterface.newExtendedDataOnRevision(poid, roid, edid, soid, service.getServiceIdentifier(), service.getProfileIdentifier(), service.getToken(), authorization.asHexToken(bimServer.getEncryptionKey()), bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), new NewExtendedDataOnRevisionCallback(){
					@Override
					public void success() {
					}

					@Override
					public void error(Throwable e) {
						LOGGER.error("", e);
					}});
				asyncRemoteServiceInterface.newRevision(poid, roid, service.getOid(), service.getServiceIdentifier(), service.getProfileIdentifier(), service.getToken(), authorization.asHexToken(bimServer.getEncryptionKey()), bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), new NewRevisionCallback(){
					@Override
					public void success() {
					}

					@Override
					public void error(Throwable e) {
						LOGGER.error("", e);
					}});
			} catch (ChannelConnectionException e) {
				LOGGER.error("", e);
			} catch (PublicInterfaceNotFoundException e) {
				LOGGER.error("", e);
			} finally {
				if (channel != null) {
					channel.disconnect(); // TODO This is interesting, when sending async, is this not going to break?
				}
			}
		}
	}
}
