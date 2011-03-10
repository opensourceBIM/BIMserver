package org.bimserver.database.migrations;

import org.apache.commons.lang.StringUtils;
import org.bimserver.database.Database;

public class Migrator {
	public void migrate(Database database) throws MigrationException {
		int applicationSchemaVersion = database.getApplicationSchemaVersion();
		int databaseSchemaVersion = database.getDatabaseSchemaVersion();
		
		if (applicationSchemaVersion == databaseSchemaVersion) {
			// Do nothing
		} else if (applicationSchemaVersion > databaseSchemaVersion) {
			// Upgrade
			upgrade(database, applicationSchemaVersion, databaseSchemaVersion);
		} else if (applicationSchemaVersion < databaseSchemaVersion) {
			throw new MigrationException("Database schema version is greater than application schema version, you are probably using an older version of the software with a newer version of the database");
		}
	}

	private void upgrade(Database database, int applicationSchemaVersion, int databaseSchemaVersion) throws MigrationException {
		Schema schema = new Schema();
		for (int i=1; i<applicationSchemaVersion; i++) {
			String name = "org.bimserver.database.migrations.Step" + StringUtils.leftPad("" + i, 4, "0");
			try {
				Class<Migration> migrationClass = (Class<Migration>) Class.forName(name);
				Migration migration = migrationClass.newInstance();
				migration.migrate(schema);
				if (i < databaseSchemaVersion) {
					schema.upgradeDatabase(database);
				}
			} catch (ClassNotFoundException e) {
				throw new MigrationException("Required migration not found: " + name);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
