package org.bimserver.plugins.renderengine;

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

import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;

public interface RenderEnginePlugin extends Plugin {
	/**
	 * @param pluginConfiguration The user specific configuration for this plugin
	 * @return A RenderEngine instance
	 * @throws RenderEngineException
	 */
	RenderEngine createRenderEngine(PluginConfiguration pluginConfiguration, String schema) throws RenderEngineException;
	
	/**
	 * @return Some information about the version used
	 */
	VersionInfo getVersionInfo();
	
	@Override
	default SPluginType getPluginType() {
		return SPluginType.RENDER_ENGINE;
	}
}