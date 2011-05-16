package org.bimserver.database.migrations;

import java.util.LinkedHashSet;
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
			return (Migration) migrationClass.newInstance();
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
			if (migration != null) {
				migration.migrate(schema);
				i++;
			} else {
				moreUpgrades = false;
			}
		}
		return schema;
	}

	public int getLatestVersion() {
		int i = -1;
		while (true) {
			Migration migration = getMigration(i+1);
			if (migration == null) {
				return i;
			} else {
				i++;
			}
		}
	}

	public Schema migrateSchemaToLatest() {
		return migrateSchemaTo(getLatestVersion());
	}

	public Schema migrate() throws MigrationException, InconsistentModelsException {
		DatabaseSession session = database.createSession(true);
		try {
			Schema schema = migrate(session);
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

	private Schema upgrade(DatabaseSession databaseSession, int applicationSchemaVersion, int databaseSchemaVersion) throws MigrationException, InconsistentModelsException {
		Schema schema = new Schema();
		for (int i = 0; i <= applicationSchemaVersion; i++) {
			Migration migration = getMigration(i);
			if (migration != null) {
				migration.migrate(schema);
				if (i > databaseSchemaVersion) {
					schema.upgradeDatabase(database, i, databaseSession);
				}
				schema.clearUpdates();
			} else {
				throw new MigrationException("Required migration not found: " + i);
			}
		}
		
//		Schema emfSchema = new Schema();
//		emfSchema.addEPackage(StorePackage.eINSTANCE);
//		emfSchema.addEPackage(LogPackage.eINSTANCE);
//		emfSchema.addEPackage(Ifc2x3Package.eINSTANCE);
//		
//		SchemaChecker checker = new SchemaChecker(schema, emfSchema);
//		if (checker.compare()) {
//			return schema;
//		} else {
//			throw new InconsistentModelsException();
//		}
		return schema;
	}

	public Set<SMigration> getMigrations() {
		Set<SMigration> migrations = new LinkedHashSet<SMigration>();
		int applicationSchemaVersion = database.getApplicationSchemaVersion();
		int databaseSchemaVersion = database.getDatabaseSchemaVersion();
		for (int i = applicationSchemaVersion; i >= 0; i--) {
			Migration migration = getMigration(i);
			if (migration != null) {
				SMigration sMigration = new SMigration();
				sMigration.setNumber(i);
				sMigration.setExecuted(i <= databaseSchemaVersion);
				sMigration.setDescription(migration.getDescription());
				migrations.add(sMigration);
			}
		}
		return migrations;
	}

	public Schema migrate(DatabaseSession session) throws MigrationException, InconsistentModelsException {
		int applicationSchemaVersion = database.getApplicationSchemaVersion();
		int databaseSchemaVersion = database.getDatabaseSchemaVersion();

		Schema schema = upgrade(session, applicationSchemaVersion, databaseSchemaVersion);
		return schema;
	}

	public boolean migrationRequired() {
		return database.getApplicationSchemaVersion() > database.getDatabaseSchemaVersion();
	}

	public boolean migrationImpossible() {
		return database.getApplicationSchemaVersion() < database.getDatabaseSchemaVersion();
	}
}