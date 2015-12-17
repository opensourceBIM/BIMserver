package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelMergerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteModelMergerDatabaseAction extends DeleteDatabaseAction<ModelMergerPluginConfiguration> {

	public DeleteModelMergerDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long iid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getModelMergerPluginConfiguration(), iid);
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ModelMergerPluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), OldQuery.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getModelmergers().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}