package org.bimserver.plugins.classloaders;

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

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileJarClassLoader extends JarClassLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileJarClassLoader.class);
	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();
	private Path tempDir;
	private Path jarFile;

	public FileJarClassLoader(ClassLoader parentClassLoader, Path jarFile, Path tempDir) throws FileNotFoundException, IOException {
		super(parentClassLoader);
		this.jarFile = jarFile;
		InputStream is = Files.newInputStream(jarFile);
		try {
			String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
			this.tempDir = tempDir.resolve(md5);
 		} finally {
 			is.close();
 		}
		
		if (Files.exists(this.tempDir)) {
			// This exact file has been extracted before, do nothing
			return;
		}
		Files.createDirectories(this.tempDir);
		
		InputStream inputStream = Files.newInputStream(jarFile);
		try {
			JarInputStream jarInputStream = new JarInputStream(inputStream);
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
		} finally {
			inputStream.close();
		}
	}

	private void addDataToMap(JarInputStream jarInputStream, JarEntry entry) throws IOException {
		Path file = tempDir.resolve(entry.getName());
		if (!Files.exists(file.getParent())) {
			Files.createDirectories(file.getParent());
		}
		OutputStream outputStream = Files.newOutputStream(file);
		try {
			IOUtils.copy(jarInputStream, outputStream);
		} finally {
			outputStream.close();
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
		final Path file = tempDir.resolve(name);
		if (!Files.exists(file)) {
			return null;
		}
		try {
			return new URL(new URL("file:" + this.tempDir.toAbsolutePath().toString() + "/" + name), name, new URLStreamHandler() {
				@Override
				protected URLConnection openConnection(URL u) throws IOException {
					return new URLConnection(u) {
						@Override
						public void connect() throws IOException {
						}

						@Override
						public InputStream getInputStream() throws IOException {
							return Files.newInputStream(file);
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
			Path file = tempDir.resolve(fileName);
			if (!Files.exists(file)) {
				throw new ClassNotFoundException();
			}
			InputStream inputStream = Files.newInputStream(file);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			try {
				IOUtils.copy(inputStream, byteArrayOutputStream);
			} finally {
				inputStream.close();
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

	@Override
	public void dumpStructure(int indent) {
		System.out.print(StringUtils.gen("  ", indent));
		System.out.println("FileJarClassLoader " + jarFile.getFileName().toString());
	}
}