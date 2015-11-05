package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.shared.exceptions.UserException;

public class GetDatabaseInformationAction extends BimDatabaseAction<DatabaseInformation> {

	public GetDatabaseInformationAction(DatabaseSession databaseSession, AccessMethod accessMethod) {
		super(databaseSession, accessMethod);
	}

	@Override
	public DatabaseInformation execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return getDatabaseSession().getDatabaseInformation();
	}
}