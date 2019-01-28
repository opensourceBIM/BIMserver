package org.bimserver.plugins;

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

import org.bimserver.plugins.web.AbstractWebModulePlugin;
import org.bimserver.shared.exceptions.PluginException;

public class JsonWebModule extends AbstractWebModulePlugin {

	private WebModulePlugin webModulePlugin;

	public JsonWebModule(WebModulePlugin webModulePlugin) {
		this.webModulePlugin = webModulePlugin;
	}

	@Override
	public void init(PluginContext pluginContext, PluginConfiguration systemSettings) throws PluginException {
		super.init(pluginContext, systemSettings);
	}

	@Override
	public String getIdentifier() {
		return webModulePlugin.getIdentifier();
	}

	@Override
	public String getInternalPath() {
		String internalPath = webModulePlugin.getInternalPath();
		if (internalPath == null) {
			internalPath = "";
		}
		if (internalPath.length() > 0) {
			if (!internalPath.endsWith("/")) {
				internalPath = internalPath + "/";
			}
		}
		return internalPath;
	}
	
	@Override
	public String getDefaultContextPath() {
		return webModulePlugin.getIdentifier();
	}
}