package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddModelCompareDatabaseAction extends AddDatabaseAction<ModelComparePluginConfiguration> {

	private Authorization authorization;

	public AddModelCompareDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, ModelComparePluginConfiguration modelCompare) {
		super(databaseSession, accessMethod, modelCompare);
		this.authorization = authorization;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
		user.getUserSettings().getModelcompares().add(getIdEObject());
		getDatabaseSession().store(user.getUserSettings());
		return super.execute();
	}
}