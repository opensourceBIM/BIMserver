package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class ObjectCache {
	private final BiMap<RecordIdentifier, IdEObjectImpl> cache = HashBiMap.create();
	private final BiMap<Long, IdEObjectImpl> oidCache = HashBiMap.create();

	public void put(RecordIdentifier recordIdentifier, IdEObject object) {
		if (useRecordLevelVersioning(object)) {
			if (!oidCache.containsValue(object)) {
				oidCache.put(recordIdentifier.getOid(), (IdEObjectImpl) object);
			}
		} else {
			if (!cache.containsValue(object)) {
				cache.put(recordIdentifier, (IdEObjectImpl) object);
				oidCache.put(recordIdentifier.getOid(), (IdEObjectImpl) object);
			}
		}
	}
	
	private boolean useRecordLevelVersioning(IdEObject idEObject) {
		return idEObject.eClass().getEPackage() != Ifc2x3tc1Package.eINSTANCE;
	}
	
	public IdEObject get(long oid) {
		return oidCache.get(oid);
	}
	
	public IdEObject get(RecordIdentifier recordIdentifier) {
		if (recordIdentifier.getPid() == Database.STORE_PROJECT_ID) {
			return oidCache.get(recordIdentifier.getOid());
		} else {
			return cache.get(recordIdentifier);
		}
	}

	public long get(IdEObject object) {
		if (useRecordLevelVersioning(object)) {
			return oidCache.inverse().get(object);
		} else {
			return cache.inverse().get(object).getOid();
		}
	}
	
	public boolean contains(IdEObject object) {
		if (useRecordLevelVersioning(object)) {
			return oidCache.inverse().containsKey(object);
		} else {
			return cache.inverse().containsKey(object);
		}
	}

	public boolean contains(RecordIdentifier recordIdentifier) {
		if (recordIdentifier.getPid() == Database.STORE_PROJECT_ID) {
			return oidCache.containsKey(recordIdentifier.getOid());
		} else {
			return cache.containsKey(recordIdentifier);
		}
	}
	
	public boolean contains(long oid) {
		return oidCache.containsKey(oid);
	}

	public void clear() {
		cache.clear();
		oidCache.clear();
	}
}