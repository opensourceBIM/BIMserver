package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;

public class AddUserToExtendedDataSchemaDatabaseAction extends BimDatabaseAction<Void> {

	private final long uoid;
	private final long edsid;

	public AddUserToExtendedDataSchemaDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long uoid, long edsid) {
		super(databaseSession, accessMethod);
		this.uoid = uoid;
		this.edsid = edsid;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), uoid, OldQuery.getDefault());
		if (user == null) {
			throw new UserException("User with oid " + uoid + " not found");
		}
		ExtendedDataSchema extendedDataSchema = getDatabaseSession().get(StorePackage.eINSTANCE.getExtendedDataSchema(), edsid, OldQuery.getDefault());
		if (extendedDataSchema == null) {
			throw new UserException("ExtendedDataSchema with oid " + edsid + " not found");
		}
		user.getSchemas().add(extendedDataSchema);
		getDatabaseSession().store(user);
		getDatabaseSession().store(extendedDataSchema);
		return null;
	}
}