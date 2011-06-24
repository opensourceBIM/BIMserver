package org.bimserver.changes;

import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EReference;

public class AddReferenceChange implements Change {

	private final long oid;
	private final String referenceName;
	private final long referenceOid;
	private final String className;
	private final String referenceClassName;

	public AddReferenceChange(long oid, String className, String referenceName, long referenceOid, String referenceClassName) {
		this.oid = oid;
		this.className = className;
		this.referenceName = referenceName;
		this.referenceOid = referenceOid;
		this.referenceClassName = referenceClassName;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		IdEObject referencedObject = bimDatabaseSession.get(bimDatabaseSession.getEClassForName(referenceClassName), referenceOid, false);
		if (referencedObject == null) {
			throw new UserException("Referenced object of type " + referenceClassName + " with oid " + referenceOid + " not found");
		}
		List list = (List) idEObject.eGet(eReference);
		list.add(referencedObject);
		bimDatabaseSession.store(idEObject);
	}
}