package org.bimserver.database.migrations;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OperationType;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Migrator {
	private static final Logger LOGGER = LoggerFactory.getLogger(Migrator.class);
	private final Database database;

	public Migrator(Database database) {
		this.database = database;
	}

	@SuppressWarnings("unchecked")
	private Migration getMigration(int number) {
		String name = "org.bimserver.database.migrations.steps.Step" + StringUtils.leftPad("" + number, 4, "0");
		try {
			Class<Migration> migrationClass = (Class<Migration>) Class.forName(name);
			return migrationClass.newInstance();
		} catch (Exception e) {
			if (e instanceof ClassNotFoundException) {
				// ignore
			} else {
				LOGGER.error("", e);
			}
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
				migration.migrate(schema, null);
				i++;
			} else {
				moreUpgrades = false;
			}
		}
		if (i < targetVersion) {
			LOGGER.warn("Not upgraded to " + targetVersion + ", probably missing Step files!");
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
		DatabaseSession session = database.createSession(OperationType.POSSIBLY_WRITE);
		try {
			Schema schema = migrate(session);
			session.commit();
			return schema;
		} catch (BimserverDatabaseException e) {
			throw new MigrationException(e);
		} catch (ServiceException e) {
			throw new MigrationException(e);
		} finally {
			session.close();
		}
	}

	private Schema upgrade(DatabaseSession databaseSession, int applicationSchemaVersion, int databaseSchemaVersion) throws MigrationException, InconsistentModelsException {
		Schema schema = new Schema();
		try {
			for (int i = 0; i <= applicationSchemaVersion; i++) {
				Migration migration = getMigration(i);
				if (migration != null) {
					migration.migrate(schema, databaseSession);
					if (i > databaseSchemaVersion) {
						schema.upgradeDatabase(database, i, databaseSession);
					}
					schema.clearUpdates();
				} else {
					throw new MigrationException("Required migration not found: " + i);
				}
			}
		} catch (NotImplementedException e) {
			throw new MigrationException(e);
		} catch (BimserverDatabaseException e) {
			throw new MigrationException(e);
		}
		
//		Schema emfSchema = new Schema();
//		emfSchema.addEPackage(StorePackage.eINSTANCE);
//		emfSchema.addEPackage(LogPackage.eINSTANCE);
//		emfSchema.addEPackage(Ifc2x3tc1Package.eINSTANCE);
		
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