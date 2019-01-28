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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class RemoveServiceFromProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long poid;
	private long soid;

	public RemoveServiceFromProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long soid, long poid,
			Authorization authorization) {
		super(databaseSession, accessMethod);
		this.soid = soid;
		this.poid = poid;
	}

	@Override
	public Boolean execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		Service service = getDatabaseSession().get(soid, OldQuery.getDefault());
		Project project = getDatabaseSession().get(poid, OldQuery.getDefault());
		project.getServices().remove(service);
		getDatabaseSession().store(project);
		return true;
	}
}