package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectIDMPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteObjectIDMDatabaseAction extends DeleteDatabaseAction<ObjectIDMPluginConfiguration> {

	public DeleteObjectIDMDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long ifid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), ifid);
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ObjectIDMPluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), OldQuery.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getObjectIDMs().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}