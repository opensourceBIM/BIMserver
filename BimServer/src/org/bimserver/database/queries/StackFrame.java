package org.bimserver.database.queries;

import java.util.Set;

import org.bimserver.BimserverDatabaseException;

public interface StackFrame {
	Set<StackFrame> process() throws BimserverDatabaseException, QueryException;
}