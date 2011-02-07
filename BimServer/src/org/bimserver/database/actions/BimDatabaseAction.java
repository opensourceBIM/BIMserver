package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public abstract class BimDatabaseAction<T> {
	private final AccessMethod accessMethod;

	public abstract T execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException;

	public BimDatabaseAction(AccessMethod accessMethod) {
		this.accessMethod = accessMethod;
	}

	public AccessMethod getAccessMethod() {
		return accessMethod;
	}
}