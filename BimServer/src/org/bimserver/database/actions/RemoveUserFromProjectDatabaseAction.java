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

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.UserRemovedFromProject;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class RemoveUserFromProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private final long poid;
	private Authorization authorization;
	private BimServer bimServer;

	public RemoveUserFromProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long uoid, long poid,
			Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.uoid = uoid;
		this.poid = poid;
		this.authorization = authorization;
	}

	@Override
	public Boolean execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		User user = getUserByUoid(uoid);
		Project project = getProjectByPoid(poid);
		User actingUser = getUserByUoid(authorization.getUoid());
		if (authorization.hasRightsOnProject(actingUser, project)) {
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
			final UserRemovedFromProject userRemovedFromProject = getDatabaseSession().create(UserRemovedFromProject.class);
			userRemovedFromProject.setDate(new Date());
			userRemovedFromProject.setExecutor(actingUser);
			userRemovedFromProject.setAccessMethod(getAccessMethod());
			userRemovedFromProject.setProject(project);
			userRemovedFromProject.setUser(user);
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(userRemovedFromProject));
				}
			});
			getDatabaseSession().store(user);
			getDatabaseSession().store(project);
			return true;
		} else {
			throw new UserException("Insufficient rights to remove user from project");
		}
	}
}