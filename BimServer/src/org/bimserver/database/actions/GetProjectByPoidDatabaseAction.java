package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetProjectByPoidDatabaseAction extends BimDatabaseAction<Project> {

	private final long poid;
	private Authorization authorization;

	public GetProjectByPoidDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.authorization = authorization;
	}

	@Override
	public Project execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		if (project == null) {
			throw new UserException("Project with oid " + poid + " does not exist");
		}
		User user = getUserByUoid(authorization.getUoid());
		if (user == null) {
			throw new UserException("Authenticated user required");
		}
		if (project.getState() == ObjectState.DELETED && user.getUserType() != UserType.ADMIN) {
			throw new UserException("Project has been deleted");
		}
		if (authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			return project;
		} else {
			throw new UserException("User '" + user.getUsername() + "' has no rights on this project");
		}
	}
}