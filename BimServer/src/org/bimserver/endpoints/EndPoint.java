package org.bimserver.endpoints;

import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;

public interface EndPoint {

	long getEndPointId();
	NotificationInterface getNotificationInterface();
	RemoteServiceInterface getRemoteServiceInterface();
	void cleanup();
	long getUoid();
}