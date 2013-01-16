package org.bimserver.database.migrations;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;

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
		DatabaseSession session = database.createSession();
		try {
			Schema schema = migrate(session);
			session.commit();
			return schema;
		} catch (BimserverDatabaseException e) {
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
		
		Schema emfSchema = new Schema();
		emfSchema.addEPackage(StorePackage.eINSTANCE);
		emfSchema.addEPackage(LogPackage.eINSTANCE);
		emfSchema.addEPackage(Ifc2x3tc1Package.eINSTANCE);
		
		// Check whether the migrated schema is the same as the programmatic schema		
//		SchemaChecker checker = new SchemaChecker(schema, emfSchema);
//		try {
//			checker.compare();
//		} catch (SchemaCompareException e) {
//			throw new InconsistentModelsException(e);
//		}
		
		return schema;
	}

	public List<org.bimserver.models.store.Migration> getMigrations() {
		List<org.bimserver.models.store.Migration> migrations = new ArrayList<org.bimserver.models.store.Migration>();
		int applicationSchemaVersion = database.getApplicationSchemaVersion();
		int databaseSchemaVersion = database.getDatabaseSchemaVersion();
		for (int i = applicationSchemaVersion; i >= 0; i--) {
			Migration migration = getMigration(i);
			if (migration != null) {
				org.bimserver.models.store.Migration migrationObject = StoreFactory.eINSTANCE.createMigration();
				((IdEObjectImpl)migrationObject).setOid(i);
				migrationObject.setNumber(i);
				migrationObject.setExecuted(i <= databaseSchemaVersion);
				migrationObject.setDescription(migration.getDescription());
				migrations.add(migrationObject);
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