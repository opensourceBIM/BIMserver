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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetExtendedDataByIdDatabaseAction extends GetByIdDatabaseAction<ExtendedData> {

	private Authorization authorization;

	public GetExtendedDataByIdDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long oid) {
		super(databaseSession, accessMethod, oid, StorePackage.eINSTANCE.getExtendedData());
		this.authorization = authorization;
	}
	
	@Override
	public ExtendedData execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ExtendedData extendedData = super.execute();
		if (authorization == null) {
			throw new UserException("Authorization required for this call");
		}
		if (extendedData.getRevision() != null) {
			Revision revision = extendedData.getRevision();
			authorization.canReadExtendedData(revision.getOid());
		} else if (extendedData.getProject() != null) {
//			Project project = extendedData.getProject();
			// TODO check auth
		}
		return extendedData;
	}
}