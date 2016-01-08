package org.bimserver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.PluginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDevPluginLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevPluginLoader.class);
	
	public static void loadPlugins(PluginManager pluginManager, Path[] pluginDirectories) throws PluginException {
		if (pluginDirectories != null) {
			for (Path pluginDirectory : pluginDirectories) {
				try {
					pluginManager.loadAllPluginsFromEclipseWorkspaces(pluginDirectory, false);
				} catch (PluginException e) {
					LOGGER.error("", e);
				} catch (IOException e) {
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
		PluginManager pluginManager = new PluginManager(home.resolve("tmp"), System.getProperty("java.class.path"), null, null, null);
		loadPlugins(pluginManager, pluginDirectories);
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}