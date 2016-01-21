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

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.shared.exceptions.PluginException;

public interface Plugin {
	/**
	 * Initialize this plugin
	 * @param pluginManager
	 * @throws PluginException
	 */
	void init(PluginManagerInterface pluginManager) throws PluginException;
	
	/**
	 * @return The default name of this plugin, a user can later change the name
	 */
	String getDefaultName();
	
	/**
	 * @return An object with the definition of a set of properties that can be set by the user of a plugin, the plugin can later use the actual values a user has set
	 */
	ObjectDefinition getSettingsDefinition();
}