package org.bimserver.endpoints;

import org.bimserver.shared.interfaces.NotificationInterface;

public interface EndPoint {

	long getEndPointId();
	NotificationInterface getNotificationInterface();
	void cleanup();
}