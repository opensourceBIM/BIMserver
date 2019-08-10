package org.bimserver;

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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.plugins.MavenPluginRepository;
import org.bimserver.plugins.PluginBundleManager;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.PluginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDevPluginLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevPluginLoader.class);
	
	public static void loadPlugins(PluginBundleManager pluginBundleManager, Path[] pluginDirectories) throws PluginException {
		if (pluginDirectories != null) {
			for (Path pluginDirectory : pluginDirectories) {
				try {
					pluginBundleManager.loadPluginsFromEclipseProject(pluginDirectory);
				} catch (PluginException e) {
					LOGGER.error("", e);
				}
			}
		}
	}
	
	public static PluginManager createPluginManager(Path home) throws PluginException {
		return createPluginManager(home, null);
	}
	
	public static PluginManager createPluginManager(Path home, Path[] pluginDirectories) throws PluginException {
		if (!Files.exists(home)) {
			try {
				Files.createDirectories(home);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		MavenPluginRepository mavenPluginRepository = new MavenPluginRepository();
		PluginManager pluginManager = new PluginManager(home.resolve("tmp"), System.getProperty("java.class.path"), null, null, null, null);
		PluginBundleManager pluginBundleManager = new PluginBundleManager(pluginManager, mavenPluginRepository, home.resolve("plugins"));
		loadPlugins(pluginBundleManager, pluginDirectories);
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}