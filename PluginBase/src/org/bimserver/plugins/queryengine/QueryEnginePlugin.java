package org.bimserver.plugins.queryengine;

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

import java.util.Collection;

import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.shared.exceptions.PluginException;

public interface QueryEnginePlugin extends Plugin {

	/**
	 * @return A usable QueryEngine implementation
	 */
	QueryEngine getQueryEngine(PluginConfiguration pluginConfiguration) throws PluginException;
	
	/**
	 * @return Return a list of keys (usually file names) corresponding to code examples for this plugin
	 */
	Collection<String> getExampleKeys();
	
	/**
	 * @param key
	 * @return Return the code example for the given key
	 */
	String getExample(String key);
	
	@Override
	default SPluginType getPluginType() {
		return SPluginType.QUERY_ENGINE;
	}
}