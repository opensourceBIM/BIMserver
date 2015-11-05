package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;

public class UpdateDatabaseAction<T extends IdEObject> extends BimDatabaseAction<Void> {

	private final T idEObject;

	public UpdateDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, T idEObject) {
		super(databaseSession, accessMethod);
		this.idEObject = idEObject;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		getDatabaseSession().store(idEObject);
		return null;
	}
	
	public T getIdEObject() {
		return idEObject;
	}
}