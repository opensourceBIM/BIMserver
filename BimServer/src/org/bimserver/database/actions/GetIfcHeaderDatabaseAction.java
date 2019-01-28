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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetIfcHeaderDatabaseAction extends BimDatabaseAction<SIfcHeader> {

	private long croid;
	private BimServer bimServer;

	public GetIfcHeaderDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long croid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.croid = croid;
	}

	@Override
	public SIfcHeader execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		ConcreteRevision concreteRevision = getDatabaseSession().get(croid, OldQuery.getDefault());
		if (concreteRevision == null) {
			throw new UserException("No ConcreteRevision found with oid " + croid);
		}
		return bimServer.getSConverter().convertToSObject(concreteRevision.getIfcHeader());
	}
}