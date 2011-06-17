package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.GuidanceProvider;

public class UpdateGuidanceProviderDatabaseAction extends UpdateDatabaseAction {

	public UpdateGuidanceProviderDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, GuidanceProvider guidanceProvider) {
		super(bimDatabaseSession, accessMethod, guidanceProvider);
	}
}