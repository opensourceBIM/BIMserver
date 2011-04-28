package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IgnoreFile;
import org.bimserver.models.store.StorePackage;

public class GetIgnoreFileByIdDatabaseAction extends GetByIdDatabaseAction<IgnoreFile> {

	public GetIgnoreFileByIdDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long oid) {
		super(bimDatabaseSession, accessMethod, oid, StorePackage.eINSTANCE.getIgnoreFile());
	}
}