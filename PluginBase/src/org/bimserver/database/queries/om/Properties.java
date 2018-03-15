package org.bimserver.database.queries.om;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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
import java.util.Map;
import java.util.Set;

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
	
	public Set<String> keys() {
		return mappings.keySet();
	}
}
