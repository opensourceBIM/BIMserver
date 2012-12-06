package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class SetServerSettingDatabaseAction extends BimDatabaseAction<Void> {
	private ServerSettingsSetter serverSettingsSetter;
	private BimServer bimServer;

	public SetServerSettingDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, ServerSettingsSetter serverSettingsSetter) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.serverSettingsSetter = serverSettingsSetter;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ServerSettings serverSettings = getDatabaseSession().getSingle(StorePackage.eINSTANCE.getServerSettings(), ServerSettings.class);
		serverSettingsSetter.set(serverSettings);
		getDatabaseSession().store(serverSettings);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getServerSettingsCache().updateCache();
			}
		});
		return null;
	}
}