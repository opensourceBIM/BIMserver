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

import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.shared.exceptions.PluginException;

public interface Plugin {
	/**
	 * Initialize this plugin
	 * @param pluginContext The context of the plugin, you can store this object as a field and use it later
	 * @param systemSettings TODO
	 * @throws PluginException When the init method throws a PluginException, this will always disable the plugin
	 */
	void init(PluginContext pluginContext, PluginConfiguration systemSettings) throws PluginException;
	
	/**
	 * @return An object with the definition of a set of properties that can be set by the user of a plugin, the plugin can later use the actual values a user has set
	 * These are settings specific to a specific user of the plugin
	 */
	ObjectDefinition getUserSettingsDefinition();

	/**
	 * @return An object with the definition of a set of properties that can be set by the (system) user of a plugin, the plugin can later use the actual values a user has set
	 * These are settings specific to the plugin
	 */
	ObjectDefinition getSystemSettingsDefinition();
	
	/**
	 * @return Returns the type of plugin, should be implemented by all underlying interfaces, and not by the actual plugins
	 */
	SPluginType getPluginType();
}