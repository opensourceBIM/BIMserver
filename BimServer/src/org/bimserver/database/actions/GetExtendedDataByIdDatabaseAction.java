package org.bimserver.database.actions;

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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class GetExtendedDataByIdDatabaseAction extends GetByIdDatabaseAction<ExtendedData> {

	private Authorization authorization;

	public GetExtendedDataByIdDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long oid) {
		super(databaseSession, accessMethod, oid, StorePackage.eINSTANCE.getExtendedData());
		this.authorization = authorization;
	}
	
	@Override
	public ExtendedData execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ExtendedData extendedData = super.execute();
		authorization.canReadExtendedData(extendedData.getRevision().getOid());
		return extendedData;
	}
}