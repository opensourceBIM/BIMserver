package org.bimserver.satellite;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.client.BimServerClient;
import org.bimserver.satellite.activities.Activity;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class SatelliteServer {
	private BimServerClient bimServerClient = new BimServerClient();
	private final Set<Activity> activities = new HashSet<Activity>();
	
	public void connect(SatelliteSettings settings, NotificationInterface... notificationInterfaces) throws IOException {
		bimServerClient.connectProtocolBuffers(settings.getAddress(), settings.getPort());
		try {
			bimServerClient.getServiceInterface().login(settings.getUsername(), settings.getPassword());
			for (NotificationInterface notificationInterface : notificationInterfaces) {
				bimServerClient.registerNotificationListener(notificationInterface);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public void registerActivity(Activity activity) {
		activities.add(activity);
		activity.activate(this);
	}
	
	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}
	
	public void disconnect() {
		bimServerClient.disconnect();
	}
}