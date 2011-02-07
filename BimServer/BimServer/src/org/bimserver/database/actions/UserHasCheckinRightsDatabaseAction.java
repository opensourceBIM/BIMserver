package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.mail.MailSystem;
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
		User user = bimDatabaseSession.getUserByUoid(uoid);
		if (!MailSystem.isValidEmailAddress(user.getUsername())) {
			return false;
		}
		return RightsManager.hasRightsOnProject(user, bimDatabaseSession.getProjectByPoid(poid));
	}
}