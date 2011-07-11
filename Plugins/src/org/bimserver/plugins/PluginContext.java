package org.bimserver.plugins;

import java.io.InputStream;
import java.net.URL;

public class PluginContext {

	private Plugin plugin;
	private String location;
	private boolean enabled = true;
	private final PluginManager pluginManager;
	private String classLocation;

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

	public URL getResourceAsUrl(String name) {
		return plugin.getClass().getClassLoader().getResource(name);
	}
	
	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}
	
	public String getClassLocation() {
		return classLocation;
	}
}