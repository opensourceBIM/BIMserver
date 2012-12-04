package org.bimserver.database.actions;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.shared.exceptions.UserException;

public class SetServerSettingDatabaseAction extends BimDatabaseAction<Void> {
	private ServerSettingsSetter serverSettingsSetter;

	public SetServerSettingDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, ServerSettingsSetter serverSettingsSetter) {
		super(databaseSession, accessMethod);
		this.serverSettingsSetter = serverSettingsSetter;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ServerSettings serverSettings = getServerSettings();
		serverSettingsSetter.set(serverSettings);
		getDatabaseSession().store(serverSettings);
		return null;
	}
}