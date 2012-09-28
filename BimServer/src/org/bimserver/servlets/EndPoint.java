package org.bimserver.servlets;

import org.bimserver.shared.interfaces.NotificationInterface;

public interface EndPoint {

	long getEndPointId();
	NotificationInterface getNotificationInterface();
	void cleanup();
}