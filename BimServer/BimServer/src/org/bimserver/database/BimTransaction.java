package org.bimserver.database;

public interface BimTransaction {

	void setName(String string);
	void close();
	void rollback();
	void commit() throws BimDeadlockException, BimDatabaseException;
}
