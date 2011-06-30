package org.bimserver;

import java.io.File;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;

public class LocalDevPluginLoader {
	public static PluginManager createPluginManager() throws PluginException {
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		PluginManager pluginManager = new PluginManager(resourceFetcher, null, null);
		pluginManager.loadPluginsFromEclipseProject(new File("../IFCEngine"));
		pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
		pluginManager.loadPluginsFromEclipseProject(new File("../IfcPlugins"));
		pluginManager.loadPluginsFromEclipseProject(new File("../CityGML"));
		pluginManager.loadPlugin(GuidanceProviderPlugin.class, "Internal", new SchemaFieldGuidanceProviderPlugin());
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}
