package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewProjectAdded;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;

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
		if (actingUser.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Anonymous user cannot create new projects");
		}
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
		NewProjectAdded newProjectAdded = LogFactory.eINSTANCE.createNewProjectAdded();
		newProjectAdded.setDate(new Date());
		newProjectAdded.setExecutor(actingUser);
		newProjectAdded.setParentProject(parentProject);
		newProjectAdded.setProject(project);
		newProjectAdded.setAccessMethod(getAccessMethod());
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
		}
		getDatabaseSession().store(project);
		getDatabaseSession().store(newProjectAdded);
		return project;
	}
}