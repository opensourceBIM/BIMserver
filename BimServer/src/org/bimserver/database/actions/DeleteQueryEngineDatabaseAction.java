package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteQueryEngineDatabaseAction extends DeleteDatabaseAction<QueryEnginePluginConfiguration> {

	public DeleteQueryEngineDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long iid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), iid);
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		QueryEnginePluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), OldQuery.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getQueryengines().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}