package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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