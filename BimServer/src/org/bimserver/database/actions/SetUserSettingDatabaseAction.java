package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class SetUserSettingDatabaseAction extends BimDatabaseAction<Void> {
	private UserSettingsSetter userSettingsSetter;
	private Authorization authorization;

	public SetUserSettingDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, UserSettingsSetter userSettingsSetter) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
		this.userSettingsSetter = userSettingsSetter;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
		userSettingsSetter.set(user.getUserSettings());
		getDatabaseSession().store(user.getUserSettings());
		return null;
	}
}