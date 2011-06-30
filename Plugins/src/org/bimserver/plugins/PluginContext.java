package org.bimserver.plugins;

import java.io.InputStream;

public class PluginContext {

	private Plugin plugin;
	private String location;
	private boolean enabled = true;
	private final PluginManager pluginManager;

	public PluginContext(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
	}
	
	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		pluginManager.notifyPluginStateChange(this, enabled);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public InputStream getResourceAsInputStream(String name) {
		return plugin.getClass().getClassLoader().getResourceAsStream(name);
	}
}