package org.bimserver.plugins.classloaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bimserver.plugins.PluginManager;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileJarClassLoader extends JarClassLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileJarClassLoader.class);
	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();
	private Path jarFile;
	private FileSystem fileSystem;

	public FileJarClassLoader(PluginManager pluginManager, ClassLoader parentClassLoader, Path jarFile) throws FileNotFoundException, IOException {
		super(parentClassLoader);
		this.jarFile = jarFile;
		fileSystem = pluginManager.getOrCreateFileSystem(jarFile.toAbsolutePath().toString());
	}

	@Override
	public URL findResource(String name) {
		final Path path = fileSystem.getPath(name);
		if (Files.exists(path)) {
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
								return Files.newInputStream(path);
							}
						};
					}
				});
				return url;
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		} else {
			LOGGER.info("File not found: " + name + " (in " + jarFile.getFileName().toString() + ")");
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
			Path file = fileSystem.getPath(fileName);
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