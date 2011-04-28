package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IgnoreFile;
import org.bimserver.models.store.StorePackage;

public class GetAllIgnoreFilesDatabaseAction extends GetAllDatabaseAction<IgnoreFile> {

	public GetAllIgnoreFilesDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod, IgnoreFile.class, StorePackage.eINSTANCE.getIgnoreFile());
	}
}