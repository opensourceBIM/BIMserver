package org.bimserver.plugins;

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