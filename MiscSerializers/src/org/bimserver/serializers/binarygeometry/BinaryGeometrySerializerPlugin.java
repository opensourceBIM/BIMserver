package org.bimserver.serializers.binarygeometry;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.shared.exceptions.PluginException;

@Deprecated
public class BinaryGeometrySerializerPlugin extends AbstractSerializerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "BinaryGeometrySerializer";
	}

	@Override
	public String getDefaultName() {
		return "BinaryGeometrySerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		return new BinaryGeometrySerializer();
	}

	@Override
	public boolean needsGeometry() {
		return true;
	}

	@Override
	public String getDefaultExtension() {
		return "dat";
	}

	@Override
	public String getDefaultContentType() {
		return "binarygeometry";
	}
	
	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.asSet(Schema.IFC2X3TC1, Schema.IFC4);
	}
}