package org.bimserver.notifications;

import org.bimserver.models.log.LogAction;

public interface NotificationListener {

	void notify(LogAction notificationMessage);
}
