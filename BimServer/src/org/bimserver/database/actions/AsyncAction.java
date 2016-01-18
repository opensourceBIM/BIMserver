package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public abstract class AsyncAction<T> {
	private BimServer bimServer;

	public AsyncAction(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}

	public abstract T execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException;

}
