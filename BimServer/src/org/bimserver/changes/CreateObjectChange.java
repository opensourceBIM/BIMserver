package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class CreateObjectChange implements Change {

	private final long oid;
	private final String type;

	public CreateObjectChange(String type, long oid) {
		this.type = type;
		this.oid = oid;
	}

	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		EClass eClass = bimDatabaseSession.getEClassForName(type);
		if (eClass == null) {
			throw new UserException("Type " + type + " does not exist");
		}
		IdEObject eObject = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
		eObject.setOid(oid);
		eObject.setPid(pid);
		eObject.setRid(rid);
		bimDatabaseSession.store(eObject, pid, rid);
	}
}