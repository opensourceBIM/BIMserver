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

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.PostCommitAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewProjectAdded;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.NewProjectNotification;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class AddProjectDatabaseAction extends BimDatabaseAction<Project> {

	private final String name;
	private final long owningUoid;
	private final long parentPoid;
	private final BimServer bimServer;

	public AddProjectDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String name, long owningUoid) {
		this(bimServer, bimDatabaseSession, accessMethod, name, -1, owningUoid);
	}

	public AddProjectDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String projectName, long parentPoid, long owningUoid) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.name = projectName;
		this.parentPoid = parentPoid;
		this.owningUoid = owningUoid;
	}

	@Override
	public Project execute() throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = getUserByUoid(owningUoid);
		String trimmedName = name.trim();
		if (trimmedName.equals("")) {
			throw new UserException("Invalid project name");
		}
		final Project project = StoreFactory.eINSTANCE.createProject();
		Project parentProject = null;
		if (parentPoid != -1) {
			parentProject = getProjectByPoid(parentPoid);
			project.setParent(parentProject);
			getDatabaseSession().store(parentProject);
		}
		if (actingUser.getUserType() != UserType.SYSTEM) {
			if (parentPoid == -1 && actingUser.getUserType() != UserType.ADMIN && !bimServer.getSettingsManager().getSettings().isAllowUsersToCreateTopLevelProjects()) {
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
			project.setClashDetectionSettings(parent.getClashDetectionSettings());
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
				NewProjectNotification newProjectNotification = StoreFactory.eINSTANCE.createNewProjectNotification();
				newProjectNotification.setProject(project);
				bimServer.getNotificationsManager().notify(newProjectNotification);
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
			ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE.createClashDetectionSettings();
			clashDetectionSettings.setEnabled(false);
			project.setClashDetectionSettings(clashDetectionSettings);
			getDatabaseSession().store(geoTag);
			getDatabaseSession().store(clashDetectionSettings);
		} else {
			ClashDetectionSettings clashDetectionSettings = parentProject.getClashDetectionSettings();
			project.setClashDetectionSettings(clashDetectionSettings);
			getDatabaseSession().store(clashDetectionSettings);

			GeoTag geoTag = parentProject.getGeoTag();
			project.setGeoTag(geoTag);
			getDatabaseSession().store(geoTag);
		}
		getDatabaseSession().store(project);
		getDatabaseSession().store(newProjectAdded);
		return project;
	}
}