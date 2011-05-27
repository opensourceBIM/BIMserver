package org.bimserver.shared;

import java.net.URI;
import java.util.Collection;

import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import net.xeoh.plugins.base.util.PluginManagerUtil;

import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BimPluginManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimPluginManager.class);
	private PluginManager pluginManager;

	public BimPluginManager() {
		pluginManager = PluginManagerFactory.createPluginManager();
	}

	public void loadPlugins(URI uri) {
		pluginManager.addPluginsFrom(uri);
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