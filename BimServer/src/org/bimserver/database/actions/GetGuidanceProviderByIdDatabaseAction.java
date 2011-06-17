package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.GuidanceProvider;
import org.bimserver.models.store.StorePackage;

public class GetGuidanceProviderByIdDatabaseAction extends GetByIdDatabaseAction<GuidanceProvider> {

	public GetGuidanceProviderByIdDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long oid) {
		super(bimDatabaseSession, accessMethod, oid, StorePackage.eINSTANCE.getGuidanceProvider());
	}
}