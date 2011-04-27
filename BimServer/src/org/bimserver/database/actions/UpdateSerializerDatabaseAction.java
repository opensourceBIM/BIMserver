package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.shared.UserException;

public class UpdateSerializerDatabaseAction extends BimDatabaseAction<Void> {

	public UpdateSerializerDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Serializer serializer) {
		super(bimDatabaseSession, accessMethod);
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return null;
	}
}