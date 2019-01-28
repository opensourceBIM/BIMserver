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
import org.bimserver.models.log.ExtendedDataAddedToProject;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddExtendedDataToProjectDatabaseAction extends AddDatabaseAction<ExtendedData> {

	private final Long poid;
	private BimServer bimServer;
	private Authorization authorization;

	public AddExtendedDataToProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Long poid, ExtendedData extendedData, Authorization authorization) {
		super(databaseSession, accessMethod, extendedData);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		super.execute();
		User actingUser = getUserByUoid(authorization.getUoid());
		Project project = getProjectByPoid(poid);
		if (project == null) {
			throw new UserException("Project with poid " + poid + " not found");
		}
		project.getExtendedData().add(getIdEObject());
		getDatabaseSession().store(project);
		
		final ExtendedDataAddedToProject extendedDataAddedToProject = getDatabaseSession().create(ExtendedDataAddedToProject.class);
		extendedDataAddedToProject.setAccessMethod(getAccessMethod());
		extendedDataAddedToProject.setDate(new Date());
		extendedDataAddedToProject.setExecutor(actingUser);
		extendedDataAddedToProject.setExtendedData(getIdEObject());
		extendedDataAddedToProject.setProject(project);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(extendedDataAddedToProject));
			}
		});

		return null;
	}
}