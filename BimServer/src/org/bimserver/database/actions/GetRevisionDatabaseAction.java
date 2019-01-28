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
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetRevisionDatabaseAction extends BimDatabaseAction<Revision> {

	private final long roid;
	private Authorization authorization;

	public GetRevisionDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long roid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.roid = roid;
		this.authorization = authorization;
	}

	@Override
	public Revision execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		if (revision == null) {
			throw new UserException("Revision does not exist");
		}
		Project project = revision.getProject();
		User user = getUserByUoid(authorization.getUoid());
		if (authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			return revision;
		}
		throw new UserException("User has no rights on this revision's project (" + project.getName() + ")");
	}
}