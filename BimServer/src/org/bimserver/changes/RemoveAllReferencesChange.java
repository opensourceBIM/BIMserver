package org.bimserver.changes;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.shared.exceptions.UserException;

public class RemoveAllReferencesChange implements Change {

	private Long oid;
	private String referenceName;

	public RemoveAllReferencesChange(Long oid, String referenceName) {
		this.oid = oid;
		this.referenceName = referenceName;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Transaction transaction) throws UserException, BimserverLockConflictException,
			BimserverDatabaseException {
		throw new UserException("Not implemented");
	}
}
