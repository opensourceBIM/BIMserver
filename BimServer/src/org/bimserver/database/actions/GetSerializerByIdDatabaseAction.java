package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;

public class GetSerializerByIdDatabaseAction extends GetByIdDatabaseAction<Serializer> {

	public GetSerializerByIdDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long oid) {
		super(bimDatabaseSession, accessMethod, oid, StorePackage.eINSTANCE.getSerializer());
	}
}