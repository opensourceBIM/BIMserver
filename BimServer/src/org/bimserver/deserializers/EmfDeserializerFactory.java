package org.bimserver.deserializers;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;

public class EmfDeserializerFactory {
	private PluginManager pluginManager;
	private BimDatabase bimDatabase;

	public void init(PluginManager pluginManager, BimDatabase bimDatabase) {
		this.pluginManager = pluginManager;
		this.bimDatabase = bimDatabase;
	}
	
	public EmfDeserializer createDeserializer(String deserializerName) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
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
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}