package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetProjectByPoidDatabaseAction extends BimDatabaseAction<Project> {

	private final long actionUoid;
	private final long poid;

	public GetProjectByPoidDatabaseAction(AccessMethod accessMethod, long poid, long actionUoid) {
		super(accessMethod);
		this.poid = poid;
		this.actionUoid = actionUoid;
	}

	@Override
	public Project execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		if (project == null) {
			throw new UserException("Project does not exist");
		}
		User user = bimDatabaseSession.getUserByUoid(actionUoid);
		if (project.getState() == ObjectState.DELETED && user.getUserType() != UserType.ADMIN) {
			throw new UserException("Project has been deleted");
		}
		if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			return project;
		} else {
			throw new UserException("User '" + user.getUsername() + "' has no rights on this project");
		}
	}
}