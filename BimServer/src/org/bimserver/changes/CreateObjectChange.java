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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class CreateObjectChange implements Change {

	private final long oid;
	private final String type;
	private IdEObjectImpl eObject;

	public CreateObjectChange(String type, long oid) {
		this.type = type;
		this.oid = oid;
	}

	@Override
	public void execute(int pid, int rid, DatabaseSession databaseSession, Map<Long, IdEObject> created) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		EClass eClass = databaseSession.getEClassForName(type);
		if (eClass == null) {
			throw new UserException("Type " + type + " does not exist");
		}
		eObject = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		eObject.setOid(oid);
		eObject.setPid(pid);
		eObject.setRid(rid);
		databaseSession.store(eObject, pid, rid);
		created.put(oid, eObject);
	}
}