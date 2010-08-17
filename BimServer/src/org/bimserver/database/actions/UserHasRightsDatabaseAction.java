package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UserHasRightsDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long poid;
	private final long uoid;

	public UserHasRightsDatabaseAction(AccessMethod accessMethod, long uoid, long poid) {
		super(accessMethod);
		this.uoid = uoid;
		this.poid = poid;
	}

	@Override
	public Boolean execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		User user = bimDatabaseSession.getUserByUoid(uoid);
		return RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project);
	}
}