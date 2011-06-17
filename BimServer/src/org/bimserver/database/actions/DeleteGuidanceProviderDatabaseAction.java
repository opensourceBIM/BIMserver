package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;

public class DeleteGuidanceProviderDatabaseAction extends DeleteDatabaseAction {

	public DeleteGuidanceProviderDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long ifid) {
		super(bimDatabaseSession, accessMethod, StorePackage.eINSTANCE.getGuidanceProvider(), ifid);
	}
}