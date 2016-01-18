package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import org.bimserver.plugins.web.AbstractWebModulePlugin;
import org.bimserver.shared.exceptions.PluginException;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonWebModule extends AbstractWebModulePlugin {

	private ObjectNode settings;
	private boolean initialized;

	public JsonWebModule(ObjectNode settings) {
		this.settings = settings;
	}

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}

	@Override
	public String getDescription() {
		return settings.get("description").asText();
	}

	@Override
	public String getDefaultName() {
		return settings.get("defaultName").asText();
	}

	@Override
	public String getVersion() {
		return settings.get("version").asText();
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getIdentifier() {
		return settings.get("identifier").asText();
	}

	@Override
	public String getDefaultContextPath() {
		return settings.get("defaultContextPath").asText();
	}
}