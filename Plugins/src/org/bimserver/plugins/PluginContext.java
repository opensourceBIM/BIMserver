package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public void setEnabled(boolean enabled, boolean notify) {
		this.enabled = enabled;
		if (notify) {
			pluginManager.notifyPluginStateChange(this, enabled);
		}
	}

	public boolean isEnabled() {
		return enabled;
	}

	public InputStream getResourceAsInputStream(String name) {
		InputStream resourceAsStream = plugin.getClass().getClassLoader().getResourceAsStream(name);
		if (resourceAsStream == null) {
			File file = new File(location + File.separator + name);
			if (file.exists()) {
				try {
					return new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return resourceAsStream;
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