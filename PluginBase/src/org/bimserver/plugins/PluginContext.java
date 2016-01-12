package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.models.store.Parameter;

public class PluginContext {

	private final PluginManagerInterface pluginManager;
	private final ClassLoader classLoader;
	private final PluginSourceType pluginType;
	private final URI location;
	private final Plugin plugin;
	private final PluginImplementation pluginImplementation;
	private final String classLocation;
	private boolean enabled = true;
	private FileSystem fileSystem;
	private Path rootPath;

	public PluginContext(PluginManagerInterface pluginManager, ClassLoader classLoader, PluginSourceType pluginType, URI location, Plugin plugin, PluginImplementation pluginImplementation, String classLocation) throws IOException {
		this.pluginManager = pluginManager;
		this.classLoader = classLoader;
		this.pluginType = pluginType;
		this.location = location;
		this.plugin = plugin;
		this.pluginImplementation = pluginImplementation;
		this.classLocation = classLocation;
		switch (pluginType) {
		case ECLIPSE_PROJECT:
			fileSystem = FileSystems.getDefault();
			rootPath = Paths.get(location);
			break;
		case INTERNAL:
			break;
		case JAR_FILE:
			fileSystem = pluginManager.getOrCreateFileSystem(location);
			rootPath = fileSystem.getPath("/");
			break;
		default:
			break;
		}
	}
	
	public PluginSourceType getPluginType() {
		return pluginType;
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public URI getLocation() {
		return location;
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

	public String getClassLocation() {
		return classLocation;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public Path getRootPath() {
		return rootPath;
	}
	
	public Parameter getParameter(String name) {
		return pluginManager.getParameter(this, name);
	}
	
	public PluginImplementation getPluginImplementation() {
		return pluginImplementation;
	}
}