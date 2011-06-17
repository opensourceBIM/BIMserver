package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.GuidanceProvider;

public class AddGuidanceProviderDatabaseAction extends AddDatabaseAction {

	public AddGuidanceProviderDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, GuidanceProvider guidanceProvider) {
		super(bimDatabaseSession, accessMethod, guidanceProvider);
	}
}