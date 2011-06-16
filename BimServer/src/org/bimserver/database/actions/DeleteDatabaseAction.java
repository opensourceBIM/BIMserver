package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;

public class DeleteDatabaseAction extends BimDatabaseAction<Void> {

	private final long oid;
	private final EClass eClass;

	public DeleteDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, EClass eClass, long oid) {
		super(bimDatabaseSession, accessMethod);
		this.eClass = eClass;
		this.oid = oid;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		IdEObject object = getDatabaseSession().get(eClass, oid, false);
		if (object == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}
		getDatabaseSession().delete(object);
		return null;
	}
}