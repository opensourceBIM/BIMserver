package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
import java.util.List;

import org.bimserver.models.store.Parameter;
import org.bimserver.shared.exceptions.PluginException;

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
	private List<Dependency> dependencies;
	private PluginBundle pluginBundle;
	private String description;
	private boolean initialized;
	private Class<?> pluginInterface;
	private String identifier;

	public PluginContext(PluginManagerInterface pluginManager, PluginBundle pluginBundle, Class<?> pluginInterface, ClassLoader classLoader, PluginSourceType pluginType, String description, URI location, Plugin plugin, PluginImplementation pluginImplementation, String classLocation, List<Dependency> dependencies, String identifier2) throws IOException {
		this.pluginManager = pluginManager;
		this.pluginBundle = pluginBundle;
		this.pluginInterface = pluginInterface;
		this.classLoader = classLoader;
		this.pluginType = pluginType;
		this.description = description;
		this.location = location;
		this.plugin = plugin;
		this.pluginImplementation = pluginImplementation;
		this.classLocation = classLocation;
		this.dependencies = dependencies;
		identifier = identifier2;

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

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public PluginBundle getPluginBundle() {
		return pluginBundle;
	}

	public String getDescription() {
		return description;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public String getVersion() {
		// All plugins in a bundle have the same version
		return pluginBundle.getVersion();
	}

	public Class<?> getPluginInterface() {
		return pluginInterface;
	}

	public void initialize() throws PluginException {
		if (!isInitialized()) {
			plugin.init(pluginManager);
			setInitialized(true);
		}
	}

	public String getIdentifier() {
		return identifier;
	}
}