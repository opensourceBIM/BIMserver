package org.bimserver.pluginsettings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.plugins.PluginConfiguration;

public class PluginSettingsCache {

	private BimServer bimServer;
	private final Map<Long, PluginConfiguration> pluginConfigurations = Collections.synchronizedMap(new HashMap<>());

	public PluginSettingsCache(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public void reset(long serializerOid) {
		this.pluginConfigurations.remove(serializerOid);
	}

	public PluginConfiguration getPluginSettings(Long serializerOid) throws BimserverDatabaseException {
		PluginConfiguration pluginConfiguration = pluginConfigurations.get(serializerOid);
		if (pluginConfiguration == null) {
			try (DatabaseSession databaseSession = bimServer.getDatabase().createSession()) {
				org.bimserver.models.store.PluginConfiguration serializerPluginConfiguration = databaseSession.get(serializerOid, OldQuery.getDefault());
				if (serializerPluginConfiguration != null) {
					pluginConfiguration = new org.bimserver.plugins.PluginConfiguration(serializerPluginConfiguration.getSettings());
					pluginConfigurations.put(serializerOid, pluginConfiguration);
				}
			}
		}
		return pluginConfiguration;
	}
}