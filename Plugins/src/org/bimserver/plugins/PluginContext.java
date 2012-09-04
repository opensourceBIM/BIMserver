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

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.ToolProvider;

public class PluginContext {

	private Plugin plugin;
	private String location;
	private boolean enabled = true;
	private final PluginManager pluginManager;
	private String classLocation;
	private final PluginType pluginType;
	private JavaFileManager javaFileManager;
	private final ClassLoader classLoader;

	public PluginContext(PluginManager pluginManager, ClassLoader classLoader, PluginType pluginType) {
		this.pluginManager = pluginManager;
		this.classLoader = classLoader;
		this.pluginType = pluginType;
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

	public ClassLoader getClassLoader() {
		return plugin.getClass().getClassLoader();
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
			VirtualFile fromJar = VirtualFile.fromJar(new File(location));
			this.javaFileManager = new VirtualFileManager(systemJavaCompiler.getStandardFileManager(null, null, null), classLoader, fromJar);
			break;
		default:
			break;
		}
		return javaFileManager;
	}
}