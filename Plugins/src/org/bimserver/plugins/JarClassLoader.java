package org.bimserver.plugins;

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

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

public class JarClassLoader extends ClassLoader {
	private File jarFile;
	private Map<String, byte[]> map;
	private Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();

	public JarClassLoader(ClassLoader parentClassLoader, File jarFile) {
		super(parentClassLoader);
		this.jarFile = jarFile;
		try {
			JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarFile));
			JarEntry entry = jarInputStream.getNextJarEntry();
			map = new HashMap<String, byte[]>();
			while (entry != null) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				IOUtils.copy(jarInputStream, byteArrayOutputStream);
				map.put(entry.getName(), byteArrayOutputStream.toByteArray());
				if (entry.getName().endsWith(".jar")) {
					loadSubJars(byteArrayOutputStream.toByteArray());
				}
				entry = jarInputStream.getNextJarEntry();
			}
			jarInputStream.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	private void loadSubJars(byte[] byteArray) {
		try {
			JarInputStream jarInputStream = new JarInputStream(new ByteArrayInputStream(byteArray));
			JarEntry entry = jarInputStream.getNextJarEntry();
			while (entry != null) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				IOUtils.copy(jarInputStream, byteArrayOutputStream);
				map.put(entry.getName(), byteArrayOutputStream.toByteArray());
				entry = jarInputStream.getNextJarEntry();
			}
			jarInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected URL findResource(final String name) {
		if (map.containsKey(name)) {
			try {
				return new URL(new URL("jar:" + new File(jarFile.getName()).toURI().toURL() + "!/" + name), name, new URLStreamHandler() {
					@Override
					protected URLConnection openConnection(URL u) throws IOException {
						return new URLConnection(u) {
							@Override
							public void connect() throws IOException {
							}

							@Override
							public InputStream getInputStream() throws IOException {
								return new ByteArrayInputStream(map.get(name));
							}
						};
					}
				});
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = name.replace(".", "/") + ".class";
		if (loadedClasses.containsKey(fileName)) {
			return loadedClasses.get(fileName);
		}
		if (map.containsKey(fileName)) {
			byte[] bs = map.get(fileName);
			Class<?> defineClass = defineClass(name, bs, 0, bs.length);
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
		}
		throw new ClassNotFoundException(name);
	}
}