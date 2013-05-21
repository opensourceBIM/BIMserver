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

import org.bimserver.BimServer;
import org.bimserver.client.Channel;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.async.AsyncRemoteServiceInterface;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewRevisionNotification extends Notification {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewRevisionNotification.class);
	private long roid;
	private long poid;
	private long soid;

	public NewRevisionNotification(BimServer bimServer, long poid, long roid, long soid) {
		super(bimServer);
		this.poid = poid;
		this.roid = roid;
		this.soid = soid;
	}

	public NewRevisionNotification(BimServer bimServer, long poid, long roid) {
		super(bimServer);
		this.poid = poid;
		this.roid = roid;
		this.soid = -1;
	}

	@Override
	public void process() throws BimserverDatabaseException, UserException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
			for (Service service : project.getServices()) {
				if (soid == -1 || service.getOid() == soid) {
					triggerNewRevision(getBimServer().getNotificationsManager(), getBimServer(), getBimServer().getNotificationsManager().getSiteAddress(), project, roid, Trigger.NEW_REVISION, service);
				}
			}
			if (soid == -1) {
				// Only execute if we are not triggering a specific service with this notification
				NewRevisionTopic newRevisionTopic = getBimServer().getNotificationsManager().getNewRevisionTopic();
				if (newRevisionTopic != null) {
					newRevisionTopic.process(session, poid, roid, this);
				}
				NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = getBimServer().getNotificationsManager().getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
				if (newRevisionOnSpecificProjectTopic != null) {
					newRevisionOnSpecificProjectTopic.process(session, poid, roid, this);
				}
			}
		} finally {
			session.close();
		}
	}
	
	public void triggerNewRevision(NotificationsManager notificationsManager, final BimServer bimServer, String siteAddress, Project project, final long roid, Trigger trigger, final Service service) throws UserException, ServerException {
		if (service.getTrigger() == trigger) {
			Channel channel = null;
			try {
				channel = notificationsManager.getChannel(service);
				final RemoteServiceInterface remoteServiceInterface = channel.get(RemoteServiceInterface.class);
				long writeProjectPoid = service.getWriteRevision() == null ? -1 : service.getWriteRevision().getOid();
				long writeExtendedDataRoid = service.getWriteExtendedData() != null ? roid : -1;
				long readRevisionRoid = service.isReadRevision() ? roid : -1;
				long readExtendedDataRoid = service.getReadExtendedData() != null ? roid : -1;
				final ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(service.getUser().getOid(), service.getOid(), readRevisionRoid, writeProjectPoid, readExtendedDataRoid, writeExtendedDataRoid);
				ServiceInterface newService = bimServer.getServiceFactory().get(authorization, AccessMethod.INTERNAL).get(ServiceInterface.class);
				((org.bimserver.webservices.ServiceImpl)newService).setAuthorization(authorization);
				
				AsyncRemoteServiceInterface asyncRemoteServiceInterface = new AsyncRemoteServiceInterface(remoteServiceInterface, bimServer.getExecutorService());
				asyncRemoteServiceInterface.newRevision(poid, roid, service.getOid(), service.getServiceIdentifier(), service.getProfileIdentifier(), authorization.asHexToken(bimServer.getEncryptionKey()), bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), null);
			} catch (ChannelConnectionException e) {
				LOGGER.error("", e);
			} catch (PublicInterfaceNotFoundException e) {
				LOGGER.error("", e);
			} finally {
				if (channel != null) {
					channel.disconnect();
				}
			}
		}
	}
}