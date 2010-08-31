package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetSubProjectsDatabaseAction extends BimDatabaseAction<Set<Project>> {

	private final long actingUoid;
	private final long poid;

	public GetSubProjectsDatabaseAction(AccessMethod accessMethod, long actingUoid, long poid) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.poid = poid;
	}

	@Override
	public Set<Project> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		if (!RightsManager.hasRightsOnProject(user, project)) {
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