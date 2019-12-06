package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
public class GetProjectByUuidDatabaseAction extends BimDatabaseAction<Project> {

	private final String uuid;
	private Authorization authorization;

	public GetProjectByUuidDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String uuid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.uuid = uuid;
		this.authorization = authorization;
	}

	@Override
	public Project execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
//		List<IdEObject> projects = (List<IdEObject>) getDatabaseSession().query(StorePackage.eINSTANCE.getProject_Uuid(), uuid);
//		if (projects.size() == 0) {
//			throw new UserException("Project with uuid " + uuid + " does not exist");
//		}
//		Project project = (Project) projects.get(0);
//		User user = getUserByUoid(authorization.getUoid());
//		if (user == null) {
//			throw new UserException("Authenticated user required");
//		}
//		if (project.getState() == ObjectState.DELETED && user.getUserType() != UserType.ADMIN) {
//			throw new UserException("Project has been deleted");
//		}
//		if (authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
//			return project;
//		} else {
//			throw new UserException("User '" + user.getUsername() + "' has no rights on this project");
//		}
		// TODO reimplement
		return null;
	}
}