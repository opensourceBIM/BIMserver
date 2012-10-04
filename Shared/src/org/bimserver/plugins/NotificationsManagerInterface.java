package org.bimserver.plugins;

import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.shared.interfaces.NotificationInterface;

public interface NotificationsManagerInterface {

	void register(ServiceDescriptor serviceDescriptor, NotificationInterface notificationInterface);
}