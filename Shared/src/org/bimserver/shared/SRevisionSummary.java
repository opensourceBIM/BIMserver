package org.bimserver.shared;

import java.util.Map;
import java.util.TreeMap;

public class SRevisionSummary {
	private final Map<String, Map<String, Integer>> map = new TreeMap<String, Map<String, Integer>>();

	public SRevisionSummary() {
		map.put("IFC Entities", new TreeMap<String, Integer>());
		map.put("IFC Relations", new TreeMap<String, Integer>());
		map.put("IFC Primitives", new TreeMap<String, Integer>());
		map.put("Rest", new TreeMap<String, Integer>());
	}
	
	public Map<String, Map<String, Integer>> getMap() {
		return map;
	}
}