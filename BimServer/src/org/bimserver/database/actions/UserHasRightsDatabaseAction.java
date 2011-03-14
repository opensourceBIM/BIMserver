package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UserHasRightsDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long poid;
	private final long uoid;

	public UserHasRightsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid, long poid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
		this.poid = poid;
	}

	@Override
	public Boolean execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(uoid);
		return RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project);
	}
}