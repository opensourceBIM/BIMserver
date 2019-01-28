package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
				LOGGER.info("Removing one cache item");
				iterator.remove();
			}
		}
	}
}