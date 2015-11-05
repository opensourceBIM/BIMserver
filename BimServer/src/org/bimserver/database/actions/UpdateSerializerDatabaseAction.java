package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.shared.exceptions.UserException;

public class UpdateSerializerDatabaseAction extends UpdateDatabaseAction<SerializerPluginConfiguration> {

	public UpdateSerializerDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, SerializerPluginConfiguration serializer) {
		super(databaseSession, accessMethod, serializer);
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Void execute = super.execute();
		// Make sure the backreferences are stored as well, someday this should be automatic
		if (getIdEObject().getRenderEngine() != null) {
			getDatabaseSession().store(getIdEObject().getRenderEngine());
		}
		if (getIdEObject().getObjectIDM() != null) {
			getDatabaseSession().store(getIdEObject().getObjectIDM());
		}
		return execute;
	}
}