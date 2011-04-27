package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IgnoreFile;
import org.bimserver.shared.UserException;

public class GetIgnoreFileByIdDatabaseAction extends BimDatabaseAction<IgnoreFile> {

	private final long oid;

	public GetIgnoreFileByIdDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long oid) {
		super(bimDatabaseSession, accessMethod);
		this.oid = oid;
	}

	@Override
	public IgnoreFile execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return null;
	}
}
