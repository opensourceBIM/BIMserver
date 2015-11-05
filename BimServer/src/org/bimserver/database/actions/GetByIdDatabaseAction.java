package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class GetByIdDatabaseAction<T> extends BimDatabaseAction<T> {

	private final EClass eClass;
	private final long oid;

	public GetByIdDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long oid, EClass eClass) {
		super(databaseSession, accessMethod);
		this.oid = oid;
		this.eClass = eClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return (T) getDatabaseSession().get(eClass, oid, Query.getDefault());
	}
}