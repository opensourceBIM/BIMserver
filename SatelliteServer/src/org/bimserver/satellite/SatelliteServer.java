package org.bimserver.satellite;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.satellite.activities.Activity;
import org.bimserver.shared.NotificationInterface;

public class SatelliteServer {
	private PluginManager pluginManager;
	private BimServerClient bimServerClient;
	private final Set<Activity> activities = new HashSet<Activity>();

	public SatelliteServer() {
		pluginManager = new PluginManager(new File("tmp"), null);
		try {
			pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
			pluginManager.loadPluginsFromEclipseProject(new File("../IfcPlugins"));
		} catch (PluginException e) {
			e.printStackTrace();
		}
		bimServerClient = new BimServerClient(pluginManager);
	}

	public void connect(SatelliteSettings settings, NotificationInterface... notificationInterfaces) throws ConnectionException {
		AuthenticationInfo authenticationInfo = new UsernamePasswordAuthenticationInfo(settings.getUsername(), settings.getPassword());
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connectProtocolBuffers(settings.getAddress(), settings.getPort());
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			bimServerClient.registerNotificationListener(notificationInterface);
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