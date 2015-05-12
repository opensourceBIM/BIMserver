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
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.ToolProvider;

import org.bimserver.models.store.Parameter;
import org.bimserver.plugins.web.WebModulePlugin;

public class PluginContext {

	private Plugin plugin;
	private String location;
	private boolean enabled = true;
	private final PluginManager pluginManager;
	private String classLocation;
	private final PluginSourceType pluginType;
	private JavaFileManager javaFileManager;
	private final ClassLoader classLoader;
	private VirtualFile virtualFile;
	private PluginImplementation pluginImplementation;

	public PluginContext(PluginManager pluginManager, ClassLoader classLoader, PluginSourceType pluginType, String location) throws IOException {
		this.pluginManager = pluginManager;
		this.classLoader = classLoader;
		this.pluginType = pluginType;
		this.location = location;
		switch (pluginType) {
		case ECLIPSE_PROJECT:
			virtualFile = VirtualFile.fromDirectory(new File(location));
			break;
		case INTERNAL:
			break;
		case JAR_FILE:
			virtualFile = VirtualFile.fromJar(new File(location));
			break;
		default:
			break;
		}
	}
	
	public PluginSourceType getPluginType() {
		return pluginType;
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

	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
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
			this.javaFileManager = new VirtualFileManager(systemJavaCompiler.getStandardFileManager(null, null, null), classLoader, virtualFile);
			break;
		default:
			break;
		}
		return javaFileManager;
	}

	public Collection<VirtualFile> listResources(String path) {
		List<VirtualFile> urls = new ArrayList<VirtualFile>();
		switch (pluginType) {
		case ECLIPSE_PROJECT: {
			VirtualFile folder = virtualFile.get(path);
			if (folder != null) {
				return folder.listFiles();
			}
			break;
		}
		case INTERNAL:
			// Not supported yet
			break;
		case JAR_FILE: {
			VirtualFile folder = virtualFile.get(path);
			if (folder != null) {
				return folder.listFiles();
			}
			break;
		}
		default:
			break;
		}
		return urls;
	}
	
	public Parameter getParameter(String name) {
		return pluginManager.getParameter(this, name);
	}

	public void setConfig(PluginImplementation pluginImplementation) {
		this.pluginImplementation = pluginImplementation;
	}
	
	public PluginImplementation getPluginImplementation() {
		return pluginImplementation;
	}
}