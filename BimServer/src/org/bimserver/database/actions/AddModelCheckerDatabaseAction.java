package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.shared.exceptions.UserException;

public class AddModelCheckerDatabaseAction extends AddDatabaseAction<ModelCheckerInstance> {

	public AddModelCheckerDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, ModelCheckerInstance modelCheckerInstance) {
		super(databaseSession, accessMethod, modelCheckerInstance);
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return super.execute();
	}
}