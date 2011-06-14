package org.bimserver.shared;

import java.util.Map;

public class MapClassLoader extends ClassLoader {
	private final Map<String, byte[]> map;

	public MapClassLoader(Map<String, byte[]> map) {
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
		if (map.containsKey(name)) {
			byte[] bs = map.get(name);
			return defineClass(name, bs, 0, bs.length);
		}
		throw new ClassNotFoundException(name);
	}
}
