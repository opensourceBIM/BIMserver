package org.bimserver.notifications;

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
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewRevisionNotification extends Notification {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewRevisionNotification.class);
	private long roid;
	private long poid;
	private long soid;

	public NewRevisionNotification(long poid, long roid, long soid) {
		this.poid = poid;
		this.roid = roid;
		this.soid = soid;
	}

	public NewRevisionNotification(long poid, long roid) {
		this.poid = poid;
		this.roid = roid;
		this.soid = -1;
	}

	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
		for (Service service : project.getServices()) {
			if (soid == -1 || service.getOid() == soid) {
				triggerNewRevision(notificationsManager, bimServer, notificationsManager.getSiteAddress(), project, roid, Trigger.NEW_REVISION, service);
			}
		}
		if (soid == -1) {
			// Only execute if we are not triggering a specific service with this notification
			NewRevisionTopic newRevisionTopic = notificationsManager.getNewRevisionTopic();
			if (newRevisionTopic != null) {
				newRevisionTopic.process(session, poid, roid, this);
			}
			NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = notificationsManager.getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
			if (newRevisionOnSpecificProjectTopic != null) {
				newRevisionOnSpecificProjectTopic.process(session, poid, roid, this);
			}
		}
	}
	
	public void triggerNewRevision(NotificationsManager notificationsManager, BimServer bimServer, String siteAddress, Project project, long roid, Trigger trigger, Service service) throws UserException, ServerException {
		if (service.getTrigger() == trigger) {
			Channel channel = null;
			try {
				channel = notificationsManager.getChannel(service);
				RemoteServiceInterface remoteServiceInterface = channel.get(RemoteServiceInterface.class);
				long writeProjectPoid = service.getWriteRevision() == null ? -1 : service.getWriteRevision().getOid();
				long writeExtendedDataRoid = service.getWriteExtendedData() != null ? roid : -1;
				long readRevisionRoid = service.isReadRevision() ? roid : -1;
				long readExtendedDataRoid = service.getReadExtendedData() != null ? roid : -1;
				ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(service.getUser().getOid(), readRevisionRoid, writeProjectPoid, readExtendedDataRoid, writeExtendedDataRoid);
				ServiceInterface newService = bimServer.getServiceFactory().get(authorization, AccessMethod.INTERNAL).get(ServiceInterface.class);
				((org.bimserver.webservices.ServiceImpl)newService).setAuthorization(authorization);
				
				remoteServiceInterface.newRevision(poid, roid, service.getServiceIdentifier(), service.getProfileIdentifier(), authorization.asHexToken(bimServer.getEncryptionKey()), bimServer.getServerSettingsCache().getServerSettings().getSiteAddress());
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