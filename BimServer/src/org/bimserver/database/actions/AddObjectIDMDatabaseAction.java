package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectIDMPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddObjectIDMDatabaseAction extends AddDatabaseAction<ObjectIDMPluginConfiguration> {

	private Authorization authorization;

	public AddObjectIDMDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, ObjectIDMPluginConfiguration objectIDM) {
		super(databaseSession, accessMethod, objectIDM);
		this.authorization = authorization;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());
		user.getUserSettings().getObjectIDMs().add(getIdEObject());
		getDatabaseSession().store(user.getUserSettings());
		return super.execute();
	}
}