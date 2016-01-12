package org.bimserver.serializers;

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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.HashSet;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.StreamingSerializer;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public class JsonStreamingSerializerPlugin implements StreamingSerializerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "JsonStreamingSerializer";
	}

	@Override
	public String getDefaultName() {
		return "JsonStreamingSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public StreamingSerializer createSerializer(PluginConfiguration plugin) {
		return new StreamingJsonSerializer();
	}

	@Override
	public boolean needsGeometry() {
		return true;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		Set<Schema> schemas = new HashSet<>();
		schemas.add(Schema.IFC2X3TC1);
		schemas.add(Schema.IFC4);
		return schemas;
	}
}