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
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;

public class AddDatabaseAction<T extends IdEObject> extends BimDatabaseAction<Long> {

	private final T idEObject;

	public AddDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, T idEObject) {
		super(databaseSession, accessMethod);
		this.idEObject = idEObject;
	}


	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return getDatabaseSession().store(idEObject);
	}
	
	public T getIdEObject() {
		return idEObject;
	}
}