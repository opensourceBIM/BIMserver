package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.shared.UserException;

public class GetSerializerByIdDatabaseAction extends BimDatabaseAction<Serializer> {

	private final long oid;

	public GetSerializerByIdDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long oid) {
		super(bimDatabaseSession, accessMethod);
		this.oid = oid;
	}

	@Override
	public Serializer execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return null;
	}
}
