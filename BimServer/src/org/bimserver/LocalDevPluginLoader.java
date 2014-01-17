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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDevPluginLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevPluginLoader.class);
	
	public static void loadPlugins(PluginManager pluginManager, File current, File gitDirectory) throws PluginException {
		LOGGER.info("Loading plugins from " + current.getAbsolutePath());
		pluginManager.loadAllPluginsFromEclipseWorkspace(current);
		
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File("E:\\Workspaces\\BIMserver\\Myplugins"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File("E:\\Workspaces\\BIMserver\\IfcOpenShellPlugin"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "bimql\\BimQL"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "bimvie.ws"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "BIMSie2\\BIMsie"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "BIMsurfer3"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "RGDChecker"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "WebGL-threeJS\\ServerPlugin"));
		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "StatsbyggValidator\\StatsbyggValidator"));
//		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "COBie-plugins\\COBiePlugins_Public"));
//		pluginManager.loadPluginsFromEclipseProjectNoExceptions(new File(gitDirectory, "COBie-plugins\\COBiePlugins_Public"));
//		pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
//		pluginManager.loadPluginsFromJar(new File("../Builds/plugins/jqe.jar"));
	}
	
	public static PluginManager createPluginManager(File home) throws PluginException {
		return createPluginManager(home, new File(".."));
	}
	
	public static PluginManager createPluginManager(File home, File current) throws PluginException {
		if (!home.exists()) {
			home.mkdir();
		}
		PluginManager pluginManager = new PluginManager(new File(home, "tmp"), System.getProperty("java.class.path"), null, null, null);
		loadPlugins(pluginManager, current, current);
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}
