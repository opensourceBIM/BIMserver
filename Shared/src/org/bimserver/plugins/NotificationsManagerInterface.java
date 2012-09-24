package org.bimserver.plugins;

import org.bimserver.models.store.ServerDescriptor;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.shared.NotificationInterface;

public interface NotificationsManagerInterface {

	void register(ServerDescriptor serverDescriptor, ServiceDescriptor serviceDescriptor, NotificationInterface notificationInterface);
}