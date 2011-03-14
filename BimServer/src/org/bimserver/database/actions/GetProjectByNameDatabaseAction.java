package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetProjectByNameDatabaseAction extends BimDatabaseAction<Project> {

	private final long actionUoid;
	private final String name;

	public GetProjectByNameDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String name, long actionUoid) {
		super(bimDatabaseSession, accessMethod);
		this.name = name;
		this.actionUoid = actionUoid;
	}

	@Override
	public Project execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = getProjectByName(name);
		if (project == null) {
			throw new UserException("Project does not exist");
		}
		User user = getUserByUoid(actionUoid);
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