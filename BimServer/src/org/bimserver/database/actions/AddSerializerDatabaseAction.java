package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddSerializerDatabaseAction extends AddDatabaseAction<SerializerPluginConfiguration> {

	private Authorization authorization;

	public AddSerializerDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, SerializerPluginConfiguration serializer) {
		super(databaseSession, accessMethod, serializer);
		this.authorization = authorization;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Long execute = super.execute();
		// Make sure the backreferences are stored as well, someday this should be automatic
		if (getIdEObject().getRenderEngine() != null) {
			getDatabaseSession().store(getIdEObject().getRenderEngine());
		}
		if (getIdEObject().getObjectIDM() != null) {
			getDatabaseSession().store(getIdEObject().getObjectIDM());
		}
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
		user.getUserSettings().getSerializers().add(getIdEObject());
		getDatabaseSession().store(user.getUserSettings());

		return execute;
	}
}