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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.ToolProvider;

import org.bimserver.models.store.Parameter;
import org.bimserver.plugins.web.WebModulePlugin;

public class PluginContext {

	private final PluginManager pluginManager;
	private final ClassLoader classLoader;
	private final PluginSourceType pluginType;
	private final String location;
	private final Plugin plugin;
	private final PluginImplementation pluginImplementation;
	private final String classLocation;
	private boolean enabled = true;
	private JavaFileManager javaFileManager;
	private FileSystem filesystem;
	private Path rootPath;

	public PluginContext(PluginManager pluginManager, ClassLoader classLoader, PluginSourceType pluginType, String location, Plugin plugin, PluginImplementation pluginImplementation, String classLocation) throws IOException {
		this.pluginManager = pluginManager;
		this.classLoader = classLoader;
		this.pluginType = pluginType;
		this.location = location;
		this.plugin = plugin;
		this.pluginImplementation = pluginImplementation;
		this.classLocation = classLocation;
		switch (pluginType) {
		case ECLIPSE_PROJECT:
			filesystem = FileSystems.getDefault();
			rootPath = filesystem.getPath(location);
			break;
		case INTERNAL:
			break;
		case JAR_FILE:
			URI uri = URI.create("jar:file:/" + location.replace("\\", "/"));
			System.out.println(uri);
			Map<String, String> env = new HashMap<>();
			env.put("create", "true");
			filesystem = FileSystems.newFileSystem(uri, env, null);
			rootPath = filesystem.getPath("/");
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

	public String getLocation() {
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

	public InputStream getResourceAsInputStream(String name) throws FileNotFoundException {
		InputStream resourceAsStream = classLoader.getResourceAsStream(name);
		if (resourceAsStream == null) {
			File file = new File(location + File.separator + name);
			if (file.exists()) {
				resourceAsStream = new FileInputStream(file);
			}
		}
		if (resourceAsStream == null && !pluginImplementation.getRequires().isEmpty()) {
			for (String dep : pluginImplementation.getRequires()) {
				WebModulePlugin webModulePlugin = pluginManager.getWebModulePlugin(dep, true);
				InputStream resourceAsInputStream = pluginManager.getPluginContext(webModulePlugin).getResourceAsInputStream(name);
				if (resourceAsInputStream != null) {
					return resourceAsInputStream;
				}
			}
		}
		return resourceAsStream;
	}

	public URL getResourceAsUrl(String name) {
		return classLoader.getResource(name);
	}

	public String getClassLocation() {
		return classLocation;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public JavaFileManager getFileManager() {
		JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
		if (systemJavaCompiler == null) {
			throw new RuntimeException("JDK needed");
		}
		switch (pluginType) {
		case ECLIPSE_PROJECT:
			this.javaFileManager = new EclipseProjectPluginFileManager(systemJavaCompiler.getStandardFileManager(null, null, null), classLoader, new File(location, "bin"));
			break;
		case INTERNAL:
			this.javaFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
			break;
		case JAR_FILE:
			this.javaFileManager = new VirtualFileManager2(systemJavaCompiler.getStandardFileManager(null, null, null), classLoader, filesystem, rootPath);
			break;
		default:
			break;
		}
		return javaFileManager;
	}

	public Path getRootPath() {
		return rootPath;
	}
	
	public FileSystem getFilesystem() {
		return filesystem;
	}

	public Parameter getParameter(String name) {
		return pluginManager.getParameter(this, name);
	}
	
	public PluginImplementation getPluginImplementation() {
		return pluginImplementation;
	}
}