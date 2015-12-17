package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class GetModelCheckerOidDatabaseAction extends BimDatabaseAction<ModelCheckerInstance> {

	private final long oid;

	public GetModelCheckerOidDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long oid) {
		super(databaseSession, accessMethod);
		this.oid = oid;
	}

	@Override
	public ModelCheckerInstance execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return (ModelCheckerInstance) getDatabaseSession().get(StorePackage.eINSTANCE.getModelCheckerInstance(), oid, OldQuery.getDefault());
	}
}