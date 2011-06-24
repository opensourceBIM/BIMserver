package org.bimserver.changes;

import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EReference;

public class RemoveReferenceChange implements Change {

	private final long oid;
	private final String referenceName;
	private final int index;
	private final String className;

	public RemoveReferenceChange(long oid, String className, String referenceName, int index) {
		this.oid = oid;
		this.className = className;
		this.referenceName = referenceName;
		this.index = index;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		IdEObject idEObject = bimDatabaseSession.get(bimDatabaseSession.getEClassForName(className), oid, false);
		if (idEObject == null) {
			throw new UserException("No object of type " + className + " found in project with pid " + pid);
		}
		EReference eReference = bimDatabaseSession.getMetaDataManager().getEReference(className, referenceName);
		if (eReference == null) {
			throw new UserException("No reference with the name " + referenceName + " found in class " + className);
		}
		if (!eReference.isMany()) {
			throw new UserException("Reference is not of type 'many'");
		}
		List list = (List) idEObject.eGet(eReference);
		list.remove(index);
		bimDatabaseSession.store(idEObject);
	}
}
