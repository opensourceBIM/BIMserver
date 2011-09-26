package org.bimserver.shared.meta;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SService {
	private final Map<String, SMethod> methods = new HashMap<String, SMethod>();
	
	public SService(Class<?> clazz) {
		for (Method method : clazz.getMethods()) {
			methods.put(method.getName(), new SMethod(method));
		}
	}
	
	public SMethod getSMethod(String name) {
		return methods.get(name);
	}
}