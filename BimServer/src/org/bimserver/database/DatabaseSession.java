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
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.bimserver.MetaDataManager;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.PostCommitAction;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.LazyLoader;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.Tristate;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.DatabaseInformation;
import org.bimserver.shared.UserException;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EEnumImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class DatabaseSession implements BimDatabaseSession, LazyLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSession.class);
	private final BiMap<RecordIdentifier, IdEObject> cache = HashBiMap.create();
	private final Database database;
	private BimTransaction bimTransaction;
	private final boolean readOnly;
	private final BiMap<IdEObject, Long> objectsToCommit = HashBiMap.create();
	private final Set<PostCommitAction> postCommitActions = new LinkedHashSet<PostCommitAction>();
	private boolean storeOid = false;
	private boolean storePid = false;

	public DatabaseSession(Database database, BimTransaction bimTransaction, boolean readOnly) {
		this.database = database;
		this.bimTransaction = bimTransaction;
		this.readOnly = readOnly;
	}

	@Override
	public void addPostCommitAction(PostCommitAction postCommitAction) {
		postCommitActions.add(postCommitAction);
	}

	public void addToObjectsToCommit(IdEObject idEObject) throws BimDatabaseException {
		if (idEObject.getOid() == -1) {
			throw new BimDatabaseException("Cannot store object with oid -1");
		}
		objectsToCommit.forcePut(idEObject, idEObject.getOid());
	}

	public boolean cacheContains(EObject object) {
		return cache.inverse().containsKey(object);
	}

	public boolean cacheContains(RecordIdentifier pidOidPair) {
		return cache.containsKey(pidOidPair);
	}

	public void clear() {
		cache.clear();
	}

	@Override
	public void clearCache() {
		cache.clear();
	}

	@Override
	public void clearProject(int pid, int oldRid, int newRid) throws BimDeadlockException, BimDatabaseException {
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

	public void close() {
		database.unregisterSession(this);
		if (bimTransaction != null) {
			bimTransaction.close();
		}
		if (!isReadOnly() && objectsToCommit.size() == 0) {
			// LOGGER.warn("No objects were changed, could have used a read-only session, printing stack trace");
			// Thread.dumpStack();
		}
	}

	public void commit() throws BimDeadlockException, BimDatabaseException {
		commit(null);
	}

	public void commit(ProgressHandler progressHandler) throws BimDeadlockException, BimDatabaseException {
		if (!readOnly) {
			try {
				if (progressHandler != null) {
					progressHandler.progress(0, objectsToCommit.size());
				}
				int current = 0;
				for (IdEObject object : objectsToCommit.keySet()) {
					if (object.getOid() == -1) {
						throw new BimDatabaseException("Cannot store object with oid -1");
					}
					ByteBuffer keyBuffer = createKeyBuffer(object.getPid(), object.getOid(), object.getRid());
					// putInCache(new RecordIdentifier(object.getPid(),
					// object.getOid(), object.getRid()), object);
					database.getColumnDatabase().store(object.eClass().getName(), keyBuffer.array(), convertObjectToByteArray(object).array(), this);
					if (progressHandler != null) {
						progressHandler.progress(++current, objectsToCommit.size());
					}
				}
				if (storeOid) {
					saveOidCounter();
				}
				if (storePid) {
					savePidCounter();
				}
				for (PostCommitAction postCommitAction : postCommitActions) {
					postCommitAction.execute();
				}
				if (bimTransaction != null) {
					bimTransaction.commit();
				}
			} catch (BimDatabaseException e) {
				LOGGER.error("", e);
			} catch (UserException e) {
				LOGGER.error("", e);
			}
		} else {
			throw new BimDatabaseException("Cannot commit readonly session");
		}
	}

	@Override
	public Object convert(EClassifier type, String value) {
		return database.convert(type, value);
	}

	public IdEObject convertByteArrayToObject(EClass originalQueryClass, EClass eClass, long oid, ByteBuffer buffer, IfcModelInterface model, int pid, int rid, boolean deep)
			throws BimDatabaseException, BimDeadlockException {
		if (model.contains(oid)) {
			return model.get(oid);
		}
		RecordIdentifier recordIdentifier = new RecordIdentifier(pid, oid, rid);
		if (cache.containsKey(recordIdentifier)) {
			return cache.get(recordIdentifier);
		}
		IdEObject object = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setOid(oid);
		object.setPid(pid);
		object.setRid(rid);
		if (!deep) {
			object.setLazyLoader(this);
			object.setLoading();
		}
		if (!(object instanceof WrappedValue) && !(object instanceof IfcGloballyUniqueId)) {
			model.add(oid, object);
		}
		if (buffer.capacity() == 1 && buffer.get(0) == -1) {
			buffer.position(buffer.position() + 1);
			return null;
		}
		return convertByteArrayToObject(object, originalQueryClass, eClass, oid, buffer, model, pid, rid, deep);
	}

	@SuppressWarnings("unchecked")
	public IdEObject convertByteArrayToObject(IdEObject idEObject, EClass originalQueryClass, EClass eClass, long oid, ByteBuffer buffer, IfcModelInterface model, int pid, int rid,
			boolean deep) throws BimDatabaseException, BimDeadlockException {
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (!feature.isTransient() && !feature.isVolatile()) {
				if (database.shouldIgnoreField(originalQueryClass, eClass, feature)) {
					// we have to do some reading to maintain a correct index
					database.fakeRead(buffer, feature);
				} else {
					Object newValue = null;
					if (feature.isMany()) {
						if (feature.getEType() instanceof EEnum) {
						} else if (feature.getEType() instanceof EClass) {
							// EReference eReference = (EReference) feature;
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
								int listSize = buffer.getInt();
								BasicEList<Object> list = (BasicEList<Object>) idEObject.eGet(feature);
								for (int i = 0; i < listSize; i++) {
									IdEObject referencedObject = null;

									short cid = buffer.getShort();
									if (cid == -1) {
										// null, do nothing
									} else if (cid < 0) {
										// negative cid means value is embedded
										// in record
										EClass referenceClass = database.getEClassForCid((short) (-cid));
										referencedObject = readWrappedValue(feature, buffer, referenceClass);
									} else if (cid > 0) {
										// positive cid means value is reference
										// to other record
										EClass referenceClass = database.getEClassForCid(cid);
										referencedObject = readReference(originalQueryClass, buffer, model, pid, rid, idEObject, feature, referenceClass, deep);
									}
									if (referencedObject != null) {
										if (!feature.getEType().isInstance(referencedObject)) {
											throw new BimDatabaseException(referencedObject.getClass().getSimpleName() + " cannot be stored in list of " + feature.getName());
										}
										// if (eReference.getEOpposite() == null
										// ||
										// !referencedObject.isLoadedOrLoading())
										// {
										if (feature.isUnique()) {
											list.add(referencedObject);
										} else {
											list.addUnique(referencedObject);
										}
										// }
									}
								}
							}
						} else if (feature.getEType() instanceof EDataType) {
							int listSize = buffer.getInt();
							BasicEList<Object> list = new BasicEList<Object>(listSize);
							for (int i = 0; i < listSize; i++) {
								Object reference = readPrimitiveValue(feature.getEType(), buffer);
								if (reference != null) {
									list.addUnique(reference);
								}
							}
							newValue = list;
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
							// EReference eReference = (EReference) feature;
							short cid = buffer.getShort();
							if (cid == -1) {
								// null, do nothing
							} else if (cid < 0) {
								// negative cid means value is embedded in
								// record
								EClass referenceClass = database.getEClassForCid((short) (-cid));
								newValue = readWrappedValue(feature, buffer, referenceClass);
							} else if (cid > 0) {
								// positive cid means value is reference to
								// other record
								EClass referenceClass = database.getEClassForCid(cid);
								newValue = readReference(originalQueryClass, buffer, model, pid, rid, idEObject, feature, referenceClass, deep);
								// if (eReference.getEOpposite() != null &&
								// ((IdEObject) newValue).isLoadedOrLoading()) {
								// newValue = null;
								// }
							}
						} else if (feature.getEType() instanceof EDataType) {
							newValue = readPrimitiveValue(feature.getEType(), buffer);
						}
					}
					if (newValue != null) {
						idEObject.eSet(feature, newValue);
					}
				}
			}
		}
		idEObject.setLoaded();
		return idEObject;
	}

	public ByteBuffer convertObjectToByteArray(IdEObject object) throws BimDeadlockException, BimDatabaseException {
		ByteBuffer buffer = ByteBuffer.allocate(getExactSize(object));
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (!feature.isTransient() && !feature.isVolatile()) {
				if (feature.isMany()) {
					if (feature.getEType() instanceof EEnum) {
						// Aggregate relations to enums never occur... at
						// this
						// moment
					} else if (feature.getEType() instanceof EClass) {
						EList<?> list = (EList<?>) object.eGet(feature);
						buffer.putInt(list.size());
						for (Object o : list) {
							if (o == null) {
								buffer.putShort((short) -1);
							} else {
								IdEObject listObject = (IdEObject) o;
								boolean wrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(listObject.eClass());
								if (wrappedValue) {
									writeWrappedValue(object.getPid(), object.getRid(), o, buffer);
								} else {
									writeReference(object.getPid(), object.getRid(), o, buffer, object, feature);
								}
							}
						}
					} else if (feature.getEType() instanceof EDataType) {
						EList<?> list = (EList<?>) object.eGet(feature);
						buffer.putInt(list.size());
						for (Object o : list) {
							writePrimitiveValue(feature, o, buffer);
						}
					}
				} else {
					Object value = object.eGet(feature);
					if (feature.getEType() instanceof EEnum) {
						if (value == null) {
							buffer.putInt(-1);
						} else {
							EEnum eEnum = (EEnum) feature.getEType();
							EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteralByLiteral(((Enum<?>) value).toString());
							if (eEnumLiteral != null) {
								buffer.putInt(eEnumLiteral.getValue());
							} else {
								LOGGER.error(((Enum<?>) value).toString() + " not found");
								buffer.putInt(-1);
							}
						}
					} else if (feature.getEType() instanceof EClass) {
						if (value == null) {
							buffer.putShort((short) -1);
						} else {
							IdEObject referencedObject = (IdEObject) value;
							EClass referencedClass = referencedObject.eClass();
							boolean wrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(referencedClass);
							if (wrappedValue) {
								writeWrappedValue(object.getPid(), object.getRid(), value, buffer);
							} else {
								writeReference(object.getPid(), object.getRid(), value, buffer, object, feature);
							}
						}
					} else if (feature.getEType() instanceof EDataType) {
						writePrimitiveValue(feature, value, buffer);
					}
				}
			}
		}
		return buffer;
	}

	private ByteBuffer createKeyBuffer(IdEObject object) {
		return createKeyBuffer(object.getPid(), object.getOid(), object.getRid());
	}

	private ByteBuffer createKeyBuffer(int pid, long oid, int rid) {
		ByteBuffer keyBuffer = ByteBuffer.allocate(16);
		keyBuffer.putInt(pid);
		keyBuffer.putLong(oid);
		keyBuffer.putInt(-rid);
		return keyBuffer;
	}

	@Override
	public void delete(IdEObject object) {
		try {
			database.getColumnDatabase().delete(object.eClass().getName(), createKeyBuffer(object).array(), this);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		}
	}

	private boolean delete(String className, int pid, int rid, long oid) throws BimDeadlockException {
		ByteBuffer buffer = createKeyBuffer(pid, oid, rid);
		try {
			database.getColumnDatabase().store(className, buffer.array(), new byte[] { -1 }, this);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		}
		return true;
	}

	@Override
	public <T> T executeAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException {
		for (int i = 0; i < retries; i++) {
			try {
				return action.execute();
			} catch (BimDeadlockException e) {
				bimTransaction.rollback();
				bimTransaction = database.getColumnDatabase().startTransaction();
				LOGGER.info("Deadlock while executing " + action.getClass().getSimpleName() + " run (" + i + ")");
				if (i < retries - 1) {
					try {
						Thread.sleep(new Random().nextInt((i + 1) * 1000));
					} catch (InterruptedException e1) {
						LOGGER.error("", e1);
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
		return executeAndCommitAction(action, retries, null);
	}

	@Override
	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries, ProgressHandler progressHandler) throws BimDatabaseException, UserException {
		for (int i = 0; i < retries; i++) {
			try {
				T result = action.execute();
				commit(progressHandler);
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
					LOGGER.error("", e1);
				}
			}
		}
		throw new BimDatabaseException("Too many deadlocks (" + retries + ")");
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T get(EClass eClass, long oid, boolean deep) {
		try {
			return (T) get(getCid(eClass), oid, deep);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public <T extends IdEObject> T get(EClass eClass, int pid, int rid, long oid, boolean deep) {
		try {
			return (T) get(getCid(eClass), oid, pid, rid, new IfcModel(), deep);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	public <T extends IdEObject> T get(short cid, long oid, boolean deep) throws BimDatabaseException, BimDeadlockException {
		return get(cid, oid, Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID, new IfcModel(), deep);
	}

	public <T extends IdEObject> T get(short cid, long oid, int pid, int rid, IfcModel model, boolean deep) throws BimDatabaseException, BimDeadlockException {
		if (objectsToCommit.containsValue(oid)) {
			return (T) objectsToCommit.inverse().get(oid);
		}
		EClass eClass = getEClassForCid(cid);
		ByteBuffer mustStartWith = ByteBuffer.wrap(new byte[12]);
		mustStartWith.putInt(pid);
		mustStartWith.putLong(oid);
		ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[16]);
		startSearchWith.putInt(pid);
		startSearchWith.putLong(oid);
		startSearchWith.putInt(-rid);
		SearchingRecordIterator recordIterator = database.getColumnDatabase().getRecordIterator(eClass.getName(), mustStartWith.array(), startSearchWith.array(), this);
		try {
			Record record = recordIterator.next();
			if (record == null) {
				return null;
			}
			ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
			ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
			int keyPid = keyBuffer.getInt();
			long keyOid = keyBuffer.getLong();
			int keyRid = -keyBuffer.getInt();
			if (keyRid <= rid) {
				RecordIdentifier recordIdentifier = new RecordIdentifier(pid, keyOid, keyRid);
				if (cacheContains(recordIdentifier)) {
					return (T) getObject(recordIdentifier);
				} else {
					if (model.contains(keyOid)) {
						return (T) model.get(keyOid);
					} else {
						if (valueBuffer.capacity() == 1 && valueBuffer.get(0) == -1) {
							valueBuffer.position(valueBuffer.position() + 1);
							return null;
							// deleted entity
						} else {
							return (T) convertByteArrayToObject(eClass, eClass, keyOid, valueBuffer, model, pid, rid, deep);
						}
					}
				}
			} else {
				return null;
			}
		} finally {
			recordIterator.close();
		}
	}

	@Override
	public IfcModel getAllOfType(EClass eClass, boolean deep) throws BimDatabaseException, BimDeadlockException {
		return getAllOfType(eClass, Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID, deep);
	}

	public IfcModel getAllOfType(EClass eClass, int pid, int rid, boolean deep) throws BimDatabaseException, BimDeadlockException {
		IfcModel model = new IfcModel();
		getMap(eClass, pid, rid, model, deep);
		return model;
	}

	@Override
	public IfcModel getAllOfType(String className, int pid, int rid, boolean deep) throws BimDatabaseException, BimDeadlockException {
		return getAllOfType(getEClassForName(className), pid, rid, deep);
	}

	public BimTransaction getBimTransaction() {
		return bimTransaction;
	}

	public long getCachedOid(EObject referencedObject) {
		return cache.inverse().get(referencedObject).getOid();
	}

	@Override
	public short getCid(EClass eClass) throws BimDatabaseException {
		Short cidOfEClass = database.getCidOfEClass(eClass);
		if (cidOfEClass == null) {
			throw new BimDatabaseException("EClass " + eClass.getName() + " not registered");
		}
		return cidOfEClass;
	}

	@Override
	public short getCidForClassName(String className) {
		return database.getCidOfEClass(getEClassForName(className));
	}

	public short getCidOfEClass(EClass eClass) {
		return database.getCidOfEClass(eClass);
	}

	@Override
	public Collection<EClass> getClasses() {
		return database.getClasses();
	}

	@Override
	public List<String> getClassList() {
		return database.getAvailableClasses();
	}

	private EClass getClassOfObjectId(int pid, int rid, long oid, boolean deep) throws BimDatabaseException, BimDeadlockException {
		for (EClass eClass : database.getClasses()) {
			if (get(database.getCidOfEClass(eClass), oid, pid, rid, new IfcModel(), deep) != null) {
				return eClass;
			}
		}
		return null;
	}

	public int getCount(EClass eClass, IfcModel model, int pid, int rid) throws BimDatabaseException, BimDeadlockException {
		int count = 0;
		SearchingRecordIterator recordIterator = database.getColumnDatabase().getRecordIterator(eClass.getName(), BinUtils.intToByteArray(pid), BinUtils.intToByteArray(pid), this);
		try {
			Record record = recordIterator.next();
			ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
			byte[] nullReference = new byte[] { -1 };
			while (record != null) {
				ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
				int keyPid = keyBuffer.getInt();
				long oid = keyBuffer.getLong();
				int keyRid = -keyBuffer.getInt();
				int map = getCount(model, pid, rid, keyPid, keyRid);
				if (map == 1) {
					if (!Arrays.equals(record.getValue(), nullReference)) {
						count++;
					}
					nextKeyStart.position(0);
					nextKeyStart.putInt(pid);
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

	private int getCount(IfcModel model, int pid, int rid, int keyPid, int keyRid) {
		if (keyPid == pid) {
			if (keyRid <= rid) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 0;
		}
	}

	public Date getCreatedDate() {
		return database.getCreated();
	}

	@Override
	public DatabaseInformation getDatabaseInformation() throws BimDatabaseException, BimDeadlockException {
		DatabaseInformation databaseInformation = new DatabaseInformation();
		databaseInformation.setNumberOfProjects(getObjectCount(Project.class, false));
		databaseInformation.setNumberOfUsers(getObjectCount(User.class, false));
		databaseInformation.setNumberOfCheckouts(getObjectCount(Checkout.class, false));
		databaseInformation.setNumberOfRevisions(getObjectCount(ConcreteRevision.class, false));
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

	@Override
	public EClass getEClassForCid(short cid) {
		return database.getEClassForCid(cid);
	}

	@Override
	public EClass getEClassForName(String className) {
		return database.getEClassForName(className);
	}

	private int getExactSize(IdEObject idEObject) {
		int size = 0;
		for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
			Object val = idEObject.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute) eStructuralFeature;
				if (eAttribute.isMany()) {
					size += 4;
					for (Object v : ((List<?>) val)) {
						size += getPrimitiveSize(eAttribute.getEAttributeType(), v);
					}
				} else {
					size += getPrimitiveSize(eAttribute.getEAttributeType(), val);
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference) eStructuralFeature;
				if (val == null) {
					size += 2;
				} else {
					if (eReference.isMany()) {
						size += 4;
						for (Object v : ((List<?>) val)) {
							size += getWrappedValueSize(v);
						}
					} else {
						size += getWrappedValueSize(val);
					}
				}
			}
		}
		return size;
	}

	private int getMap(EClass originalQueryClass, EClass eClass, IfcModelInterface model, ByteBuffer buffer, int keyPid, long keyOid, int keyRid, int pid, int rid, boolean deep)
			throws BimDatabaseException, BimDeadlockException {
		if (keyPid == pid) {
			if (keyRid <= rid) {
				RecordIdentifier recordIdentifier = new RecordIdentifier(pid, keyOid, keyRid);
				if (cacheContains(recordIdentifier)) {
					IdEObject object = getObject(recordIdentifier);
					if (!model.contains(keyOid) && !(object instanceof WrappedValue) && !(object instanceof IfcGloballyUniqueId)) {
						model.add(keyOid, object);
					}
					return 1;
				} else {
					IdEObject object = null;
					if (model.contains(keyOid)) {
						object = model.get(keyOid);
					} else {
						if (buffer.capacity() == 1 && buffer.get(0) == -1) {
							buffer.position(buffer.position() + 1);
							return 1;
							// deleted entity
						} else {
							object = convertByteArrayToObject(originalQueryClass, eClass, keyOid, buffer, model, pid, rid, deep);
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

	public void getMap(EClass eClass, int pid, int rid, IfcModel ifcModel, boolean deep) throws BimDatabaseException, BimDeadlockException {
		SearchingRecordIterator recordIterator = database.getColumnDatabase().getRecordIterator(eClass.getName(), BinUtils.intToByteArray(pid), BinUtils.intToByteArray(pid), this);
		try {
			Record record = recordIterator.next();
			ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
			while (record != null) {
				ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
				int keyPid = keyBuffer.getInt();
				long keyOid = keyBuffer.getLong();
				int keyRid = -keyBuffer.getInt();
				ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
				int map = getMap(eClass, eClass, ifcModel, valueBuffer, keyPid, keyOid, keyRid, pid, rid, deep);
				if (map == 1) {
					nextKeyStart.position(0);
					nextKeyStart.putInt(pid);
					nextKeyStart.putLong(keyOid + 1);
					record = recordIterator.next(nextKeyStart.array());
				} else {
					record = recordIterator.next();
				}
			}
		} finally {
			recordIterator.close();
		}
	}

	@Override
	public void getMap(IfcModel ifcModel, int pid, int rid, boolean deep) throws BimDatabaseException, BimDeadlockException {
		for (EClass eClass : database.getClasses()) {
			getMap(eClass, pid, rid, ifcModel, deep);
		}
	}

	@Override
	public IfcModel getMapWithObjectIdentifiers(int pid, int rid, Set<ObjectIdentifier> oids, boolean deep) throws BimDeadlockException, BimDatabaseException {
		IfcModel model = new IfcModel();
		for (ObjectIdentifier objectIdentifier : oids) {
			getMapWithOid(pid, rid, objectIdentifier.getCid(), objectIdentifier.getOid(), model, deep);
		}
		return model;
	}

	public IfcModel getMapWithOid(int pid, int rid, short cid, long oid, IfcModel model, boolean deep) throws BimDatabaseException, BimDeadlockException {
		EClass eClass = database.getEClassForCid(cid);
		if (eClass == null) {
			return model;
		}
		clear();
		ByteBuffer key = createKeyBuffer(pid, oid, rid);
		byte[] value = database.getColumnDatabase().get(eClass.getName(), key.array(), this);
		if (value == null) {
			return null;
		}
		ByteBuffer valueBuffer = ByteBuffer.wrap(value);
		getMap(eClass, eClass, model, valueBuffer, pid, oid, rid, pid, rid, deep);
		return model;
	}

	@Override
	public void getMapWithOids(IfcModel model, int pid, int rid, Set<Long> oids, boolean deep) throws BimDatabaseException, BimDeadlockException {
		for (Long oid : oids) {
			EClass eClass = getClassOfObjectId(pid, rid, oid, deep);
			if (eClass != null) {
				getMapWithOid(pid, rid, database.getCidOfEClass(eClass), oid, model, deep);
				// throw new BimDatabaseException("Object with oid " + oid +
				// ", rid " + rid + ", pid " + pid + " not found");
			}
		}
	}

	@Override
	public MetaDataManager getMetaDataManager() {
		return database.getMetaDataManager();
	}

	public IdEObject getObject(RecordIdentifier pidOidPair) {
		return cache.get(pidOidPair);
	}

	private int getObjectCount(Class<? extends IdEObject> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new IsOfTypeCondition((EClass) StorePackage.eINSTANCE.getEClassifier(clazz.getSimpleName()));
		return query(condition, clazz, deep).size();
	}

	public long getOid(IdEObject object) {
		return cache.inverse().get(object).getOid();
	}

	@Override
	public ObjectIdentifier getOidOfGuid(String guid, int pid, int rid) throws BimDeadlockException, BimDatabaseException {
		RecordIterator recordIterator = database.getColumnDatabase().getRecordIterator("IfcGloballyUniqueId", BinUtils.intToByteArray(pid), BinUtils.intToByteArray(pid), this);
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
						int stringLength = value.getInt();
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

	private int getPrimitiveSize(EDataType eDataType, Object val) {
		if (eDataType == EcorePackage.eINSTANCE.getEInt()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEFloat()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEBoolean()) {
			return 1;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDate()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getELong()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDouble()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEString()) {
			if (val != null) {
				return 4 + ((String) val).getBytes(Charsets.UTF_8).length;
			}
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEByteArray()) {
			if (val != null) {
				return 4 + ((byte[]) val).length;
			}
			return 4;
		} else if (eDataType instanceof EEnum) {
			return 4;
		}
		throw new RuntimeException("Unimplemented: " + eDataType);
	}

	private int getWrappedValueSize(Object val) {
		if (val instanceof EObject) {
			EObject eObject = (EObject) val;
			boolean isWrappedValue = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eObject.eClass());
			int refSize = 10;
			if (isWrappedValue) {
				WrappedValue wrappedValue = (WrappedValue) val;
				EStructuralFeature wrappedValueFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
				Object wrappedVal = eObject.eGet(wrappedValueFeature);
				refSize = 2 + getPrimitiveSize((EDataType) wrappedValueFeature.getEType(), wrappedVal);
			}
			return refSize;
		}
		return 10;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public IdEObject lazyLoad(IdEObject idEObject) throws BimDeadlockException, BimDatabaseException {
		return lazyLoad(idEObject, idEObject.getPid(), idEObject.getRid());
	}

	public IdEObject lazyLoad(IdEObject idEObject, int pid, int rid) throws BimDeadlockException, BimDatabaseException {
		IfcModel model = new IfcModel();
		ByteBuffer keyBuffer = createKeyBuffer(pid, idEObject.getOid(), rid);
		byte[] value = database.getColumnDatabase().get(idEObject.eClass().getName(), keyBuffer.array(), this);
		if (value == null) {
			return null;
		} else {
			ByteBuffer buffer = ByteBuffer.wrap(value);
			IdEObject object = convertByteArrayToObject(idEObject, idEObject.eClass(), idEObject.eClass(), idEObject.getOid(), buffer, model, pid, rid, false);
			putInCache(new RecordIdentifier(pid, idEObject.getOid(), rid), object);
			return object;
		}
	}

	@Override
	public void load(IdEObject idEObject) {
		try {
			lazyLoad(idEObject);
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		}
	}

	public long newOid() {
		storeOid = true;
		return database.newOid();
	}

	@Override
	public int newPid() {
		storePid = true;
		return database.newPid();
	}

	@Override
	public BimDatabaseSession newSession(boolean useTransaction) {
		return database.createSession(false);
	}

	public void putInCache(RecordIdentifier pidOidPair, IdEObject object) {
		if (!cache.containsValue(object)) {
			cache.put(pidOidPair, object);
		}
	}

	public <T extends IdEObject> Map<Long, T> query(Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException {
		return query(Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID, condition, clazz, deep);
	}

	public <T extends IdEObject> Map<Long, T> query(int pid, int rid, Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException {
		Map<Long, T> map = new HashMap<Long, T>();
		Set<EClass> eClasses = new HashSet<EClass>();
		condition.getEClassRequirements(eClasses);
		IfcModel model = new IfcModel();
		for (EClass eClass : eClasses) {
			getMap(eClass, pid, rid, model, deep);
			for (Long oid : model.keySet()) {
				EObject object = model.get(oid);
				if (clazz.isInstance(object)) {
					if (condition.matches(object)) {
						map.put(oid, clazz.cast(object));
					}
				}
			}
		}
		return map;
	}

	public <T extends IdEObject> T querySingle(Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException {
		return querySingle(Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID, condition, clazz, deep);
	}

	public <T extends IdEObject> T querySingle(int pid, int rid, Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException {
		Collection<T> values = query(pid, rid, condition, clazz, deep).values();
		if (values.size() == 0) {
			return null;
		}
		return values.iterator().next();
	}

	public Object readPrimitiveValue(EClassifier classifier, ByteBuffer buffer) {
		if (classifier == EcorePackage.eINSTANCE.getEString()) {
			int length = buffer.getInt();
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
			long val = buffer.getLong();
			if (val == -1L) {
				return null;
			}
			return new Date(val);
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

	private IdEObject readReference(EClass originalQueryClass, ByteBuffer buffer, IfcModelInterface model, int pid, int rid, IdEObject object, EStructuralFeature feature, EClass eClass,
			boolean deep) throws BimDatabaseException, BimDeadlockException {
		if (buffer.capacity() == 1 && buffer.get(0) == -1) {
			buffer.position(buffer.position() + 1);
			return null;
		}
		long oid = buffer.getLong();
		if (cacheContains(new RecordIdentifier(pid, oid, rid))) {
			return getObject(new RecordIdentifier(pid, oid, rid));
		} else {
			if (model.contains(oid)) {
				return model.get(oid);
			} else {
				if (deep) {
					int descRid = rid;
					byte[] referenceValue = null;
					while (referenceValue == null && (descRid > 0 || descRid == -1)) {
						ByteBuffer pidoidrid = createKeyBuffer(pid, oid, descRid);
						referenceValue = database.getColumnDatabase().getFirstStartingWith(eClass.getName(), pidoidrid.array(), this);
						descRid--;
					}
					if (referenceValue == null) {
						throw new BimDatabaseException("Unsatisfied reference error, there is no " + eClass.getName() + " with pid " + pid + ", oid " + oid + ", rid <= " + rid
								+ " (referenced from " + object.eClass().getName() + " with oid " + object.getOid() + " on field " + feature.getName() + ")");
					}
					if (referenceValue.length == 1 && referenceValue[0] == -1) {
					} else if (referenceValue != null) {
						ByteBuffer referenceBuffer = ByteBuffer.wrap(referenceValue);
						IdEObject newObject = convertByteArrayToObject(originalQueryClass, eClass, oid, referenceBuffer, model, pid, rid, deep);
						RecordIdentifier recordIdentifier = new RecordIdentifier(pid, oid, rid);
						putInCache(recordIdentifier, newObject);
						return newObject;
					}
				} else {
					IdEObject newObject = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
					newObject.setLazyLoader(this);
					newObject.setOid(oid);
					newObject.setPid(pid);
					newObject.setRid(rid);
					RecordIdentifier recordIdentifier = new RecordIdentifier(pid, oid, rid);
					putInCache(recordIdentifier, newObject);
					if (!(object instanceof WrappedValue) && !(object instanceof IfcGloballyUniqueId)) {
						model.add(oid, newObject);
					}
					return newObject;
				}
			}
		}
		return null;
	}

	private IdEObject readWrappedValue(EStructuralFeature feature, ByteBuffer buffer, EClass eClass) {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("wrappedValue");
		Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer);
		IdEObject eObject = (IdEObject) Ifc2x3Factory.eINSTANCE.create(eClass);
		eObject.eSet(eStructuralFeature, primitiveValue);
		return eObject;
	}

	private void saveOidCounter() throws BimDeadlockException {
		database.getRegistry().save(Database.OID_COUNTER, database.getOidCounter(), this);
	}

	private void savePidCounter() throws BimDeadlockException {
		database.getRegistry().save(Database.PID_COUNTER, database.getPidCounter(), this);
	}

	@Override
	public void store(Collection<? extends IdEObject> values) throws BimDeadlockException, BimDatabaseException {
		store(values, Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID);
	}

	@Override
	public void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimDeadlockException, BimDatabaseException {
		for (IdEObject object : values) {
			store(object, pid, rid);
		}
	}

	@Override
	public long store(IdEObject object) throws BimDeadlockException, BimDatabaseException {
		return store(object, Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID);
	}

	@Override
	public long store(IdEObject object, int pid, int rid) throws BimDeadlockException, BimDatabaseException {
		if (!objectsToCommit.containsKey(object)) {
			if (object.getOid() == -1) {
				long newOid = newOid();
				object.setOid(newOid);
			}
			object.load();
			object.setPid(pid);
			object.setRid(rid);
			addToObjectsToCommit(object);
		}
		return object.getOid();
	}

	public void writePrimitiveValue(EStructuralFeature feature, Object value, ByteBuffer buffer) throws BimDatabaseException {
		if (feature.getEType() == EcorePackage.eINSTANCE.getEString()) {
			if (value == null) {
				buffer.putInt(-1);
			} else {
				String stringValue = (String) value;
				byte[] bytes = stringValue.getBytes(Charsets.UTF_8);
				if (bytes.length > Integer.MAX_VALUE) {
					throw new BimDatabaseException("String value too long (max length is " + Integer.MAX_VALUE + ")");
				}
				buffer.putInt(bytes.length);
				buffer.put(bytes);
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
				buffer.putLong(-1L);
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

	private void writeReference(int pid, int rid, Object value, ByteBuffer buffer, IdEObject object, EStructuralFeature feature) throws BimDeadlockException, BimDatabaseException {
		Short cid = database.getCidOfEClass(((EObject) value).eClass());
		buffer.putShort(cid);
		IdEObject idEObject = (IdEObject) value;
		if (idEObject.getOid() == -1) {
			throw new BimDatabaseException("Cannot store reference to object " + idEObject.eClass().getName() + " with oid=" + idEObject.getOid() + ", pid=" + idEObject.getPid()
					+ ", rid=" + idEObject.getRid() + " referenced from " + object.eClass().getName() + " with oid=" + object.getOid() + ", feature " + feature.getName());
		}
		buffer.putLong(idEObject.getOid());
	}

	private void writeWrappedValue(int pid, int rid, Object value, ByteBuffer buffer) throws BimDatabaseException, BimDeadlockException {
		WrappedValue wrappedValue = (WrappedValue) value;
		EStructuralFeature eStructuralFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
		Short cid = database.getCidOfEClass(wrappedValue.eClass());
		buffer.putShort((short) -cid);
		writePrimitiveValue(eStructuralFeature, wrappedValue.eGet(eStructuralFeature), buffer);
		if (wrappedValue instanceof IfcGloballyUniqueId) {
			if (wrappedValue.getOid() == -1) {
				wrappedValue.setOid(newOid());
			}
			ByteBuffer convertObjectToByteArray = convertObjectToByteArray(wrappedValue);
			ByteBuffer createKeyBuffer = createKeyBuffer(pid, wrappedValue.getOid(), rid);
			try {
				database.getColumnDatabase().store("IfcGloballyUniqueId", createKeyBuffer.array(), convertObjectToByteArray.array(), this);
			} catch (BimDeadlockException e) {
				LOGGER.error("", e);
			}
		}
	}
}