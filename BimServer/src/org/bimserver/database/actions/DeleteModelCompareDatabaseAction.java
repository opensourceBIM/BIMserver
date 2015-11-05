package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteModelCompareDatabaseAction extends DeleteDatabaseAction<ModelComparePluginConfiguration> {

	public DeleteModelCompareDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long iid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getModelComparePluginConfiguration(), iid);
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ModelComparePluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), Query.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getModelcompares().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}