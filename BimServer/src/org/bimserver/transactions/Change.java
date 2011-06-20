package org.bimserver.transactions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.shared.UserException;

public interface Change {

	void execute(int transactionPid, BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException;
}
