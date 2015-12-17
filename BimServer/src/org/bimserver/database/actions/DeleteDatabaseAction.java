package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class DeleteDatabaseAction<T extends IdEObject> extends BimDatabaseAction<Void> {

	private final long oid;
	private final EClass eClass;

	public DeleteDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, EClass eClass, long oid) {
		super(databaseSession, accessMethod);
		this.eClass = eClass;
		this.oid = oid;
	}

	public EClass geteClass() {
		return eClass;
	}
	
	public long getOid() {
		return oid;
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		T object = getDatabaseSession().get(eClass, oid, OldQuery.getDefault());
		if (object == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}
		getDatabaseSession().delete(object, object.getRid() + 1);
		return null;
	}
}