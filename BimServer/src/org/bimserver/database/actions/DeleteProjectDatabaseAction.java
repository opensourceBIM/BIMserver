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
import org.bimserver.models.log.ProjectDeleted;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class DeleteProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long poid;
	private Authorization authorization;
	private BimServer bimServer;

	public DeleteProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
	}

	@Override
	public Boolean execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		User actingUser = getUserByUoid(authorization.getUoid());
		final Project project = getProjectByPoid(poid);
		if (actingUser.getUserType() == UserType.ADMIN || (actingUser.getHasRightsOn().contains(project) && bimServer.getServerSettingsCache().getServerSettings().isAllowUsersToCreateTopLevelProjects())) {
			delete(project);
			final ProjectDeleted projectDeleted = getDatabaseSession().create(ProjectDeleted.class);
			projectDeleted.setAccessMethod(getAccessMethod());
			projectDeleted.setDate(new Date());
			projectDeleted.setExecutor(actingUser);
			projectDeleted.setProject(project);
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(projectDeleted));
				}
			});
			getDatabaseSession().store(project);
			return true;
		} else {
			throw new UserException("No rights to delete this project");
		}
	}
	
	private void delete(Project project) {
		project.setState(ObjectState.DELETED);
		for (Project subProject : project.getSubProjects()) {
			delete(subProject);
		}
	}
}