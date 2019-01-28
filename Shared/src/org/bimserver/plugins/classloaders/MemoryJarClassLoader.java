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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemoryJarClassLoader extends JarClassLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemoryJarClassLoader.class);
	private final File jarFile;
	private final Map<String, byte[]> map = new HashMap<String, byte[]>();
	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();

	public MemoryJarClassLoader(ClassLoader parentClassLoader, File jarFile) throws FileNotFoundException, IOException {
		super(parentClassLoader);
		this.jarFile = jarFile;
		try (FileInputStream fileInputStream = new FileInputStream(jarFile)) {
			try (JarInputStream jarInputStream = new JarInputStream(fileInputStream)) {
				JarEntry entry = jarInputStream.getNextJarEntry();
				while (entry != null) {
					if (entry.getName().endsWith(".jar")) {
						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						IOUtils.copy(jarInputStream, byteArrayOutputStream);
						
						// Not storing the original JAR, so future code will be unable to read the original
						loadSubJars(byteArrayOutputStream.toByteArray());
					} else {
						// Files are being stored deflated in memory because most of the time a lot of files are not being used (or the complete plugin is not being used)
						addDataToMap(jarInputStream, entry);
					}
					entry = jarInputStream.getNextJarEntry();
				}
			}
		}
	}

	private void addDataToMap(JarInputStream jarInputStream, JarEntry entry) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
		IOUtils.copy(jarInputStream, deflaterOutputStream);
		deflaterOutputStream.finish();
		map.put(entry.getName(), byteArrayOutputStream.toByteArray());
	}

	private void loadSubJars(byte[] byteArray) {
		try {
			JarInputStream jarInputStream = new JarInputStream(new ByteArrayInputStream(byteArray));
			JarEntry entry = jarInputStream.getNextJarEntry();
			while (entry != null) {
				addDataToMap(jarInputStream, entry);
				entry = jarInputStream.getNextJarEntry();
			}
			jarInputStream.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public URL findResource(final String name) {
		if (map.containsKey(name)) {
			try {
				return new URL(new URL("jar:" + jarFile.toURI().toURL() + "!/" + name), name, new URLStreamHandler() {
					@Override
					protected URLConnection openConnection(URL u) throws IOException {
						return new URLConnection(u) {
							@Override
							public void connect() throws IOException {
							}

							@Override
							public InputStream getInputStream() throws IOException {
								return new InflaterInputStream(new ByteArrayInputStream(map.get(name)));
							}
						};
					}
				});
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = name.replace(".", "/") + ".class";
		if (loadedClasses.containsKey(fileName)) {
			return loadedClasses.get(fileName);
		}
		if (map.containsKey(fileName)) {
			byte[] bs = map.get(fileName);
			InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bs));
			ByteArrayOutputStream uncompressed = new ByteArrayOutputStream();
			try {
				IOUtils.copy(inflaterInputStream, uncompressed);
			} catch (IOException e) {
				LOGGER.error("", e);
			}
			byte[] byteArray = uncompressed.toByteArray();
			Class<?> defineClass = defineClass(name, byteArray, 0, byteArray.length);
			loadedClasses.put(fileName, defineClass);

			/*
			 * This is a fix to actually load the package-info.class file with
			 * the annotations about for example namespaces required for JAXB to
			 * work. Found this code here:
			 * https://issues.jboss.org/browse/JBPM-1404
			 */
			if (defineClass != null) {
				final int packageIndex = name.lastIndexOf('.');
				if (packageIndex != -1) {
					final String packageName = name.substring(0, packageIndex);
					final Package classPackage = getPackage(packageName);
					if (classPackage == null) {
						definePackage(packageName, null, null, null, null, null, null, null);
					}
				}
			}
			
			// The original class file cannot be loaded for other purposes after this (would be strange), this saves memory
			map.remove(fileName);
			
			return defineClass;
		}
		throw new ClassNotFoundException(name);
	}

	@Override
	public void dumpStructure(int indent) {
		System.out.print(StringUtils.gen("  ", indent));
		System.out.println("MemoryClassLoader");
	}
}