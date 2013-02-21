package org.bimserver.notifications;

import java.util.UUID;

import org.bimserver.BimServer;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.channels.Channel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.interfaces.objects.SExtendedDataAddedToRevision;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewProjectAdded;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogActionNotification extends Notification {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogActionNotification.class);
	private SLogAction logAction;

	public LogActionNotification(SLogAction logAction) {
		this.logAction = logAction;
	}
	
	public SLogAction getLogAction() {
		return logAction;
	}
	
	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		if (logAction instanceof SNewProjectAdded) {
		} else if (logAction instanceof SNewRevisionAdded) {
			SNewRevisionAdded newRevisionNotification = (SNewRevisionAdded) logAction;
			Project project = session.get(StorePackage.eINSTANCE.getProject(), newRevisionNotification.getProjectId(), Query.getDefault());
			triggerNewRevision(notificationsManager, bimServer, bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), newRevisionNotification, project, newRevisionNotification.getRevisionId(), Trigger.NEW_REVISION);
		} else if (logAction instanceof SExtendedDataAddedToRevision) {
			SExtendedDataAddedToRevision action = (SExtendedDataAddedToRevision) logAction;
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), action.getRevisionId(), Query.getDefault());
			Project project = revision.getProject();
			triggerNewRevision(notificationsManager, bimServer, bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), action, project, action.getRevisionId(), Trigger.NEW_EXTENDED_DATA);
		}
	}
	
	public void triggerNewRevision(NotificationsManager notificationsManager, BimServer bimServer, String siteAddress, SLogAction action, Project project, long roid, Trigger trigger) throws UserException, ServerException {
		for (Service service : project.getServices()) {
			triggerNewRevision(notificationsManager, bimServer, siteAddress, action, project, roid, trigger, service);
		}
	}

	public void triggerNewRevision(NotificationsManager notificationsManager, BimServer bimServer, String siteAddress, SLogAction action, Project project, long roid, Trigger trigger, Service service) throws UserException, ServerException {
		if (service.getTrigger() == trigger) {
			Channel channel = null;
			try {
				channel = notificationsManager.getChannel(service);
				NotificationInterface notificationInterface = channel.getNotificationInterface();
				String uuid = UUID.randomUUID().toString();
//				runningServices.put(uuid, new RunningExternalService());
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
}
