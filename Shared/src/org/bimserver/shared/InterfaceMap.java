package org.bimserver.shared;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.shared.interfaces.PublicInterface;

public class InterfaceMap {
	private final Map<Class<? extends PublicInterface>, PublicInterface> map = new HashMap<Class<? extends PublicInterface>, PublicInterface>();
	private final Map<String, PublicInterface> mapSimpleName = new HashMap<String, PublicInterface>();
	
	public <T extends PublicInterface> void add(Class<T> clazz, T t) {
		map.put(clazz, t);
		mapSimpleName.put(clazz.getSimpleName(), t);
	}

	@SuppressWarnings("unchecked")
	public <T extends PublicInterface> T get(String simpleName) {
		return (T) mapSimpleName.get(simpleName);
	}

	@SuppressWarnings("unchecked")
	public <T extends PublicInterface> T get(Class<T> clazz) {
		return (T) map.get(clazz);
	}

	public boolean contains(String serviceName) {
		return mapSimpleName.containsKey(serviceName);
	}
}
