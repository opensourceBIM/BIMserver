package org.bimserver.plugins;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.models.store.Parameter;

public class PluginContext {

	private final PluginManager pluginManager;
	private final ClassLoader classLoader;
	private final PluginSourceType pluginType;
	private final URI location;
	private final Plugin plugin;
	private final PluginImplementation pluginImplementation;
	private final String classLocation;
	private boolean enabled = true;
	private FileSystem fileSystem;
	private Path rootPath;

	public PluginContext(PluginManager pluginManager, ClassLoader classLoader, PluginSourceType pluginType, URI location, Plugin plugin, PluginImplementation pluginImplementation, String classLocation) throws IOException {
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