package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class DeleteUserDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private Authorization authorization;

	public DeleteUserDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long uoid) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
		this.uoid = uoid;
	}

	@Override
	public Boolean execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		User actingUser = getUserByUoid(authorization.getUoid());
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only administrators can delete users accounts");
		}
		final User user = getUserByUoid(uoid);
		if (user == null) {
			throw new UserException("No user found with oid " + uoid);
		}
		if (user.getUserType() == UserType.SYSTEM) {
			throw new UserException("System user cannot be deleted");
		}
		user.setState(ObjectState.DELETED);
		getDatabaseSession().store(user);
		return true;
	}
}