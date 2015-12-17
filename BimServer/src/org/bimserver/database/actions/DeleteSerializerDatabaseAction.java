package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteSerializerDatabaseAction extends DeleteDatabaseAction<SerializerPluginConfiguration> {

	public DeleteSerializerDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long sid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getSerializerPluginConfiguration(), sid);
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		SerializerPluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), OldQuery.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getSerializers().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}