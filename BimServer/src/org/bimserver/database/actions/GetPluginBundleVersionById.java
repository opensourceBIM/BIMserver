package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetPluginBundleVersionById extends PluginBundleDatabaseAction<SPluginBundleVersion> {
	private BimServer bimServer;
	private Long pbid;

	public GetPluginBundleVersionById(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, Long pbid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.pbid = pbid;
	}

	@Override
	public SPluginBundleVersion execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		PluginBundleVersion pluginBundle = getDatabaseSession().get(pbid, OldQuery.getDefault());
		return bimServer.getSConverter().convertToSObject(pluginBundle);
	}
}