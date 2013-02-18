package org.bimserver.tools.psetschema;

import java.util.HashMap;
import java.util.Map;

public class PsetSchema {

	private final Map<String, ClassDefinition> classes = new HashMap<String, ClassDefinition>();
	
	public ClassDefinition addOrGetClass(String name) {
		if (classes.containsKey(name)) {
			return classes.get(name);
		}
		ClassDefinition classDefinition = new ClassDefinition(name);
		classes.put(name, classDefinition);
		return classDefinition;
	}

	public ClassDefinition getClass(String name) {
		return classes.get(name);
	}
}