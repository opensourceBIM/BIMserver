package org.bimserver.database.migrations;

import org.apache.commons.lang.StringUtils;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;

public class Migrator {
	public Schema migrateSchemaTo(int targetVersion) {
		Schema schema = new Schema();
		boolean moreUpgrades = true;
		int i = 0;
		while (moreUpgrades && i <= targetVersion) {
			String name = "org.bimserver.database.migrations.steps.Step" + StringUtils.leftPad("" + i, 4, "0");
			try {
				Class<Migration> migrationClass = (Class<Migration>) Class.forName(name);
				Migration migration = migrationClass.newInstance();
				migration.migrate(schema);
				i++;
			} catch (ClassNotFoundException e) {
				moreUpgrades = false;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return schema;
	}

	public int getLatestVersion() {
		boolean more = true;
		int i = 0;
		while (more) {
			String name = "org.bimserver.database.migrations.steps.Step" + StringUtils.leftPad("" + i, 4, "0");
			try {
				Class<Migration> migrationClass = (Class<Migration>) Class.forName(name);
				i++;
			} catch (ClassNotFoundException e) {
				more = false;
			}
		}
		return i;
	}
	
	public Schema migrateSchemaToLatest() {
		return migrateSchemaTo(getLatestVersion());
	}
	
	public Schema migrate(Database database, DatabaseSession databaseSession) throws MigrationException {
		int applicationSchemaVersion = database.getApplicationSchemaVersion();
		int databaseSchemaVersion = database.getDatabaseSchemaVersion();
	
		return upgrade(database, databaseSession, applicationSchemaVersion, databaseSchemaVersion);
	}

	@SuppressWarnings("unchecked")
	private Schema upgrade(Database database, DatabaseSession databaseSession, int applicationSchemaVersion, int databaseSchemaVersion) throws MigrationException {
		Schema schema = new Schema();
		for (int i=0; i<=applicationSchemaVersion; i++) {
			String name = "org.bimserver.database.migrations.steps.Step" + StringUtils.leftPad("" + i, 4, "0");
			try {
				Class<Migration> migrationClass = (Class<Migration>) Class.forName(name);
				Migration migration = migrationClass.newInstance();
				migration.migrate(schema);
				if (i >= databaseSchemaVersion) {
					schema.upgradeDatabase(database, i, databaseSession);
					schema.clearUpdates();
				}
			} catch (ClassNotFoundException e) {
				throw new MigrationException("Required migration not found: " + name);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return schema;
	}
}