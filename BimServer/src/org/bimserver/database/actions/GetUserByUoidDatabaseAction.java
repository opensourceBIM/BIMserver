package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;

public class GetUserByUoidDatabaseAction extends BimDatabaseAction<User> {

	private final long uoid;

	public GetUserByUoidDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long uoid) {
		super(databaseSession, accessMethod);
		this.uoid = uoid;
	}

	@Override
	public User execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return (User) getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), uoid, Query.getDefault());
	}
}