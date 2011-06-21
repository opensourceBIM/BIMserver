package org.bimserver.changes;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;

public class CreateObjectChange implements Change {

	private final long oid;
	private final String type;

	public CreateObjectChange(String type, long oid) {
		this.type = type;
		this.oid = oid;
	}

	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		EClass eClass = bimDatabaseSession.getEClassForName(type);
		if (eClass == null) {
			throw new UserException("Type " + type + " does not exist");
		}
		IdEObject eObject = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
		eObject.setOid(oid);
		eObject.setPid(pid);
		bimDatabaseSession.store(eObject, pid, rid);
	}
}