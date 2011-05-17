package org.bimserver.shared;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import net.xeoh.plugins.base.options.addpluginsfrom.OptionReportAfter;
import net.xeoh.plugins.base.util.PluginManagerUtil;

import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BimPluginManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimPluginManager.class);
	private PluginManager pluginManager;

	public BimPluginManager() {
	}

	public void start() {
		pluginManager = PluginManagerFactory.createPluginManager();
//		try {
//			pluginManager.addPluginsFrom(new URI("classpath://*"));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
		pluginManager.addPluginsFrom(new File("../BimServer/bin").toURI());
		pluginManager.addPluginsFrom(new File("../CityGML/bin").toURI());
		pluginManager.addPluginsFrom(new File("../Collada/bin").toURI());
		pluginManager.addPluginsFrom(new File("../Ifc/bin").toURI());
		pluginManager.addPluginsFrom(new File("../O3d/bin").toURI());
	}

	public Collection<SerializerPlugin> getAllSerializerPlugins() {
		PluginManagerUtil pluginManagerUtil = new PluginManagerUtil(pluginManager);
		Collection<SerializerPlugin> plugins = pluginManagerUtil.getPlugins(SerializerPlugin.class);
		return plugins;
	}

	public Collection<IfcEnginePlugin> getIfcPlugins() {
		PluginManagerUtil pluginManagerUtil = new PluginManagerUtil(pluginManager);
		Collection<IfcEnginePlugin> plugins = pluginManagerUtil.getPlugins(IfcEnginePlugin.class);
		return plugins;
	}
}