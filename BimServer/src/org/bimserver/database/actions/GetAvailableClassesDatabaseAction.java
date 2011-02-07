package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public class GetAvailableClassesDatabaseAction extends BimDatabaseAction<List<String>> {

	public GetAvailableClassesDatabaseAction(AccessMethod accessMethod) {
		super(accessMethod);
	}

	@Override
	public List<String> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		return bimDatabaseSession.getClassList();
	}
}