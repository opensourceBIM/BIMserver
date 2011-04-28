package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;

public class AddSerializerDatabaseAction extends AddDatabaseAction {

	public AddSerializerDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Serializer serializer) {
		super(bimDatabaseSession, accessMethod, serializer);
	}
}