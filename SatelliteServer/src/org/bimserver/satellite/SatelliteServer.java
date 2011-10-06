package org.bimserver.satellite;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.satellite.activities.Activity;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class SatelliteServer {
	private PluginManager pluginManager;
	private BimServerClient bimServerClient;
	private final Set<Activity> activities = new HashSet<Activity>();

	public SatelliteServer() {
		pluginManager = new PluginManager(new File("tmp"), null);
		try {
			pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
		} catch (PluginException e) {
			e.printStackTrace();
		}
		bimServerClient = new BimServerClient(pluginManager);
	}

	public void connect(SatelliteSettings settings, NotificationInterface... notificationInterfaces) throws ConnectionException {
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

	public Set<Activity> getActivities() {
		return activities;
	}
}