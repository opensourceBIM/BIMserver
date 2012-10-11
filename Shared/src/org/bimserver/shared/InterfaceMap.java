package org.bimserver.shared;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.shared.interfaces.PublicInterface;

public class InterfaceMap {
	private final Map<Class<? extends PublicInterface>, PublicInterface> map = new HashMap<Class<? extends PublicInterface>, PublicInterface>();
	
	public <T extends PublicInterface> void add(Class<T> clazz, T t) {
		map.put(clazz, t);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PublicInterface> T get(Class<T> clazz) {
		return (T) map.get(clazz);
	}

	public boolean contains(String serviceName) {
		return map.containsKey(serviceName);
	}
}
