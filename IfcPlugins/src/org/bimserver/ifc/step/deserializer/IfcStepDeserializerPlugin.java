package org.bimserver.ifc.step.deserializer;

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

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.schema.SchemaException;

public class IfcStepDeserializerPlugin implements DeserializerPlugin {

	boolean initialized = false;
	
	@Override
	public Deserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new IfcStepDeserializer();
	}

	@Override
	public String getDescription() {
		return "IfcStepDeserializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws SchemaException, PluginException {
		pluginManager.requireSchemaDefinition();
		initialized = true;
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("ifc") || extension.equalsIgnoreCase("ifczip");
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultName() {
		return "IfcStepDeserializer";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}