package org.bimserver.database;

public interface BimDatabase {
	BimDatabaseSession createSession();

	BimDatabaseSession createReadOnlySession();

	void close();
}