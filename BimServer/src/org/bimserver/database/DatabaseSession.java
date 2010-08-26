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

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.database.query.literals.IntegerLiteral;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Factory;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.IfcGloballyUniqueId;
import org.bimserver.ifc.emf.Ifc2x3.Tristate;
import org.bimserver.ifc.emf.Ifc2x3.WrappedValue;
import org.bimserver.shared.Addition;
import org.bimserver.shared.DatabaseInformation;
import org.bimserver.shared.UserException;
import org.bimserver.utils.BinUtils;
import org.bimserver.utils.GrowingByteBuffer;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EEnumImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class DatabaseSession implements BimDatabaseSession {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSession.class);
	private final BiMap<RecordIdentifier, IdEObject> cache = HashBiMap.create();
	private final Database database;
	private BimTransaction bimTransaction;
	private final boolean readOnly;

	public DatabaseSession(Database database, BimTransaction bimTransaction, boolean readOnly) {
		this.database = database;
		this.bimTransaction = bimTransaction;
		this.readOnly = readOnly;
	}

	public BimTransaction getBimTransaction() {
		return bimTransaction;
	}

	public boolean cacheContains(EObject object) {
		return cache.inverse().containsKey(object);
	}

	public boolean containsKey(RecordIdentifier pidOidPair) {
		return cache.containsKey(pidOidPair);
	}

	public IdEObject getObject(RecordIdentifier pidOidPair) {
		return cache.get(pidOidPair);
	}

	public void putInCache(RecordIdentifier pidOidPair, IdEObject object) {
		if (!cache.containsValue(object)) {
			cache.put(pidOidPair, object);
		}
	}

	public long getOid(IdEObject object) {
		return cache.inverse().get(object).getOid();
	}

	public void clear() {
		cache.clear();
	}

	public void close() {
		database.unregisterSession(this);
		bimTransaction.close();
	}

	@Override
	public <T> T executeAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException {
		for (int i = 0; i < retries; i++) {
			try {
				return action.execute(this);
			} catch (BimDeadlockException e) {
				bimTransaction.rollback();
				bimTransaction = database.getColumnDatabase().startTransaction();
				LOGGER.info("Deadlock while executing " + action.getClass().getSimpleName() + " run (" + i + ")");
				if (i < retries - 1) {
					try {
						Thread.sleep(new Random().nextInt((i + 1) * 1000));
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			} catch (BimDatabaseException e) {
				throw e;
			}
		}
		throw new BimDatabaseException("Too many deadlocks (" + retries + ")");
	}

	@Override
	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException {
		for (int i = 0; i < retries; i++) {
			try {
				T result = action.execute(this);
				bimTransaction.commit();
				return result;
			} catch (BimDeadlockException e) {
				bimTransaction.rollback();
				bimTransaction = database.getColumnDatabase().startTransaction();
				// LOGGER.error("", e);
				LOGGER.info("Deadlock while executing " + action.getClass().getSimpleName() + " run (" + i + ")");
			} catch (BimDatabaseException e) {
				LOGGER.error("", e);
				throw e;
			}
			if (i < retries - 1) {
				try {
					Thread.sleep(new Random().nextInt((i + 1) * 1000));
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		throw new BimDatabaseException("Too many deadlocks (" + retries + ")");
	}

	@Override
	public void clearProject(int pid, int oldRid, int newRid) throws BimDeadlockException {
		ByteBuffer keyBuffer = ByteBuffer.allocate(16);
		ByteBuffer searchKeyBuffer = ByteBuffer.allocate(12);
		for (EClass classifier : database.getClasses()) {
			byte[] pidArray = BinUtils.intToByteArray(pid);
			SearchingRecordIterator recordIterator = database.getColumnDatabase().getRecordIterator(classifier.getName(), pidArray, pidArray, this);
			try {
				Record next = recordIterator.next();
				while (next != null) {
					keyBuffer.position(0);
					keyBuffer.put(next.getKey());
					keyBuffer.position(0);
					keyBuffer.getInt();
					long foundOid = keyBuffer.getLong();
					int foundRid = -keyBuffer.getInt();
					if (next.getValue().length == 1 && next.getValue()[0] == -1) {
						// was already deleted in previous revision
					} else if (foundRid > oldRid) {
						// skip, we probably just added it
					} else if (oldRid == foundRid) {
						delete(classifier.getName(), pid, newRid, foundOid);
					}
					searchKeyBuffer.position(0);
					searchKeyBuffer.putInt(pid);
					searchKeyBuffer.putLong(foundOid + 1);
					next = recordIterator.next(searchKeyBuffer.array());
				}
			} finally {
				recordIterator.close();
			}
		}
	}

	private boolean delete(String className, int pid, int rid, long oid) throws BimDeadlockException {
		ByteBuffer buffer = createKeyBuffer(pid, oid, rid);
		try {
			database.getColumnDatabase().store(className, buffer.array(), new byte[] { -1 }, this);
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Object convert(EClassifier type, String value) {
		return database.convert(type, value);
	}

	@Override
	public void convertAdditionToEObject(IdEObject object, Addition addition, Map<Long, IdEObject> processedAdditions, Map<Long, IdEObject> map) {
		database.convertAdditionToEObject(object, addition, processedAdditions, map);
	}

	public ConcreteRevision createNewConcreteRevision(long size, long poid, long uoid, String comment, boolean finalized) throws BimDatabaseException, BimDeadlockException {
		ConcreteRevision concreteRevision = StoreFactory.eINSTANCE.createConcreteRevision();
		Date date = new Date();
		Project project = getProjectByPoid(poid);
		if (project.getConcreteRevisions().isEmpty()) {
			concreteRevision.setId(1);
		} else {
			concreteRevision.setId(project.getConcreteRevisions().size() + 1);
		}
		User user = getUserByUoid(uoid);
		concreteRevision.setProject(project);
		concreteRevision.setFinalized(finalized);
		createNewVirtualRevision(project, concreteRevision, comment, date, user, size, finalized);

		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user) {
				checkout.setActive(false);
			}
		}

		Project parent = project.getParent();
		while (parent != null) {
			Revision revision = StoreFactory.eINSTANCE.createRevision();
			revision.setComment(comment);
			revision.setDate(date);
			revision.setUser(user);
			revision.setSize(size);
			revision.setProject(parent);
			revision.setFinalized(finalized);
			if (parent.getLastRevision() != null) {
				Revision lastRevision = parent.getLastRevision();
				for (ConcreteRevision oldRevision : lastRevision.getConcreteRevisions()) {
					if (oldRevision.getProject() != project && oldRevision.getProject() != parent) {
						revision.getConcreteRevisions().add(oldRevision);
					}
				}
			}
			revision.getConcreteRevisions().add(concreteRevision);
			revision.setLastConcreteRevision(concreteRevision);
			if (parent.getLastRevision() == null) {
				revision.setId(1);
			} else {
				revision.setId(parent.getLastRevision().getId() + 1);
			}
			parent.setLastRevision(revision);
			store(revision, new CommitSet(Database.STORE_PROJECT_ID, -1));
			parent = parent.getParent();
		}
		return concreteRevision;
	}

	private void createNewVirtualRevision(Project project, ConcreteRevision revision, String comment, Date date, User user, long size, boolean finalized)
			throws BimDeadlockException {
		Revision virtualRevision = StoreFactory.eINSTANCE.createRevision();
		virtualRevision.getConcreteRevisions().add(revision);
		virtualRevision.setLastConcreteRevision(revision);
		virtualRevision.setComment(comment);
		virtualRevision.setDate(date);
		virtualRevision.setUser(user);
		virtualRevision.setSize(size);
		virtualRevision.setFinalized(finalized);
		project.setLastRevision(virtualRevision);
		if (project.getRevisions().isEmpty()) {
			virtualRevision.setId(1);
		} else {
			virtualRevision.setId(project.getRevisions().size() + 1);
			for (ConcreteRevision concreteRevision : project.getRevisions().get(0).getConcreteRevisions()) {
				if (concreteRevision.getProject() != project) {
					virtualRevision.getConcreteRevisions().add(concreteRevision);
					virtualRevision.setSize(virtualRevision.getSize() + concreteRevision.getSize());
				}
			}
		}
		virtualRevision.setProject(project);
		store(virtualRevision, new CommitSet(Database.STORE_PROJECT_ID, -1));
	}

	public IdEObject get(short cid, long oid, ReadSet readSet) throws BimDatabaseException, BimDeadlockException {
		ByteBuffer keyBuffer = createKeyBuffer(readSet.getPid(), oid, readSet.getRid());
		EClass eClass = getEClassForCid(cid);
		byte[] value = database.getColumnDatabase().get(eClass.getName(), keyBuffer.array(), this);
		if (value == null) {
			return null;
		} else {
			ByteBuffer buffer = ByteBuffer.wrap(value);
			IdEObject object = convertByteArrayToObject(eClass, eClass, oid, buffer, readSet);
			putInCache(new RecordIdentifier(readSet.getPid(), oid, readSet.getRid()), object);
			return object;
		}
	}

	public IdEObject convertByteArrayToObject(EClass originalQueryClass, EClass eClass, long oid, ByteBuffer buffer, ReadSet readSet)
			throws BimDatabaseException, BimDeadlockException {
		if (readSet.isReading(oid)) {
			return readSet.get(oid);
		}
		RecordIdentifier recordIdentifier = new RecordIdentifier(readSet.getPid(), oid, readSet.getRid());
		if (cache.containsKey(recordIdentifier)) {
			return cache.get(recordIdentifier);
		}
		IdEObject object = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setOid(oid);
		if (!(object instanceof WrappedValue) && !(object instanceof IfcGloballyUniqueId)) {
			readSet.put(oid, object);
		}
		if (buffer.capacity() == 1 && buffer.get(0) == -1) {
			buffer.position(buffer.position() + 1);
			return null;
		}
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (!feature.isTransient() && !feature.isVolatile()) {
				if (database.shouldIgnoreField(originalQueryClass, eClass, feature)) {
					// we have to do some reading to maintain a correct index
					database.fakeRead(buffer, feature);
				} else {
					Object newValue = null;
					if (feature.getUpperBound() > 1 || feature.getUpperBound() == -1) {
						if (feature.getEType() instanceof EEnum) {
						} else if (feature.getEType() instanceof EClass) {
							if (buffer.capacity() == 1 && buffer.get(0) == -1) {
								buffer.position(buffer.position() + 1);
							} else {
								/*
								 * TODO There still is a problem with this, when
								 * readReference (and all calls beyond that
								 * call) alter (by opposites) this list, this
								 * list can potentially grow too large
								 * 
								 * Only can happen with non-unique references
								 */
								short listSize = buffer.getShort();
								BasicEList<Object> list = (BasicEList<Object>) object.eGet(feature);
								boolean wrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) (feature.getEType()));
								for (int i = 0; i < listSize; i++) {
									Object reference = null;
									if (wrappedValue) {
										reference = readWrappedValue(feature, buffer);
									} else {
										reference = readReference(originalQueryClass, buffer, readSet);
									}
									if (reference != null) {
										if (feature.isUnique()) {
											list.add(reference);
										} else {
											list.addUnique(reference);
										}
									}
								}
							}
						} else if (feature.getEType() instanceof EDataType) {
							short listSize = buffer.getShort();
							BasicEList<Object> list = new BasicEList<Object>(listSize);
							for (int i = 0; i < listSize; i++) {
								Object reference = readPrimitiveValue(feature.getEType(), buffer);
								if (reference != null) {
									list.addUnique(reference);
								}
							}
							object.eSet(feature, list);
						}
					} else {
						if (feature.getEType() instanceof EEnum) {
							int enumOrdinal = buffer.getInt();
							EClassifier eType = feature.getEType();
							EEnumLiteral enumLiteral = ((EEnumImpl) eType).getEEnumLiteral(enumOrdinal);
							if (enumLiteral != null) {
								newValue = enumLiteral.getInstance();
							} else {
								LOGGER.error(enumOrdinal + " not found");
							}
						} else if (feature.getEType() instanceof EClass) {
							boolean wrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) (feature.getEType()));
							if (wrappedValue) {
								newValue = readWrappedValue(feature, buffer);
							} else {
								newValue = readReference(originalQueryClass, buffer, readSet);
							}
						} else if (feature.getEType() instanceof EDataType) {
							newValue = readPrimitiveValue(feature.getEType(), buffer);
						}
					}
					if (newValue != null) {
						object.eSet(feature, newValue);
					}
				}
			}
		}
		return object;
	}

	private Object readWrappedValue(EStructuralFeature feature, ByteBuffer buffer) {
		short cid = buffer.getShort();
		if (cid == -1) {
			return null;
		}
		EClass eClass = database.getEClassForCid(cid);
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("wrappedValue");
		Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer);
		EObject eObject = Ifc2x3Factory.eINSTANCE.create(eClass);
		eObject.eSet(eStructuralFeature, primitiveValue);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEFloat() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
			eObject.eSet(eClass.getEStructuralFeature("wrappedValueAsString"), readPrimitiveValue(EcorePackage.eINSTANCE.getEString(), buffer));
		}
		return eObject;
	}

	private EObject readReference(EClass originalQueryClass, ByteBuffer buffer, ReadSet readSet) throws BimDatabaseException, BimDeadlockException {
		if (buffer.capacity() == 1 && buffer.get(0) == -1) {
			buffer.position(buffer.position() + 1);
			return null;
		}
		short cid = buffer.getShort();
		if (cid != -1) {
			long oid = buffer.getLong();
			if (containsKey(new RecordIdentifier(readSet.getPid(), oid, readSet.getRid()))) {
				return getObject(new RecordIdentifier(readSet.getPid(), oid, readSet.getRid()));
			} else {
				if (readSet.isReading(oid)) {
					return readSet.get(oid);
				} else {
					int descRid = readSet.getRid();
					byte[] referenceValue = null;
					EClass classifier = database.getEClassForCid(cid);
					while (referenceValue == null && (descRid > 0 || descRid == -1)) {
						ByteBuffer pidoidrid = createKeyBuffer(readSet.getPid(), oid, descRid);
						referenceValue = database.getColumnDatabase().getFirstStartingWith(classifier.getName(), pidoidrid.array(), this);
						descRid--;
					}
					if (referenceValue == null) {
						throw new BimDatabaseException("Unsatisfied reference error, there is no " + classifier.getName() + " with pid " + readSet.getPid()
								+ ", oid " + oid + ", rid <= " + readSet.getRid());
					}
					if (referenceValue.length == 1 && referenceValue[0] == -1) {
					} else if (referenceValue != null) {
						ByteBuffer referenceBuffer = ByteBuffer.wrap(referenceValue);
						IdEObject newObject = convertByteArrayToObject(originalQueryClass, classifier, oid, referenceBuffer, readSet);
						RecordIdentifier recordIdentifier = new RecordIdentifier(readSet.getPid(), oid, readSet.getRid());
						putInCache(recordIdentifier, newObject);
						return newObject;
					}
				}
			}
		}
		return null;
	}

	@Override
	public User getAdminUser() throws BimDatabaseException, BimDeadlockException {
		return getUserByUserName("admin");
	}

	@Override
	public EClass getEClassForName(String className) {
		return database.getEClassForName(className);
	}

	@Override
	public EClass getEClassForCid(short cid) {
		return database.getEClassForCid(cid);
	}

	@Override
	public ReadSet getMap(int pid, int rid) throws BimDatabaseException, BimDeadlockException {
		ReadSet readSet = new ReadSet(pid, rid);
		for (EClass eClass : database.getClasses()) {
			getMap(eClass, readSet);
		}
		return readSet;
	}

	public void getMap(EClass eClass, ReadSet readSet) throws BimDatabaseException, BimDeadlockException {
		SearchingRecordIterator recordIterator = database.getColumnDatabase().getRecordIterator(eClass.getName(), BinUtils.intToByteArray(readSet.getPid()),
				BinUtils.intToByteArray(readSet.getPid()), this);
		try {
			Record record = recordIterator.next();
			ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
			while (record != null) {
				ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
				int pid = keyBuffer.getInt();
				long oid = keyBuffer.getLong();
				int rid = -keyBuffer.getInt();
				ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
				int map = getMap(eClass, eClass, readSet, valueBuffer, pid, oid, rid);
				if (map == 1) {
					nextKeyStart.position(0);
					nextKeyStart.putInt(readSet.getPid());
					nextKeyStart.putLong(oid + 1);
					record = recordIterator.next(nextKeyStart.array());
				} else {
					record = recordIterator.next();
				}
			}
		} finally {
			recordIterator.close();
		}
	}

	public int getCount(EClass eClass, ReadSet readSet) throws BimDatabaseException, BimDeadlockException {
		int count = 0;
		SearchingRecordIterator recordIterator = database.getColumnDatabase().getRecordIterator(eClass.getName(), BinUtils.intToByteArray(readSet.getPid()),
				BinUtils.intToByteArray(readSet.getPid()), this);
		try {
			Record record = recordIterator.next();
			ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
			byte[] nullReference = new byte[] { -1 };
			while (record != null) {
				ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
				int pid = keyBuffer.getInt();
				long oid = keyBuffer.getLong();
				int rid = -keyBuffer.getInt();
				int map = getCount(readSet, pid, rid);
				if (!Arrays.equals(record.getValue(), nullReference)) {
					count++;
				}
				if (map == 1) {
					nextKeyStart.position(0);
					nextKeyStart.putInt(readSet.getPid());
					nextKeyStart.putLong(oid + 1);
					record = recordIterator.next(nextKeyStart.array());
				} else {
					record = recordIterator.next();
				}
			}
		} finally {
			recordIterator.close();
		}
		return count;
	}

	private int getMap(EClass originalQueryClass, EClass eClass, ReadSet readSet, ByteBuffer buffer, int pid, long oid, int rid) throws BimDatabaseException,
			BimDeadlockException {
		if (pid == readSet.getPid()) {
			if (rid <= readSet.getRid()) {
				RecordIdentifier recordIdentifier = new RecordIdentifier(readSet.getPid(), oid, rid);
				if (containsKey(recordIdentifier)) {
					IdEObject object = getObject(recordIdentifier);
					if (!(object instanceof WrappedValue) && !(object instanceof IfcGloballyUniqueId)) {
						readSet.put(oid, object);
					}
					return 1;
				} else {
					IdEObject object = null;
					if (readSet.isReading(oid)) {
						object = readSet.get(oid);
					} else {
						if (buffer.capacity() == 1 && buffer.get(0) == -1) {
							buffer.position(buffer.position() + 1);
							return 1;
							// deleted entity
						} else {
							object = convertByteArrayToObject(originalQueryClass, eClass, oid, buffer, readSet);
						}
					}
					if (object != null) {
						putInCache(recordIdentifier, object);
						return 1;
					}
				}
			} else {
				return -1;
			}
		} else {
			return 0;
		}
		return 0;
	}

	private int getCount(ReadSet readSet, int pid, int rid) {
		if (pid == readSet.getPid()) {
			if (rid <= readSet.getRid()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 0;
		}
	}

	@Override
	public ReadSet getMapWithOid(int pid, int rid, long oid) throws BimDatabaseException, BimDeadlockException {
		EClass eClass = getClassOfObjectId(pid, rid, oid);
		ReadSet readSet = new ReadSet(pid, rid);
		if (eClass == null) {
			return readSet;
		}
		clear();
		if (eClass == null) {
			return null;
		} else {
			ByteBuffer key = createKeyBuffer(pid, oid, rid);
			byte[] value = database.getColumnDatabase().get(eClass.getName(), key.array(), this);
			if (value == null) {
				return null;
			}
			ByteBuffer valueBuffer = ByteBuffer.wrap(value);
			getMap(eClass, eClass, readSet, valueBuffer, pid, oid, rid);
			return readSet;
		}
	}

	private EClass getClassOfObjectId(int pid, int rid, long oid) throws BimDatabaseException, BimDeadlockException {
		for (EClass eClass : database.getClasses()) {
			if (get(database.getCidOfEClass(eClass), oid, new ReadSet(pid, rid)) != null) {
				return eClass;
			}
		}
		return null;
	}

	@Override
	public Project getProjectById(int pid) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Id(), new IntegerLiteral(pid));
		return querySingle(Database.STORE_PROJECT_ID, -1, condition, Project.class);
	}

	public <T extends IdEObject> T querySingle(int pid, int rid, Condition condition, Class<T> clazz) throws BimDatabaseException, BimDeadlockException {
		Collection<T> values = query(pid, rid, condition, clazz).values();
		if (values.size() == 0) {
			return null;
		}
		return values.iterator().next();
	}

	public <T extends IdEObject> Map<Long, T> query(int pid, int rid, Condition condition, Class<T> clazz) throws BimDatabaseException, BimDeadlockException {
		ReadSet readSet = new ReadSet(pid, rid);
		Map<Long, T> map = new HashMap<Long, T>();
		Set<EClass> eClasses = new HashSet<EClass>();
		condition.getEClassRequirements(eClasses);
		for (EClass eClass : eClasses) {
			getMap(eClass, readSet);
			for (Long oid : readSet.keySet()) {
				EObject object = readSet.get(oid);
				if (clazz.isInstance(object)) {
					if (condition.matches(object)) {
						map.put(oid, clazz.cast(object));
					}
				}
			}
		}
		return map;
	}

	@Override
	public Collection<Project> getProjectsByName(String projectName) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(projectName));
		return (Collection<Project>) query(Database.STORE_PROJECT_ID, -1, condition, Project.class).values();
	}

	@Override
	public User getUserByUserName(String username) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral(username));
		return querySingle(Database.STORE_PROJECT_ID, -1, condition, User.class);
	}

	@Override
	public int newPid() {
		return database.newPid();
	}

	@Override
	public void saveOidCounter() throws BimDeadlockException {
		database.getRegistry().save(Database.OID_COUNTER, database.getOidCounter(), this);
	}

	@Override
	public void savePidCounter() throws BimDeadlockException {
		database.getRegistry().save(Database.PID_COUNTER, database.getPidCounter(), this);
	}

	@Override
	public void saveUidCounter() throws BimDeadlockException {
		database.getRegistry().save(Database.UID_COUNTER, database.getUidCounter(), this);
	}

	public void saveGidCounter() throws BimDeadlockException {
		database.getRegistry().save(Database.GID_COUNTER, database.getGidCounter(), this);
	}

	private ByteBuffer createKeyBuffer(int pid, long oid, int rid) {
		ByteBuffer keyBuffer = ByteBuffer.allocate(16);
		keyBuffer.putInt(pid);
		keyBuffer.putLong(oid);
		keyBuffer.putInt(-rid);
		return keyBuffer;
	}

	@Override
	public long store(IdEObject object, CommitSet commitSet) throws BimDeadlockException {
		if (!commitSet.isStoring(object)) {
			if (object.getOid() == -1) {
				long newOid = database.newOid();
				object.setOid(newOid);
			}
			commitSet.add(object, object.getOid());
		} else {
			return object.getOid();
		}
		try {
			ByteBuffer keyBuffer = createKeyBuffer(commitSet.getPid(), object.getOid(), commitSet.getRid());
			putInCache(new RecordIdentifier(commitSet.getPid(), object.getOid(), commitSet.getRid()), object);
			database.getColumnDatabase().store(object.eClass().getName(), keyBuffer.array(), convertObjectToByteArray(object, commitSet).array(), this);
			return object.getOid();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public GrowingByteBuffer convertObjectToByteArray(EObject object, CommitSet commitSet) throws BimDeadlockException, BimDatabaseException {
		GrowingByteBuffer buffer = new GrowingByteBuffer();
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (!feature.isTransient() && !feature.isVolatile()) {
				if (feature.getUpperBound() > 1 || feature.getUpperBound() == -1) {
					if (feature.getEType() instanceof EEnum) {
						// Aggregate relations to enums never occur... at this
						// moment
					} else if (feature.getEType() instanceof EClass) {
						EList<?> list = (EList<?>) object.eGet(feature);
						buffer.putShort((short) list.size());
						boolean wrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) feature.getEType());
						for (Object o : list) {
							if (wrappedValue) {
								writeWrappedValue(o, buffer, commitSet);
							} else {
								writeReference(o, commitSet, buffer);
							}
						}
					} else if (feature.getEType() instanceof EDataType) {
						EList<?> list = (EList<?>) object.eGet(feature);
						buffer.putShort((short) list.size());
						for (Object o : list) {
							writePrimitiveValue(feature, o, buffer);
						}
					}
				} else {
					Object value = object.eGet(feature);
					if (feature.getEType() instanceof EEnum) {
						EEnum eEnum = (EEnum)feature.getEType();
						EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteralByLiteral(((Enum<?>) value).toString());
						if (eEnumLiteral != null) {
							buffer.putInt(eEnumLiteral.getValue());
						} else {
							LOGGER.error(((Enum<?>) value).toString() + " not found");
							buffer.putInt(-1);
						}
					} else if (feature.getEType() instanceof EClass) {
						boolean wrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) feature.getEType());
						if (wrappedValue) {
							writeWrappedValue(value, buffer, commitSet);
						} else {
							writeReference(value, commitSet, buffer);
						}
					} else if (feature.getEType() instanceof EDataType) {
						writePrimitiveValue(feature, value, buffer);
					}
				}
			}
		}
		return buffer;
	}

	public Object readPrimitiveValue(EClassifier classifier, ByteBuffer buffer) {
		if (classifier == EcorePackage.eINSTANCE.getEString()) {
			short length = buffer.getShort();
			if (length != -1) {
				return BinUtils.readString(buffer, length);
			} else {
				return null;
			}
		} else if (classifier == EcorePackage.eINSTANCE.getEInt()) {
			return buffer.getInt();
		} else if (classifier == EcorePackage.eINSTANCE.getELong()) {
			return buffer.getLong();
		} else if (classifier == EcorePackage.eINSTANCE.getEFloat()) {
			return buffer.getFloat();
		} else if (classifier == EcorePackage.eINSTANCE.getEDouble()) {
			return buffer.getDouble();
		} else if (classifier == EcorePackage.eINSTANCE.getEBoolean()) {
			return buffer.get() == 1;
		} else if (classifier == EcorePackage.eINSTANCE.getEDate()) {
			return new Date(buffer.getLong());
		} else if (classifier == EcorePackage.eINSTANCE.getEByteArray()) {
			int size = buffer.getInt();
			byte[] result = new byte[size];
			buffer.get(result);
			return result;
		} else if (classifier == Ifc2x3Package.eINSTANCE.getTristate()) {
			int ordinal = buffer.getInt();
			return Tristate.get(ordinal);
		} else {
			throw new RuntimeException("Unsupported type " + classifier.getName());
		}
	}

	private void writeWrappedValue(Object value, GrowingByteBuffer buffer, CommitSet commitSet) throws BimDatabaseException, BimDeadlockException {
		if (value == null) {
			buffer.putShort((short) -1);
			return;
		}
		WrappedValue wrappedValue = (WrappedValue) value;
		EStructuralFeature eStructuralFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
		Short cid = database.getCidOfEClass(wrappedValue.eClass());
		buffer.putShort(cid);
		writePrimitiveValue(eStructuralFeature, wrappedValue.eGet(eStructuralFeature), buffer);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEFloat() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
			EStructuralFeature floatValueFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValueAsString");
			writePrimitiveValue(floatValueFeature, wrappedValue.eGet(floatValueFeature), buffer);
		}
		if (wrappedValue instanceof IfcGloballyUniqueId) {
			GrowingByteBuffer convertObjectToByteArray = convertObjectToByteArray(wrappedValue, commitSet);
			ByteBuffer createKeyBuffer = createKeyBuffer(commitSet.getPid(), getReferenceOid(wrappedValue, commitSet), commitSet.getRid());
			try {
				database.getColumnDatabase().store("IfcGloballyUniqueId", createKeyBuffer.array(), convertObjectToByteArray.array(), this);
			} catch (BimDeadlockException e) {
				e.printStackTrace();
			}
		}
	}

	public void writePrimitiveValue(EStructuralFeature feature, Object value, GrowingByteBuffer buffer) throws BimDatabaseException {
		if (feature.getEType() == EcorePackage.eINSTANCE.getEString()) {
			if (value == null) {
				buffer.putShort((short) -1);
			} else {
				String stringValue = (String) value;
				try {
					byte[] bytes = stringValue.getBytes("UTF-8");
					if (bytes.length > Short.MAX_VALUE) {
						throw new BimDatabaseException("String value too long");
					}
					buffer.putShort((short) bytes.length);
					buffer.put(bytes);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		} else if (feature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
			buffer.putInt((Integer) value);
		} else if (feature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
			buffer.putDouble((Double) value);
		} else if (feature.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
			buffer.putFloat((Float) value);
		} else if (feature.getEType() == EcorePackage.eINSTANCE.getELong()) {
			buffer.putLong((Long) value);
		} else if (feature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
			buffer.put(((Boolean) value) ? (byte) 1 : (byte) 0);
		} else if (feature.getEType() == EcorePackage.eINSTANCE.getEDate()) {
			if (value == null) {
				buffer.put(new byte[8]);
			} else {
				buffer.putLong(((Date) value).getTime());
			}
		} else if (feature.getEType() == Ifc2x3Package.eINSTANCE.getTristate()) {
			Enumerator eEnumLiteral = (Enumerator) value;
			buffer.putInt(eEnumLiteral.getValue());
		} else if (feature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
			if (value == null) {
				buffer.putInt(0);
			} else {
				byte[] bytes = (byte[]) value;
				buffer.putInt(bytes.length);
				buffer.put(bytes);
			}
		} else {
			throw new RuntimeException("Unsupported type " + feature.getEType().getName());
		}
	}

	private void writeReference(Object value, CommitSet commitSet, GrowingByteBuffer buffer) throws BimDeadlockException {
		if (value == null) {
			buffer.putShort((byte) -1);
		} else {
			Short cid = database.getCidOfEClass(((EObject) value).eClass());
			buffer.putShort(cid);
			buffer.putLong(getReferenceOid((IdEObject) value, commitSet));
		}
	}

	private long getReferenceOid(IdEObject object, CommitSet commitSet) throws BimDeadlockException {
		if (commitSet.isStoring(object)) {
			return commitSet.getOid(object);
		} else {
			if (object != null) {
				return store(object, commitSet);
			} else {
				return -1;
			}
		}
	}

	@Override
	public void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimDeadlockException {
		CommitSet commitSet = new CommitSet(pid, rid);
		for (IdEObject object : values) {
			store(object, commitSet);
		}
	}

	@Override
	public ReadSet getAllOfType(String className, int pid, int rid) throws BimDatabaseException, BimDeadlockException {
		ReadSet readSet = new ReadSet(pid, rid);
		getMap(getEClassForName(className), readSet);
		return readSet;
	}

	@Override
	public Collection<EClass> getClasses() {
		return database.getClasses();
	}

	@Override
	public DatabaseInformation getDatabaseInformation() throws BimDatabaseException, BimDeadlockException {
		DatabaseInformation databaseInformation = new DatabaseInformation();
		databaseInformation.setNumberOfProjects(getObjectCount(Project.class));
		databaseInformation.setNumberOfUsers(getObjectCount(User.class));
		databaseInformation.setNumberOfCheckouts(getObjectCount(Checkout.class));
		databaseInformation.setNumberOfRevisions(getObjectCount(ConcreteRevision.class));
		databaseInformation.setType(database.getColumnDatabase().getType());
		databaseInformation.setCreated(database.getCreated());
		databaseInformation.setDatabaseSizeInBytes(database.getColumnDatabase().getDatabaseSizeInBytes());
		databaseInformation.setSchemaVersion(database.getRegistry().readInt(Database.SCHEMA_VERSION, this));
		String stats = database.getColumnDatabase().getStats();
		Scanner scanner = new Scanner(stats);
		String title = "";
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains("=")) {
				databaseInformation.addGenericLine(title, line.substring(0, line.indexOf("=")), line.substring(line.indexOf("=") + 1));
			} else {
				title = line;
			}
		}
		databaseInformation.setLocation(database.getColumnDatabase().getLocation());
		return databaseInformation;
	}

	private int getObjectCount(Class<? extends IdEObject> clazz) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new IsOfTypeCondition((EClass) StorePackage.eINSTANCE.getEClassifier(clazz.getSimpleName()));
		return query(Database.STORE_PROJECT_ID, -1, condition, clazz).size();
	}

	@Override
	public ObjectIdentifier getOidOfGuid(String guid, int pid, int rid) throws BimDeadlockException {
		RecordIterator recordIterator = database.getColumnDatabase().getRecordIterator("IfcGloballyUniqueId", BinUtils.intToByteArray(pid),
				BinUtils.intToByteArray(pid), this);
		try {
			Record record = recordIterator.next();
			while (record != null) {
				ByteBuffer buffer = ByteBuffer.wrap(record.getKey());
				int pidOfRecord = buffer.getInt();
				buffer.getLong();
				int ridOfRecord = -buffer.getInt();
				if (ridOfRecord == rid && pid == pidOfRecord) {
					ByteBuffer value = ByteBuffer.wrap(record.getValue());
					if (value.capacity() > 1) {
						short stringLength = value.getShort();
						String s = BinUtils.readString(value, stringLength);
						if (s.equals(guid)) {
							short referenceCid = value.getShort();
							// Read the next value, because this is the
							// (manually added) IfcRoot field, pointing to the
							// Object referring this Guid
							long referencedOid = value.getLong();
							return new ObjectIdentifier(referencedOid, referenceCid);
						}
					}
				}
				record = recordIterator.next();
			}
		} finally {
			recordIterator.close();
		}
		return null;
	}

	public void commit() throws BimDeadlockException, BimDatabaseException {
		if (!readOnly) {
			bimTransaction.commit();
		} else {
			throw new BimDatabaseException("Cannot commit readonly session");
		}
	}

	@Override
	public List<String> getClassList() {
		return database.getAvailableClasses();
	}

	@Override
	public void updateLastActive(long uoid) {
		try {
			User user = getUserByUoid(uoid);
			user.setLastSeen(new Date());
			store(user, new CommitSet(Database.STORE_PROJECT_ID, -1));
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Revision getVirtualRevision(long roid) throws BimDeadlockException, BimDatabaseException {
		IdEObject idEObject = get(database.getCidOfEClass(StorePackage.eINSTANCE.getRevision()), roid, new ReadSet(Database.STORE_PROJECT_ID, -1));
		return (Revision) idEObject;
	}

	public FieldIgnoreMap getFieldIgnoreMap() {
		return database.getFieldIgnoreMap();
	}

	@Override
	public short getCidForClassName(String className) {
		return database.getCidOfEClass(getEClassForName(className));
	}

	@Override
	public void clearCache() {
		cache.clear();
	}

	public long getCachedOid(EObject referencedObject) {
		return cache.inverse().get(referencedObject).getOid();
	}

	@Override
	public Project getProjectByPoid(long poid) {
		return (Project) get(StorePackage.eINSTANCE.getProject(), poid);
	}

	@Override
	public User getUserByUoid(long uoid) {
		return (User) get(StorePackage.eINSTANCE.getUser(), uoid);
	}

	@Override
	public short getCid(EClass eClass) {
		return database.getCidOfEClass(eClass);
	}

	@Override
	public Revision getRevisionByRoid(long roid) {
		return (Revision) get(StorePackage.eINSTANCE.getRevision(), roid);
	}

	@Override
	public ConcreteRevision getConcreteRevision(long roid) throws BimDeadlockException, BimDatabaseException {
		return (ConcreteRevision) get(StorePackage.eINSTANCE.getConcreteRevision(), roid);
	}

	@Override
	public IdEObject get(EClass eClass, long oid) {
		try {
			return get(getCid(eClass), oid, new ReadSet(Database.STORE_PROJECT_ID, -1));
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getAnonymousUser() throws BimDatabaseException, BimDeadlockException {
		return getUserByUserName("anonymous");
	}

	public boolean isReadOnly() {
		return readOnly;
	}
}