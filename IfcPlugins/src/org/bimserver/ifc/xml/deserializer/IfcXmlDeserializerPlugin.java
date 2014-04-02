package org.bimserver.ifc.xml.deserializer;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.Collections;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;

public class IfcXmlDeserializerPlugin implements DeserializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfDeserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new IfcXmlDeserializer();
	}

	@Override
	public String getDescription() {
		return "IfcXmlDeserializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
		pluginManager.requireSchemaDefinition("ifc2x3tc1");
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("ifcxml");
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultName() {
		return "IfcXmlDeserializer";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Collections.singleton(Schema.IFC2X3TC1);
	}
}