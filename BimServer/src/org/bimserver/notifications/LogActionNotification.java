package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class LogActionNotification extends Notification {
	private SLogAction logAction;

	public LogActionNotification(SLogAction logAction) {
		this.logAction = logAction;
	}
	
	public SLogAction getLogAction() {
		return logAction;
	}
	
	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
	}
}