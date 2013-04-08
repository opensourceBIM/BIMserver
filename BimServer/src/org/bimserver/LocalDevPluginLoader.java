package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
		pluginManager.loadAllPluginsFromEclipseWorkspace(new File(".."));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File("C:\\Users\\Ruben de Laat\\git\\bimql\\BimQL"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File("C:\\Users\\Ruben\\git\\BootstrapBIM\\BootstrapBIM"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File("C:\\Users\\Ruben\\git\\BIMsurfer"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File("C:\\Users\\Ruben\\git\\RGDChecker"));
//		pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
//		pluginManager.loadPluginsFromJar(new File("../Builds/plugins/jqe.jar"));
	}
	
	public static void loadIfExists(PluginManager pluginManager, File file) {
		try {
			pluginManager.loadPluginsFromEclipseProject(file);
		} catch (PluginException e) {
		}
	}
	
	public static PluginManager createPluginManager(File home) throws PluginException {
		if (!home.exists()) {
			home.mkdir();
		}
		PluginManager pluginManager = new PluginManager(new File(home, "tmp"), System.getProperty("java.class.path"), null, null, null);
		loadPlugins(pluginManager);
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}
