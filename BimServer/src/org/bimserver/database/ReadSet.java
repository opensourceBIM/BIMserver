package org.bimserver.database;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Collection;
import java.util.Set;

import org.bimserver.emf.IdEObject;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class ReadSet {
	private final BiMap<Long, IdEObject> reading = HashBiMap.create();
	private final int pid;
	private final int rid;

	public ReadSet(int pid, int rid) {
		this.pid = pid;
		this.rid = rid;
	}

	public int getRid() {
		return rid;
	}

	public int getPid() {
		return pid;
	}

	public void put(long oid, IdEObject object) {
		reading.put(oid, object);
	}

	public boolean isReading(long oid) {
		return reading.containsKey(oid);
	}

	public IdEObject get(long oid) {
		return reading.get(oid);
	}

	public long get(IdEObject eObject) {
		return reading.inverse().get(eObject);
	}

	public Set<Long> keySet() {
		return reading.keySet();
	}

	public Collection<IdEObject> values() {
		return reading.values();
	}

	public int size() {
		return reading.size();
	}

	public BiMap<Long, IdEObject> getMap() {
		return reading;
	}
}
