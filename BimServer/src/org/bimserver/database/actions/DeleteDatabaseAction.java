package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class DeleteDatabaseAction<T extends IdEObject> extends BimDatabaseAction<Void> {

	private final long oid;
	private final EClass eClass;

	public DeleteDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, EClass eClass, long oid) {
		super(databaseSession, accessMethod);
		this.eClass = eClass;
		this.oid = oid;
	}

	public EClass geteClass() {
		return eClass;
	}
	
	public long getOid() {
		return oid;
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		T object = getDatabaseSession().get(eClass, oid, OldQuery.getDefault());
		if (object == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}
		getDatabaseSession().delete(object, object.getRid() + 1);
		return null;
	}
}