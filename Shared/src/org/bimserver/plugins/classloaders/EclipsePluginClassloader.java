package org.bimserver.plugins.classloaders;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EclipsePluginClassloader extends ClassLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(EclipsePluginClassloader.class);
	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();
	private final File projectFolder;
	private final File classFolder;

	public EclipsePluginClassloader(ClassLoader parentClassloader, File projectFolder) {
		super(parentClassloader);
		this.projectFolder = projectFolder;
		this.classFolder = new File(projectFolder, "bin");
	}
	
	@Override
	public String toString() {
		return "EclipsePluginClassLoader: " + projectFolder.getAbsolutePath();
	}

	@Override
	public URL getResource(String name) {
		return findResource(name);
	}
	
	@Override
	protected URL findResource(String name) {
		File file = new File(projectFolder, name);
		if (file.exists()) {
			try {
				return file.toURI().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String filename = name.replace(".", File.separator) + ".class";
		if (loadedClasses.containsKey(filename)) {
			return loadedClasses.get(filename);
		}
		File classFile = new File(classFolder, filename);
		if (classFile.isFile()) {
			try {
				byte[] bytes = FileUtils.readFileToByteArray(classFile);
				Class<?> definedClass = defineClass(name, bytes, 0, bytes.length);
				if (definedClass != null) {
					loadedClasses.put(filename, definedClass);
					return definedClass;
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		throw new ClassNotFoundException(name);
	}
}