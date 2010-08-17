package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UserHasCheckinRightsDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private final long poid;

	public UserHasCheckinRightsDatabaseAction(AccessMethod accessMethod, long uoid, long poid) {
		super(accessMethod);
		this.uoid = uoid;
		this.poid = poid;
	}

	@Override
	public Boolean execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		return RightsManager.hasRightsOnProject(bimDatabaseSession.getUserByUoid(uoid), bimDatabaseSession.getProjectByPoid(poid));
	}
}