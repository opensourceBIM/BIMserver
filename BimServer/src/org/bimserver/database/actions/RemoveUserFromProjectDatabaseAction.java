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

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.UserRemovedFromProject;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class RemoveUserFromProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private final long poid;
	private final long actingUoid;

	public RemoveUserFromProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid, long poid,
			long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
		this.poid = poid;
		this.actingUoid = actingUoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDatabaseException, BimDeadlockException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(uoid);
		User actingUser = getUserByUoid(actingUoid);
		if (actingUser.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Anonymous user has no rights to remove users from any project");
		} else if (RightsManager.hasRightsOnProject(actingUser, project)) {
			if (user.getUserType() == UserType.ADMIN) {
				int nrAdmins = 0;
				for (User authUser : project.getHasAuthorizedUsers()) {
					if (authUser.getUserType() == UserType.ADMIN) {
						nrAdmins++;
					}
				}
				if (nrAdmins == 1) {
					throw new UserException(
							"User cannot be removed from this project because it is the only admin user with authorization on this project");
				}
			}
			project.getHasAuthorizedUsers().remove(user);
			user.getHasRightsOn().remove(project);
			UserRemovedFromProject userRemovedFromProject = LogFactory.eINSTANCE.createUserRemovedFromProject();
			userRemovedFromProject.setDate(new Date());
			userRemovedFromProject.setExecutor(actingUser);
			userRemovedFromProject.setAccessMethod(getAccessMethod());
			userRemovedFromProject.setProject(project);
			userRemovedFromProject.setUser(user);
			getDatabaseSession().store(userRemovedFromProject);
			getDatabaseSession().store(user);
			getDatabaseSession().store(project);
			return true;
		} else {
			throw new UserException("Insufficient rights to remove user from project");
		}
	}
}