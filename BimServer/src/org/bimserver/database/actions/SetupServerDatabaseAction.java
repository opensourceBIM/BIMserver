package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.UserException;

public class SetupServerDatabaseAction extends BimDatabaseAction<Void> {

	public SetupServerDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod);
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		
		return null;
	}
}