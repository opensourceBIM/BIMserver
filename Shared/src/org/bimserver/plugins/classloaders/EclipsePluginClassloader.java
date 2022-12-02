package org.bimserver.plugins.classloaders;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EclipsePluginClassloader extends PublicFindClassClassLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(EclipsePluginClassloader.class);
	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();
	private final Path projectFolder;
	private final Path classFolder;

	public EclipsePluginClassloader(ClassLoader parentClassloader, Path projectFolder) {
		super(parentClassloader);
		this.projectFolder = projectFolder;
		this.classFolder = projectFolder.resolve("target/classes");
	}
	
	@Override
	public String toString() {
		return "EclipsePluginClassLoader: " + projectFolder.toString();
	}

	@Override
	public URL getResource(String name) {
		return findResource(name);
	}
	
	@Override
	public URL findResource(String name) {
		Path file = projectFolder.resolve(name);
		if (Files.exists(file)) {
			try {
				return file.toUri().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	@Override
	public Enumeration<URL> findResources(String name) {
		URL resource = findResource(name);
		return resource==null ? Collections.emptyEnumeration() : Collections.enumeration(Collections.singletonList(resource));
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		String filename = name.replace(".", File.separator) + ".class";
		if (loadedClasses.containsKey(filename)) {
			return loadedClasses.get(filename);
		}
		Path classFile = classFolder.resolve(filename);
		if (Files.exists(classFile)) {
			try {
				byte[] bytes = null;
				try (InputStream newInputStream = Files.newInputStream(classFile)) {
					bytes = IOUtils.toByteArray(newInputStream);
				}
				Class<?> definedClass = defineClass(name, bytes, 0, bytes.length);
				if (definedClass != null) {
					loadedClasses.put(filename, definedClass);
					
					/*
					 * This is a fix to actually load the package-info.class file with
					 * the annotations about for example namespaces required for JAXB to
					 * work. Found this code here:
					 * https://issues.jboss.org/browse/JBPM-1404
					 */
					if (definedClass != null) {
						final int packageIndex = name.lastIndexOf('.');
						if (packageIndex != -1) {
							final String packageName = name.substring(0, packageIndex);
							final Package classPackage = getPackage(packageName);
							if (classPackage == null) {
								definePackage(packageName, null, null, null, null, null, null, null);
							}
						}
					}				
					
					return definedClass;
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		throw new ClassNotFoundException(name);
	}

	public void dumpStructure(int indent) {
		System.out.print(StringUtils.gen("  ", indent));
		System.out.println("EclipsePluginClassloader " + projectFolder);
		ClassLoader parentLoader = getParent();
		if (parentLoader instanceof DelegatingClassLoader) {
			DelegatingClassLoader delegatingClassLoader = (DelegatingClassLoader)parentLoader;
			delegatingClassLoader.dumpStructure(indent + 1);
		}
	}
}