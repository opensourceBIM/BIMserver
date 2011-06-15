package org.bimserver.plugins;

public interface PluginChangeListener {
	void pluginStateChanged(PluginContext pluginContext, boolean enabled);
}