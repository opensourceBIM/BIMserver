package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewProjectAdded;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class AddProjectDatabaseAction extends BimDatabaseAction<Project> {

	private final String name;
	private final long parentPoid;
	private final BimServer bimServer;
	private Authorization authorization;

	public AddProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, String name, Authorization authorization) {
		this(bimServer, databaseSession, accessMethod, name, -1, authorization);
	}

	public AddProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, String projectName, long parentPoid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.name = projectName;
		this.parentPoid = parentPoid;
		this.authorization = authorization;
	}

	@Override
	public Project execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		User actingUser = getUserByUoid(authorization.getUoid());
		String trimmedName = name.trim();
		if (trimmedName.equals("")) {
			throw new UserException("Invalid project name");
		}
		final Project project = StoreFactory.eINSTANCE.createProject();
		Project parentProject = null;
		if (parentPoid != -1) {
			parentProject = getProjectByPoid(parentPoid);
			project.setParent(parentProject);
			parentProject.getSubProjects().add(project);
			getDatabaseSession().store(parentProject);
		}
		if (actingUser.getUserType() != UserType.SYSTEM) {
			if (parentPoid == -1 && actingUser.getUserType() != UserType.ADMIN && !getServerSettings().isAllowUsersToCreateTopLevelProjects()) {
				throw new UserException("Only administrators can create new projects");
			}
		}
		if (project.getParent() == null) {
			for (Project p : getProjectsByName(trimmedName)) {
				if (p.getParent() == null) {
					throw new UserException("Project name must be unique");
				}
			}
		} else {
			Project parent = project.getParent();
			for (Project subProject : parent.getSubProjects()) {
				if (subProject != project && subProject.getName().equals(trimmedName)) {
					throw new UserException("Project name must be unique within parent project (" + parent.getName() + ")");
				}
			}
			project.setGeoTag(parent.getGeoTag());
		}
		final NewProjectAdded newProjectAdded = LogFactory.eINSTANCE.createNewProjectAdded();
		newProjectAdded.setDate(new Date());
		newProjectAdded.setExecutor(actingUser);
		newProjectAdded.setParentProject(parentProject);
		newProjectAdded.setProject(project);
		newProjectAdded.setAccessMethod(getAccessMethod());
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(newProjectAdded));
			}
		});
		project.setId(getDatabaseSession().newPid());
		project.setName(trimmedName);
//		project.getHasAuthorizedUsers().add(getAdminUser());
		project.getHasAuthorizedUsers().add(actingUser);
		project.setCreatedBy(actingUser);
		project.setCreatedDate(new Date());
		project.setDescription("");
		project.setExportLengthMeasurePrefix(SIPrefix.METER);
		if (project.getParent() == null) {
			GeoTag geoTag = StoreFactory.eINSTANCE.createGeoTag();
			geoTag.setEnabled(false);
			project.setGeoTag(geoTag);
			getDatabaseSession().store(geoTag);
		} else {
			GeoTag geoTag = parentProject.getGeoTag();
			project.setGeoTag(geoTag);
			getDatabaseSession().store(geoTag);
		}
		getDatabaseSession().store(project);
		getDatabaseSession().store(actingUser);
		getDatabaseSession().store(newProjectAdded);
		return project;
	}
}