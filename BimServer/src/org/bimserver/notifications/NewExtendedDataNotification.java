package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewExtendedDataNotification extends Notification {

	private Long edid;
	private Long soid;

	public NewExtendedDataNotification(Long edid, Long soid) {
		this.edid = edid;
		this.soid = soid;
	}

	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
//		NewExtendedDataTopic newRevisionTopic = notificationsManager.getNewRevisionTopic();
//		Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
//		for (Service service : project.getServices()) {
//			triggerNewRevision(notificationsManager, bimServer, notificationsManager.getSiteAddress(), project, roid, Trigger.NEW_REVISION, service);
//		}
//		if (newRevisionTopic != null) {
//			newRevisionTopic.process(session, poid, roid, this);
//		}
//		NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = notificationsManager.getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
//		if (newRevisionOnSpecificProjectTopic != null) {
//			newRevisionOnSpecificProjectTopic.process(session, poid, roid, this);
//		}
	}
}
