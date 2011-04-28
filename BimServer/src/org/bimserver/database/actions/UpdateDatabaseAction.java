package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.UserException;

public class UpdateDatabaseAction extends BimDatabaseAction<Void> {

	private final IdEObject idEObject;

	public UpdateDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IdEObject idEObject) {
		super(bimDatabaseSession, accessMethod);
		this.idEObject = idEObject;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		getDatabaseSession().store(idEObject);
		return null;
	}
}