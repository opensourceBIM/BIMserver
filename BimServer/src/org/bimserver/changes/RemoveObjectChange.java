package org.bimserver.changes;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;

public class RemoveObjectChange implements Change {

	private final long oid;
	private final String className;

	public RemoveObjectChange(String className, long oid) {
		this.className = className;
		this.oid = oid;
	}

	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		EClass eClass = bimDatabaseSession.getEClassForName(className);
		if (eClass == null) {
			throw new UserException("Unknown classname " + className);
		}
		IdEObject idEObject = bimDatabaseSession.get(eClass, pid, rid-1, oid, false);
		if (idEObject == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}
		bimDatabaseSession.delete(idEObject);
	}
}
