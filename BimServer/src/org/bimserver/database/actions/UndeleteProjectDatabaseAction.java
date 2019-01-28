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
import org.bimserver.models.log.ProjectUndeleted;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class UndeleteProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long poid;
	private Authorization authorization;
	private BimServer bimServer;

	public UndeleteProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
	}

	@Override
	public Boolean execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		User actingUser = getUserByUoid(authorization.getUoid());
		final Project project = getProjectByPoid(poid);
		if (project == null) {
			throw new UserException("No Project with oid " + poid + " found");
		}
		if (actingUser.getUserType() == UserType.ADMIN || actingUser.getHasRightsOn().contains(project)) {
			project.setState(ObjectState.ACTIVE);
			final ProjectUndeleted projectUndeleted = getDatabaseSession().create(ProjectUndeleted.class);
			projectUndeleted.setAccessMethod(getAccessMethod());
			projectUndeleted.setDate(new Date());
			projectUndeleted.setExecutor(actingUser);
			projectUndeleted.setProject(project);
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(projectUndeleted));
				}
			});
			getDatabaseSession().store(project);
			return true;
		} else {
			throw new UserException("No rights to undelete this project");
		}
	}
}