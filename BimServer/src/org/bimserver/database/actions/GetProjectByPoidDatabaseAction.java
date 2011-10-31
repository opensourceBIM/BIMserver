package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class GetProjectByPoidDatabaseAction extends BimDatabaseAction<Project> {

	private final long actionUoid;
	private final long poid;

	public GetProjectByPoidDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, long actionUoid) {
		super(bimDatabaseSession, accessMethod);
		this.poid = poid;
		this.actionUoid = actionUoid;
	}

	@Override
	public Project execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = getProjectByPoid(poid);
		if (project == null) {
			throw new UserException("Project does not exist");
		}
		User user = getUserByUoid(actionUoid);
		if (project.getState() == ObjectState.DELETED && user.getUserType() != UserType.ADMIN) {
			throw new UserException("Project has been deleted");
		}
		if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			return project;
		} else {
			throw new UserException("User '" + user.getUsername() + "' has no rights on this project");
		}
	}
}