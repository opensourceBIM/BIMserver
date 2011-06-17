package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.GuidanceProvider;
import org.bimserver.models.store.StorePackage;

public class GetAllGuidanceProvidersDatabaseAction extends GetAllDatabaseAction<GuidanceProvider> {

	public GetAllGuidanceProvidersDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod, GuidanceProvider.class, StorePackage.eINSTANCE.getGuidanceProvider());
	}
}