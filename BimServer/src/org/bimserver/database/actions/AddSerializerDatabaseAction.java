package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.shared.UserException;

public class AddSerializerDatabaseAction extends BimDatabaseAction<Void> {

	private final Serializer serializer;

	public AddSerializerDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Serializer serializer) {
		super(bimDatabaseSession, accessMethod);
		this.serializer = serializer;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		getDatabaseSession().store(serializer);
		return null;
	}
}