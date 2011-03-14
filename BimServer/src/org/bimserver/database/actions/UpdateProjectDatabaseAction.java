package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.ProjectUpdated;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UpdateProjectDatabaseAction extends BimDatabaseAction<Void> {

	private final SProject sProject;
	private final long actingUoid;

	public UpdateProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, SProject sProject) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.sProject = sProject;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		final Project project = getProjectByPoid(sProject.getOid());
		if (project == null) {
			throw new UserException("Project with pid " + sProject.getOid() + " not found");
		}
		if (sProject.getName().trim().equals("")) {
			throw new UserException("Project name cannot be empty");
		}
		if (actingUser.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("User anonymous cannot update project properties");
		}
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(actingUser, project)) {
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
		project.setName(sProject.getName());
		project.setDescription(sProject.getDescription());
		project.setExportLengthMeasurePrefix(SIPrefix.get(sProject.getExportLengthMeasurePrefix().getOrdinal()));
		ProjectUpdated projectUpdated = LogFactory.eINSTANCE.createProjectUpdated();
		projectUpdated.setAccessMethod(getAccessMethod());
		projectUpdated.setDate(new Date());
		projectUpdated.setExecutor(actingUser);
		projectUpdated.setProject(project);
		getDatabaseSession().store(projectUpdated);
		getDatabaseSession().store(project);
		return null;
	}
}