package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;

public class GetUserByUserNameDatabaseAction extends BimDatabaseAction<User> {

	private final String username;

	public GetUserByUserNameDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String username) {
		super(databaseSession, accessMethod);
		this.username = username;
	}

	@Override
	public User execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return (User) getDatabaseSession().querySingle(StorePackage.eINSTANCE.getUser_Username(), username.trim().toLowerCase());
	}
}