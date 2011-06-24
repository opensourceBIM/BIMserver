package org.bimserver.changes;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EAttribute;

public class SetAttributeChange implements Change {

	private final long oid;
	private final String attributeName;
	private final Object value;
	private final String className;

	public SetAttributeChange(long oid, String className, String attributeName, Object value) {
		this.oid = oid;
		this.className = className;
		this.attributeName = attributeName;
		this.value = value;
	}

	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		IdEObject idEObject = bimDatabaseSession.get(bimDatabaseSession.getEClassForName(className), oid, false);
		if (idEObject == null) {
			throw new UserException("No object of type " + className + " found in project with pid " + pid);
		}
		EAttribute eAttribute = bimDatabaseSession.getMetaDataManager().getEAttribute(className, attributeName);
		if (eAttribute == null) {
			throw new UserException("No attribute with the name " + attributeName + " found in class " + className);
		}
		if (eAttribute.isMany()) {
			throw new UserException("Attribute is not of type 'single'");
		}
		idEObject.eSet(eAttribute, value);
		bimDatabaseSession.store(idEObject);
	}
}