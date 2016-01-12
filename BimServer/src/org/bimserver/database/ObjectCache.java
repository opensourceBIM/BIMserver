package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class ObjectCache {
	private final BiMap<Long, IdEObjectImpl> oidCache = HashBiMap.create();

	public void put(long oid, IdEObject object) {
		if (!oidCache.containsValue(object)) {
			oidCache.put(oid, (IdEObjectImpl) object);
		}
	}
	
	public IdEObject get(long oid) {
		return oidCache.get(oid);
	}
	
	public long get(IdEObject object) {
		return oidCache.inverse().get(object);
	}
	
	public boolean contains(IdEObject object) {
		return oidCache.inverse().containsKey(object);
	}

	public boolean contains(long oid) {
		return oidCache.containsKey(oid);
	}

	public void clear() {
		oidCache.clear();
	}
}