package org.bimserver.database;

import org.bimserver.database.migrations.Migrator;

public interface BimDatabase {
	BimDatabaseSession createSession();

	BimDatabaseSession createReadOnlySession();

	void close();

	Migrator getMigrator();
}