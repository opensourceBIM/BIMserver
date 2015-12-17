package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteDeserializerDatabaseAction extends DeleteDatabaseAction<DeserializerPluginConfiguration> {

	public DeleteDeserializerDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long sid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), sid);
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		DeserializerPluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), OldQuery.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getDeserializers().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}