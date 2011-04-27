package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IgnoreFile;
import org.bimserver.shared.UserException;

public class AddIgnoreFileDatabaseAction extends BimDatabaseAction<Void> {

	private final IgnoreFile ignoreFile;

	public AddIgnoreFileDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IgnoreFile ignoreFile) {
		super(bimDatabaseSession, accessMethod);
		this.ignoreFile = ignoreFile;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		getDatabaseSession().store(ignoreFile);
		return null;
	}
}
