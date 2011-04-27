package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IgnoreFile;
import org.bimserver.shared.UserException;

public class GetAllIgnoreFilesDatabaseAction extends BimDatabaseAction<List<IgnoreFile>> {

	public GetAllIgnoreFilesDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod);
	}

	@Override
	public List<IgnoreFile> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return null;
	}
}