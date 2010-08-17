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
import java.util.Map;
import java.util.Set;

import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.CreateBaseProject;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogPackage;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.shared.AbstractAttributeValuePair;
import org.bimserver.shared.Addition;
import org.bimserver.shared.AttributeList;
import org.bimserver.shared.AttributeNewReferencePair;
import org.bimserver.shared.AttributeReferencePair;
import org.bimserver.shared.AttributeValuePair;
import org.bimserver.shared.UserException;
import org.bimserver.utils.BinUtils;
import org.bimserver.utils.DoubleHashMap;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;

public class Database implements BimDatabase {

	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final String OID_COUNTER = "OID_COUNTER";
	public static final String PID_COUNTER = "PID_COUNTER";
	public static final String UID_COUNTER = "UID_COUNTER";
	public static final String GID_COUNTER = "GID_COUNTER";
	private static final String CLASS_LOOKUP_TABLE = "INT-ClassLookup";
	public static final String STORE_PROJECT_NAME = "INT-Store";
	public static final int STORE_PROJECT_ID = 1;
	public static final String WRAPPED_VALUE = "wrappedValue";
	public static final String SCHEMA_VERSION = "SCHEMA_VERSION";
	private static final String DATE_CREATED = "DATE_CREATED";
	private final Set<EPackage> emfPackages = new LinkedHashSet<EPackage>();
	private final ColumnDatabase columnDatabase;
	private final DoubleHashMap<Short, EClass> classifiers = new DoubleHashMap<Short, EClass>();
	private final List<String> realClasses = new ArrayList<String>();
	private volatile long oidCounter;
	private volatile int pidCounter = 1;
	private volatile int gidCounter = 1;
	private volatile int uidCounter;
	private final FieldIgnoreMap fieldIgnoreMap;
	private final Registry registry;
	private Date created;
	private final Set<BimDatabaseSession> sessions = new HashSet<BimDatabaseSession>();
	
	/*  This variable should be _incremented_ with every (released) database-schema change
	 *  Do not change this variable when nothing has changed in the schema!
	 */
	public static final int APPLICATION_SCHEMA_VERSION = 6;

	public Database(Set<? extends EPackage> emfPackages, ColumnDatabase columnDatabase, FieldIgnoreMap fieldIgnoreMap) throws DatabaseInitException {
		this.columnDatabase = columnDatabase;
		this.fieldIgnoreMap = fieldIgnoreMap;
		this.emfPackages.add(StorePackage.eINSTANCE);
		this.emfPackages.add(LogPackage.eINSTANCE);
		this.emfPackages.addAll(emfPackages);
		this.registry = new Registry(columnDatabase);
		init();
	}

	private void init() throws DatabaseInitException {
		DatabaseSession databaseSession = createSession();
		try {
			updateAndCheckStructure(databaseSession);
			if (getColumnDatabase().isNew()) {
				registry.save(SCHEMA_VERSION, APPLICATION_SCHEMA_VERSION, databaseSession);
				created = new Date();
				registry.save(DATE_CREATED, created, databaseSession);
			} else {
				created = registry.readDate(DATE_CREATED, databaseSession);
				if (created == null) {
					created = new Date();
					registry.save(DATE_CREATED, created, databaseSession);
				}
			}
			int databaseSchemaVersion = registry.readInt(SCHEMA_VERSION, databaseSession, -1);
			if (databaseSchemaVersion != APPLICATION_SCHEMA_VERSION) {
				databaseSession.close();
				close();
				throw new DatabaseInitException("Database schema version (" + databaseSchemaVersion + ") does not match application schema version (" + APPLICATION_SCHEMA_VERSION + ")");
			}
			getColumnDatabase().createTableIfNotExists(Database.STORE_PROJECT_NAME, databaseSession);
			initInternalStructure(databaseSession);
			if (getColumnDatabase().isNew()) {
				new CreateBaseProject(AccessMethod.INTERNAL).execute(databaseSession);
				new AddUserDatabaseAction(AccessMethod.INTERNAL, "admin", "admin", "Administrator", UserType.ADMIN, -1).execute(databaseSession);
				new AddUserDatabaseAction(AccessMethod.INTERNAL, "anonymous", "anonymous", "Anonymous", UserType.ANONYMOUS, -1).execute(databaseSession);
			} else {
				initOidCounter(databaseSession);
				initPidCounter(databaseSession);
				initUidCounter(databaseSession);
				initGidCounter(databaseSession);
			}
			for (EClass eClass : classifiers.keyBSet()) {
				if (eClass.getEPackage() == Ifc2x3Package.eINSTANCE && eClass != Ifc2x3Package.eINSTANCE.getWrappedValue()) {
					realClasses.add(eClass.getName());
				}
			}
			databaseSession.commit();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
			close();
			throw new DatabaseInitException(e.getMessage());
		} catch (UserException e) {
			e.printStackTrace();
			close();
			throw new DatabaseInitException(e.getMessage());
		} catch (BimDatabaseException e) {
			e.printStackTrace();
			close();
			throw new DatabaseInitException(e.getMessage());
		} finally {
			databaseSession.close();
		}
	}

	public void updateAndCheckStructure(DatabaseSession databaseSession) throws BimDeadlockException {
		columnDatabase.createTableIfNotExists(CLASS_LOOKUP_TABLE, databaseSession);
		registry.ensureExists(databaseSession);
		short tableId = 0;
		for (EPackage emfPackage : emfPackages) {
			for (EClassifier classifier : emfPackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					if (columnDatabase.createTableIfNotExists(classifier.getName(), databaseSession)) {
						tableId++;
						try {
							columnDatabase.store(CLASS_LOOKUP_TABLE, BinUtils.shortToByteArray(tableId), BinUtils.stringToByteArray(classifier.getName()),
									databaseSession);
						} catch (BimDatabaseException e) {
							e.printStackTrace();
						}
					}
				}
			}
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
					short listSize = buffer.getShort();
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
				short listSize = buffer.getShort();
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

	public void initInternalStructure(DatabaseSession databaseSession) throws BimDeadlockException {
		RecordIterator recordIterator = columnDatabase.getRecordIterator(CLASS_LOOKUP_TABLE, databaseSession);
		try {
			Record record = recordIterator.next();
			while (record != null) {
				String string = BinUtils.byteArrayToString(record.getValue());
				EClass eClass = (EClass) getEClassifier(string);
				Short cid = BinUtils.byteArrayToShort(record.getKey());
				classifiers.put(cid, eClass);
				record = recordIterator.next();
			}
		} finally {
			recordIterator.close();
		}
	}

	public void initOidCounter(DatabaseSession databaseSession) throws BimDeadlockException {
		oidCounter = registry.readLong(OID_COUNTER, databaseSession);
	}

	public void initPidCounter(DatabaseSession databaseSession) throws BimDeadlockException {
		pidCounter = registry.readInt(PID_COUNTER, databaseSession);
	}

	public void initGidCounter(DatabaseSession databaseSession) throws BimDeadlockException {
		gidCounter = registry.readInt(GID_COUNTER, databaseSession);
	}
	
	public void initUidCounter(DatabaseSession databaseSession) throws BimDeadlockException {
		uidCounter = registry.readInt(UID_COUNTER, databaseSession);
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

	@SuppressWarnings("unchecked")
	public EObject convertAdditionToEObject(IdEObject object, Addition addition, Map<Long, IdEObject> processedAdditions, Map<Long, IdEObject> map) {
		for (AbstractAttributeValuePair aavp : addition.getAttributes()) {
			EStructuralFeature feature = object.eClass().getEStructuralFeature(aavp.getName());
			if (aavp instanceof AttributeValuePair) {
				Object value = ((AttributeValuePair) aavp).getValue();
				if (value != null) {
					EStructuralFeature structuralFeature = ((EClass) feature.getEType()).getEStructuralFeature(WRAPPED_VALUE);
					if (structuralFeature != null) {
						Object convert = convert(feature.getEType(), value.toString());
						object.eSet(feature, convert);
					} else {
						object.eSet(feature, value);
					}
				}
			} else if (aavp instanceof AttributeNewReferencePair) {
				AttributeNewReferencePair aavp2 = (AttributeNewReferencePair) aavp;
				EObject item = processedAdditions.get(aavp2.getOid());
				if (feature.getUpperBound() == -1) {
					EList<EObject> list = (EList<EObject>) object.eGet(feature);
					list.add(item);
				} else {
					object.eSet(feature, item);
				}
			} else if (aavp instanceof AttributeReferencePair) {
				EObject newValue = map.get(((AttributeReferencePair) aavp).getOid());
				object.eSet(feature, newValue);
			} else if (aavp instanceof AttributeList) {
				BasicEList<Object> list = new BasicEList<Object>();
				AttributeList attributeList = (AttributeList) aavp;
				for (AbstractAttributeValuePair pair : attributeList.getAttributes()) {
					if (pair instanceof AttributeValuePair) {
						AttributeValuePair avp = (AttributeValuePair) pair;
						Object value = avp.getValue();
						if (value != null) {
							EStructuralFeature structuralFeature = ((EClass) feature.getEType()).getEStructuralFeature(WRAPPED_VALUE);
							if (structuralFeature != null) {
								Object convert = convert(feature.getEType(), value.toString());
								list.add(convert);
							} else {
								list.add(value);
							}
						}
					} else if (pair instanceof AttributeReferencePair) {
						AttributeReferencePair arp = (AttributeReferencePair) pair;
						EObject object2 = map.get(arp.getOid());
						list.add(object2);
					} else if (pair instanceof AttributeNewReferencePair) {
						AttributeNewReferencePair anrp = (AttributeNewReferencePair) pair;
						EObject object2 = processedAdditions.get(anrp.getOid());
						if (object2 != null) {
							list.add(object2);
						}
					}
				}
				object.eSet(feature, list);
			}
		}
		return object;
	}

	public List<String> getAvailableClasses() {
		return realClasses;
	}

	public DatabaseSession createSession() {
		DatabaseSession databaseSession = new DatabaseSession(this, columnDatabase.startTransaction(), false);
		sessions.add(databaseSession);
		return databaseSession;
	}

	public BimDatabaseSession createReadOnlySession() {
		DatabaseSession databaseSession = new DatabaseSession(this, columnDatabase.startTransaction(), true);
		sessions.add(databaseSession);
		return databaseSession;
	}
	
	public ColumnDatabase getColumnDatabase() {
		return columnDatabase;
	}

	public Set<EClass> getClasses() {
		return classifiers.keyBSet();
	}

	public boolean shouldIgnoreField(EClass originalQueryClass, EClass eClass, EStructuralFeature feature) {
		return fieldIgnoreMap.shouldIgnoreField(originalQueryClass, eClass, feature);
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

	public int getGidCounter() {
		return gidCounter;
	}
	
	public int getUidCounter() {
		return uidCounter;
	}

	public Short getCidOfEClass(EClass eClass) {
		return classifiers.getA(eClass);
	}

	public Registry getRegistry() {
		return registry;
	}

	public FieldIgnoreMap getFieldIgnoreMap() {
		return fieldIgnoreMap;
	}

	public Date getCreated() {
		return created;
	}

	public void unregisterSession(DatabaseSession databaseSession) {
		sessions.remove(databaseSession);
	}
}