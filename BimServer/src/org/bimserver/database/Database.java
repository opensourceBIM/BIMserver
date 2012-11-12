package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.bimserver.BimServer;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.CreateBaseProjectDatabaseAction;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.database.migrations.Migrator;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.DatabaseCreated;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.BinUtils;
import org.bimserver.utils.DoubleHashMap;
import org.bimserver.webservices.SystemAuthorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database implements BimDatabase {

	private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
	private static final String CLASS_LOOKUP_TABLE = "INT-ClassLookup";
	public static final String STORE_PROJECT_NAME = "INT-Store";
	public static final int STORE_PROJECT_ID = 1;
	public static final String SCHEMA_VERSION = "SCHEMA_VERSION";
	private static final String DATE_CREATED = "DATE_CREATED";
	private final Set<EPackage> emfPackages = new LinkedHashSet<EPackage>();
	private final KeyValueStore keyValueStore;
	private final DoubleHashMap<Short, EClass> classifiers = new DoubleHashMap<Short, EClass>();
	private final List<String> realClasses = new ArrayList<String>();
	private final Map<EClass, Long> oidCounters = new HashMap<EClass, Long>();
	private volatile int pidCounter = 1;
	private final Registry registry;
	private Date created;
	private final Set<DatabaseSession> sessions = Collections.newSetFromMap(new ConcurrentHashMap<DatabaseSession, Boolean>());
	private int databaseSchemaVersion;
	private short tableId;
	private Migrator migrator;
	private MetaDataManager metaDataManager = new MetaDataManager();
	private final BimServer bimServer;

	/*
	 * This variable should be _incremented_ with every (released)
	 * database-schema change Do not change this variable when nothing has
	 * changed in the schema!
	 */
	public static final int APPLICATION_SCHEMA_VERSION = 26;

	public Database(BimServer bimServer, Set<? extends EPackage> emfPackages, KeyValueStore keyValueStore) throws DatabaseInitException {
		this.bimServer = bimServer;
		this.keyValueStore = keyValueStore;
		this.emfPackages.add(StorePackage.eINSTANCE);
		this.emfPackages.add(LogPackage.eINSTANCE);
		this.emfPackages.addAll(emfPackages);
		this.registry = new Registry(keyValueStore);
	}

	public int getApplicationSchemaVersion() {
		return APPLICATION_SCHEMA_VERSION;
	}

	public int getDatabaseSchemaVersion() {
		return databaseSchemaVersion;
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

				ServerSettings settings = createDefaultSettings();
				databaseSession.store(settings);
				
				new CreateBaseProjectDatabaseAction(databaseSession, AccessMethod.INTERNAL).execute();
				AddUserDatabaseAction addUserDatabaseAction = new AddUserDatabaseAction(bimServer, databaseSession, AccessMethod.INTERNAL, "system", "system", "System", UserType.SYSTEM, new SystemAuthorization(), false);
				addUserDatabaseAction.setCreateSystemUser();
				User systemUser = addUserDatabaseAction.execute();
				systemUser.setCreatedBy(systemUser);
				databaseSession.store(systemUser);

				DatabaseCreated databaseCreated = LogFactory.eINSTANCE.createDatabaseCreated();
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
				if (eClass.getEPackage() == Ifc2x3tc1Package.eINSTANCE && eClass != Ifc2x3tc1Package.eINSTANCE.getWrappedValue()) {
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


	public ServerSettings createDefaultSettings() {
		ServerSettings settings = StoreFactory.eINSTANCE.createServerSettings();
		settings.setCustomLogoAddress("http://www.bimserver.org/version/defaultlogo.gif");
		settings.setEmailSenderAddress("no-reply@bimserver.org");
		settings.setSiteAddress("");
		settings.setSmtpServer("");
		settings.setRegistrationAddition("");
		settings.setHeaderAddition("");
		settings.setFooterAddition("<script type=\"text/javascript\">var _gaq = _gaq || [];_gaq.push(['_setAccount', 'UA-12034708-3']);_gaq.push(['_trackPageview']);(function() {var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);})();</script>");
		settings.setProtocolBuffersPort(8020);
		settings.setAllowSelfRegistration(false);
		settings.setAllowUsersToCreateTopLevelProjects(false);
		settings.setCheckinMergingEnabled(false);
		settings.setHideUserListForNonAdmin(true);
		settings.setShowVersionUpgradeAvailable(false);
		settings.setCacheOutputFiles(true);
		settings.setServiceRepositoryUrl("http://extend.bimserver.org");
		settings.getWhitelistedDomains().add("localhost");
		settings.getWhitelistedDomains().add("localhost:8080");
		settings.getWhitelistedDomains().add("bimserver.logic-labs.nl");
		settings.getWhitelistedDomains().add("demo.bimserver.org");
		settings.getWhitelistedDomains().add("e-bouw.org:8080");
		settings.getWhitelistedDomains().add("bimgui.logic-labs.nl");
		settings.getWhitelistedDomains().add("bimsurfer.logic-labs.nl");
		return settings;
	}
	
	public synchronized long newOid(EClass eClass) {
		long id = oidCounters.get(eClass);
		long newId = id + 65536;
		oidCounters.put(eClass, newId);
		return newId;
	}

	private EClassifier getEClassifier(String classifierName) {
		for (EPackage ePackage : emfPackages) {
			if (ePackage.getEClassifier(classifierName) != null) {
				return ePackage.getEClassifier(classifierName);
			}
		}
		return null;
	}

	public void initInternalStructure(DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		RecordIterator recordIterator = keyValueStore.getRecordIterator(CLASS_LOOKUP_TABLE, databaseSession);
		try {
			Record record = recordIterator.next();
			while (record != null) {
				String className = BinUtils.byteArrayToString(record.getValue());
				EClass eClass = (EClass) getEClassifier(className);
				keyValueStore.openTable(eClass.getEPackage().getName() + "_" + eClass.getName());
				Short cid = BinUtils.byteArrayToShort(record.getKey());
				classifiers.put(cid, eClass);
				record = recordIterator.next();
			}
		} finally {
			recordIterator.close();
		}
	}

	public void initCounters(DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		DatabaseSession session = createSession();
		try {
			for (EClass eClass : classifiers.keyBSet()) {
				RecordIterator iterator = keyValueStore.getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), databaseSession);
				try {
					Record record = iterator.last();
					initCounter(eClass);
					if (record != null) {
						ByteBuffer buffer = ByteBuffer.wrap(record.getKey());
						int pid = buffer.getInt();
						long oid = buffer.getLong();
						if (oid > oidCounters.get(eClass)) {
							oidCounters.put(eClass, oid);
						}
						if (pid > pidCounter) {
							pidCounter = pid;
						}
					}
				} finally {
					iterator.close();
				}
			}
		} finally {
			session.close();
		}
	}

	private void initCounter(EClass eClass) {
		ByteBuffer cidBuffer = ByteBuffer.wrap(new byte[8]);
		cidBuffer.putShort(6, getCidOfEClass(eClass));
		long startOid = cidBuffer.getLong(0);
		oidCounters.put(eClass, startOid);
	}

	public synchronized int newPid() {
		return ++pidCounter;
	}

	public void close() {
		keyValueStore.close();
	}

	public EClass getEClassForName(String className) {
		for (EPackage ePackage : emfPackages) {
			if (ePackage.getEClassifier(className) != null) {
				return (EClass) ePackage.getEClassifier(className);
			}
		}
		return null;
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

	public int getPidCounter() {
		return pidCounter;
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
				keyValueStore.store(CLASS_LOOKUP_TABLE, BinUtils.shortToByteArray(tableId), BinUtils.stringToByteArray(eClass.getName()), null);
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			}
			return true;
		}
		return false;
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

	public void incrementCommittedWrites(int committedWrites) {
		keyValueStore.incrementCommittedWrites(committedWrites);
	}

	public void incrementReads(int reads) {
		keyValueStore.incrementReads(reads);
	}
}