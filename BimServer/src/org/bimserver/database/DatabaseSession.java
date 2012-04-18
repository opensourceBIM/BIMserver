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

import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.LazyLoader;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.Tristate;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.DatabaseInformationCategory;
import org.bimserver.models.store.DatabaseInformationItem;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.exceptions.UserException;
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
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.LockTimeoutException;
import com.sleepycat.je.TransactionTimeoutException;

public class DatabaseSession implements LazyLoader, OidProvider {
	private static final boolean DEVELOPER_DEBUG = true;
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSession.class);
	private final BiMap<RecordIdentifier, IdEObject> cache = HashBiMap.create();
	private final Database database;
	private BimTransaction bimTransaction;
	private final boolean readOnly;
	private final Set<PostCommitAction> postCommitActions = new LinkedHashSet<PostCommitAction>();
	private boolean storeOid = false;
	private boolean storePid = false;
	private static final EcorePackage ECORE_PACKAGE = EcorePackage.eINSTANCE;
	private final ObjectsToCommit objectsToCommit = new ObjectsToCommit();
	private StackTraceElement[] stackTrace;
	private ClearProjectPlan clearProjectPlan = null;

	public DatabaseSession(Database database, BimTransaction bimTransaction, boolean readOnly) {
		this.database = database;
		this.bimTransaction = bimTransaction;
		this.readOnly = readOnly;
		stackTrace = Thread.currentThread().getStackTrace();
		if (DEVELOPER_DEBUG) {
			LOGGER.info("");
			LOGGER.info("NEW SESSION");
		}
	}

	public void addPostCommitAction(PostCommitAction postCommitAction) {
		postCommitActions.add(postCommitAction);
	}

	public void addToObjectsToCommit(IdEObject idEObject) throws BimserverDatabaseException {
		if (idEObject.getOid() == -1) {
			throw new BimserverDatabaseException("Cannot store object with oid -1");
		}
		objectsToCommit.put(idEObject, idEObject.getOid());
	}

	public boolean cacheContains(EObject object) {
		return cache.inverse().containsKey(object);
	}

	public boolean cacheContains(RecordIdentifier pidOidPair) {
		return cache.containsKey(pidOidPair);
	}

	public void clearCache() {
		cache.clear();
	}

	public void clearProject() throws BimserverDeadlockException, BimserverDatabaseException {
		ByteBuffer keyBuffer = ByteBuffer.allocate(16);
		ByteBuffer searchKeyBuffer = ByteBuffer.allocate(12);
		for (EClass classifier : database.getClasses()) {
			byte[] pidArray = BinUtils.intToByteArray(clearProjectPlan.getPid());
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
					} else if (foundRid > clearProjectPlan.getOldRid()) {
						// skip, we probably just added it
					} else if (clearProjectPlan.getOldRid() == foundRid) {
						delete(classifier.getName(), clearProjectPlan.getPid(), clearProjectPlan.getNewRid(), foundOid);
					}
					searchKeyBuffer.position(0);
					searchKeyBuffer.putInt(clearProjectPlan.getPid());
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
		if (DEVELOPER_DEBUG) {
			LOGGER.info("END SESSION");
		}
	}

	public void commit() throws BimserverDatabaseException {
		commit(null);
	}

	public void commit(ProgressHandler progressHandler) throws BimserverDatabaseException {
		if (!readOnly) {
			try {
				if (progressHandler != null) {
					progressHandler.progress(0, objectsToCommit.size());
				}
				int current = 0;
				if (clearProjectPlan != null) {
					clearProject();
				}
				for (IdEObject object : objectsToCommit) {
					if (object.getOid() == -1) {
						throw new BimserverDatabaseException("Cannot store object with oid -1");
					}
					// TODO move keybuffer out of loop
					ByteBuffer keyBuffer = createKeyBuffer(object.getPid(), object.getOid(), object.getRid());
					if (DEVELOPER_DEBUG && StorePackage.eINSTANCE == object.eClass().getEPackage()) {
						LOGGER.info("Write: " + object.eClass().getName() + " " + "pid=" + object.getPid() + " oid=" + object.getOid() + " rid=" + object.getRid());
					}
					database.getColumnDatabase().storeNoOverwrite(object.eClass().getName(), keyBuffer.array(), convertObjectToByteArray(object).array(), this);
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
				if (bimTransaction != null) {
					bimTransaction.commit();
				}
				for (PostCommitAction postCommitAction : postCommitActions) {
					postCommitAction.execute();
				}
			} catch (BimserverConcurrentModificationDatabaseException e) {
				throw e;
			} catch (BimserverDeadlockException e) {
				throw e;
			} catch (BimserverDatabaseException e) {
				throw e;
			} catch (UserException e) {
				LOGGER.error("", e);
			}
		} else {
			throw new BimserverDatabaseException("Cannot commit readonly session");
		}
	}

	public Object convert(EClassifier type, String value) {
		return database.convert(type, value);
	}

	public IdEObject convertByteArrayToObject(EClass originalQueryClass, EClass eClass, long oid, ByteBuffer buffer, IfcModelInterface model, int pid, int rid, boolean deep,
			ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
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
		if (rid == Integer.MAX_VALUE) {
			throw new RuntimeException("This is not oke");
		}
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
		return convertByteArrayToObject(object, originalQueryClass, eClass, oid, buffer, model, pid, rid, deep, objectIDM);
	}

	@SuppressWarnings("unchecked")
	public IdEObject convertByteArrayToObject(IdEObject idEObject, EClass originalQueryClass, EClass eClass, long oid, ByteBuffer buffer, IfcModelInterface model, int pid,
			int rid, boolean deep, org.bimserver.plugins.objectidms.ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {

		if (idEObject == null) {
			idEObject = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
			idEObject.setOid(oid);
			idEObject.setPid(pid);
			if (rid == Integer.MAX_VALUE) {
				throw new RuntimeException("This is not oke");
			}
			idEObject.setRid(rid);
		}

		if (DEVELOPER_DEBUG && StorePackage.eINSTANCE == idEObject.eClass().getEPackage()) {
			LOGGER.info("Read: " + idEObject.eClass().getName() + " pid=" + pid + " oid=" + oid + " rid=" + rid);
		}
		
		byte unsettedLength = buffer.get();
		byte[] unsetted = new byte[unsettedLength];
		buffer.get(unsetted);

		int fieldCounter = 0;
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (feature.isUnsettable() && (unsetted[fieldCounter / 8] & (1 << (fieldCounter % 8))) != 0) {
				idEObject.eUnset(feature);
			} else {
				if (objectIDM != null && !objectIDM.shouldFollowReference(originalQueryClass, eClass, feature)) {
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
								 * readReference (and all calls beyond that call)
								 * alter (by opposites) this list, this list can
								 * potentially grow too large
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
										referencedObject = readReference(originalQueryClass, buffer, model, pid, rid, idEObject, feature, referenceClass, deep, objectIDM);
									}
									if (referencedObject != null) {
										if (!feature.getEType().isInstance(referencedObject)) {
											throw new BimserverDatabaseException(referencedObject.getClass().getSimpleName() + " cannot be stored in list of " + feature.getName());
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
								newValue = readReference(originalQueryClass, buffer, model, pid, rid, idEObject, feature, referenceClass, deep, objectIDM);
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
			fieldCounter++;
		}
		idEObject.setLoaded();
		return idEObject;
	}

	public ByteBuffer convertObjectToByteArray(IdEObject object) throws BimserverDeadlockException, BimserverDatabaseException {
		ByteBuffer buffer = ByteBuffer.allocate(getExactSize(object));
		byte[] unsetted = new byte[(int) Math.ceil(object.eClass().getEAllStructuralFeatures().size() / 8.0)];
		int fieldCounter = 0;
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (feature.isUnsettable() && !object.eIsSet(feature)) {
				unsetted[fieldCounter / 8] |= (1 << (fieldCounter % 8));
			}
			fieldCounter++;
		}
		buffer.put((byte) unsetted.length);
		buffer.put(unsetted);

		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (!feature.isUnsettable() || object.eIsSet(feature)) {
				if (feature.isMany()) {
					if (feature.getEType() instanceof EEnum) {
						// Aggregate relations to enums never occur... at this
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

	public ByteBuffer createKeyBuffer(IdEObject object) {
		return createKeyBuffer(object.getPid(), object.getOid(), object.getRid());
	}

	private ByteBuffer createKeyBuffer(int pid, long oid, int rid) {
		ByteBuffer keyBuffer = ByteBuffer.allocate(16);
		keyBuffer.putInt(pid);
		keyBuffer.putLong(oid);
		keyBuffer.putInt(-rid);
		return keyBuffer;
	}

	public void delete(IdEObject object) throws BimserverDeadlockException {
		ByteBuffer buffer = createKeyBuffer(object.getPid(), object.getOid(), object.getRid());
		try {
			database.getColumnDatabase().store(object.eClass().getName(), buffer.array(), new byte[] { -1 }, this);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	private boolean delete(String className, int pid, int rid, long oid) throws BimserverDeadlockException {
		ByteBuffer buffer = createKeyBuffer(pid, oid, rid);
		try {
			database.getColumnDatabase().store(className, buffer.array(), new byte[] { -1 }, this);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		return true;
	}

	public <T> T executeAction(BimDatabaseAction<T> action, int retries) throws BimserverDatabaseException, UserException {
		for (int i = 0; i < retries; i++) {
			try {
				return action.execute();
			} catch (BimserverDeadlockException e) {
				if (bimTransaction != null) {
					bimTransaction.rollback();
					bimTransaction = database.getColumnDatabase().startTransaction();
				}
				LOGGER.info("Deadlock while executing " + action.getClass().getSimpleName() + " run (" + i + ")");
				if (i < retries - 1) {
					try {
						Thread.sleep(new Random().nextInt((i + 1) * 1000));
					} catch (InterruptedException e1) {
						LOGGER.error("", e1);
					}
				}
			} catch (BimserverDatabaseException e) {
				throw e;
			}
		}
		throw new BimserverDatabaseException("Too many deadlocks (" + retries + ")");
	}

	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries) throws BimserverDatabaseException, UserException {
		return executeAndCommitAction(action, retries, null);
	}

	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries, ProgressHandler progressHandler) throws BimserverDatabaseException, UserException {
		for (int i = 0; i < retries; i++) {
			try {
				T result = action.execute();
				commit(progressHandler);
				return result;
			} catch (BimserverConcurrentModificationDatabaseException e) {
				bimTransaction.rollback();
				clearCache();
				objectsToCommit.clear();
				bimTransaction = database.getColumnDatabase().startTransaction();
			} catch (BimserverDeadlockException e) {
				bimTransaction.rollback();
				clearCache();
				objectsToCommit.clear();
				bimTransaction = database.getColumnDatabase().startTransaction();
				if (DEVELOPER_DEBUG) {
					LockConflictException lockException = e.getLockException();
					if (lockException instanceof TransactionTimeoutException) {
						TransactionTimeoutException transactionTimeoutException = (TransactionTimeoutException)e.getLockException();
					} else if (lockException instanceof LockTimeoutException) {
						LockTimeoutException lockTimeoutException = (LockTimeoutException)lockException;
					}
					LOGGER.info("Lock while executing " + action.getClass().getSimpleName() + " run (" + i + ")", lockException);
					long[] ownerTxnIds = e.getLockException().getOwnerTxnIds();
					for (long txnid : ownerTxnIds) {
						DatabaseSession databaseSession = database.getDatabaseSession(txnid);
						if (databaseSession != null) {
							LOGGER.info("Owner: " + databaseSession);
							StackTraceElement[] stackTraceElements = databaseSession.getStackTrace();
							for (StackTraceElement stackTraceElement : stackTraceElements) {
								LOGGER.info("\tat " + stackTraceElement);
							}
						}
					}
				}
			} catch (BimserverDatabaseException e) {
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
		throw new BimserverDatabaseException("Too many deadlocks (" + retries + ")");
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T get(EClass eClass, IdEObject idEObject, long oid, boolean deep, ObjectIDM objectIDM) {
		try {
			return (T) get(getCid(eClass), idEObject, oid, deep, objectIDM);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public IdEObject get(EClass eClass, int pid, int rid, long oid, boolean deep, ObjectIDM objectIDM) {
		return get(eClass, null, pid, rid, oid, deep, objectIDM);
	}
	
	public <T extends IdEObject> T get(EClass eClass, long poid, boolean deep, ObjectIDM objectIDM) {
		return get(eClass, null, poid, deep, objectIDM);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T get(EClass eClass, IdEObject idEObject, int pid, int rid, long oid, boolean deep, ObjectIDM objectIDM) {
		try {
			return (T) get(getCid(eClass), idEObject, oid, pid, rid, new IfcModel(), deep, objectIDM);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public <T extends IdEObject> T get(short cid, IdEObject idEObject, long oid, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		return get(cid, idEObject, oid, Database.STORE_PROJECT_ID, Integer.MAX_VALUE, new IfcModel(), deep, objectIDM);
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T get(short cid, IdEObject idEObject, long oid, int pid, int rid, IfcModel model, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		if (objectsToCommit.containsOid(oid)) {
			return (T) objectsToCommit.getByOid(oid);
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
			keyBuffer.getInt(); // pid
			long keyOid = keyBuffer.getLong();
			int keyRid = -keyBuffer.getInt();
			if (keyRid <= rid) {
				RecordIdentifier recordIdentifier = new RecordIdentifier(pid, keyOid, keyRid);
				if (cacheContains(recordIdentifier) && getObject(recordIdentifier).getLoadingState() == State.LOADED) {
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
							T convertByteArrayToObject = (T) convertByteArrayToObject(idEObject, eClass, eClass, keyOid, valueBuffer, model, pid, rid == Integer.MAX_VALUE ? keyRid : rid, deep, objectIDM);
							putInCache(recordIdentifier, convertByteArrayToObject);
							return convertByteArrayToObject;
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

	public IfcModel getAllOfType(EClass eClass, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		return getAllOfType(eClass, Database.STORE_PROJECT_ID, Integer.MAX_VALUE, deep, objectIDM);
	}

	public IfcModel getAllOfType(EClass eClass, int pid, int rid, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		IfcModel model = new IfcModel();
		getMap(eClass, pid, rid, model, deep, objectIDM);
		return model;
	}

	public IfcModel getAllOfTypes(Set<EClass> eClasses, int pid, int rid, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		IfcModel model = new IfcModel();
		for (EClass eClass : eClasses) {
			getMap(eClass, pid, rid, model, deep, objectIDM);
		}
		return model;
	}

	public IfcModel getAllOfType(String className, int pid, int rid, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		return getAllOfType(getEClassForName(className), pid, rid, deep, objectIDM);
	}

	public BimTransaction getBimTransaction() {
		return bimTransaction;
	}

	public long getCachedOid(EObject referencedObject) {
		return cache.inverse().get(referencedObject).getOid();
	}

	public short getCid(EClass eClass) throws BimserverDatabaseException {
		Short cidOfEClass = database.getCidOfEClass(eClass);
		if (cidOfEClass == null) {
			throw new BimserverDatabaseException("EClass " + eClass.getName() + " not registered");
		}
		return cidOfEClass;
	}

	public short getCidForClassName(String className) {
		return database.getCidOfEClass(getEClassForName(className));
	}

	public short getCidOfEClass(EClass eClass) {
		return database.getCidOfEClass(eClass);
	}

	public Collection<EClass> getClasses() {
		return database.getClasses();
	}

	public List<String> getClassList() {
		return database.getAvailableClasses();
	}

	private EClass getClassOfObjectId(int pid, int rid, long oid, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		for (EClass eClass : database.getClasses()) {
			if (get(database.getCidOfEClass(eClass), null, oid, pid, rid, new IfcModel(), deep, objectIDM) != null) {
				return eClass;
			}
		}
		return null;
	}

	public int getCount(EClass eClass, IfcModel model, int pid, int rid) throws BimserverDatabaseException, BimserverDeadlockException {
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

	public DatabaseInformation getDatabaseInformation() throws BimserverDatabaseException, BimserverDeadlockException {
		DatabaseInformation databaseInformation = StoreFactory.eINSTANCE.createDatabaseInformation();
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
		DatabaseInformationCategory category = StoreFactory.eINSTANCE.createDatabaseInformationCategory();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains("=")) {
				DatabaseInformationItem item = StoreFactory.eINSTANCE.createDatabaseInformationItem();
				category.getItems().add(item);
				item.setKey(line.substring(0, line.indexOf("=")));
				item.setValue(line.substring(line.indexOf("=") + 1));
			} else {
				category = StoreFactory.eINSTANCE.createDatabaseInformationCategory();
				category.setTitle(line);
				databaseInformation.getCategories().add(category);
			}
		}
		databaseInformation.setLocation(database.getColumnDatabase().getLocation());
		return databaseInformation;
	}

	public EClass getEClassForCid(short cid) {
		return database.getEClassForCid(cid);
	}

	public EClass getEClassForName(String className) {
		return database.getEClassForName(className);
	}

	private int getExactSize(IdEObject idEObject) {
		int size = 0;

		size += 1; // Length of unsetted bytes
		int bits = 0;

		for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
			bits++;
			if (!eStructuralFeature.isUnsettable() || idEObject.eIsSet(eStructuralFeature)) {
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
		}
		
		size += (int)Math.ceil(bits / 8.0);
		
		return size;
	}

	private int getMap(EClass originalQueryClass, EClass eClass, IfcModelInterface model, ByteBuffer buffer, int keyPid, long keyOid, int keyRid, int pid, int rid, boolean deep,
			ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
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
							object = convertByteArrayToObject(originalQueryClass, eClass, keyOid, buffer, model, pid, rid == Integer.MAX_VALUE ? keyRid : rid, deep, objectIDM);
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

	public void getMap(EClass eClass, int pid, int rid, IfcModel ifcModel, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
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
				int map = getMap(eClass, eClass, ifcModel, valueBuffer, keyPid, keyOid, keyRid, pid, rid, deep, objectIDM);
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

	public void getMap(IfcModel ifcModel, int pid, int rid, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		for (EClass eClass : database.getClasses()) {
			if (objectIDM == null || objectIDM.shouldIncludeClass(eClass, eClass)) {
				getMap(eClass, pid, rid, ifcModel, deep, objectIDM);
			}
		}
	}

	public IfcModel getMapWithObjectIdentifiers(int pid, int rid, Set<ObjectIdentifier> oids, boolean deep, ObjectIDM objectIDM) throws BimserverDeadlockException, BimserverDatabaseException {
		IfcModel model = new IfcModel();
		for (ObjectIdentifier objectIdentifier : oids) {
			getMapWithOid(pid, rid, objectIdentifier.getCid(), objectIdentifier.getOid(), model, deep, objectIDM);
		}
		return model;
	}

	public IfcModel getMapWithOid(int pid, int rid, short cid, long oid, IfcModel model, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		EClass eClass = database.getEClassForCid(cid);
		if (eClass == null) {
			return model;
		}
		clearCache();
		ByteBuffer key = createKeyBuffer(pid, oid, rid);
		byte[] value = database.getColumnDatabase().get(eClass.getName(), key.array(), this);
		if (value == null) {
			return null;
		}
		ByteBuffer valueBuffer = ByteBuffer.wrap(value);
		getMap(eClass, eClass, model, valueBuffer, pid, oid, rid, pid, rid, deep, objectIDM);
		return model;
	}

	public void getMapWithOids(IfcModel model, int pid, int rid, Set<Long> oids, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		for (Long oid : oids) {
			EClass eClass = getClassOfObjectId(pid, rid, oid, deep, objectIDM);
			if (eClass != null) {
				getMapWithOid(pid, rid, database.getCidOfEClass(eClass), oid, model, deep, objectIDM);
				// throw new BimDatabaseException("Object with oid " + oid +
				// ", rid " + rid + ", pid " + pid + " not found");
			}
		}
	}

	public MetaDataManager getMetaDataManager() {
		return database.getMetaDataManager();
	}

	public IdEObject getObject(RecordIdentifier pidOidPair) {
		return cache.get(pidOidPair);
	}

	private int getObjectCount(Class<? extends IdEObject> clazz, boolean deep) throws BimserverDatabaseException, BimserverDeadlockException {
		Condition condition = new IsOfTypeCondition((EClass) StorePackage.eINSTANCE.getEClassifier(clazz.getSimpleName()));
		return query(condition, clazz, deep, null).size();
	}

	public long getOid(IdEObject object) {
		return cache.inverse().get(object).getOid();
	}

	public ObjectIdentifier getOidOfGuid(String guid, int pid, int rid) throws BimserverDeadlockException, BimserverDatabaseException {
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
					
					//Skip the unsettable part
					byte unsettablesSize = value.get();
					value.position(value.position() + unsettablesSize);

					if (value.capacity() > 1) {
						int stringLength = value.getInt();
						if (stringLength == -1) {
							return null;
						} else {
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
				}
				record = recordIterator.next();
			}
		} finally {
			recordIterator.close();
		}
		return null;
	}

	private int getPrimitiveSize(EDataType eDataType, Object val) {
		if (eDataType == ECORE_PACKAGE.getEInt() || eDataType == ECORE_PACKAGE.getEIntegerObject()) {
			return 4;
		} else if (eDataType == ECORE_PACKAGE.getEFloat() || eDataType == ECORE_PACKAGE.getEFloatObject()) {
			return 4;
		} else if (eDataType == ECORE_PACKAGE.getEBoolean() || eDataType == ECORE_PACKAGE.getEBooleanObject()) {
			return 1;
		} else if (eDataType == ECORE_PACKAGE.getEDate()) {
			return 8;
		} else if (eDataType == ECORE_PACKAGE.getELong() || eDataType == ECORE_PACKAGE.getELongObject()) {
			return 8;
		} else if (eDataType == ECORE_PACKAGE.getEDouble() || eDataType == ECORE_PACKAGE.getEDoubleObject()) {
			return 8;
		} else if (eDataType == ECORE_PACKAGE.getEString()) {
			if (val != null) {
				return 4 + ((String) val).getBytes(Charsets.UTF_8).length;
			}
			return 4;
		} else if (eDataType == ECORE_PACKAGE.getEByteArray()) {
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

	public IdEObject lazyLoad(IdEObject idEObject, ObjectIDM objectIDM) throws BimserverDeadlockException, BimserverDatabaseException {
		return lazyLoad(idEObject, idEObject.getPid(), perRecordVersioning(idEObject) ? Integer.MAX_VALUE : idEObject.getRid(), objectIDM);
	}
	
	public boolean perRecordVersioning(IdEObject idEObject) {
		return idEObject.eClass().getEPackage() != Ifc2x3Package.eINSTANCE;
	}
	
	public IdEObject lazyLoad(IdEObject idEObject, int pid, int rid, ObjectIDM objectIDM) throws BimserverDeadlockException, BimserverDatabaseException {
		if (DEVELOPER_DEBUG) {
			LOGGER.info("Lazy loading " + idEObject.eClass().getName() + " " + idEObject.getOid());
		}
		get(idEObject.eClass(), idEObject, pid, rid, idEObject.getOid(), false, objectIDM);
		return idEObject;
	}

	@Override
	public void load(IdEObject idEObject) {
		try {
			lazyLoad(idEObject, null);
		} catch (BimserverDeadlockException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	public long newOid() {
		storeOid = true;
		return database.newOid();
	}

	public int newPid() {
		storePid = true;
		return database.newPid();
	}

	public void putInCache(RecordIdentifier pidOidPair, IdEObject object) {
		if (!cache.containsValue(object)) {
			cache.put(pidOidPair, object);
		}
	}

	public <T extends IdEObject> Map<Long, T> query(Condition condition, Class<T> clazz, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		return query(Database.STORE_PROJECT_ID, Integer.MAX_VALUE, condition, clazz, deep, objectIDM);
	}

	public <T extends IdEObject> Map<Long, T> query(int pid, int rid, Condition condition, Class<T> clazz, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException,
			BimserverDeadlockException {
		Map<Long, T> map = new HashMap<Long, T>();
		Set<EClass> eClasses = new HashSet<EClass>();
		condition.getEClassRequirements(eClasses);
		IfcModel model = new IfcModel();
		for (EClass eClass : eClasses) {
			getMap(eClass, pid, rid, model, deep, objectIDM);
			for (Long oid : model.keySet()) {
				IdEObject object = model.get(oid);
				if (clazz.isInstance(object)) {
					if (condition.matches(object)) {
						map.put(oid, clazz.cast(object));
					}
				}
			}
		}
		return map;
	}

	public <T extends IdEObject> T querySingle(Condition condition, Class<T> clazz, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
		return querySingle(Database.STORE_PROJECT_ID, Integer.MAX_VALUE, condition, clazz, deep, objectIDM);
	}

	public <T extends IdEObject> T querySingle(int pid, int rid, Condition condition, Class<T> clazz, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException,
			BimserverDeadlockException {
		Collection<T> values = query(pid, rid, condition, clazz, deep, objectIDM).values();
		if (values.size() == 0) {
			return null;
		}
		return values.iterator().next();
	}

	public Object readPrimitiveValue(EClassifier classifier, ByteBuffer buffer) {
		if (classifier == ECORE_PACKAGE.getEString()) {
			int length = buffer.getInt();
			if (length != -1) {
				return BinUtils.readString(buffer, length);
			} else {
				return null;
			}
		} else if (classifier == ECORE_PACKAGE.getEInt() || classifier == ECORE_PACKAGE.getEIntegerObject()) {
			return buffer.getInt();
		} else if (classifier == ECORE_PACKAGE.getELong() || classifier == ECORE_PACKAGE.getELongObject()) {
			return buffer.getLong();
		} else if (classifier == ECORE_PACKAGE.getEFloat() || classifier == ECORE_PACKAGE.getEFloatObject()) {
			return buffer.getFloat();
		} else if (classifier == ECORE_PACKAGE.getEDouble() || classifier == ECORE_PACKAGE.getEDoubleObject()) {
			return buffer.getDouble();
		} else if (classifier == ECORE_PACKAGE.getEBoolean() || classifier == ECORE_PACKAGE.getEBooleanObject()) {
			return buffer.get() == 1;
		} else if (classifier == ECORE_PACKAGE.getEDate()) {
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
		} else if (classifier instanceof EEnum) {
			int ordinal = buffer.getInt();
			EEnum eEnum = (EEnum)classifier;
			return eEnum.getEEnumLiteral(ordinal).getInstance();
		} else {
			throw new RuntimeException("Unsupported type " + classifier.getName());
		}
	}

	private IdEObject readReference(EClass originalQueryClass, ByteBuffer buffer, IfcModelInterface model, int pid, int rid, IdEObject object, EStructuralFeature feature,
			EClass eClass, boolean deep, ObjectIDM objectIDM) throws BimserverDatabaseException, BimserverDeadlockException {
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
						throw new BimserverDatabaseException("Unsatisfied reference error, there is no " + eClass.getName() + " with pid " + pid + ", oid " + oid + ", rid <= " + rid
								+ " (referenced from " + object.eClass().getName() + " with oid " + object.getOid() + " on field " + feature.getName() + ")");
					}
					if (referenceValue.length == 1 && referenceValue[0] == -1) {
						// Deleted
					} else {
						if (objectIDM != null && !objectIDM.shouldIncludeClass(originalQueryClass, eClass)) {
							return null;
						} else {
							ByteBuffer referenceBuffer = ByteBuffer.wrap(referenceValue);
							IdEObject newObject = convertByteArrayToObject(originalQueryClass, eClass, oid, referenceBuffer, model, pid, rid, deep, objectIDM);
							RecordIdentifier recordIdentifier = new RecordIdentifier(pid, oid, rid);
							putInCache(recordIdentifier, newObject);
							return newObject;
						}
					}
				} else {
					IdEObject newObject = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
					newObject.setLazyLoader(this);
					newObject.setOid(oid);
					newObject.setPid(pid);
					newObject.setRid(perRecordVersioning(newObject) ? Integer.MAX_VALUE : rid);
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

	private void saveOidCounter() throws BimserverDeadlockException {
		database.getRegistry().save(Database.OID_COUNTER, database.getOidCounter(), this);
	}

	private void savePidCounter() throws BimserverDeadlockException {
		database.getRegistry().save(Database.PID_COUNTER, database.getPidCounter(), this);
	}

	public void store(Collection<? extends IdEObject> values) throws BimserverDeadlockException, BimserverDatabaseException {
		store(values, Database.STORE_PROJECT_ID, Integer.MAX_VALUE);
	}

	public void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimserverDeadlockException, BimserverDatabaseException {
		for (IdEObject object : values) {
			store(object, pid, rid);
		}
	}

	public long store(IdEObject object) throws BimserverDeadlockException, BimserverDatabaseException {
		return store(object, Database.STORE_PROJECT_ID, Integer.MAX_VALUE);
	}

	public long store(IdEObject object, int pid, int rid) throws BimserverDeadlockException, BimserverDatabaseException {
		if (!objectsToCommit.containsObject(object)) {
			if (object.getOid() == -1) {
				long newOid = newOid();
				object.setOid(newOid);
			}
			object.load();
			object.setPid(pid);
			if (rid == Integer.MAX_VALUE) {
				object.setRid(object.getRid() + 1);
			} else {
				object.setRid(rid);
			}
			addToObjectsToCommit(object);
		}
		return object.getOid();
	}

	public void writePrimitiveValue(EStructuralFeature feature, Object value, ByteBuffer buffer) throws BimserverDatabaseException {
		EClassifier type = feature.getEType();
		if (type == ECORE_PACKAGE.getEString()) {
			if (value == null) {
				buffer.putInt(-1);
			} else {
				String stringValue = (String) value;
				byte[] bytes = stringValue.getBytes(Charsets.UTF_8);
				if (bytes.length > Integer.MAX_VALUE) {
					throw new BimserverDatabaseException("String value too long (max length is " + Integer.MAX_VALUE + ")");
				}
				buffer.putInt(bytes.length);
				buffer.put(bytes);
			}
		} else if (type == ECORE_PACKAGE.getEInt() || type == ECORE_PACKAGE.getEIntegerObject()) {
			if (value == null) {
				buffer.putInt(0);
			} else {
				buffer.putInt((Integer) value);
			}
		} else if (type == ECORE_PACKAGE.getEDouble() || type == ECORE_PACKAGE.getEDoubleObject()) {
			if (value == null) {
				buffer.putDouble(0D);
			} else {
				buffer.putDouble((Double) value);
			}
		} else if (type == ECORE_PACKAGE.getEFloat() || type == ECORE_PACKAGE.getEFloatObject()) {
			if (value == null) {
				buffer.putFloat(0F);
			} else {
				buffer.putFloat((Float) value);
			}
		} else if (type == ECORE_PACKAGE.getELong() || type == ECORE_PACKAGE.getELongObject()) {
			if (value == null) {
				buffer.putLong(0L);
			} else {
				buffer.putLong((Long) value);
			}
		} else if (type == ECORE_PACKAGE.getEBoolean() || type == ECORE_PACKAGE.getEBooleanObject()) {
			if (value == null) {
				buffer.put((byte)0);
			} else {
				buffer.put(((Boolean) value) ? (byte) 1 : (byte) 0);
			}
		} else if (type == ECORE_PACKAGE.getEDate()) {
			if (value == null) {
				buffer.putLong(-1L);
			} else {
				buffer.putLong(((Date) value).getTime());
			}
		} else if (type == Ifc2x3Package.eINSTANCE.getTristate()) {
			Enumerator eEnumLiteral = (Enumerator) value;
			buffer.putInt(eEnumLiteral.getValue());
		} else if (value instanceof Enumerator) {
			Enumerator eEnumLiteral = (Enumerator) value;
			buffer.putInt(eEnumLiteral.getValue());
		} else if (type == EcorePackage.eINSTANCE.getEByteArray()) {
			if (value == null) {
				buffer.putInt(0);
			} else {
				byte[] bytes = (byte[]) value;
				buffer.putInt(bytes.length);
				buffer.put(bytes);
			}
		} else {
			throw new RuntimeException("Unsupported type " + type.getName());
		}
	}

	private void writeReference(int pid, int rid, Object value, ByteBuffer buffer, IdEObject object, EStructuralFeature feature) throws BimserverDeadlockException, BimserverDatabaseException {
		Short cid = database.getCidOfEClass(((EObject) value).eClass());
		buffer.putShort(cid);
		IdEObject idEObject = (IdEObject) value;
		if (idEObject.getOid() == -1) {
			throw new BimserverDatabaseException("Cannot store reference to object " + idEObject.eClass().getName() + " with oid=" + idEObject.getOid() + ", pid=" + idEObject.getPid()
					+ ", rid=" + idEObject.getRid() + " referenced from " + object.eClass().getName() + " with oid=" + object.getOid() + ", feature " + feature.getName());
		}
		buffer.putLong(idEObject.getOid());
	}

	private void writeWrappedValue(int pid, int rid, Object value, ByteBuffer buffer) throws BimserverDatabaseException, BimserverDeadlockException {
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
			} catch (BimserverDeadlockException e) {
				LOGGER.error("", e);
			}
		}
	}

	public List<String> getAvailableClassesInRevision(int pid, int rid) {
		IfcModel ifcModel = new IfcModel();
		try {
			getMap(ifcModel, pid, rid, true, null);
			List<String> classes = new ArrayList<String>();
			for (IdEObject idEObject : ifcModel.getValues()) {
				classes.add(idEObject.eClass().getName());
			}
			return classes;
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public long getTransactionId() {
		return bimTransaction.getId();
	}
	
	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

	public void planClearProject(int pid, int oldCid, int newCid) {
		clearProjectPlan = new ClearProjectPlan(pid, oldCid, newCid);
	}
}