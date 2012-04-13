package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class RemoveObjectChange implements Change {

	private final long oid;
	private final String className;

	public RemoveObjectChange(String className, long oid) {
		this.className = className;
		this.oid = oid;
	}

	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession, Map<Long, IdEObject> created) throws UserException, BimDeadlockException, BimDatabaseException {
		EClass eClass = bimDatabaseSession.getEClassForName(className);
		if (eClass == null) {
			throw new UserException("Unknown classname " + className);
		}
		IdEObject idEObject = bimDatabaseSession.get(eClass, pid, rid-1, oid, false, null);
		if (idEObject == null) {
			idEObject = created.get(oid);
		}
		if (idEObject == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}
		bimDatabaseSession.store(idEObject, pid, rid);
	}
}
