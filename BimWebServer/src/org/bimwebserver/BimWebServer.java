package org.bimwebserver;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.meta.SService;

public class BimWebServer {

	private final Map<Long, NotificationInterface> notificationHandlers = new HashMap<Long, NotificationInterface>();
	private final HashMap<String, SService> sServices = new HashMap<String, SService>();
	private final HashMap<String, Object> services = new HashMap<String, Object>();
	
	public BimWebServer() {
		sServices.put(NotificationInterface.class.getSimpleName(), new SService(null, NotificationInterface.class));
		services.put(NotificationInterface.class.getSimpleName(), new NotificationInterfaceImpl());
	}
	
	public void registerForNotifications(long uoid, NotificationInterface notificationInterface) {
		notificationHandlers.put(uoid, notificationInterface);
	}

	public void unregisterForNotification(long uoid) {
		notificationHandlers.remove(uoid);
	}

	public Map<String, SService> getServicesInterfaces() {
		return null;
	}

	public SService getServiceInterface(String interfaceName) {
		return sServices.get(interfaceName);
	}

	public Object getService(String interfaceName) {
		return services.get(interfaceName);
	}
}