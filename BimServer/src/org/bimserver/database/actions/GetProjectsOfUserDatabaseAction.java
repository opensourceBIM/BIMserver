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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class GetProjectsOfUserDatabaseAction extends BimDatabaseAction<List<Project>>{

	private final long actingUoid;

	public GetProjectsOfUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public List<Project> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		if (user != null) {
			List<Project> result = new ArrayList<Project>();
			for (Project project : user.getHasRightsOn()) {
				if (project.getState() == ObjectState.ACTIVE || user.getUserType() == UserType.ADMIN) {
					result.add(project);
				}
			}
			return result;
		} else {
			throw new UserException("User with id " + actingUoid + " does not exist");
		}
	}
}