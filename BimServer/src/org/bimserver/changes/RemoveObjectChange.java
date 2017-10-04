package org.bimserver.changes;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class RemoveObjectChange implements Change {

	private final long oid;
	private EClass eClass;

	/**
	 * This is a potentially quite slow action
	 * 
	 * @param oid
	 * @param eClass
	 */
	public RemoveObjectChange(long oid, EClass eClass) {
		this.oid = oid;
		this.eClass = eClass;
	}

	public EClass geteClass() {
		return eClass;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		throw new UserException("Not implemented");
	}
}