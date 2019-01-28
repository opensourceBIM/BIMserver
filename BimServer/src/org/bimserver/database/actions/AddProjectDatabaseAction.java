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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewProjectAdded;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.notifications.NewProjectNotification;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddProjectDatabaseAction extends BimDatabaseAction<Project> {

	private final String name;
	private final long parentPoid;
	private final BimServer bimServer;
	private Authorization authorization;
	private String schema;

	public AddProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, String name, String schema, Authorization authorization) {
		this(bimServer, databaseSession, accessMethod, name, -1, schema, authorization);
		this.schema = schema;
	}

	public AddProjectDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, String projectName, long parentPoid, String schema, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.name = projectName;
		this.parentPoid = parentPoid;
		this.schema = schema;
		this.authorization = authorization;
	}

	@Override
	public Project execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		User actingUser = getUserByUoid(authorization.getUoid());
		String trimmedName = name.trim();
		if (trimmedName.equals("")) {
			throw new UserException("Invalid project name");
		}
		final Project project = getDatabaseSession().create(Project.class);
		Project parentProject = null;
		if (parentPoid != -1) {
			parentProject = getProjectByPoid(parentPoid);
			project.setParent(parentProject);
			parentProject.getSubProjects().add(project);
			getDatabaseSession().store(parentProject);
		}
		if (actingUser.getUserType() != UserType.SYSTEM) {
			if (parentPoid == -1 && actingUser.getUserType() != UserType.ADMIN && !bimServer.getServerSettingsCache().getServerSettings().isAllowUsersToCreateTopLevelProjects()) {
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
		if (schema == null || (!schema.toLowerCase().equals("ifc2x3tc1") && !schema.toLowerCase().equals("ifc4"))) {
			throw new UserException("Invalid schema, the only 2 valid options are: \"ifc2x3tc1\" and \"ifc4\", not \"" + this.schema + "\"");
		}
		
		schema = schema.toLowerCase();
		
		final NewProjectAdded newProjectAdded = getDatabaseSession().create(NewProjectAdded.class);
		newProjectAdded.setDate(new Date());
		newProjectAdded.setExecutor(actingUser);
		newProjectAdded.setParentProject(parentProject);
		newProjectAdded.setProject(project);
		newProjectAdded.setAccessMethod(getAccessMethod());
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new NewProjectNotification(bimServer, project.getOid()));
//				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(newProjectAdded));
			}
		});
		project.setSendEmailOnNewRevision(bimServer.getServerSettingsCache().getServerSettings().isSendEmailOnNewRevision());
		project.setId(getDatabaseSession().newPid());
		project.setName(trimmedName);
		project.setSchema(schema);
//		project.getHasAuthorizedUsers().add(getAdminUser());
		project.getHasAuthorizedUsers().add(actingUser);
		project.setCreatedBy(actingUser);
		project.setCreatedDate(new Date());
		project.setDescription("");
		project.setExportLengthMeasurePrefix(SIPrefix.METER);
		if (project.getParent() == null) {
			GeoTag geoTag = getDatabaseSession().create(GeoTag.class);
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