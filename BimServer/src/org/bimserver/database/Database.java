package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.CreateBaseProjectDatabaseAction;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.database.migrations.Migrator;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.DatabaseCreated;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.SmtpProtocol;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.BinUtils;
import org.bimserver.utils.DoubleHashMap;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.je.DatabaseNotFoundException;

public class Database implements BimDatabase {

	private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
	private static final String CLASS_LOOKUP_TABLE = "INT-ClassLookup";
	public static final String STORE_PROJECT_NAME = "INT-Store";
	public static final int STORE_PROJECT_ID = 1;
	public static final String SCHEMA_VERSION = "SCHEMA_VERSION";
	private static final String DATE_CREATED = "DATE_CREATED";
	private final Map<String, EPackage> emfPackages = new LinkedHashMap<String, EPackage>();
	private final KeyValueStore keyValueStore;
	private final DoubleHashMap<Short, EClass> classifiers = new DoubleHashMap<Short, EClass>();
	private final List<String> realClasses = new ArrayList<String>();
	private final Map<EClass, AtomicLong> oidCounters = new HashMap<EClass, AtomicLong>();
	private final AtomicInteger pidCounter = new AtomicInteger(1);
	private final Registry registry;
	private Date created;
	private final Set<DatabaseSession> sessions = Collections.newSetFromMap(new ConcurrentHashMap<DatabaseSession, Boolean>());
	private int databaseSchemaVersion;
	private short tableId;
	private Migrator migrator;
	private final MetaDataManager metaDataManager;
	private final BimServer bimServer;

	/*
	 * This variable should be _incremented_ with every (released)
	 * database-schema change. Do not change this variable when nothing has
	 * changed in the schema!
	 */
	public static final int APPLICATION_SCHEMA_VERSION = 20;

	public Database(BimServer bimServer, Set<? extends EPackage> emfPackages, KeyValueStore keyValueStore, MetaDataManager metaDataManager) throws DatabaseInitException {
		this.bimServer = bimServer;
		this.keyValueStore = keyValueStore;
		this.metaDataManager = metaDataManager;
		this.emfPackages.put(StorePackage.eINSTANCE.getName(), StorePackage.eINSTANCE);
		this.emfPackages.put(LogPackage.eINSTANCE.getName(), LogPackage.eINSTANCE);
		this.emfPackages.put(GeometryPackage.eINSTANCE.getName(), GeometryPackage.eINSTANCE);
		for (EPackage ePackage : emfPackages) {
			this.emfPackages.put(ePackage.getName(), ePackage);
		}
		this.registry = new Registry(keyValueStore);
	}

	public int getApplicationSchemaVersion() {
		return APPLICATION_SCHEMA_VERSION;
	}

	public int getDatabaseSchemaVersion() {
		return databaseSchemaVersion;
	}

	public EClass getEClassForName(String packageName, String className) {
		EPackage ePackage = emfPackages.get(packageName);
		if (ePackage.getEClassifier(className) != null) {
			return (EClass) ePackage.getEClassifier(className);
		}
		return null;
	}

	public void init() throws DatabaseInitException, DatabaseRestartRequiredException, InconsistentModelsException {
		DatabaseSession databaseSession = createSession();
		try {
			if (getKeyValueStore().isNew()) {
				keyValueStore.createTable(CLASS_LOOKUP_TABLE, null);
				keyValueStore.createTable(Database.STORE_PROJECT_NAME, null);
				keyValueStore.createTable(Registry.REGISTRY_TABLE, null);
				setDatabaseVersion(-1, databaseSession);
				created = new Date();
				registry.save(DATE_CREATED, created, databaseSession);
			} else {
				keyValueStore.openTable(CLASS_LOOKUP_TABLE);
				keyValueStore.openTable(Database.STORE_PROJECT_NAME);
				keyValueStore.openTable(Registry.REGISTRY_TABLE);
				created = registry.readDate(DATE_CREATED, databaseSession);
				if (created == null) {
					created = new Date();
					registry.save(DATE_CREATED, created, databaseSession);
				}
			}
			
			databaseSchemaVersion = registry.readInt(SCHEMA_VERSION, databaseSession, -1);
			
			migrator = new Migrator(this);

			if (getKeyValueStore().isNew()) {
				try {
					migrator.migrate(databaseSession);
				} catch (MigrationException e) {
					LOGGER.error("", e);
				}
				registry.save("isnew", true, databaseSession);
				databaseSession.commit();
				databaseSession.close();
				throw new DatabaseRestartRequiredException();
			} else if (registry.readBoolean("isnew", true, databaseSession)) {
				initInternalStructure(databaseSession);
				initCounters(databaseSession);

				ServerSettings settings = createDefaultSettings(databaseSession);
				databaseSession.store(settings);
				
				new CreateBaseProjectDatabaseAction(databaseSession, AccessMethod.INTERNAL).execute();
				AddUserDatabaseAction addUserDatabaseAction = new AddUserDatabaseAction(bimServer, databaseSession, AccessMethod.INTERNAL, "system", "system", "System", UserType.SYSTEM, new SystemAuthorization(1, TimeUnit.HOURS), false, null);
				addUserDatabaseAction.setCreateSystemUser();
				User systemUser = addUserDatabaseAction.execute();
				systemUser.setCreatedBy(systemUser);
				databaseSession.store(systemUser);

				DatabaseCreated databaseCreated = databaseSession.create(DatabaseCreated.class);
				databaseCreated.setAccessMethod(AccessMethod.INTERNAL);
				databaseCreated.setExecutor(systemUser);
				databaseCreated.setDate(new Date());
				databaseCreated.setPath(getKeyValueStore().getLocation());
				databaseCreated.setVersion(databaseSchemaVersion);
				databaseSession.store(databaseCreated);

				registry.save("isnew", false, databaseSession);
			} else {
				initInternalStructure(databaseSession);
				initCounters(databaseSession);
			}
			for (EClass eClass : classifiers.keyBSet()) {
				if (eClass.getEPackage() == Ifc2x3tc1Package.eINSTANCE || eClass.getEPackage() == Ifc4Package.eINSTANCE) {
					realClasses.add(eClass.getName());
				}
			}
			databaseSession.commit();
		} catch (UserException e) {
			LOGGER.error("", e);
			close();
			throw new DatabaseInitException(e.getMessage());
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
			close();
			throw new DatabaseInitException(e.getMessage());
		} catch (DatabaseRestartRequiredException e) {
			throw e;
		} catch (Exception e) {
			throw new DatabaseInitException(e);
		} finally {
			databaseSession.close();
		}
	}

	public ServerSettings createDefaultSettings(DatabaseSession databaseSession) throws BimserverDatabaseException {
		ServerSettings settings = databaseSession.create(ServerSettings.class);
		settings.setEmailSenderAddress("no-reply@bimserver.org");
		settings.setEmailSenderName("Administrator");
		settings.setSiteAddress("");
		settings.setSmtpServer("");
		settings.setSmtpPort(25);
		settings.setSmtpProtocol(SmtpProtocol.SMTP);
		settings.setProtocolBuffersPort(-1);
		settings.setAllowCreateValidatedUser(true);
		settings.setAllowSelfRegistration(false);
		settings.setAllowUsersToCreateTopLevelProjects(false);
		settings.setCheckinMergingEnabled(false);
		settings.setHideUserListForNonAdmin(true);
		settings.setCacheOutputFiles(true);
		settings.setServiceRepositoryUrl("https://raw.githubusercontent.com/opensourceBIM/BIMserver-Repository/master");
		settings.setAllowOnlyWhitelisted(false);
		settings.setGenerateGeometryOnCheckin(true);
		settings.setReuseGeometry(true);
		settings.setRenderEngineProcesses(1);
		settings.setSessionTimeOutSeconds(60 * 60 * 24 * 30); // 1 month
		settings.getWhitelistedDomains().add("localhost");
		settings.getWhitelistedDomains().add("localhost:8080");
		return settings;
	}
	
	public long newOid(EClass eClass) {
		return oidCounters.get(eClass).addAndGet(65536);
	}

	public long getCounter(EClass eClass) {
		return oidCounters.get(eClass).get();
	}

	public EClassifier getEClassifier(String packageName, String classifierName) throws BimserverDatabaseException {
		if (packageName == null) {
			throw new BimserverDatabaseException("No package name given");
		}
		if (packageName.contains(".")) {
			packageName = packageName.substring(packageName.lastIndexOf(".") + 1);
		}
		EPackage ePackage = emfPackages.get(packageName);
		if (ePackage == null) {
			throw new BimserverDatabaseException("No package found with name " + packageName);
		}
		if (ePackage.getEClassifier(classifierName) != null) {
			return ePackage.getEClassifier(classifierName);
		}
		throw new BimserverDatabaseException("No classifier found with name " + classifierName + " in package " + packageName);
	}

	public EClass getEClass(String packageName, String classifierName) throws BimserverDatabaseException {
		EClassifier eClassifier = getEClassifier(packageName, classifierName);
		if (eClassifier instanceof EClass) {
			return (EClass)eClassifier;
		}
		throw new BimserverDatabaseException("Classifier " + packageName + "." + classifierName + " is not an EClass");
	}

	public void initInternalStructure(DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		RecordIterator recordIterator = keyValueStore.getRecordIterator(CLASS_LOOKUP_TABLE, databaseSession);
		try {
			Record record = recordIterator.next();
			while (record != null) {
				String packageAndClassName = BinUtils.byteArrayToString(record.getValue());
				String packageName = packageAndClassName.substring(0, packageAndClassName.indexOf("_"));
				String className = packageAndClassName.substring(packageAndClassName.indexOf("_") + 1);
				EClass eClass = (EClass) getEClassifier(packageName, className);
				keyValueStore.openTable(packageAndClassName);
				
				for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
					if (eStructuralFeature.getEAnnotation("singleindex") != null) {
						String indexTableName = eClass.getEPackage().getName() + "_" + eClass.getName() + "_" + eStructuralFeature.getName();
						try {
							keyValueStore.openIndexTable(indexTableName);
						} catch (DatabaseNotFoundException e) {
						}
					}
				}
				
				Short cid = BinUtils.byteArrayToShort(record.getKey());
				classifiers.put(cid, eClass);
				record = recordIterator.next();
			}
		} finally {
			recordIterator.close();
		}
	}

	public void initCounters(DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		for (EClass eClass : classifiers.keyBSet()) {
			RecordIterator iterator = keyValueStore.getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), databaseSession);
			try {
				Record record = iterator.last();
				initCounter(eClass);
				if (record != null) {
					ByteBuffer buffer = ByteBuffer.wrap(record.getKey());
					int pid = buffer.getInt();
					long oid = buffer.getLong();
					if (oid > oidCounters.get(eClass).get()) {
						oidCounters.put(eClass, new AtomicLong(oid));
					}
					if (pid > pidCounter.get()) {
						pidCounter.set(pid);
					}
				}
			} finally {
				iterator.close();
			}
		}
	}

	private void initCounter(EClass eClass) {
		ByteBuffer cidBuffer = ByteBuffer.wrap(new byte[8]);
		cidBuffer.putShort(6, getCidOfEClass(eClass));
		long startOid = cidBuffer.getLong(0);
		oidCounters.put(eClass, new AtomicLong(startOid));
	}

	public int newPid() {
		return pidCounter.incrementAndGet();
	}

	public void close() {
		keyValueStore.close();
	}

	public List<String> getAvailableClasses() {
		return realClasses;
	}

	public DatabaseSession createSession() {
		DatabaseSession databaseSession = new DatabaseSession(this, keyValueStore.startTransaction());
		sessions.add(databaseSession);
		return databaseSession;
	}

	public KeyValueStore getKeyValueStore() {
		return keyValueStore;
	}

	public Set<EClass> getClasses() {
		return classifiers.keyBSet();
	}

	public EClass getEClassForCid(short cid) {
		return classifiers.getB(cid);
	}

	public Short getCidOfEClass(EClass eClass) {
		return classifiers.getA(eClass);
	}

	public Registry getRegistry() {
		return registry;
	}

	public Date getCreated() {
		return created;
	}

	public void unregisterSession(DatabaseSession databaseSession) {
		sessions.remove(databaseSession);
	}

	public void setDatabaseVersion(int version, DatabaseSession databaseSession) throws BimserverLockConflictException {
		databaseSchemaVersion = version;
		registry.save(SCHEMA_VERSION, version, databaseSession);
	}

	@Override
	public Migrator getMigrator() {
		return migrator;
	}

	public boolean createTable(EClass eClass, DatabaseSession databaseSession) throws BimserverDatabaseException {
		boolean createTable = keyValueStore.createTable(eClass.getEPackage().getName() + "_" + eClass.getName(), databaseSession);
		if (createTable) {
			tableId++;
			try {
				keyValueStore.store(CLASS_LOOKUP_TABLE, BinUtils.shortToByteArray(tableId), BinUtils.stringToByteArray(eClass.getEPackage().getName() + "_" + eClass.getName()), null);
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			}
			return true;
		}
		return false;
	}

	public boolean createIndexTable(EClass eClass, EStructuralFeature eStructuralFeature, DatabaseSession databaseSession) throws BimserverDatabaseException {
		boolean createTable = keyValueStore.createIndexTable(eClass.getEPackage().getName() + "_" + eClass.getName() + "_" + eStructuralFeature.getName(), databaseSession);
		return createTable;
	}

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}
	
	public DatabaseSession getDatabaseSession(long txnid) {
		for (DatabaseSession databaseSession : sessions) {
			if (databaseSession.getTransactionId() == txnid) {
				return databaseSession;
			}
		}
		return null;
	}

	public void incrementCommittedWrites(long committedWrites) {
		keyValueStore.incrementCommittedWrites(committedWrites);
	}

	public void incrementReads(long reads) {
		keyValueStore.incrementReads(reads);
	}
	
	public EClass getEClassForOid(long oid) throws BimserverDatabaseException {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
		buffer.putLong(oid);
		short cid = buffer.getShort(6);
		EClass eClass = getEClassForCid(cid);
		if (eClass == null) {
			throw new BimserverDatabaseException("No class for cid " + cid + " (cid came from oid: " + oid  + ")");
		}
		return eClass;
	}
}