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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileJarClassLoader extends JarClassLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileJarClassLoader.class);
	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();
	private File tempDir;

	public FileJarClassLoader(ClassLoader parentClassLoader, File jarFile, File tempDir) throws FileNotFoundException, IOException {
		super(parentClassLoader);
		FileInputStream fis = new FileInputStream(jarFile);
		try {
			String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
			this.tempDir = new File(tempDir, md5);
 		} finally {
 			fis.close();
 		}
		
		if (this.tempDir.exists()) {
			// This exact file has been extracted before, do nothing
			return;
		}
		this.tempDir.mkdir();
		
		JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarFile));
		JarEntry entry = jarInputStream.getNextJarEntry();
		while (entry != null) {
			if (entry.getName().endsWith(".jar")) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				IOUtils.copy(jarInputStream, byteArrayOutputStream);

				// Not storing the original JAR, so future code will be unable to read the original
				loadSubJars(byteArrayOutputStream.toByteArray());
			} else {
				if (!entry.isDirectory()) {
					addDataToMap(jarInputStream, entry);
				}
			}
			entry = jarInputStream.getNextJarEntry();
		}
		jarInputStream.close();
	}

	private void addDataToMap(JarInputStream jarInputStream, JarEntry entry) throws IOException {
		File file = new File(tempDir, entry.getName());
		if (!file.getParentFile().exists()) {
			FileUtils.forceMkdir(file.getParentFile());
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		try {
			IOUtils.copy(jarInputStream, fileOutputStream);
		} finally {
			fileOutputStream.close();
		}
	}

	private void loadSubJars(byte[] byteArray) {
		try {
			JarInputStream jarInputStream = new JarInputStream(new ByteArrayInputStream(byteArray));
			JarEntry entry = jarInputStream.getNextJarEntry();
			while (entry != null) {
				if (!entry.isDirectory()) {
					addDataToMap(jarInputStream, entry);
				}
				entry = jarInputStream.getNextJarEntry();
			}
			jarInputStream.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public URL findResource(final String name) {
		final File file = new File(tempDir, name);
		if (!file.exists()) {
			return null;
		}
		try {
			return new URL(new URL("file:" + this.tempDir.getAbsolutePath() + "/" + name), name, new URLStreamHandler() {
				@Override
				protected URLConnection openConnection(URL u) throws IOException {
					return new URLConnection(u) {
						@Override
						public void connect() throws IOException {
						}

						@Override
						public InputStream getInputStream() throws IOException {
							return new FileInputStream(file);
						}
					};
				}
			});
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = name.replace(".", "/") + ".class";
		if (loadedClasses.containsKey(fileName)) {
			return loadedClasses.get(fileName);
		}
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(tempDir, fileName));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			try {
				IOUtils.copy(fileInputStream, byteArrayOutputStream);
			} finally {
				fileInputStream.close();
			}
			Class<?> defineClass = defineClass(name, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length);
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
			return defineClass;
		} catch (FileNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (IOException e) {
			throw new ClassNotFoundException();
		}
	}
}