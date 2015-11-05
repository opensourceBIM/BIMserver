package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class UserHasCheckinRightsDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private final long poid;
	private Authorization authorization;

	public UserHasCheckinRightsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long uoid, long poid) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
		this.uoid = uoid;
		this.poid = poid;
	}

	@Override
	public Boolean execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(uoid);
		if (!MailSystem.isValidEmailAddress(user.getUsername())) {
			return false;
		}
		return authorization.hasRightsOnProject(user, getProjectByPoid(poid));
	}
}