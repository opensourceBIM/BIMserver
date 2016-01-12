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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EClass;

public class ObjectsToDelete implements Iterable<RecordIdentifierPlusType> {

	private final Set<RecordIdentifierPlusType> set = new HashSet<RecordIdentifierPlusType>();

	public void put(EClass eClass, int pid, int rid, long oid) {
		RecordIdentifierPlusType recordIdentifier = new RecordIdentifierPlusType(eClass, pid, oid, rid);
		put(recordIdentifier);
	}

	private void put(RecordIdentifierPlusType recordIdentifier) {
		set.add(recordIdentifier);
	}

	@Override
	public Iterator<RecordIdentifierPlusType> iterator() {
		return set.iterator();
	}

	public void clear() {
		set.clear();
	}

	public int size() {
		return set.size();
	}

	public boolean contains(IdEObject object) {
		return set.contains(new RecordIdentifierPlusType(object.eClass(), object.getPid(), object.getOid(), object.getRid()));
	}
}