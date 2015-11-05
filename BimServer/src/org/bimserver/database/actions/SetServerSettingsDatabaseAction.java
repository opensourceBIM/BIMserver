package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SServerSettings;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class SetServerSettingsDatabaseAction extends BimDatabaseAction<Void> {

	private SServerSettings serverSettings;

	public SetServerSettingsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, SServerSettings serverSettings) {
		super(databaseSession, accessMethod);
		this.serverSettings = serverSettings;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ServerSettings existingServerSettings = getDatabaseSession().getSingle(StorePackage.eINSTANCE.getServerSettings(), Query.getDefault());
		existingServerSettings.getWhitelistedDomains().clear();
		new SConverter().convertFromSObject(serverSettings, existingServerSettings, getDatabaseSession());
		getDatabaseSession().store(existingServerSettings);
		return null;
	}
}