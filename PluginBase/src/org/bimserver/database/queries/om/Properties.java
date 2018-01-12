package org.bimserver.database.queries.om;

import java.util.HashMap;
import java.util.Map;

public class Properties {

	private final Map<String, Object> mappings = new HashMap<>();
	
	public Properties(String key, Object value) {
		mappings.put(key, value);
	}

	public void add(String key, Object value) {
		mappings.put(key, value);
	}

	public int count() {
		return mappings.size();
	}

	public boolean has(String name) {
		return mappings.containsKey(name);
	}

	public Object get(String name) {
		return mappings.get(name);
	}
}
