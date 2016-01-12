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

import java.util.Iterator;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterators;

public class ObjectsToCommit implements Iterable<IdEObject> {
	private final BiMap<IdEObject, Long> objectsToCommitFirst = HashBiMap.create();
	private final BiMap<IdEObject, Long> objectsToCommitSecond = HashBiMap.create();

	public void put(IdEObject idEObject) {
		getMap(idEObject).forcePut(idEObject, idEObject.getOid());
	}

	public int size() {
		return objectsToCommitFirst.size() + objectsToCommitSecond.size();
	}

	public BiMap<IdEObject, Long> getMap(IdEObject idEObject) {
		if (idEObject.eClass().getEPackage() == Ifc2x3tc1Package.eINSTANCE || idEObject.eClass().getEPackage() == Ifc4Package.eINSTANCE) {
			return objectsToCommitFirst;
		} else {
			return objectsToCommitSecond;
		}
	}

	public boolean containsObject(IdEObject object) {
		return getMap(object).containsKey(object);
	}

	public boolean containsOid(long oid) {
		return objectsToCommitFirst.containsValue(oid) || objectsToCommitSecond.containsValue(oid);
	}

	public IdEObject getByOid(long oid) {
		IdEObject result = objectsToCommitFirst.inverse().get(oid);
		if (result == null) {
			return objectsToCommitSecond.inverse().get(oid);
		}
		return result;
	}

	@Override
	public Iterator<IdEObject> iterator() {
		return Iterators.concat(objectsToCommitFirst.keySet().iterator(), objectsToCommitSecond.keySet().iterator());
	}

	public void clear() {
		objectsToCommitFirst.clear();
		objectsToCommitSecond.clear();
	}

	public void remove(IdEObject object) {
		objectsToCommitFirst.remove(object);
		objectsToCommitSecond.remove(object);
	}
}