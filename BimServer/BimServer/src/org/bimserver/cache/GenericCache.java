package org.bimserver.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericCache<K extends GenericCacheKey, V extends GenericCacheValue> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GenericCache.class);
	private final Map<K, V> cache = new HashMap<K, V>();

	public GenericCache() {
		
	}
	
	protected void store(K key, V value) {
		cache.put(key, value);
	}
	
	protected V getValue(K key) {
		return cache.get(key);
	}
	
	public synchronized void cleanup() {
		Iterator<K> iterator = cache.keySet().iterator();
		while (iterator.hasNext()) {
			GenericCacheKey key = iterator.next();
			if (cache.get(key).shouldCleanUp()) {
				LOGGER.info("Removing one clash detection cache item");
				iterator.remove();
			}
		}
	}
}