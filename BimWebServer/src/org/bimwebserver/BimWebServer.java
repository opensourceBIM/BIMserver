package org.bimwebserver;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.NotificationInterfaceAdapter;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.meta.SService;

public class BimWebServer extends NotificationInterfaceAdapter {

	private final Map<Long, NotificationInterface> notificationHandlers = new HashMap<Long, NotificationInterface>();
	private final Map<String, SService> sServices;
	private final Map<String, Object> services = new HashMap<String, Object>();
	private BimServerClientFactory bimServerClientFactory;
	
	public BimWebServer(Map<String, SService> sServices) {
		this.sServices = sServices;
		services.put(NotificationInterface.class.getSimpleName(), new NotificationInterfaceAdapter());
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
	public void newLogAction(SLogAction newRevisionNotification, SToken token, String apiUrl) throws UserException, ServerException {
		for (NotificationInterface notificationInterface : notificationHandlers.values()) {
			notificationInterface.newLogAction(newRevisionNotification, token, apiUrl);
		}
	}

	public BimServerClientFactory getBimServerClientFactory() {
		return bimServerClientFactory;
	}

	public void setBimServerClientFactory(BimServerClientFactory bimServerClientFactory) {
		this.bimServerClientFactory = bimServerClientFactory;
	}
}