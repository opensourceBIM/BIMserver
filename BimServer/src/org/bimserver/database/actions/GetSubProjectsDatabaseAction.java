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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.Authorization;

public class GetSubProjectsDatabaseAction extends BimDatabaseAction<Set<Project>> {

	private final long poid;
	private Authorization authorization;

	public GetSubProjectsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long poid) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
		this.poid = poid;
	}

	@Override
	public Set<Project> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(authorization.getUoid());
		Project project = getProjectByPoid(poid);
		if (!authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has no rights on project");
		}
		Set<Project> subProjects = new HashSet<Project>();
		for (Project subProject : project.getSubProjects()) {
			if (subProject.getState() == ObjectState.ACTIVE || authorization instanceof AdminAuthorization) {
				subProjects.add(subProject);
			}
		}
		return subProjects;
	}
}