package org.bimserver.plugins;

import java.util.Set;

public interface Plugin {
	void init(PluginManager pluginManager) throws PluginException;
	String getName();
	String getDescription();
	String getVersion();
	boolean isInitialized();
	Set<Class<? extends Plugin>> getRequiredPlugins();
}