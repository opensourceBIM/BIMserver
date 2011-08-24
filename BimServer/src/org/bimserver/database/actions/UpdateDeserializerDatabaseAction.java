package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Deserializer;

public class UpdateDeserializerDatabaseAction extends UpdateDatabaseAction {

	public UpdateDeserializerDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Deserializer deserializer) {
		super(bimDatabaseSession, accessMethod, deserializer);
	}
}