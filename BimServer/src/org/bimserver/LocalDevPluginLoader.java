package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

public class LocalDevPluginLoader {
	public static void loadPlugins(PluginManager pluginManager) throws PluginException {
		pluginManager.loadPluginsFromEclipseProject(new File("../IfcEngine"));
//		pluginManager.loadPluginsFromEclipseProject(new File("../CityGML"));
		pluginManager.loadPluginsFromEclipseProject(new File("../Collada"));
		pluginManager.loadPluginsFromEclipseProject(new File("../SceneJS"));
		pluginManager.loadPluginsFromEclipseProject(new File("../IfcPlugins"));
		pluginManager.loadPluginsFromEclipseProject(new File("../MiscSerializers"));
		pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
		pluginManager.loadPluginsFromEclipseProject(new File("../FileBasedObjectIDM"));
		pluginManager.loadPluginsFromEclipseProject(new File("../Report1Serializer"));
		loadIfExists(pluginManager, new File("C:\\Users\\Ruben de Laat\\git\\COBie-plugins"));
		loadIfExists(pluginManager, new File("../IfcOpenShellPlugin"));
		loadIfExists(pluginManager, new File("../geobim"));
	}
	
	private static void loadIfExists(PluginManager pluginManager, File file) {
		try {
			pluginManager.loadPluginsFromEclipseProject(file);
		} catch (PluginException e) {
		}
	}
	
	public static PluginManager createPluginManager() throws PluginException {
		PluginManager pluginManager = new PluginManager(new File("home"), System.getProperty("java.class.path"));
		loadPlugins(pluginManager);
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}
