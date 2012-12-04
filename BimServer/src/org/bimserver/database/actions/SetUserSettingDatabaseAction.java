package org.bimserver.database.actions;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class SetUserSettingDatabaseAction extends BimDatabaseAction<Void> {
	private UserSettingsSetter userSettingsSetter;

	public SetUserSettingDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, UserSettingsSetter userSettingsSetter) {
		super(databaseSession, accessMethod);
		this.userSettingsSetter = userSettingsSetter;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		UserSettings userSettings = getUserSettings();
		userSettingsSetter.set(userSettings);
		getDatabaseSession().store(userSettings);
		return null;
	}
}