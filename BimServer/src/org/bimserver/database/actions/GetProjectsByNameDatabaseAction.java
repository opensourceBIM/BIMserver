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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetProjectsByNameDatabaseAction extends BimDatabaseAction<List<Project>> {

	private final String name;
	private Authorization authorization;

	public GetProjectsByNameDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String name, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.name = name;
		this.authorization = authorization;
	}

	@Override
	public List<Project> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<Project> projects = getProjectsByName(name);
		List<Project> result = new ArrayList<Project>();
		User user = getUserByUoid(authorization.getUoid());
		for (Project project : projects) {
			if ((project.getState() == ObjectState.ACTIVE && authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project))) {
				result.add(project);
			}
		}
		return result;
	}
}