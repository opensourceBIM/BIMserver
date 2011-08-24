package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;

public class DeleteDeserializerDatabaseAction extends DeleteDatabaseAction {

	public DeleteDeserializerDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long sid) {
		super(bimDatabaseSession, accessMethod, StorePackage.eINSTANCE.getDeserializer(), sid);
	}
}