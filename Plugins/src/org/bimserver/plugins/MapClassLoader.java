package org.bimserver.plugins;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapClassLoader extends ClassLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(MapClassLoader.class);
	private final Map<String, byte[]> map;

	public MapClassLoader(ClassLoader parentLoader, Map<String, byte[]> map) {
		super(parentLoader);
		LOGGER.info("Using as parent classloader: " + parentLoader);
		this.map = map;
	}

	public MapClassLoader(ClassLoader parentLoader) {
		super(parentLoader);
		this.map = new HashMap<String, byte[]>();
	}

	public void addMap(Map<String, byte[]> map) {
		this.map.putAll(map);
	}

	@Override
	protected Enumeration<URL> findResources(String name) throws IOException {
		return super.findResources(name);
	}
	
	@Override
	protected URL findResource(String name) {
		URL findResource = super.findResource(name);
		if (findResource != null) {
			return findResource;
		}
		try {
			URL url = new URL(name);
			System.out.println(url);
			return url;
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