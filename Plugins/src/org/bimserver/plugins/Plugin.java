package org.bimserver.plugins;

public interface Plugin {
	void init(PluginManager pluginManager) throws PluginException;
	String getDescription();
	String getVersion();
	boolean isInitialized();
}