package org.bimserver.deserializers;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeserializerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeserializerFactory.class);
	private PluginManager pluginManager;
	private BimDatabase bimDatabase;

	public void init(PluginManager pluginManager, BimDatabase bimDatabase) {
		this.pluginManager = pluginManager;
		this.bimDatabase = bimDatabase;
	}

	public Deserializer createDeserializer(long deserializerOid) throws PluginException, UserException {
		DatabaseSession session = bimDatabase.createSession();
		try {
			DeserializerPluginConfiguration deserializerPluginConfiguration = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, Query.getDefault());
			if (deserializerPluginConfiguration != null) {
				DeserializerPlugin deserializerPlugin = (DeserializerPlugin) pluginManager.getPlugin(deserializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				if (deserializerPlugin != null) {
					ObjectType settings = deserializerPluginConfiguration.getSettings();
					return deserializerPlugin.createDeserializer(new PluginConfiguration(settings));
				} else {
					throw new UserException("No (enabled) deserializer found with oid " + deserializerOid);
				}
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}
}