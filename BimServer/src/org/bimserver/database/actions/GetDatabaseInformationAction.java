package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.objects.DatabaseInformation;

public class GetDatabaseInformationAction extends BimDatabaseAction<DatabaseInformation> {

	public GetDatabaseInformationAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod);
	}

	@Override
	public DatabaseInformation execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return getDatabaseSession().getDatabaseInformation();
	}
}