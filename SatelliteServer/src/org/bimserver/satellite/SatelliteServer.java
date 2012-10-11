package org.bimserver.satellite;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.satellite.activities.Activity;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.NotificationInterface;

public class SatelliteServer {
	private PluginManager pluginManager;
	private BimServerClient bimServerClient;
	private final Set<Activity> activities = new HashSet<Activity>();

	public SatelliteServer() {
		pluginManager = new PluginManager(new File("tmp"), null, null, null);
		try {
			pluginManager.loadAllPluginsFromDirectoryOfJars(new File("plugins"));
		} catch (PluginException e) {
			// Ignore exceptions
		}
		try {
			pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
			pluginManager.loadPluginsFromEclipseProject(new File("../IfcPlugins"));
		} catch (PluginException e) {
			// Ignore exceptions
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