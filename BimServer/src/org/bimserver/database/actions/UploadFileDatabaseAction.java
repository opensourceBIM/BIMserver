package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.File;
import org.bimserver.shared.exceptions.UserException;

public class UploadFileDatabaseAction extends BimDatabaseAction<Long> {

	private File convertFromSObject;

	public UploadFileDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, File convertFromSObject) {
		super(databaseSession, accessMethod);
		this.convertFromSObject = convertFromSObject;
	}

	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return getDatabaseSession().store(convertFromSObject);
	}
}
