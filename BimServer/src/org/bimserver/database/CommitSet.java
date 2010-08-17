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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class CommitSet {
	private final int pid;
	private final int rid;
	private final Map<EObject, Long> storing = new HashMap<EObject, Long>();

	public CommitSet(int pid, int rid) {
		this.pid = pid;
		this.rid = rid;
	}
	
	public int getRid() {
		return rid;
	}

	public long getOid(EObject object) {
		return storing.get(object);
	}

	public int getPid() {
		return pid;
	}

	public boolean isStoring(EObject object) {
		return storing.containsKey(object);
	}

	public void add(EObject object, long oid) {
		storing.put(object, oid);
	}
}
