package org.bimserver.database.migrations;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.shared.SMigration;

public class Migrator {
	private final Database database;

	public Migrator(Database database) {
		this.database = database;
	}

	@SuppressWarnings("unchecked")
	private Migration getMigration(int number) {
		String name = "org.bimserver.database.migrations.steps.Step" + StringUtils.leftPad("" + number, 4, "0");
		try {
			Class<Migration> migrationClass = (Class<Migration>) Class.forName(name);
			return (Migration)migrationClass.newInstance();
		} catch (ClassNotFoundException e) {
			return null;
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}
	
	public Schema migrateSchemaTo(int targetVersion) {
		Schema schema = new Schema();
		boolean moreUpgrades = true;
		int i = 0;
		while (moreUpgrades && i <= targetVersion) {
			Migration migration = getMigration(i);
			if  (migration != null) {
				migration.migrate(schema);
				i++;
			} else {
				moreUpgrades = false;
			}
		}
		return schema;
	}

	public int getLatestVersion() {
		boolean more = true;
		int i = 0;
		while (more) {
			Migration migration = getMigration(i);
			if (migration != null) {
				i++;
			} else {
				more = false;
			}
		}
		return i;
	}
	
	public Schema migrateSchemaToLatest() {
		return migrateSchemaTo(getLatestVersion());
	}
	
	public Schema migrate() throws MigrationException {
		DatabaseSession session = database.createSession();
		try {
			int applicationSchemaVersion = database.getApplicationSchemaVersion();
			int databaseSchemaVersion = database.getDatabaseSchemaVersion();
			
			Schema schema = upgrade(session, applicationSchemaVersion, databaseSchemaVersion);
			session.commit();
			return schema;
		} catch (BimDeadlockException e) {
			throw new MigrationException(e);
		} catch (BimDatabaseException e) {
			throw new MigrationException(e);
		} finally {
			session.close();
		}
	}

	private Schema upgrade(DatabaseSession databaseSession, int applicationSchemaVersion, int databaseSchemaVersion) throws MigrationException {
		Schema schema = new Schema();
		for (int i=0; i<=applicationSchemaVersion; i++) {
			Migration migration = getMigration(i);
			if (migration != null) {
				migration.migrate(schema);
				if (i >= databaseSchemaVersion) {
					schema.upgradeDatabase(database, i, databaseSession);
					schema.clearUpdates();
				}
			} else {
				throw new MigrationException("Required migration not found: " + i);
			}
		}
		return schema;
	}

	public Set<SMigration> getPendingMigrations() {
		Set<SMigration> migrations = new HashSet<SMigration>();
		int applicationSchemaVersion = database.getApplicationSchemaVersion();
		int databaseSchemaVersion = database.getDatabaseSchemaVersion();
		for (int i=databaseSchemaVersion+1; i<=applicationSchemaVersion; i++) {
			Migration migration = getMigration(i);
			if (migration != null) {
				SMigration sMigration = new SMigration();
				sMigration.setNumber(i);
				sMigration.setDescription(migration.getDescription());
				migrations.add(sMigration);
			}
		}
		return migrations;
	}
}