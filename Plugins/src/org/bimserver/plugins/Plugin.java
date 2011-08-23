package org.bimserver.plugins;

public interface Plugin {
	void init(PluginManager pluginManager) throws PluginException;
	String getName();
	String getDescription();
	String getVersion();
	boolean isInitialized();
}