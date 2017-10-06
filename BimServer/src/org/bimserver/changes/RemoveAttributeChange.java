package org.bimserver.changes;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.shared.exceptions.UserException;

public class RemoveAttributeChange implements Change {

	private final long oid;
	private final String attributeName;
	private final int index;

	public RemoveAttributeChange(long oid, String attributeName, int index) {
		this.oid = oid;
		this.attributeName = attributeName;
		this.index = index;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		throw new UserException("Not implemented");
	}
}
