package org.bimserver;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.io.File;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;

public class LocalDevPluginLoader {
	public static void loadPlugins(PluginManager pluginManager) throws PluginException {
		pluginManager.loadPluginsFromEclipseProject(new File("../CityGML"));
		pluginManager.loadPluginsFromEclipseProject(new File("../Collada"));
		pluginManager.loadPluginsFromEclipseProject(new File("../SceneJS"));
		pluginManager.loadPluginsFromEclipseProject(new File("../IfcPlugins"));
		pluginManager.loadPluginsFromEclipseProject(new File("../MiscSerializers"));
		pluginManager.loadPluginsFromEclipseProject(new File("../IfcEngine"));
		pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
		pluginManager.loadPluginsFromEclipseProject(new File("../FileBasedGuidanceProvider"));
		pluginManager.loadPluginsFromEclipseProject(new File("../Report1Serializer"));
		try {
			pluginManager.loadPluginsFromEclipseProject(new File("C:\\Users\\Ruben de Laat\\git\\BIMserver\\DeserializerExample"));
			pluginManager.loadPluginsFromEclipseProject(new File("C:\\Users\\Ruben de Laat\\git\\BIMserver\\SerializerExample"));
		} catch (PluginException e) {
		}
	}
	
	public static PluginManager createPluginManager() throws PluginException {
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		PluginManager pluginManager = new PluginManager(resourceFetcher, new File("home"), null);
		loadPlugins(pluginManager);
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}
