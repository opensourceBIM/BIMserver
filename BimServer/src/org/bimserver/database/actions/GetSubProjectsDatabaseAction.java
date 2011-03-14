package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetSubProjectsDatabaseAction extends BimDatabaseAction<Set<Project>> {

	private final long actingUoid;
	private final long poid;

	public GetSubProjectsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long poid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.poid = poid;
	}

	@Override
	public Set<Project> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		Project project = getProjectByPoid(poid);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has no rights on project");
		}
		Set<Project> subProjects = new HashSet<Project>();
		for (Project subProject : project.getSubProjects()) {
			if (subProject.getState() == ObjectState.ACTIVE) {
				subProjects.add(subProject);
			}
		}
		return subProjects;
	}
}