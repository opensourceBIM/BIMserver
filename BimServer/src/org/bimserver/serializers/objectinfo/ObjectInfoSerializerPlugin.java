package org.bimserver.serializers.objectinfo;

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

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.shared.exceptions.PluginException;

public class ObjectInfoSerializerPlugin extends AbstractSerializerPlugin {

	@Override
	public void init(PluginContext pluginContext, PluginConfiguration systemSettings) throws PluginException {
	}
	
	@Override
	public EmfSerializer createSerializer(PluginConfiguration pluginConfiguration) {
		return new ObjectInfoSerializer();
	}

	@Override
	public String getDefaultContentType() {
		return "text/html";
	}

	@Override
	public String getDefaultExtension() {
		return "html";
	}

	@Override
	public ObjectDefinition getUserSettingsDefinition() {
		return super.getUserSettingsDefinition();
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}

	@Override
	public String getOutputFormat(Schema schema) {
		return null;
	}
}