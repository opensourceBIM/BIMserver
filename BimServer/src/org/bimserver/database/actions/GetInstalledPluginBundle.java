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

public class GetInstalledPluginBundle extends BimDatabaseAction<SPluginBundleVersion> {

	private Long oid;
	private BimServer bimServer;

	public GetInstalledPluginBundle(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, Long oid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.oid = oid;
	}

	@Override
	public SPluginBundleVersion execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		return bimServer.getSConverter().convertToSObject((PluginBundleVersion)getDatabaseSession().get(oid, OldQuery.getDefault()));
	}
}
