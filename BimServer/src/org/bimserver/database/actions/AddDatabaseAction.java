package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;

public class AddDatabaseAction<T extends IdEObject> extends BimDatabaseAction<Long> {

	private final T idEObject;

	public AddDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, T idEObject) {
		super(databaseSession, accessMethod);
		this.idEObject = idEObject;
	}


	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return getDatabaseSession().store(idEObject);
	}
	
	public T getIdEObject() {
		return idEObject;
	}
}