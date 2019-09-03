package org.bimserver.geometry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SkippedBecauseOfInvalidRepresentation {

	private final Map<String, Integer> map = new HashMap<>();
	
	public Set<String> keySet() {
		return map.keySet();
	}

	public int get(String key) {
		return map.get(key);
	}

	public void merge(String key, int value) {
		map.merge(key, value, Integer::sum);
	}

	public int size() {
		return map.size();
	}

	private boolean isImportant(String key) {
		return key == null || !(key.contentEquals("Axis") || key.contentEquals("Annotation"));
	}
	
	public boolean hasImportant() {
		for (String key : map.keySet()) {
			if (isImportant(key)) {
				return true;
			}
		}
		return false;
	}

	public Set<String> getImportantSet() {
		Set<String> result = new HashSet<>();
		for (String key : map.keySet()) {
			if (isImportant(key)) {
				result.add(key);
			}
		}
		return result;
	}
}
