package org.bimserver;

import java.io.File;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;

public class LocalDevPluginLoader {
	public static void loadPlugins(PluginManager pluginManager) throws PluginException {
		pluginManager.loadPluginsFromEclipseProject(new File("../CityGML"));
		pluginManager.loadPluginsFromEclipseProject(new File("../Collada"));
		pluginManager.loadPluginsFromEclipseProject(new File("../IfcPlugins"));
		pluginManager.loadPluginsFromEclipseProject(new File("../MiscSerializers"));
		pluginManager.loadPluginsFromEclipseProject(new File("../O3d"));
		pluginManager.loadPluginsFromEclipseProject(new File("../IFCEngine"));
		pluginManager.loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
		pluginManager.loadPluginsFromEclipseProject(new File("../FileBasedGuidanceProvider"));
		pluginManager.loadPluginsFromEclipseProject(new File("../Cobie2Serializer"));
		pluginManager.loadPluginsFromEclipseProject(new File("../Report1Serializer"));
	}
	
	public static PluginManager createPluginManager() throws PluginException {
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		PluginManager pluginManager = new PluginManager(resourceFetcher, null, null);
		loadPlugins(pluginManager);
		pluginManager.initAllLoadedPlugins();
		return pluginManager;
	}
}
