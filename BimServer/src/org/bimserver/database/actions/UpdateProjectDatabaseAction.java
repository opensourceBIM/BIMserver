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
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ProjectUpdated;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class UpdateProjectDatabaseAction extends BimDatabaseAction<Void> {

	private final SProject sProject;
	private Authorization authorization;
	private BimServer bimServer;

	public UpdateProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, SProject sProject) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.sProject = sProject;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		final Project project = getProjectByPoid(sProject.getOid());
		if (project == null) {
			throw new UserException("Project with pid " + sProject.getOid() + " not found");
		}
		if (sProject.getName().trim().equals("")) {
			throw new UserException("Project name cannot be empty");
		}
		if (!authorization.hasRightsOnProjectOrSuperProjects(actingUser, project)) {
			throw new UserException("User has no rights to update project properties");
		}
		if (project.getParent() == null) {
			if (!sProject.getName().equals(project.getName())) {
				for (Project p : getProjectsByName(sProject.getName())) {
					if (p.getParent() == null) {
						throw new UserException("Project name must be unique");
					}
				}
			}
		} else {
			Project parent = project.getParent();
			for (Project subProject : parent.getSubProjects()) {
				if (subProject.getName().equals(sProject.getName()) && subProject != project) {
					throw new UserException("Project name must be unique within parent project (" + parent.getName() + ")");
				}
			}
		}
		project.setSendEmailOnNewRevision(sProject.isSendEmailOnNewRevision());
		project.setName(sProject.getName());
		project.setDescription(sProject.getDescription());
		project.setExportLengthMeasurePrefix(SIPrefix.get(sProject.getExportLengthMeasurePrefix().getOrdinal()));
		final ProjectUpdated projectUpdated = getDatabaseSession().create(ProjectUpdated.class);
		projectUpdated.setAccessMethod(getAccessMethod());
		projectUpdated.setDate(new Date());
		projectUpdated.setExecutor(actingUser);
		projectUpdated.setProject(project);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(projectUpdated));
			}
		});
		getDatabaseSession().store(project);
		return null;
	}
}