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
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bimserver.plugins.PluginManager;
import org.bimserver.utils.PathUtils;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileJarClassLoader extends JarClassLoader implements Closeable {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileJarClassLoader.class);
	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();
	private final Map<String, byte[]> jarContent = new HashMap<>();
	private final Path jarFile;
	private FileSystem fileSystem;
	private boolean embeddedJarFilesLoaded = false;

	public FileJarClassLoader(PluginManager pluginManager, ClassLoader parentClassLoader, Path jarFile) throws FileNotFoundException, IOException {
		super(parentClassLoader);
		this.jarFile = jarFile;
		URI uri = jarFile.toUri();
		try {
			URI x = new URI("jar:" + uri.toString());
			fileSystem = pluginManager.getOrCreateFileSystem(x);
		} catch (URISyntaxException e) {
			LOGGER.error("", e);
		}
	}

	private void loadEmbeddedJarFileSystems() {
		if (!embeddedJarFilesLoaded) {
			loadEmbeddedJarFileSystems(fileSystem.getPath("/"));
			embeddedJarFilesLoaded = true;
		}
	}
	
	private void loadEmbeddedJarFileSystems(Path path) {
		try {
			if (Files.isDirectory(path)) {
				for (Path subPath : PathUtils.list(path)) {
					if (!subPath.getFileName().toString().contentEquals("..")) {
						loadEmbeddedJarFileSystems(subPath);
					}
				}
			} else {
				// This is annoying, but we are caching the contents of JAR files within JAR files in memory, could not get the JarFileSystem to work with jar:jar:file URI's
				// Also there is a problem with not being able to change position within a file, at least in the JarFileSystem
				// It looks like there are 2 other solutions to this problem:
				// - Copy the embedded JAR files to a tmp directory, and load from there with a JarFileSystem wrapper (at some stage we were doing this for all JAR contents, 
				// resulted in 50.000 files, which was annoying, but a few JAR files probably won't hurt
				// - Don't allow plugins to have embedded JAR's, could force them to extract all dependencies...
				//
				if (path.getFileName().toString().toLowerCase().endsWith(".jar")) {
					try (InputStream newInputStream = Files.newInputStream(path)) {
						try (JarInputStream jarInputStream = new JarInputStream(newInputStream)) {
							JarEntry jarEntry = jarInputStream.getNextJarEntry();
							while (jarEntry != null) {
								jarContent.put(jarEntry.getName(), IOUtils.toByteArray(jarInputStream));
								jarEntry = jarInputStream.getNextJarEntry();
							}
						}
					}
				}
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public URL findResource(String name) {
		try {
			final Lazy<InputStream> lazyInputStream = findPath(name);
			if (lazyInputStream != null) {
				try {
					URL baseUrl = new URL("file:" + name);
					URL url = new URL(baseUrl, name, new URLStreamHandler() {
						@Override
						protected URLConnection openConnection(URL u) throws IOException {
							return new URLConnection(u) {
								@Override
								public void connect() throws IOException {
								}

								@Override
								public InputStream getInputStream() throws IOException {
									return lazyInputStream.get();
								}
							};
						}
					});
					return url;
				} catch (MalformedURLException e) {
					LOGGER.error("", e);
				}
			} else {
				LOGGER.debug("File not found: " + name + " (in " + jarFile.getFileName().toString() + ")");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private Lazy<InputStream> findPath(final String name) throws IOException {
		loadEmbeddedJarFileSystems();
		final Path file = this.fileSystem.getPath(name);
		if (Files.exists(file)) {
			return new Lazy<InputStream>(){
				@Override
				public InputStream get() {
					try {
						return Files.newInputStream(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}};
		}
		if (jarContent.containsKey(name)) {
			return new Lazy<InputStream>(){
				@Override
				public InputStream get() {
					return new ByteArrayInputStream(jarContent.get(name));
				}};
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
			Lazy<InputStream> lazyInputStream = findPath(fileName);
			if (lazyInputStream == null) {
				throw new ClassNotFoundException(name);
			}
			InputStream inputStream = lazyInputStream.get();
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
			throw new ClassNotFoundException(name);
		} catch (IOException e) {
			throw new ClassNotFoundException(name);
		}
	}

	@Override
	public void dumpStructure(int indent) {
		System.out.print(StringUtils.gen("  ", indent));
		System.out.println("FileJarClassLoader " + jarFile.getFileName().toString());
	}
	
	public void close() throws IOException {
		fileSystem.close();
	}
}