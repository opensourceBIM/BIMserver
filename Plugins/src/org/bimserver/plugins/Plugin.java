package org.bimserver.plugins;

public interface Plugin {
	void init(PluginManager pluginManager);
	String getName();
	String getDescription();
	String getVersion();
}