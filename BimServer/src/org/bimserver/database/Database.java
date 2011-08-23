package org.bimserver.database;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.MetaDataManager;
import org.bimserver.SettingsManager;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.CreateBaseProject;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.database.migrations.Migrator;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.DatabaseCreated;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;
import org.bimserver.utils.BinUtils;
import org.bimserver.utils.DoubleHashMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database implements BimDatabase {

	private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
	public static final String OID_COUNTER = "OID_COUNTER";
	public static final String PID_COUNTER = "PID_COUNTER";
	private static final String CLASS_LOOKUP_TABLE = "INT-ClassLookup";
	public static final String STORE_PROJECT_NAME = "INT-Store";
	public static final int STORE_PROJECT_ID = 1;
	public static final int STORE_PROJECT_REVISION_ID = -1;
	public static final String WRAPPED_VALUE = "wrappedValue";
	public static final String SCHEMA_VERSION = "SCHEMA_VERSION";
	private static final String DATE_CREATED = "DATE_CREATED";
	private final Set<EPackage> emfPackages = new LinkedHashSet<EPackage>();
	private final ColumnDatabase columnDatabase;
	private final DoubleHashMap<Short, EClass> classifiers = new DoubleHashMap<Short, EClass>();
	private final List<String> realClasses = new ArrayList<String>();
	private volatile long oidCounter;
	private volatile int pidCounter = 1;
	private final Registry registry;
	private Date created;
	private final Set<BimDatabaseSession> sessions = new HashSet<BimDatabaseSession>();
	private final Set<EClass> transactionLessClasses = new HashSet<EClass>();
	private final RecordSizeEstimater recordSizeEstimater = new RecordSizeEstimater();

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
	public static final int APPLICATION_SCHEMA_VERSION = 8;

	public Database(BimServer bimServer, Set<? extends EPackage> emfPackages, ColumnDatabase columnDatabase) throws DatabaseInitException {
		this.bimServer = bimServer;
		this.columnDatabase = columnDatabase;
		this.emfPackages.add(StorePackage.eINSTANCE);
		this.emfPackages.add(LogPackage.eINSTANCE);
		this.emfPackages.addAll(emfPackages);

		// All classes from the packages other than Store/Log (basically only the Ifc2x3 package at the moment) are transaction-less (faster)

		// 13-07-2011 disabling this because low-level-transactions in the service interface require database-level transactions on all tables
		
//		for (EPackage ePackage : emfPackages) {
//			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
//				if (eClassifier instanceof EClass) {
//					EClass eClass = (EClass)eClassifier;
//					transactionLessClasses.add(eClass);
//				}
//			}
//		}
		
		recordSizeEstimater.init(this.emfPackages);
		
		this.registry = new Registry(columnDatabase);
	}

	public int getApplicationSchemaVersion() {
		return APPLICATION_SCHEMA_VERSION;
	}

	public int getDatabaseSchemaVersion() {
		return databaseSchemaVersion;
	}

	public void init() throws DatabaseInitException, DatabaseRestartRequiredException, InconsistentModelsException {
		DatabaseSession databaseSession = createSession(true);
		try {
			if (getColumnDatabase().isNew()) {
				columnDatabase.createTable(CLASS_LOOKUP_TABLE, true);
				columnDatabase.createTable(Database.STORE_PROJECT_NAME, true);
				columnDatabase.createTable(Registry.REGISTRY_TABLE, true);
				setDatabaseVersion(-1, databaseSession);
				created = new Date();
				registry.save(DATE_CREATED, created, databaseSession);
			} else {
				columnDatabase.openTable(CLASS_LOOKUP_TABLE, true);
				columnDatabase.openTable(Database.STORE_PROJECT_NAME, true);
				columnDatabase.openTable(Registry.REGISTRY_TABLE, true);
				created = registry.readDate(DATE_CREATED, databaseSession);
				if (created == null) {
					created = new Date();
					registry.save(DATE_CREATED, created, databaseSession);
				}
			}

			databaseSchemaVersion = registry.readInt(SCHEMA_VERSION, databaseSession, -1);

			migrator = new Migrator(this);

			if (getColumnDatabase().isNew()) {
				try {
					migrator.migrate(databaseSession);
				} catch (MigrationException e) {
					LOGGER.error("", e);
				}
				registry.save("isnew", true, databaseSession);
				databaseSession.commit();
				throw new DatabaseRestartRequiredException();
			} else if (registry.readBoolean("isnew", true, databaseSession)) {
				initInternalStructure(databaseSession);
				initOidCounter(databaseSession);
				initPidCounter(databaseSession);

				DatabaseCreated databaseCreated = LogFactory.eINSTANCE.createDatabaseCreated();
				databaseCreated.setAccessMethod(AccessMethod.INTERNAL);
				databaseCreated.setExecutor(null);
				databaseCreated.setDate(new Date());
				databaseCreated.setPath(getColumnDatabase().getLocation());
				databaseCreated.setVersion(databaseSchemaVersion);
				databaseSession.store(databaseCreated);

				new CreateBaseProject(databaseSession, AccessMethod.INTERNAL).execute();
				AddUserDatabaseAction addUserDatabaseAction = new AddUserDatabaseAction(bimServer, databaseSession, AccessMethod.INTERNAL, "system", "system", "System", UserType.SYSTEM, -1, false);
				addUserDatabaseAction.setCreateSystemUser();
				addUserDatabaseAction.execute();

				Settings settings = SettingsManager.createDefaultSettings();
				databaseSession.store(settings);				
				
				registry.save("isnew", false, databaseSession);
			} else {
				initInternalStructure(databaseSession);
				initOidCounter(databaseSession);
				initPidCounter(databaseSession);
				fixCheckinStates(databaseSession);
			}
			for (EClass eClass : classifiers.keyBSet()) {
				if (eClass.getEPackage() == Ifc2x3Package.eINSTANCE && eClass != Ifc2x3Package.eINSTANCE.getWrappedValue()) {
					realClasses.add(eClass.getName());
				}
			}
			databaseSession.commit();
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
			close();
			throw new DatabaseInitException(e.getMessage());
		} catch (UserException e) {
			LOGGER.error("", e);
			close();
			throw new DatabaseInitException(e.getMessage());
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
			close();
			throw new DatabaseInitException(e.getMessage());
		} finally {
			databaseSession.close();
		}
	}

	/*
	 * This method makes sure no revision states remain in "Uploading",
	 * "Parsing", "Storing" or "Searching Clashes"
	 */
	private void fixCheckinStates(DatabaseSession databaseSession) {
		try {
			int fixed = 0;
			IfcModel model = databaseSession.getAllOfType(StorePackage.eINSTANCE.getRevision(), Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID, false);
			for (IdEObject idEObject : model.getValues()) {
				if (idEObject instanceof Revision) {
					Revision revision = (Revision) idEObject;
					if (revision.getState() == CheckinState.UPLOADING || revision.getState() == CheckinState.PARSING || revision.getState() == CheckinState.STORING) {
						LOGGER.info("Changing " + revision.getState().getName() + " to " + CheckinState.ERROR.getName() + " for revision " + revision.getOid());
						revision.setState(CheckinState.ERROR);
						if (revision.getLastConcreteRevision() != null) {
							revision.getLastConcreteRevision().setChecksum(null);
						}
						revision.setLastError("Server crash while uploading");
						fixed++;
					}
					if (revision.getState() == CheckinState.SEARCHING_CLASHES) {
						LOGGER.info("Changing " + revision.getState().getName() + " to " + CheckinState.CLASHES_ERROR.getName() + " for revision " + revision.getOid());
						revision.setState(CheckinState.CLASHES_ERROR);
						revision.setLastError("Server crash while detecting clashes");
						fixed++;
					}
					databaseSession.store(revision);
				}
			}
			if (fixed > 0) {
				LOGGER.info("Fixed broken checkin states (" + fixed + ")");
			}
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		}
	}

	public void fakeRead(ByteBuffer buffer, EStructuralFeature feature) {
		boolean wrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) feature.getEType());
		if (feature.getUpperBound() > 1 || feature.getUpperBound() == -1) {
			if (feature.getEType() instanceof EEnum) {
			} else if (feature.getEType() instanceof EClass) {
				if (buffer.capacity() == 1 && buffer.get(0) == -1) {
					buffer.position(buffer.position() + 1);
				} else {
					int listSize = buffer.getInt();
					for (int i = 0; i < listSize; i++) {
						short cid = buffer.getShort();
						if (cid != -1) {
							if (wrappedValue) {
								EClass eClass = (EClass) feature.getEType();
								fakePrimitiveRead(eClass.getEStructuralFeature("wrappedValue").getEType(), buffer);
							} else {
								buffer.position(buffer.position() + 8);
							}
						}
					}
				}
			} else if (feature.getEType() instanceof EDataType) {
				int listSize = buffer.getInt();
				for (int i = 0; i < listSize; i++) {
					fakePrimitiveRead(feature.getEType(), buffer);
				}
			}
		} else {
			if (feature.getEType() instanceof EEnum) {
				buffer.position(buffer.position() + 4);
			} else if (feature.getEType() instanceof EClass) {
				if (buffer.capacity() == 1 && buffer.get(0) == -1) {
					buffer.position(buffer.position() + 1);
				} else {
					short cid = buffer.getShort();
					if (wrappedValue) {
						fakePrimitiveRead(feature.getEType(), buffer);
					} else {
						if (cid != -1) {
							buffer.position(buffer.position() + 8);
						}
					}
				}
			} else if (feature.getEType() instanceof EDataType) {
				fakePrimitiveRead(feature.getEType(), buffer);
			}
		}
	}

	private void fakePrimitiveRead(EClassifier classifier, ByteBuffer buffer) {
		if (classifier == EcorePackage.eINSTANCE.getEString()) {
			short length = buffer.getShort();
			buffer.position(buffer.position() + length);
		} else if (classifier == EcorePackage.eINSTANCE.getEInt()) {
			buffer.position(buffer.position() + 4);
		} else if (classifier == EcorePackage.eINSTANCE.getELong()) {
			buffer.position(buffer.position() + 8);
		} else if (classifier == EcorePackage.eINSTANCE.getEFloat()) {
			buffer.position(buffer.position() + 4);
		} else if (classifier == EcorePackage.eINSTANCE.getEDouble()) {
			buffer.position(buffer.position() + 8);
		} else if (classifier == EcorePackage.eINSTANCE.getEBoolean()) {
			buffer.position(buffer.position() + 1);
		} else if (classifier == EcorePackage.eINSTANCE.getEDate()) {
			buffer.position(buffer.position() + 8);
		}
	}

	public synchronized long newOid() {
		return ++oidCounter;
	}

	private EClassifier getEClassifier(String classifierName) {
		for (EPackage ePackage : emfPackages) {
			if (ePackage.getEClassifier(classifierName) != null) {
				return ePackage.getEClassifier(classifierName);
			}
		}
		return null;
	}

	public void initInternalStructure(DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException {
		RecordIterator recordIterator = columnDatabase.getRecordIterator(CLASS_LOOKUP_TABLE, databaseSession);
		try {
			Record record = recordIterator.next();
			while (record != null) {
				String className = BinUtils.byteArrayToString(record.getValue());
				EClass eClass = (EClass) getEClassifier(className);
				columnDatabase.openTable(eClass.getName(), !transactionLessClasses.contains(eClass));
				Short cid = BinUtils.byteArrayToShort(record.getKey());
				classifiers.put(cid, eClass);
				record = recordIterator.next();
			}
		} finally {
			recordIterator.close();
		}
	}

	public void initOidCounter(DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException {
		oidCounter = registry.readLong(OID_COUNTER, databaseSession);
	}

	public void initPidCounter(DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException {
		pidCounter = registry.readInt(PID_COUNTER, databaseSession);
	}

	public synchronized int newPid() {
		return ++pidCounter;
	}

	public void close() {
		columnDatabase.close();
	}

	public EClass getEClassForName(String className) {
		for (EPackage ePackage : emfPackages) {
			if (ePackage.getEClassifier(className) != null) {
				return (EClass) ePackage.getEClassifier(className);
			}
		}
		return null;
	}

	public Object convert(EClassifier classifier, String value) {
		if (classifier != null) {
			if (classifier instanceof EClassImpl) {
				if (null != ((EClassImpl) classifier).getEStructuralFeature(WRAPPED_VALUE)) {
					EObject create = classifier.getEPackage().getEFactoryInstance().create((EClass) classifier);
					Class<?> instanceClass = create.eClass().getEStructuralFeature(WRAPPED_VALUE).getEType().getInstanceClass();
					if (value.equals("")) {

					} else {
						if (instanceClass == Double.class || instanceClass == double.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Double.parseDouble(value));
						} else if (instanceClass == Integer.class || instanceClass == int.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Integer.parseInt(value));
						} else if (instanceClass == Long.class || instanceClass == long.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Long.parseLong(value));
						} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Boolean.parseBoolean(value));
						} else if (instanceClass == Float.class || instanceClass == float.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Float.parseFloat(value));
						} else if (instanceClass == String.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), value);
						}
					}
					return create;
				} else {
					// return processInline(classifier, value);
				}
			} else if (classifier instanceof EDataType) {
				// return convertSimpleValue(classifier.getInstanceClass(),
				// value);
			}
		}
		return null;
	}

	public List<String> getAvailableClasses() {
		return realClasses;
	}

	public DatabaseSession createSession(boolean useTransactions) {
		DatabaseSession databaseSession = new DatabaseSession(this, useTransactions ? columnDatabase.startTransaction() : null, false);
		sessions.add(databaseSession);
		return databaseSession;
	}

	public BimDatabaseSession createReadOnlySession() {
		DatabaseSession databaseSession = new DatabaseSession(this, null, true);
		sessions.add(databaseSession);
		return databaseSession;
	}

	public ColumnDatabase getColumnDatabase() {
		return columnDatabase;
	}

	public Set<EClass> getClasses() {
		return classifiers.keyBSet();
	}

	public EClass getEClassForCid(short cid) {
		return classifiers.getB(cid);
	}

	public long getOidCounter() {
		return oidCounter;
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

	public void setDatabaseVersion(int version, DatabaseSession databaseSession) throws BimDeadlockException {
		databaseSchemaVersion = version;
		registry.save(SCHEMA_VERSION, version, databaseSession);
	}

	@Override
	public Migrator getMigrator() {
		return migrator;
	}

	public boolean useTransactionsFor(EClass eClass) {
		return !transactionLessClasses.contains(eClass);
	}

	public void createTable(EClass eClass) throws BimDeadlockException {
		columnDatabase.createTable(eClass.getName(), !transactionLessClasses.contains(eClass));
		tableId++;
		try {
			columnDatabase.store(CLASS_LOOKUP_TABLE, BinUtils.shortToByteArray(tableId), BinUtils.stringToByteArray(eClass.getName()), null);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	public RecordSizeEstimater getRecordSizeEstimater() {
		return recordSizeEstimater;
	}

	//TODO: Implement
	public boolean shouldIgnoreField(EClass originalQueryClass, EClass eClass, EStructuralFeature feature) {
		return false;
	}

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}
}