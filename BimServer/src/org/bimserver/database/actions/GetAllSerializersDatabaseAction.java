package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;

public class GetAllSerializersDatabaseAction extends GetAllDatabaseAction<Serializer> {

	public GetAllSerializersDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod, Serializer.class, StorePackage.eINSTANCE.getSerializer());
	}
}