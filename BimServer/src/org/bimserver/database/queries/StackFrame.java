package org.bimserver.database.queries;

import org.bimserver.BimserverDatabaseException;

public interface StackFrame {
	StackFrame process() throws BimserverDatabaseException, QueryException;
}