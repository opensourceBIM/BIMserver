package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.UserException;

public class GetAvailableClassesDatabaseAction extends BimDatabaseAction<List<String>> {

	public GetAvailableClassesDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod);
	}

	@Override
	public List<String> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return getDatabaseSession().getClassList();
	}
}