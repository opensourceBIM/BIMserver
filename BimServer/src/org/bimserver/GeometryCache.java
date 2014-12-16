package org.bimserver;

import java.util.HashMap;
import java.util.Map;

public class GeometryCache {
	private final Map<Integer, GeometryCacheEntry> cache = new HashMap<Integer, GeometryCacheEntry>();

	public void put(int expressId, GeometryCacheEntry geometryCacheEntry) {
		cache.put(expressId, geometryCacheEntry);
	}

	public boolean isEmpty() {
		return cache.isEmpty();
	}

	public GeometryCacheEntry get(int expressId) {
		return cache.get(expressId);
	}
}