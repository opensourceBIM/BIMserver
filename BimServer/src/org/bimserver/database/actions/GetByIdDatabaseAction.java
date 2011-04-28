package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;

public class GetByIdDatabaseAction<T> extends BimDatabaseAction<T> {

	private final EClass eClass;
	private final long oid;

	public GetByIdDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long oid, EClass eClass) {
		super(bimDatabaseSession, accessMethod);
		this.oid = oid;
		this.eClass = eClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T execute() throws UserException, BimDeadlockException, BimDatabaseException {
		return (T) getDatabaseSession().get(eClass, oid, false);
	}
}