package org.bimserver.database;

import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.Migrator;

public interface BimDatabase {
	BimDatabaseSession createSession(boolean useTransactions);

	BimDatabaseSession createReadOnlySession();

	void close();

	Migrator getMigrator();

	void init() throws DatabaseInitException, DatabaseRestartRequiredException, InconsistentModelsException;

	long newOid();
}