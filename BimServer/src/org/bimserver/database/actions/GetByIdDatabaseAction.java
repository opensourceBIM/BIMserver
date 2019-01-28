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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class GetByIdDatabaseAction<T> extends BimDatabaseAction<T> {

	private final EClass eClass;
	private final long oid;

	public GetByIdDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long oid, EClass eClass) {
		super(databaseSession, accessMethod);
		this.oid = oid;
		this.eClass = eClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return (T) getDatabaseSession().get(eClass, oid, OldQuery.getDefault());
	}
}