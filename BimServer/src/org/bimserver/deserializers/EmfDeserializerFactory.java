package org.bimserver.deserializers;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmfDeserializerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmfDeserializerFactory.class);
	private PluginManager pluginManager;
	private BimDatabase bimDatabase;

	public void init(PluginManager pluginManager, BimDatabase bimDatabase) {
		this.pluginManager = pluginManager;
		this.bimDatabase = bimDatabase;
	}
	
	public EmfDeserializer createDeserializer(String deserializerName) {
		DatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getDeserializer_Name(), new StringLiteral(deserializerName));
			Deserializer found = session.querySingle(condition, Deserializer.class, false, null);
			if (found != null) {
				DeserializerPlugin deserializerPlugin = (DeserializerPlugin) pluginManager.getPlugin(found.getClassName(), true);
				if (deserializerPlugin != null) {
					EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
					deserializer.init(pluginManager.requireSchemaDefinition());
					return deserializer;
				}
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (PluginException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}
}