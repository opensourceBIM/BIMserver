package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.UserException;

public class GetUserByUoidDatabaseAction extends BimDatabaseAction<User> {

	private final long uoid;

	public GetUserByUoidDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
	}

	@Override
	public User execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return (User) getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), uoid, false);
	}
}