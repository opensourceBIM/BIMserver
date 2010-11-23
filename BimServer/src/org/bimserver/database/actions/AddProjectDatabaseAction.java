package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.ServerSettings;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.SIPrefix;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.NewProjectAdded;
import org.bimserver.shared.UserException;

public class AddProjectDatabaseAction extends BimDatabaseAction<Project> {

	private final String name;
	private final long owningUoid;
	private final long parentPoid;

	public AddProjectDatabaseAction(AccessMethod accessMethod, String name, long owningUoid) {
		this(accessMethod, name, -1, owningUoid);
	}

	public AddProjectDatabaseAction(AccessMethod accessMethod, String projectName, long parentPoid, long owningUoid) {
		super(accessMethod);
		this.name = projectName;
		this.parentPoid = parentPoid;
		this.owningUoid = owningUoid;
	}

	@Override
	public Project execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = bimDatabaseSession.getUserByUoid(owningUoid);
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
			parentProject = bimDatabaseSession.getProjectByPoid(parentPoid);
			project.setParent(parentProject);
		}
		if (parentPoid == -1 && actingUser.getUserType() != UserType.ADMIN && !ServerSettings.getSettings().isAllowUsersToCreateTopLevelProjects()) {
			throw new UserException("Only administrators can create new top-level projects");
		}
		if (project.getParent() == null) {
			for (Project p : bimDatabaseSession.getProjectsByName(trimmedName)) {
				if (p.getParent() == null) {
					throw new UserException("Project name must be unique");
				}
			}
		} else {
			Project parent = project.getParent();
			for (Project subProject : parent.getSubProjects()) {
				if (subProject.getName().equals(trimmedName) && subProject != project) {
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
		project.setId(bimDatabaseSession.newPid());
		project.setName(trimmedName);
		project.getHasAuthorizedUsers().add(bimDatabaseSession.getAdminUser());
		project.getHasAuthorizedUsers().add(actingUser);
		project.setCreatedBy(actingUser);
		project.setCreatedDate(new Date());
		project.setDescription("");
		project.setExportLengthMeasurePrefix(SIPrefix.METER);
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		if (project.getParent() == null) {
			GeoTag geoTag = StoreFactory.eINSTANCE.createGeoTag();
			geoTag.setEnabled(false);
			project.setGeoTag(geoTag);
			ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE.createClashDetectionSettings();
			clashDetectionSettings.setEnabled(false);
			project.setClashDetectionSettings(clashDetectionSettings);
			bimDatabaseSession.store(geoTag, commitSet);
			bimDatabaseSession.store(clashDetectionSettings, commitSet);
		}
		bimDatabaseSession.store(project, commitSet);
		bimDatabaseSession.store(newProjectAdded, commitSet);
		bimDatabaseSession.savePidCounter();
		bimDatabaseSession.saveOidCounter();
		return project;
	}
}