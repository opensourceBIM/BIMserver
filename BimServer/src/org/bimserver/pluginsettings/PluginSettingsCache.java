package org.bimserver.pluginsettings;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
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
			try (DatabaseSession databaseSession = bimServer.getDatabase().createSession(OperationType.READ_ONLY)) {
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