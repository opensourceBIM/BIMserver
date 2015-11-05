package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class UserHasRightsDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long poid;
	private final long uoid;
	private Authorization authorization;

	public UserHasRightsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long uoid, Authorization authorization, long poid) {
		super(databaseSession, accessMethod);
		this.uoid = uoid;
		this.authorization = authorization;
		this.poid = poid;
	}

	@Override
	public Boolean execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(uoid);
		return authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project);
	}
}