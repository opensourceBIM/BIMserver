package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteInternalServiceDatabaseAction extends DeleteDatabaseAction<InternalServicePluginConfiguration> {

	public DeleteInternalServiceDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long ifid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), ifid);
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		InternalServicePluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), OldQuery.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getServices().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}