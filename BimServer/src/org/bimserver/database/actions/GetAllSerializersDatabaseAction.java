package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.shared.UserException;

public class GetAllSerializersDatabaseAction extends BimDatabaseAction<List<Serializer>>{

	public GetAllSerializersDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod);
	}

	@Override
	public List<Serializer> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return null;
	}
}
