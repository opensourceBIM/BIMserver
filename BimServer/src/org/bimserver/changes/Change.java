package org.bimserver.changes;

import java.io.IOException;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.shared.exceptions.UserException;

public interface Change {

	void execute(Transaction transaction) throws UserException, BimserverLockConflictException, BimserverDatabaseException, IOException, QueryException;
}