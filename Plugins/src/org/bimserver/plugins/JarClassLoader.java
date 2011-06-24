package org.bimserver.plugins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JarClassLoader extends ClassLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(JarClassLoader.class);
	private File jarFile;
	private Map<String, byte[]> map;

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
				entry = jarInputStream.getNextJarEntry();
			}
			jarInputStream.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	@Override
	protected URL findResource(String name) {
		if (name.startsWith("/")) {
			name = name.substring(1);
		}
		try {
			return new URL("jar:" + new File(jarFile.getName()).toURI().toURL() + "!/" + name);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			Class<?> findClass = super.findClass(name);
			if (findClass != null) {
				return findClass;
			}
		} catch (ClassNotFoundException e) {
		}
		String fileName = name.replace(".", "/") + ".class";
		if (map.containsKey(fileName)) {
			byte[] bs = map.get(fileName);
			return defineClass(name, bs, 0, bs.length);
		}
		throw new ClassNotFoundException(name);
	}
}