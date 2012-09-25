package org.bimwebserver;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.NotificationInterfaceAdapter;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.meta.SService;

public class BimWebServer extends NotificationInterfaceAdapter {

	private final Map<Long, NotificationInterface> notificationHandlers = new HashMap<Long, NotificationInterface>();
	private final Map<String, SService> sServices;
	private final Map<String, Object> services = new HashMap<String, Object>();
	
	public BimWebServer(Map<String, SService> sServices) {
		this.sServices = sServices;
		services.put(NotificationInterface.class.getSimpleName(), new NotificationInterfaceImpl());
	}
	
	public void registerForNotifications(long uoid, NotificationInterface notificationInterface) {
		notificationHandlers.put(uoid, notificationInterface);
	}

	public void unregisterForNotification(long uoid) {
		notificationHandlers.remove(uoid);
	}

	public Map<String, SService> getServicesInterfaces() {
		return sServices;
	}

	public SService getServiceInterface(String interfaceName) {
		return sServices.get(interfaceName);
	}

	public Object getService(String interfaceName) {
		return services.get(interfaceName);
	}
	
	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification, SToken token, String apiUrl) throws ServiceException {
		for (NotificationInterface notificationInterface : notificationHandlers.values()) {
			notificationInterface.newRevision(newRevisionNotification, token, apiUrl);
		}
	}
}