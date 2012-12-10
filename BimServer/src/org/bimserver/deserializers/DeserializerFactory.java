package org.bimserver.deserializers;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeserializerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeserializerFactory.class);
	private PluginManager pluginManager;

	public void init(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
	}

	public Deserializer createDeserializer(String deserializerClassname) {
		DeserializerPlugin deserializerPlugin = (DeserializerPlugin) pluginManager.getPlugin(deserializerClassname, true);
		if (deserializerPlugin != null) {
			Deserializer deserializer = deserializerPlugin.createDeserializer();
			try {
				deserializer.init(pluginManager.requireSchemaDefinition());
			} catch (PluginException e) {
				LOGGER.error("", e);
			}
			return deserializer;
		}
		return null;
	}
}