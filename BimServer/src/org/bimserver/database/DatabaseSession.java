package org.bimserver.database;

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

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
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
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.ServerIfcModel;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.LazyLoader;
import org.bimserver.emf.MetaDataException;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.DatabaseInformationCategory;
import org.bimserver.models.store.DatabaseInformationItem;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.VirtualObject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
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
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.LockTimeoutException;
import com.sleepycat.je.TransactionTimeoutException;

public class DatabaseSession implements LazyLoader, OidProvider, DatabaseInterface, AutoCloseable {
	public static final int DEFAULT_CONFLICT_RETRIES = 10;
	public static final boolean DEVELOPER_DEBUG = false;
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSession.class);
	
	private final Database database;
	private BimTransaction bimTransaction;
	private Set<PostCommitAction> postCommitActions;
	private ObjectsToCommit objectsToCommit;
	private ObjectsToDelete objectsToDelete;
	private StackTraceElement[] stackTrace;
	private final ObjectCache objectCache = new ObjectCache();
	private Map<String, Long> startOids;
	private Map<Long, HashMapVirtualObject> voCache;
	private CleanupListener cleanupListener;
	private final Set<ServerIfcModel> serverModels = new HashSet<>();
	private long reads;
	private long createdAt;

	public enum SessionState {
		OPEN, CLOSED
	}

	private SessionState state = SessionState.OPEN;
	private boolean overwriteEnabled;
	private boolean error;
	private final OperationType operationType;

	public DatabaseSession(Database database, BimTransaction bimTransaction, OperationType operationType) {
		this.database = database;
		this.bimTransaction = bimTransaction;
		this.operationType = operationType;
		this.createdAt = System.currentTimeMillis();
//		if (DEVELOPER_DEBUG) {
			this.stackTrace = Thread.currentThread().getStackTrace();
//		}
	}
	
	public long getCreatedAt() {
		return createdAt;
	}
	
	public void setOverwriteEnabled(boolean overwriteEnabled) {
		this.overwriteEnabled = overwriteEnabled;
	}

	public EClass getEClassForName(String packageName, String className) {
		return database.getEClassForName(packageName, className);
	}

	public void addPostCommitAction(PostCommitAction postCommitAction) {
		if (postCommitActions == null) {
			postCommitActions = new HashSet<>();
		}
		postCommitActions.add(postCommitAction);
	}

	public void addToObjectsToCommit(IdEObject idEObject) throws BimserverDatabaseException {
		if (idEObject.getOid() == -1) {
			throw new BimserverDatabaseException("Cannot store object with oid -1");
		}
		if (objectsToCommit == null) {
			objectsToCommit = new ObjectsToCommit();
		}
		objectsToCommit.put(idEObject);
	}

	public void close() {
		if (operationType == OperationType.READ_WRITE && bimTransaction.updates() == 0 && !error) {
			LOGGER.info("Potential for readonly database session");
			LOGGER.info("Owner: " + this);
			StackTraceElement[] stackTraceElements = this.getStackTrace();
			for (StackTraceElement stackTraceElement : stackTraceElements) {
				LOGGER.info("\tat " + stackTraceElement);
			}
		}
		state = SessionState.CLOSED;
		objectCache.clear();
		for (ServerIfcModel serverIfcModel : serverModels) {
			try {
				serverIfcModel.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		database.unregisterSession(this);
		database.incrementReads(reads);
		if (bimTransaction != null) {
			try {
				bimTransaction.close();
			} catch (IllegalStateException e) {
				database.getKeyValueStore().dumpOpenCursors();
			}
		}
		if (DEVELOPER_DEBUG) {
			LOGGER.info("END SESSION");
		}
	}
	
	public void commit(ProgressHandler progressHandler) throws BimserverDatabaseException, ServiceException {
		checkOpen();
		if (operationType == OperationType.READ_ONLY) {
			throw new BimserverDatabaseException("Cannot commit READ_ONLY DatabaseSession");
		}
		try {
			if (progressHandler != null) {
				progressHandler.progress(0, objectsToCommit == null ? 0 : objectsToCommit.size());
			}
			int current = 0;
			long writes = 0;
			ByteBuffer keyBuffer = ByteBuffer.wrap(new byte[16]);
			if (objectsToDelete != null) {
				for (RecordIdentifierPlusType recordIdentifier : objectsToDelete) {
					fillKeyBuffer(keyBuffer, recordIdentifier);
					database.getKeyValueStore().storeNoOverwrite(recordIdentifier.getPackageName() + "_" + recordIdentifier.getClassName(), keyBuffer.array(), new byte[] { -1 }, this);
					writes++;
				}
			}
			// This buffer is reused for the values, it's position must be reset at the end of the loop, and the convertObjectToByteArray function is responsible for setting the buffer's position to the end of the (used part of the) buffer
			ByteBuffer reusableBuffer = ByteBuffer.allocate(32768);
			if (objectsToCommit != null) {
				for (IdEObject object : objectsToCommit) {
					if (object.getOid() == -1) {
						throw new BimserverDatabaseException("Cannot store object with oid -1");
					}
					fillKeyBuffer(keyBuffer, object);
					if (DEVELOPER_DEBUG) {
						LOGGER.info("Write: " + object.eClass().getName() + " " + "pid=" + object.getPid() + " oid=" + object.getOid() + " rid=" + object.getRid());
					}
					ByteBuffer valueBuffer = convertObjectToByteArray(object, reusableBuffer, getMetaDataManager().getPackageMetaData(object.eClass().getEPackage().getName()));
					int valueBufferPosition = valueBuffer.position();
					processPossibleIndices(keyBuffer, object.getPid(), object.getRid(), object.getOid(), object.eClass(), valueBuffer);
					if (object.eClass().getEAnnotation("nolazyload") == null && !overwriteEnabled) {
						try {
							database.getKeyValueStore().storeNoOverwrite(object.eClass().getEPackage().getName() + "_" + object.eClass().getName(), keyBuffer.array(), valueBuffer.array(), 0, valueBufferPosition, this);
						} catch (BimserverConcurrentModificationDatabaseException e) {
							throw e;
						}
					} else {
						database.getKeyValueStore().store(object.eClass().getEPackage().getName() + "_" + object.eClass().getName(), keyBuffer.array(),
								valueBuffer.array(), 0, valueBuffer.position(), this);
					}
					if (progressHandler != null) {
						progressHandler.progress(++current, objectsToCommit.size());
					}
					writes++;
					reusableBuffer = valueBuffer; // bimServerClient may have increased the size of the buffer by creating a new one, we keep using it for other objects
					reusableBuffer.position(0);
				}
			}
			if (bimTransaction != null) {
				bimTransaction.commit();
				database.getKeyValueStore().sync();
			}
			database.incrementCommittedWrites(writes);
			if (bimTransaction != null) {
				bimTransaction.incUpdates(writes);
			}
			close();
			if (postCommitActions != null) {
				for (PostCommitAction postCommitAction : postCommitActions) {
					postCommitAction.execute();
				}
				postCommitActions = null;
			}
		} catch (BimserverDatabaseException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		}
	}

	private void processPossibleIndices(ByteBuffer keyBuffer, int pid, int rid, long oid, EClass eClass, ByteBuffer valueBuffer) throws BimserverLockConflictException, BimserverDatabaseException {
		boolean hasAtLeastOneIndex = false;
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature.getEAnnotation("singleindex") != null) {
				hasAtLeastOneIndex = true;
				break;
			}
		}
		if (hasAtLeastOneIndex) {
			byte[] oldData = null;
			ByteBuffer oldKeyBuffer = null;
			boolean perRecordVersioning = perRecordVersioning(eClass);
			if (perRecordVersioning) {
				oldKeyBuffer = ByteBuffer.allocate(16);
				oldKeyBuffer.putInt(pid);
				oldKeyBuffer.putLong(oid);
				oldKeyBuffer.putInt(-(rid - 1));
				oldData = database.getKeyValueStore().get(eClass.getEPackage().getName() + "_" + eClass.getName(), oldKeyBuffer.array(), this);
			}
			
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				if (eStructuralFeature.getEAnnotation("singleindex") != null) {
					String indexTableName = eClass.getEPackage().getName() + "_" + eClass.getName() + "_" + eStructuralFeature.getName();
					if (perRecordVersioning && oldData != null) {
						ByteBuffer oldValue = ByteBuffer.wrap(oldData);
						
						byte[] featureBytesOldIndex = extractFeatureBytes(this, oldValue, eClass, eStructuralFeature);
						
						if (!perRecordVersioning) {
							ByteBuffer oldFeatureBuffer = ByteBuffer.allocate(featureBytesOldIndex.length + 8);
							oldFeatureBuffer.putInt(pid);
							oldFeatureBuffer.putInt(-(rid - 1));
							oldFeatureBuffer.put(featureBytesOldIndex);
							featureBytesOldIndex = oldFeatureBuffer.array();
						}
						
						database.getKeyValueStore().delete(indexTableName, featureBytesOldIndex, oldKeyBuffer.array(), this);
					}
					
					byte[] featureBytes = extractFeatureBytes(this, valueBuffer, eClass, eStructuralFeature);
					if (featureBytes != null) {
						if (!perRecordVersioning) {
							ByteBuffer featureBuffer = ByteBuffer.allocate(featureBytes.length + 8);
							featureBuffer.putInt(pid);
							featureBuffer.putInt(-rid);
							featureBuffer.put(featureBytes);
							featureBytes = featureBuffer.array();
						}
						database.getKeyValueStore().store(indexTableName, featureBytes, keyBuffer.array(), this);
					}
				}
			}
		}
	}

	private void fillKeyBuffer(ByteBuffer buffer, RecordIdentifierPlusType recordIdentifier) {
		fillKeyBuffer(buffer, recordIdentifier.getPid(), recordIdentifier.getOid(), recordIdentifier.getRid());
	}

	private IdEObjectImpl createInternal(EClass eClass, QueryInterface queryInterface) {
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setQueryInterface(queryInterface);
		return object;
	}

	@SuppressWarnings({ "unused" })
	private IdEObject convertByteArrayToObject(IdEObject idEObject, EClass originalQueryClass, EClass eClass, long oid, ByteBuffer buffer, IfcModelInterface model, int rid, QueryInterface query, TodoList todoList) throws BimserverDatabaseException {
		try {
			if (idEObject == null) {
				idEObject = createInternal(eClass, query);

				((IdEObjectImpl) idEObject).setOid(oid);
				((IdEObjectImpl) idEObject).setPid(query.getPid());
				if (rid == Integer.MAX_VALUE) {
					throw new BimserverDatabaseException("Database corrupt, rid cannot be " + Integer.MAX_VALUE);
				}
				
			}
			if (idEObject.eClass().getEAnnotation("wrapped") == null) {
				try {
					model.addAllowMultiModel(oid, idEObject);
				} catch (IfcModelInterfaceException e) {
					throw new BimserverDatabaseException(e);
				}
			}
			((IdEObjectImpl) idEObject).setRid(rid);
			((IdEObjectImpl) idEObject).useInverses(false);
			
			if (DEVELOPER_DEBUG && StorePackage.eINSTANCE == idEObject.eClass().getEPackage()) {
				LOGGER.info("Read: " + idEObject.eClass().getName() + " pid=" + query.getPid() + " oid=" + oid + " rid=" + rid);
			}

			((IdEObjectImpl) idEObject).setLoadingState(State.LOADING);

			objectCache.put(oid, idEObject);
			
			int unsettedLength = model.getPackageMetaData().getUnsettedLength(eClass);
			
			byte[] unsetted = new byte[unsettedLength];
			buffer.get(unsetted);
			int fieldCounter = 0;
			
			((IdEObjectImpl) idEObject).setUuid(new UUID(buffer.getLong(), buffer.getLong()));
			
			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
				try {
					if (model.getPackageMetaData().useForDatabaseStorage(eClass, feature)) {
						boolean isUnsetted = (unsetted[fieldCounter / 8] & (1 << (fieldCounter % 8))) != 0;
						if (isUnsetted) {
							if (feature.isUnsettable()) {
								idEObject.eUnset(feature);
							} else if (feature.isMany()) {
								// do nothing
							} else if (feature.getDefaultValue() != null) {
								idEObject.eSet(feature, feature.getDefaultValue());
							}
						} else {
							if (false) {
								// we have to do some reading to maintain a correct
								// index
								fakeRead(buffer, feature);
							} else {
								Object newValue = null;
								if (feature.isMany()) {
									newValue = readList(idEObject, originalQueryClass, buffer, model, query, todoList, feature);
								} else {
									if (feature.getEType() instanceof EEnum) {
										int enumOrdinal = buffer.getInt();
										if (enumOrdinal == -1) {
											newValue = null;
										} else {
											EClassifier eType = feature.getEType();
											EEnumLiteral enumLiteral = ((EEnumImpl) eType).getEEnumLiteral(enumOrdinal);
											if (enumLiteral != null) {
												newValue = enumLiteral.getInstance();
											}
										}
									} else if (feature.getEType() instanceof EClass) {
										// EReference eReference = (EReference) feature;
										buffer.order(ByteOrder.LITTLE_ENDIAN);
										short cid = buffer.getShort();
										buffer.order(ByteOrder.BIG_ENDIAN);
										if (cid == -1) {
											// null, do nothing
										} else if (cid < 0) {
											// non minus one and negative cid means value is embedded in record
											EClass referenceClass = database.getEClassForCid((short) (-cid));
											if (feature.getEAnnotation("dbembed") != null) {
												newValue = readEmbeddedValue(feature, buffer, referenceClass, query);
											} else {
												newValue = readWrappedValue(feature, buffer, referenceClass, query);
											}
										} else if (cid > 0) {
											// positive cid means value is reference to other record
											EClass referenceClass = database.getEClassForCid(cid);
											if (referenceClass == null) {
												throw new BimserverDatabaseException("No eClass found for cid " + cid);
											}
											// readReference is going to read a long, which includes the 2 bytes for the cid
											buffer.position(buffer.position() - 2);
											newValue = readReference(originalQueryClass, buffer, model, idEObject, feature, referenceClass, query, todoList);
											// if (eReference.getEOpposite() != null &&
											// ((IdEObjectImpl)
											// newValue).isLoadedOrLoading()) {
											// newValue = null;
											// }
										}
									} else if (feature.getEType() instanceof EDataType) {
										newValue = readPrimitiveValue(feature.getEType(), buffer, query);
									}
								}
								if (newValue != null) {
									idEObject.eSet(feature, newValue);
								}
							}
						}
						fieldCounter++;
					}
				} catch (StringIndexOutOfBoundsException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "(" + oid + ")." + feature.getName(), e);
				} catch (BufferUnderflowException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "(" + oid + ")." + feature.getName(), e);
				} catch (BufferOverflowException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "(" + oid + ")." + feature.getName(), e);
				}
			}
			((IdEObjectImpl) idEObject).setLoaded();
			((IdEObjectImpl) idEObject).useInverses(true);
			if (DEVELOPER_DEBUG && idEObject.getRid() > 100000 || idEObject.getRid() < -100000) {
				LOGGER.debug("Improbable rid " + idEObject.getRid() + " - " + idEObject);
			}
			return idEObject;
		} catch (BufferUnderflowException e) {
			throw new BimserverDatabaseException("Reading " + eClass.getName(), e);
		} catch (BufferOverflowException e) {
			throw new BimserverDatabaseException("Reading " + eClass.getName(), e);
		}
	}

	@SuppressWarnings("unchecked")
	private Object readList(IdEObject idEObject, EClass originalQueryClass, ByteBuffer buffer, IfcModelInterface model, QueryInterface query, TodoList todoList,
			EStructuralFeature feature) throws BimserverDatabaseException {
		if (feature.getEType() instanceof EEnum) {
		} else if (feature.getEType() instanceof EClass) {
			if (buffer.capacity() == 1 && buffer.get(0) == -1) {
				buffer.position(buffer.position() + 1);
			} else {
				/*
				 * TODO There still is a problem with this,
				 * when readReference (and all calls beyond
				 * that call) alter (by opposites) this
				 * list, this list can potentially grow too
				 * large
				 * 
				 * Only can happen with non-unique
				 * references
				 */
				int listSize = buffer.getInt();

				BasicEList<Object> list = (BasicEList<Object>) idEObject.eGet(feature);
				list.grow(listSize);
				for (int i = 0; i < listSize; i++) {
					if (feature.getEAnnotation("twodimensionalarray") != null) {
						IdEObjectImpl newObject = createInternal((EClass) feature.getEType(), query);
						Object result = readList(newObject, originalQueryClass, buffer, model, query, todoList, newObject.eClass().getEStructuralFeature("List"));
						if (result != null) {
							newObject.eSet(newObject.eClass().getEStructuralFeature("List"), result);
						}
						list.addUnique(newObject);
					} else {
						IdEObject referencedObject = null;
						
						buffer.order(ByteOrder.LITTLE_ENDIAN);
						short cid = buffer.getShort();
						buffer.order(ByteOrder.BIG_ENDIAN);
						if (cid == -1) {
							// null, do nothing
						} else if (cid < 0) {
							// negative cid means value is
							// embedded
							// in record
							EClass referenceClass = database.getEClassForCid((short) (-cid));
							if (referenceClass == null) {
								throw new BimserverDatabaseException("No class found for cid " + (-cid));
							}
							if (feature.isMany()) {
								referencedObject = readEmbeddedValue(feature, buffer, referenceClass, query);
							} else {
								referencedObject = readWrappedValue(feature, buffer, referenceClass, query);
							}
						} else if (cid > 0) {
							// positive cid means value is a
							// reference
							// to another record
							EClass referenceClass = database.getEClassForCid(cid);
							if (referenceClass == null) {
								throw new BimserverDatabaseException("Cannot find class with cid " + cid);
							}
							buffer.position(buffer.position() - 2);
							referencedObject = readReference(originalQueryClass, buffer, model, idEObject, feature, referenceClass, query, todoList);
						}
						if (referencedObject != null) {
							if (!feature.getEType().isInstance(referencedObject)) {
								throw new BimserverDatabaseException(referencedObject.getClass().getSimpleName() + " cannot be stored in list of type "
										+ feature.getEType().getName() + " for feature " + feature.getName());
							}
							if (feature.isUnique()) {
								list.add(referencedObject);
							} else {
								list.addUnique(referencedObject);
							}
						}
					}
				}
			}
		} else if (feature.getEType() instanceof EDataType) {
			int listSize = buffer.getInt();
			BasicEList<Object> list = new BasicEList<Object>(listSize);
			for (int i = 0; i < listSize; i++) {
				Object reference = readPrimitiveValue(feature.getEType(), buffer, query);
				if (reference != null) {
					list.addUnique(reference);
				}
			}
			return list;
		}
		return null;
	}

	private boolean useUnsetBit(EStructuralFeature feature, IdEObject object) {
		// TODO non-unsettable boolean values can also be stored in these bits
		Object value = object.eGet(feature);
		if (feature.isUnsettable()) {
			if (!object.eIsSet(feature)) {
				return true;
			}
			if (feature.isMany() && ((List<?>)value).isEmpty()) {
				return true;
			}
		} else {
			if (feature.isMany() && ((List<?>)value).isEmpty()) {
				return true;
			}
			if (feature.getDefaultValue() == value || (feature.getDefaultValue() != null && feature.getDefaultValue().equals(value))) {
				return true;
			}
		}
		return false;
	}
	
	private ByteBuffer convertObjectToByteArray(IdEObject object, ByteBuffer buffer, PackageMetaData packageMetaData) throws BimserverDatabaseException {
		if (object.getUuid() == null) {
			throw new BimserverDatabaseException("UUID is required " + object.eClass().getName());
		}
		int bufferSize = getExactSize(object, packageMetaData, true);
		if (bufferSize > buffer.capacity()) {
			LOGGER.debug("Buffer too small (" + bufferSize + ")");
			buffer = ByteBuffer.allocate(bufferSize);
		}
		int unsettedLength = packageMetaData.getUnsettedLength(object.eClass());
		
		byte[] unsetted = new byte[unsettedLength];
		int fieldCounter = 0;
		
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (packageMetaData.useForDatabaseStorage(object.eClass(), feature)) {
				if (useUnsetBit(feature, object)) {
					unsetted[fieldCounter / 8] |= (1 << (fieldCounter % 8));
				}
				fieldCounter++;
			}
		}
		buffer.put(unsetted);
		
		EClass eClass = getEClassForOid(object.getOid());
		if (!eClass.isSuperTypeOf(object.eClass())) {
			throw new BimserverDatabaseException("Object with oid " + object.getOid() + " is a " + object.eClass().getName() + " but it's cid-part says it's a " + eClass.getName());
		}

		buffer.putLong(object.getUuid().getMostSignificantBits());
		buffer.putLong(object.getUuid().getLeastSignificantBits());

		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (packageMetaData.useForDatabaseStorage(object.eClass(), feature)) {
				if (!useUnsetBit(feature, object)) {
					if (feature.isMany()) {
						writeList(object, buffer, packageMetaData, feature);
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
								buffer.order(ByteOrder.LITTLE_ENDIAN);
								buffer.putShort((short) -1);
								buffer.order(ByteOrder.BIG_ENDIAN);
							} else {
								IdEObject referencedObject = (IdEObject) value;
								EClass referencedClass = referencedObject.eClass();
								if (feature.getEAnnotation("dbembed") != null) {
									writeEmbeddedValue(object.getPid(), object.getRid(), value, buffer, packageMetaData);
								} else if (referencedClass.getEAnnotation("wrapped") != null) {
									writeWrappedValue(object.getPid(), object.getRid(), value, buffer, packageMetaData);
								} else {
									writeReference(object, value, buffer, feature);
								}
							}
						} else if (feature.getEType() instanceof EDataType) {
							writePrimitiveValue(feature, value, buffer);
						}
					}
				}
			}
		}
		if (buffer.position() != bufferSize) {
			throw new BimserverDatabaseException("Value buffer sizes do not match for " + object.eClass().getName() + " " + buffer.position() + "/" + bufferSize);
		}
		return buffer;
	}

	private void writeList(IdEObject object, ByteBuffer buffer, PackageMetaData packageMetaData, EStructuralFeature feature) throws BimserverDatabaseException {
		if (feature.getEType() instanceof EEnum) {
			// Aggregate relations to enums never occur... at this
			// moment
		} else if (feature.getEType() instanceof EClass) {
			EList<?> list = (EList<?>) object.eGet(feature);
			buffer.putInt(list.size());
			for (Object o : list) {
				if (o == null) {
					buffer.order(ByteOrder.LITTLE_ENDIAN);
					buffer.putShort((short) -1);
					buffer.order(ByteOrder.BIG_ENDIAN);
				} else {
					IdEObject listObject = (IdEObject) o;
					if (listObject.eClass().getEAnnotation("wrapped") != null || listObject.eClass().getEStructuralFeature("wrappedValue") != null) {
						writeWrappedValue(object.getPid(), object.getRid(), listObject, buffer, packageMetaData);
					} else if (feature.getEAnnotation("twodimensionalarray") != null) {
						EStructuralFeature lf = listObject.eClass().getEStructuralFeature("List");
						writeList(listObject, buffer, packageMetaData, lf);
					} else if (feature.getEAnnotation("dbembed") != null) {
						writeEmbeddedValue(object.getPid(), object.getRid(), listObject, buffer, packageMetaData);
					} else {
						writeReference(object, listObject, buffer, feature);
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
	}

	@SuppressWarnings("unused")
	private ByteBuffer fillKeyBuffer(ByteBuffer buffer, IdEObject object) {
		if (DEVELOPER_DEBUG && object.getRid() > 100000 || object.getRid() < -100000) {
			LOGGER.debug("Improbable rid: " + object.getRid() + " - " + object);
		}
		return fillKeyBuffer(buffer, object.getPid(), object.getOid(), object.getRid());
	}

	private ByteBuffer fillKeyBuffer(ByteBuffer buffer, int pid, long oid, int rid) {
		buffer.position(0);
		buffer.putInt(pid);
		buffer.putLong(oid);
		buffer.putInt(-rid);
		return buffer;
	}

	private ByteBuffer createKeyBuffer(int pid, long oid, int rid) {
		ByteBuffer keyBuffer = ByteBuffer.allocate(16);
		fillKeyBuffer(keyBuffer, pid, oid, rid);
		return keyBuffer;
	}

	private ByteBuffer createKeyBuffer(int pid, long oid) {
		ByteBuffer keyBuffer = ByteBuffer.allocate(12);
		fillKeyBuffer(keyBuffer, pid, oid);
		return keyBuffer;
	}

	private ByteBuffer fillKeyBuffer(ByteBuffer buffer, int pid, long oid) {
		buffer.position(0);
		buffer.putInt(pid);
		buffer.putLong(oid);
		return buffer;
	}

	public void delete(IdEObject object, Integer newRid) throws BimserverDatabaseException {
		checkOpen();
		if (objectsToDelete == null) {
			objectsToDelete = new ObjectsToDelete();
		}
		// if (perRecordVersioning(object)) {
		objectsToDelete.put(object.eClass(), object.getPid(), newRid, object.getOid());
		if (objectsToCommit != null) {
			if (objectsToCommit.containsObject(object)) {
				objectsToCommit.remove(object);
			}
		}
		// } else {

		// TODO implement
		// throw new BimserverDatabaseException("This is not supported");
		// }
	}

	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, ProgressHandler progressHandler, RollbackListener rollbackListener) throws BimserverDatabaseException, ServiceException {
		checkOpen();
		return executeAndCommitAction(action, DEFAULT_CONFLICT_RETRIES, progressHandler, rollbackListener);
	}

	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, RollbackListener rollbackListener) throws BimserverDatabaseException, UserException, ServerException {
		checkOpen();
		return executeAndCommitAction(action, DEFAULT_CONFLICT_RETRIES, null, rollbackListener);
	}
	
	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, ProgressHandler progressHandler) throws BimserverDatabaseException, ServiceException {
		checkOpen();
		return executeAndCommitAction(action, DEFAULT_CONFLICT_RETRIES, progressHandler, null);
	}
	
	public <T> T executeAndCommitAction(BimDatabaseAction<T> action) throws BimserverDatabaseException, UserException, ServerException {
		checkOpen();
		return executeAndCommitAction(action, DEFAULT_CONFLICT_RETRIES, null, null);
	}

	public <T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries, ProgressHandler progressHandler, RollbackListener rollbackListener) throws BimserverDatabaseException, UserException,
			ServerException {
		checkOpen();
		for (int i = 0; i < retries; i++) {
			try {
				T result = action.execute();
				if ((objectsToCommit != null && objectsToCommit.size() > 0) || (objectsToDelete != null && objectsToDelete.size() > 0)) {
					commit(progressHandler);
				}
				return result;
			} catch (BimserverConcurrentModificationDatabaseException e) {
				LOGGER.debug("BimserverConcurrentModificationDatabaseException", e);
				if (progressHandler != null) {
					progressHandler.retry(i + 1);
				}
				if (bimTransaction != null) {
					bimTransaction.rollback();
				}
				if (rollbackListener != null) {
					rollbackListener.rollback();
				}
				objectCache.clear();
				objectsToCommit = null;
				startOids = null;
				if (bimTransaction != null) {
					bimTransaction = database.getKeyValueStore().startTransaction();
				} else {
					// No transaction used, no transactional rollback available/executed, but we still might have to clean up some stuff, see rollback listener
				}
			} catch (BimserverLockConflictException e) {
				LOGGER.info("BimserverLockConflictException");
				bimTransaction.rollback();
				objectCache.clear();
				objectsToCommit = null;
				bimTransaction = database.getKeyValueStore().startTransaction();
				if (DEVELOPER_DEBUG) {
					LockConflictException lockException = e.getLockException();
					if (lockException instanceof TransactionTimeoutException) {
					} else if (lockException instanceof LockTimeoutException) {
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
			} catch (UncheckedBimserverLockConflictException e) {
				LOGGER.info("UncheckedBimserverLockConflictException");
				bimTransaction.rollback();
				objectCache.clear();
				objectsToCommit = null;
				bimTransaction = database.getKeyValueStore().startTransaction();
			} catch (BimserverDatabaseException e) {
				this.error = true;
				bimTransaction.rollback();
				if (cleanupListener != null) {
					cleanupListener.cleanup();
				}
				throw e;
			} catch (ServiceException e) {
				if (e instanceof UserException) {
					throw ((UserException) e);
				} else if (e instanceof ServerException) {
					throw ((ServerException) e);
				} else {
					LOGGER.error("", e);
				}
			}
			if (i < retries - 1) {
				try {
					Thread.sleep(new Random().nextInt((i + 1) * 1000));
				} catch (InterruptedException e1) {
					LOGGER.error("", e1);
				}
			}
		}
		throw new BimserverDatabaseException("Too many conflicts, tried " + retries + " times");
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T get(EClass eClass, IfcModelInterface model, IdEObject idEObject, long oid, QueryInterface query, TodoList todoList)
			throws BimserverDatabaseException {
		checkOpen();
		return (T) get(idEObject, oid, model, query, todoList);
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T get(long oid, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		TodoList todoList = new TodoList();
		IfcModelInterface model = createModel(query);
		IdEObject idEObject = get(null, oid, model, query, todoList);
		processTodoList(model, todoList, query);
		return (T) idEObject;
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T get(IfcModelInterface model, long oid, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		TodoList todoList = new TodoList();
		IdEObject idEObject = get(null, oid, model, query, todoList);
		processTodoList(model, todoList, query);
		return (T) idEObject;
	}

	public <T extends IdEObject> T get(EClass eClass, long oid, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		if (oid == -1) {
			return null;
		}
		TodoList todoList = new TodoList();
		IfcModelInterface model = createModel(query);
		T t = get(null, oid, model, query, todoList);
		processTodoList(model, todoList, query);
		return t;
	}

	public <T extends IdEObject> T get(IfcModelInterface model, EClass eClass, long oid, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		if (oid == -1) {
			return null;
		}
		TodoList todoList = new TodoList();
		T t = get(null, oid, model, query, todoList);
		processTodoList(model, todoList, query);
		return t;
	}

	private void checkOpen() throws BimserverDatabaseException {
		if (state == SessionState.CLOSED) {
			throw new BimserverDatabaseException("Database session is closed");
		}
	}

	public <T extends IdEObject> T get(IdEObject idEObject, long oid, IfcModelInterface model, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		TodoList todoList = new TodoList();
		T result = get(idEObject, oid, model, query, todoList);
		processTodoList(model, todoList, query);
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T get(IdEObject idEObject, long oid, IfcModelInterface model, QueryInterface query, TodoList todoList) throws BimserverDatabaseException {
		checkOpen();
		if (oid == -1) {
			throw new BimserverDatabaseException("Cannot get object for oid " + oid);
		}
		if (objectsToCommit != null && objectsToCommit.containsOid(oid)) {
			return (T) objectsToCommit.getByOid(oid);
		}
		EClass eClass = getEClassForOid(oid);
		if (idEObject != null) {
			if (!eClass.isSuperTypeOf(idEObject.eClass())) {
				throw new BimserverDatabaseException("Object with oid " + oid + " is a " + idEObject.eClass().getName() + " but it's cid-part says it's a " + eClass.getName());
			}
		}
		IdEObjectImpl cachedObject = (IdEObjectImpl) objectCache.get(oid);
		if (cachedObject != null) {
			idEObject = cachedObject;
			if (cachedObject.getLoadingState() == State.LOADED && cachedObject.getRid() != Integer.MAX_VALUE) {
				cachedObject.load();
				return (T) cachedObject;
			}
		}
		ByteBuffer mustStartWith = ByteBuffer.wrap(new byte[12]);
		mustStartWith.putInt(query.getPid());
		mustStartWith.putLong(oid);
		ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[16]);
		startSearchWith.putInt(query.getPid());
		startSearchWith.putLong(oid);
		startSearchWith.putInt(-query.getRid());

		SearchingRecordIterator recordIterator = database.getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), mustStartWith.array(),
				startSearchWith.array(), this);
		try {
			Record record = recordIterator.next();
			if (record == null) {
				return null;
			}
			reads++;
			ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
			ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
			keyBuffer.getInt(); // pid
			long keyOid = keyBuffer.getLong();
			int keyRid = -keyBuffer.getInt();
			if (keyRid <= query.getRid()) {
				if (idEObject != null && idEObject.getRid() == Integer.MAX_VALUE) {
					((IdEObjectImpl) idEObject).setRid(keyRid);
				}
				if (model.contains(keyOid) && ((IdEObjectImpl) model.get(keyOid)).getLoadingState() == State.LOADED) {
					return (T) model.get(keyOid);
				} else {
					if (valueBuffer.capacity() == 1 && valueBuffer.get(0) == -1) {
						valueBuffer.position(valueBuffer.position() + 1);
						return null;
						// deleted entity
					} else {
						T convertByteArrayToObject = (T) convertByteArrayToObject(idEObject, eClass, eClass, keyOid, valueBuffer, model, keyRid, query, todoList);
						if (convertByteArrayToObject.getRid() == Integer.MAX_VALUE) {
							((IdEObjectImpl) convertByteArrayToObject).setRid(keyRid);
						}
						objectCache.put(oid, convertByteArrayToObject);
						return convertByteArrayToObject;
					}
				}
			} else {
				return null;
			}
		} finally {
			recordIterator.close();
		}
	}

	public IfcModelInterface getAllOfType(EClass eClass, QueryInterface query) throws BimserverDatabaseException {
		IfcModelInterface model = createModel(query);
		return getAllOfType(model, eClass, query);
	}
	
	public IfcModelInterface getAllOfType(IfcModelInterface model, EClass eClass, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		TodoList todoList = new TodoList();
		getMap(eClass, model, query, todoList);
		processTodoList(model, todoList, query);
		return model;
	}

	public IfcModelInterface getAllOfTypes(Set<EClass> eClasses, QueryInterface query) throws BimserverDatabaseException {
		IfcModelInterface model = createModel(query);
		return getAllOfTypes(model, eClasses, query);
	}
	
	public IfcModelInterface getAllOfTypes(IfcModelInterface model, Set<EClass> eClasses, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		TodoList todoList = new TodoList();
		for (EClass eClass : eClasses) {
			getMap(eClass, model, query, todoList);
		}
		processTodoList(model, todoList, query);
		return model;
	}

	public IfcModelInterface getAllOfType(String packageName, String className, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		return getAllOfType(getEClass(packageName, className), query);
	}

	public IfcModelInterface getAllOfType(IfcModelInterface model, String packageName, String className, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		return getAllOfType(model, getEClass(packageName, className), query);
	}

	public BimTransaction getBimTransaction() {
		return bimTransaction;
	}

	public short getCid(EClass eClass) throws BimserverDatabaseException {
		Short cidOfEClass = database.getCidOfEClass(eClass);
		if (cidOfEClass == null) {
			throw new BimserverDatabaseException("EClass " + eClass.getName() + " not registered");
		}
		return cidOfEClass;
	}

	public short getCidForClassName(String packageName, String className) throws BimserverDatabaseException {
		return database.getCidOfEClass(getEClass(packageName, className));
	}

	public short getCidOfEClass(EClass eClass) {
		return database.getCidOfEClass(eClass);
	}

	public List<String> getClassList() {
		return database.getAvailableClasses();
	}

	public int getCount(EClass eClass, IfcModelInterface model, int pid, int rid) throws BimserverDatabaseException {
		// TODO, only need to fetch the first byte of the value to be able to do the null-check, needs change in keyvaluestore layer
		checkOpen();
		int count = 0;
		SearchingRecordIterator recordIterator = database.getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(),
				BinUtils.intToByteArray(pid), BinUtils.intToByteArray(pid), this);
		try {
			Record record = recordIterator.next();
			ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
			byte[] nullReference = new byte[] { -1 };
			while (record != null) {
				reads++;
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

	private int getCount(IfcModelInterface model, int pid, int rid, int keyPid, int keyRid) {
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

	public DatabaseInformation getDatabaseInformation() throws BimserverDatabaseException {
		DatabaseInformation databaseInformation = StoreFactory.eINSTANCE.createDatabaseInformation();
		databaseInformation.setNumberOfProjects(getObjectCount(Project.class, OldQuery.getDefault()));
		databaseInformation.setNumberOfUsers(getObjectCount(User.class, OldQuery.getDefault()));
		databaseInformation.setNumberOfCheckouts(getObjectCount(Checkout.class, OldQuery.getDefault()));
		databaseInformation.setNumberOfRevisions(getObjectCount(ConcreteRevision.class, OldQuery.getDefault()));
		databaseInformation.setType(database.getKeyValueStore().getType());
		databaseInformation.setCreated(database.getCreated());
		databaseInformation.setDatabaseSizeInBytes(database.getKeyValueStore().getDatabaseSizeInBytes());
		databaseInformation.setSchemaVersion(database.getRegistry().readInt(Database.SCHEMA_VERSION, this));
		String stats = database.getKeyValueStore().getStats();
		Scanner scanner = new Scanner(stats);
		try {
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
		} finally {
			scanner.close();
		}
		databaseInformation.setLocation(database.getKeyValueStore().getLocation());
		return databaseInformation;
	}

	public EClass getEClass(short cid) throws BimserverDatabaseException {
		return database.getEClassForCid(cid);
	}

	public EClass getEClass(String packageName, String className) throws BimserverDatabaseException {
		return database.getEClass(packageName, className);
	}

	private int getExactSize(IdEObject idEObject, PackageMetaData packageMetaData, boolean useUnsetBits) {
		int size = useUnsetBits ? 16 : 0; // Using useUnsetBits to determine whether this objects has a UUID, dodgy...
		int bits = 0;
		
		for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
			if (packageMetaData.useForDatabaseStorage(idEObject.eClass(), eStructuralFeature)) {
				bits++;
				if (!useUnsetBits || !useUnsetBit(eStructuralFeature, idEObject)) {
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
						if (eReference.isMany()) {
							size += 4;
							for (Object v : ((List<?>) val)) {
								size += getWrappedValueSize(v, eReference, packageMetaData);
							}
						} else {
							size += getWrappedValueSize(val, eReference, packageMetaData);
						}
					}
				}
			}
		}

		if (useUnsetBits) {
			size += (int) Math.ceil(bits / 8.0);
		}

		return size;
	}

	public enum GetResult {
		STOP, CONTINUE_WITH_NEXT_RECORD, CONTINUE_WITH_NEXT_OID,
	}

	private GetResult getMap(EClass originalQueryClass, EClass eClass, IfcModelInterface model, ByteBuffer buffer, int keyPid, long keyOid, int keyRid, QueryInterface query, TodoList todoList) throws BimserverDatabaseException {
		checkOpen();
		if (keyPid == query.getPid()) {
			if (keyRid <= query.getRid() && keyRid >= query.getStopRid()) {
				IdEObject cachedObject = objectCache.get(keyOid);
				if (cachedObject != null && ((IdEObjectImpl)cachedObject).getLoadingState() == State.LOADED) {
					if (!model.contains(keyOid) && cachedObject.eClass().getEAnnotation("wrapped") == null) {
						try {
							model.addAllowMultiModel(keyOid, cachedObject);
						} catch (IfcModelInterfaceException e) {
							throw new BimserverDatabaseException(e);
						}
					}
					return GetResult.CONTINUE_WITH_NEXT_OID;
				} else {
					IdEObject object = null;
					if (model.contains(keyOid) && ((IdEObjectImpl)model.get(keyOid)).getLoadingState() == State.LOADED) {
						object = model.get(keyOid);
					} else {
						if (buffer.capacity() == 1 && buffer.get(0) == -1) {
							buffer.position(buffer.position() + 1);
							return GetResult.CONTINUE_WITH_NEXT_OID;
							// deleted entity
						} else {
							object = convertByteArrayToObject(cachedObject, originalQueryClass, eClass, keyOid, buffer, model, keyRid, query, todoList);
						}
					}
					if (object != null) {
						objectCache.put(keyOid, object);
						return GetResult.CONTINUE_WITH_NEXT_OID;
					}
				}
			} else {
				return GetResult.CONTINUE_WITH_NEXT_RECORD;
			}
		} else {
			return GetResult.STOP;
		}
		return GetResult.STOP;
	}

	public void getMap(EClass eClass, IfcModelInterface ifcModel, QueryInterface query, TodoList todoList) throws BimserverDatabaseException {
		checkOpen();
		SearchingRecordIterator recordIterator = null;
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (query.getOidCounters() != null) {
			if (!query.getOidCounters().containsKey(eClass)) {
				return;
			}
			long startOid = query.getOidCounters().get(eClass);
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(query.getPid());
			tmp.putLong(startOid + 1);
			recordIterator = database.getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(query.getPid()), tmp.array(), this);
		} else {
//			LOGGER.warn("Potential too-many-reads");
			recordIterator = database.getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(query.getPid()), BinUtils.intToByteArray(query.getPid()), this);
		}
		try {
			Record record = recordIterator.next();
			ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
			while (record != null) {
				if (Thread.currentThread().isInterrupted()) {
					throw new BimserverThreadInterruptedException("Thread interrupted");
				}
				reads++;
				ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
				int keyPid = keyBuffer.getInt();
				long keyOid = keyBuffer.getLong();
				int keyRid = -keyBuffer.getInt();
				ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
				GetResult map = getMap(eClass, eClass, ifcModel, valueBuffer, keyPid, keyOid, keyRid, query, todoList);
				if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
					nextKeyStart.position(0);
					nextKeyStart.putInt(query.getPid());
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

	public void getMap(IfcModelInterface ifcModel, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		TodoList todoList = new TodoList();
		if (query.getOidCounters() != null) {
			for (EClass eClass : query.getOidCounters().keySet()) {
				if (Thread.currentThread().isInterrupted()) {
					throw new BimserverDatabaseException("Thread interrupted");
				}
				if (eClass.getEAnnotation("nolazyload") == null && eClass.getEAnnotation("nodatabase") == null) {
					if (true) {
						getMap(eClass, ifcModel, query, todoList);
					}
				}
			}
		} else {
			LOGGER.info("Inefficient getMap");
			for (EClass eClass : database.getClasses()) {
				if (Thread.currentThread().isInterrupted()) {
					throw new BimserverDatabaseException("Thread interrupted");
				}
				if (eClass.getEAnnotation("nolazyload") == null && eClass.getEAnnotation("nodatabase") == null) {
					if (true) {
						getMap(eClass, ifcModel, query, todoList);
					}
				}
			}
		}
		processTodoList(ifcModel, todoList, query);
	}

	public IfcModelInterface getMapWithOid(QueryInterface query, short cid, long oid, IfcModelInterface model) throws BimserverDatabaseException {
		checkOpen();
		EClass eClass = database.getEClassForCid(cid);
		if (eClass == null) {
			return model;
		}

		TodoList todoList = new TodoList();
		ByteBuffer mustStartWith = createKeyBuffer(query.getPid(), oid);
		ByteBuffer key = createKeyBuffer(query.getPid(), oid, -query.getStopRid());
		SearchingRecordIterator recordIterator = database.getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), mustStartWith.array(),
				key.array(), this);
		checkOpen();
		try {
			Record record = recordIterator.next();
			ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
			while (record != null) {
				reads++;
				ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
				int keyPid = keyBuffer.getInt();
				long keyOid = keyBuffer.getLong();
				int keyRid = -keyBuffer.getInt();
				ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
				GetResult map = getMap(eClass, eClass, model, valueBuffer, keyPid, keyOid, keyRid, query, todoList);
				if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
					nextKeyStart.position(0);
					nextKeyStart.putInt(query.getPid());
					nextKeyStart.putLong(keyOid + 1);
					record = recordIterator.next(nextKeyStart.array());
				} else {
					record = recordIterator.next();
				}
			}
		} finally {
			recordIterator.close();
		}
		processTodoList(model, todoList, query);
		return model;
	}

	private void processTodoList(IfcModelInterface model, TodoList todoList, QueryInterface query) throws BimserverDatabaseException {
		IdEObject idEObject = todoList.poll();
		while (idEObject != null) {
			IdEObject result = get(idEObject, idEObject.getOid(), model, query, todoList);
			if (result == null) {
				throw new BimserverDatabaseException("Object not found: " + query.getPid() + " " + query.getRid() + " " + idEObject.getOid() + " " + idEObject.eClass().getName());
			}
			if (!model.contains(result.getOid())) {
				try {
					model.addAllowMultiModel(result.getOid(), result);
				} catch (IfcModelInterfaceException e) {
					throw new BimserverDatabaseException(e);
				}
			}
			idEObject = todoList.poll();
		}
	}

	public void getMapWithOids(IfcModelInterface model, Set<Long> oids, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		for (Long oid : oids) {
			EClass eClass = getEClassForOid(oid);
			if (eClass != null) {
				getMapWithOid(query, database.getCidOfEClass(eClass), oid, model);
			} else {
				throw new BimserverDatabaseException("No class found for oid " + oid);
			}
		}
	}

	public MetaDataManager getMetaDataManager() {
		return database.getMetaDataManager();
	}

	private int getObjectCount(Class<? extends IdEObject> clazz, QueryInterface query) throws BimserverDatabaseException {
		Condition condition = new IsOfTypeCondition((EClass) StorePackage.eINSTANCE.getEClassifier(clazz.getSimpleName()));
		return query(condition, clazz, query).size();
	}

	public ObjectIdentifier getOidOfGuid(String schema, String guid, int pid, int rid) throws BimserverDatabaseException {
		PackageMetaData packageMetaData = getMetaDataManager().getPackageMetaData(schema);
		for (EClass eClass : packageMetaData.getAllSubClasses(packageMetaData.getEClass("IfcRoot"))) {
			RecordIterator recordIterator = database.getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), BinUtils.intToByteArray(pid),
					BinUtils.intToByteArray(pid), this);
			try {
				Record record = recordIterator.next();
				while (record != null) {
					reads++;
					ByteBuffer buffer = ByteBuffer.wrap(record.getKey());
					int pidOfRecord = buffer.getInt();
					long oid = buffer.getLong();
					int ridOfRecord = -buffer.getInt();
					if (ridOfRecord == rid && pid == pidOfRecord) {
						ByteBuffer value = ByteBuffer.wrap(record.getValue());

						// Skip the unsettable part
						value.position(value.position() + packageMetaData.getUnsettedLength(eClass) + 16); // 16 is the UUID

						if (value.capacity() > 1) {
							int stringLength = value.getInt();
							if (stringLength == -1) {
								return null;
							} else {
								String s = BinUtils.readString(value, stringLength);
								if (s.equals(guid)) {
									return new ObjectIdentifier(oid, getCid(eClass));
								}
							}
						}
					}
					record = recordIterator.next();
				}
			} finally {
				recordIterator.close();
			}
		}
		return null;
	}

	public Set<ObjectIdentifier> getOidsOfName(String schema, String name, int pid, int rid) throws BimserverDatabaseException, MetaDataException {
		Set<ObjectIdentifier> result = new HashSet<ObjectIdentifier>();
		for (EClass eClass : getMetaDataManager().getPackageMetaData(schema).getAllSubClasses(getMetaDataManager().getPackageMetaData(schema).getEClass("IfcRoot"))) {
			RecordIterator recordIterator = database.getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), BinUtils.intToByteArray(pid),
					BinUtils.intToByteArray(pid), this);
			try {
				Record record = recordIterator.next();
				while (record != null) {
					reads++;
					ByteBuffer buffer = ByteBuffer.wrap(record.getKey());
					int pidOfRecord = buffer.getInt();
					long oid = buffer.getLong();
					int ridOfRecord = -buffer.getInt();
					if (ridOfRecord == rid && pid == pidOfRecord) {
						ByteBuffer value = ByteBuffer.wrap(record.getValue());

						// Skip the unsettable part
						byte unsettablesSize = value.get();
						value.position(value.position() + unsettablesSize);

						if (value.capacity() > 1) {
							int stringLength = value.getInt();
							if (stringLength == -1) {
								return null;
							} else {
								BinUtils.readString(value, stringLength); // GUID
								if (value.getShort() != -1) { // CID of OwnerHistory
									value.getLong(); // OID of OwnerHistory
								}
								stringLength = value.getInt();
								if (stringLength != -1) {
									String foundName = BinUtils.readString(value, stringLength);
									if (name.equals(foundName)) {
										result.add(new ObjectIdentifier(oid, getCid(eClass)));
									}
								}
							}
						}
					}
					record = recordIterator.next();
				}
			} finally {
				recordIterator.close();
			}
		}
		return result;
	}

	private int getPrimitiveSize(EDataType eDataType, Object val) {
		if (eDataType == EcorePackage.eINSTANCE.getEInt() || eDataType == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEFloat() || eDataType == EcorePackage.eINSTANCE.getEFloatObject()) {
			return 4;
		} else if (eDataType == EcorePackage.eINSTANCE.getEBoolean() || eDataType == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return 1;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDate()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEShort()) {
			return 2;
		} else if (eDataType == EcorePackage.eINSTANCE.getELong() || eDataType == EcorePackage.eINSTANCE.getELongObject()) {
			return 8;
		} else if (eDataType == EcorePackage.eINSTANCE.getEDouble() || eDataType == EcorePackage.eINSTANCE.getEDoubleObject()) {
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

	private int getWrappedValueSize(Object val, EReference eReference, PackageMetaData packageMetaData) {
		if (val == null) {
			return 2;
		}
		if (val instanceof EObject) {
			IdEObject eObject = (IdEObject) val;
			if (eReference.getEAnnotation("twodimensionalarray") != null) {
				int refSize = 4;
				EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature("List");
				List<?> l = (List<?>)eObject.eGet(eStructuralFeature);
				for (Object o : l) {
					if (o instanceof EObject) {
						refSize += getWrappedValueSize(o, (EReference) eStructuralFeature, packageMetaData);
					} else {
						refSize += getPrimitiveSize((EDataType) eStructuralFeature.getEType(), o);
					}
				}
				return refSize;
			} else if (eReference.getEAnnotation("dbembed") != null) {
				int refSize = 2;
				refSize += getExactSize(eObject, packageMetaData, false);
				return refSize;
			} else if (eObject.eClass().getEAnnotation("wrapped") != null) {
				IdEObject wrappedValue = (IdEObject) val;
				EStructuralFeature wrappedValueFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
				Object wrappedVal = eObject.eGet(wrappedValueFeature);
				int refSize = 2 + getPrimitiveSize((EDataType) wrappedValueFeature.getEType(), wrappedVal);
				if (wrappedValueFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || wrappedValueFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
					EStructuralFeature wrappedStringFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValueAsString");
					String str = (String) eObject.eGet(wrappedStringFeature);
					refSize += getPrimitiveSize(EcorePackage.eINSTANCE.getEString(), str);
				}
				return refSize;
			} else {
				return 8;
			}
		} else {
			throw new RuntimeException("Programming error, cannot happen");
		}
	}

	public boolean perRecordVersioning(IdEObject idEObject) {
		return perRecordVersioning(idEObject.eClass());
	}

	public static boolean perRecordVersioning(EClass eClass) {
		return eClass.getEPackage() != Ifc2x3tc1Package.eINSTANCE && eClass.getEPackage() != Ifc4Package.eINSTANCE && eClass.getEPackage() != GeometryPackage.eINSTANCE;
	}

	public IfcModelInterface createModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap) {
		return new BasicIfcModel(packageMetaData, pidRoidMap);
	}

	public ServerIfcModel createServerModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap) {
		ServerIfcModel serverIfcModel = new ServerIfcModel(packageMetaData, pidRoidMap, this);
		this.serverModels.add(serverIfcModel);
		return serverIfcModel;
	}

	public IfcModelInterface createModel(QueryInterface queryInterface) {
		HashMap<Integer, Long> map = new HashMap<>();
		map.put(queryInterface.getPid(), queryInterface.getRoid());
		ServerIfcModel serverIfcModel = new ServerIfcModel(queryInterface.getPackageMetaData(), map, this);
		this.serverModels.add(serverIfcModel);
		return serverIfcModel;
	}

	@SuppressWarnings("unused")
	public IdEObject lazyLoad(IdEObject idEObject) throws BimserverDatabaseException {
		if (DEVELOPER_DEBUG) {
			LOGGER.info("Lazy loading " + idEObject.eClass().getName() + " " + idEObject.getOid());
		}
		IfcModelInterface model = ((IdEObjectImpl)idEObject).getModel();
		if (model == null) {
			Map<Integer, Long> pidToRoid = new HashMap<Integer, Long>();
			model = createModel(getMetaDataManager().getPackageMetaData(idEObject.eClass().getEPackage().getName()), pidToRoid);
		}
		idEObject = get(idEObject, idEObject.getOid(), model, ((IdEObjectImpl) idEObject).getQueryInterface(), new TodoList());
		if (idEObject != null) {
			if (DEVELOPER_DEBUG && idEObject.getRid() > 100000 || idEObject.getRid() < -100000) {
				LOGGER.debug("Improbable rid " + idEObject.getRid() + " - " + idEObject);
			}
		}
		return idEObject;
	}

	@Override
	public void load(IdEObject idEObject) {
		try {
			lazyLoad(idEObject);
		} catch (BimserverLockConflictException e) {
			throw new UncheckedBimserverLockConflictException(e);
		} catch (BimserverDatabaseException e) {
			throw new UncheckedBimserverDatabaseException(e);
		}
	}

	public synchronized long newOid(EClass eClass) {
		long newOid = database.newOid(eClass);
		if (startOids == null) {
			startOids = new TreeMap<>();
		}
		String fullname = eClass.getEPackage().getName() + "." + eClass.getName();
		if (!startOids.containsKey(fullname)) {
			startOids.put(fullname, newOid - 65536);
		}
		return newOid;
	}
	
	public Map<String, Long> getStartOids() {
		return startOids;
	}

	public int newPid() {
		return database.newPid();
	}

	public <T extends IdEObject> Map<Long, T> query(Condition condition, Class<T> clazz, QueryInterface query) throws BimserverDatabaseException {
		IfcModelInterface model = createModel(query);
		return query(model, condition, clazz, query);
	}
	
	public <T extends IdEObject> Map<Long, T> query(IfcModelInterface model, Condition condition, Class<T> clazz, QueryInterface query) throws BimserverDatabaseException {
		Map<Long, T> map = new HashMap<Long, T>();
		Set<EClass> eClasses = new HashSet<EClass>();
		condition.getEClassRequirements(eClasses);
		for (EClass eClass : eClasses) {
			TodoList todoList = new TodoList();
			getMap(eClass, model, query, todoList);
			processTodoList(model, todoList, query);
			List<IdEObject> list = new ArrayList<IdEObject>(model.getValues());
			for (IdEObject object : list) {
				if (clazz.isInstance(object)) {
					if (condition.matches(object)) {
						map.put(object.getOid(), clazz.cast(object));
					}
				}
			}
		}
		return map;
	}

	public <T extends IdEObject> T querySingle(Condition condition, Class<T> clazz, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		Collection<T> values = query(condition, clazz, query).values();
		if (values.size() == 0) {
			return null;
		}
		return values.iterator().next();
	}

	public Object readPrimitiveValue(EClassifier classifier, ByteBuffer buffer, QueryInterface query) {
		if (classifier == EcorePackage.eINSTANCE.getEString()) {
			int length = buffer.getInt();
			if (length != -1) {
				return BinUtils.readString(buffer, length);
			} else {
				return null;
			}
		} else if (classifier == EcorePackage.eINSTANCE.getEInt() || classifier == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return buffer.getInt();
		} else if (classifier == EcorePackage.eINSTANCE.getEShort() || classifier == EcorePackage.eINSTANCE.getEShortObject()) {
			return buffer.getShort();
		} else if (classifier == EcorePackage.eINSTANCE.getELong() || classifier == EcorePackage.eINSTANCE.getELongObject()) {
			return buffer.getLong();
		} else if (classifier == EcorePackage.eINSTANCE.getEFloat() || classifier == EcorePackage.eINSTANCE.getEFloatObject()) {
			return buffer.getFloat();
		} else if (classifier == EcorePackage.eINSTANCE.getEDouble() || classifier == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return buffer.getDouble();
		} else if (classifier == EcorePackage.eINSTANCE.getEBoolean() || classifier == EcorePackage.eINSTANCE.getEBooleanObject()) {
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
		} else if (classifier.getName().equals("Tristate")) {
			int ordinal = buffer.getInt();
			EEnum tristateEnum = query.getPackageMetaData().getEEnum("Tristate");
			return tristateEnum.getEEnumLiteral(ordinal).getInstance();
		} else if (classifier instanceof EEnum) {
			int ordinal = buffer.getInt();
			EEnum eEnum = (EEnum) classifier;
			return eEnum.getEEnumLiteral(ordinal).getInstance();
		} else {
			throw new RuntimeException("Unsupported type " + classifier.getName());
		}
	}

	public byte[] readPrimitiveBytes(EClassifier classifier, ByteBuffer buffer, QueryInterface query) {
		if (classifier == EcorePackage.eINSTANCE.getEString()) {
			int length = buffer.getInt();
			if (length != -1) {
				byte[] result = new byte[length];
				buffer.get(result, 0, length);
				return result;
			} else {
				return null;
			}
		} else if (classifier == EcorePackage.eINSTANCE.getEInt() || classifier == EcorePackage.eINSTANCE.getEIntegerObject()) {
			byte[] result = new byte[4];
			buffer.get(result, 0, 4);
			return result;
		} else if (classifier == EcorePackage.eINSTANCE.getELong() || classifier == EcorePackage.eINSTANCE.getELongObject()) {
			byte[] result = new byte[8];
			buffer.get(result, 0, 8);
			return result;
		} else if (classifier == EcorePackage.eINSTANCE.getEFloat() || classifier == EcorePackage.eINSTANCE.getEFloatObject()) {
			byte[] result = new byte[4];
			buffer.get(result, 0, 4);
			return result;
		} else if (classifier == EcorePackage.eINSTANCE.getEDouble() || classifier == EcorePackage.eINSTANCE.getEDoubleObject()) {
			byte[] result = new byte[8];
			buffer.get(result, 0, 8);
			return result;
		} else if (classifier == EcorePackage.eINSTANCE.getEBoolean() || classifier == EcorePackage.eINSTANCE.getEBooleanObject()) {
			byte[] result = new byte[1];
			buffer.get(result, 0, 1);
			return result;
		} else if (classifier == EcorePackage.eINSTANCE.getEDate()) {
			byte[] result = new byte[8];
			buffer.get(result, 0, 8);
			return result;
		} else if (classifier == EcorePackage.eINSTANCE.getEByteArray()) {
			int size = buffer.getInt();
			byte[] result = new byte[size];
			buffer.get(result);
			return result;
		} else {
			throw new RuntimeException("Unsupported type " + classifier.getName());
		}
	}
	
	public void fakeRead(ByteBuffer buffer, EStructuralFeature feature) throws BimserverDatabaseException {
		boolean wrappedValue = feature.getEType().getEAnnotation("wrapped") != null;
		if (feature.isMany()) {
			if (feature.getEType() instanceof EEnum) {
			} else if (feature.getEType() instanceof EClass) {
				if (buffer.capacity() == 1 && buffer.get(0) == -1) {
					buffer.position(buffer.position() + 1);
				} else {
					int listSize = buffer.getInt();
					for (int i = 0; i < listSize; i++) {
						buffer.order(ByteOrder.LITTLE_ENDIAN);
						short cid = buffer.getShort();
						buffer.order(ByteOrder.BIG_ENDIAN);
						if (cid != -1) {
							if (wrappedValue) {
								EClass eClass = (EClass) feature.getEType();
								fakePrimitiveRead(eClass.getEStructuralFeature("wrappedValue").getEType(), buffer);
							} else {
								buffer.position(buffer.position() + 6);
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
					buffer.order(ByteOrder.LITTLE_ENDIAN);
					short cid = buffer.getShort();
					buffer.order(ByteOrder.BIG_ENDIAN);
					if (wrappedValue) {
						fakePrimitiveRead(feature.getEType(), buffer);
					} else {
						if (cid != -1) {
							buffer.position(buffer.position() + 6);
						}
					}
				}
			} else if (feature.getEType() instanceof EDataType) {
				fakePrimitiveRead(feature.getEType(), buffer);
			}
		}
	}

	private void fakePrimitiveRead(EClassifier classifier, ByteBuffer buffer) throws BimserverDatabaseException {
		if (classifier == EcorePackage.eINSTANCE.getEString()) {
			int length = buffer.getInt();
			if (length != -1) {
				buffer.position(buffer.position() + length);
			}
		} else if (classifier == EcorePackage.eINSTANCE.getEInt() || classifier == EcorePackage.eINSTANCE.getEIntegerObject()) {
			buffer.position(buffer.position() + 4);
		} else if (classifier == EcorePackage.eINSTANCE.getELong() || classifier == EcorePackage.eINSTANCE.getELongObject()) {
			buffer.position(buffer.position() + 8);
		} else if (classifier == EcorePackage.eINSTANCE.getEFloat() || classifier == EcorePackage.eINSTANCE.getEFloatObject()) {
			buffer.position(buffer.position() + 4);
		} else if (classifier == EcorePackage.eINSTANCE.getEDouble() || classifier == EcorePackage.eINSTANCE.getEDoubleObject()) {
			buffer.position(buffer.position() + 8);
		} else if (classifier == EcorePackage.eINSTANCE.getEBoolean() || classifier == EcorePackage.eINSTANCE.getEBooleanObject()) {
			buffer.position(buffer.position() + 1);
		} else if (classifier == EcorePackage.eINSTANCE.getEDate()) {
			buffer.position(buffer.position() + 8);
		} else if (classifier == EcorePackage.eINSTANCE.getEByteArray()) {
			int length = buffer.getInt();
			if (length != -1) {
				buffer.position(buffer.position() + length);
			}
		} else {
			throw new BimserverDatabaseException("Unimplemented " + classifier);
		}
	}

	private IdEObject readReference(EClass originalQueryClass, ByteBuffer buffer, IfcModelInterface model, IdEObject object, EStructuralFeature feature, EClass eClass,
			QueryInterface query, TodoList todoList) throws BimserverDatabaseException {
		// TODO next bit seems to make no sense, why detect a deleted record when reading a reference??
		if (buffer.capacity() == 1 && buffer.get(0) == -1) {
			buffer.position(buffer.position() + 1);
			return null;
		}
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		long oid = buffer.getLong();
		buffer.order(ByteOrder.BIG_ENDIAN);
		IdEObject foundInCache = objectCache.get(oid);
		if (foundInCache != null) {
			return foundInCache;
		}
		if (model.contains(oid)) {
			return model.get(oid);
		}
		IdEObjectImpl newObject = createInternal(eClass, query);
		newObject.setOid(oid);
		if (perRecordVersioning(newObject)) {
			newObject.setPid(Database.STORE_PROJECT_ID);
		} else {
			newObject.setPid(query.getPid());
		}
		newObject.setRid(query.getRid());
		newObject.setModel(model);
		objectCache.put(oid, newObject);
		if (query.isDeep() && object.eClass().getEAnnotation("wrapped") == null) {
			if (feature.getEAnnotation("nolazyload") == null) {
				todoList.add(newObject);
			}
		} else {
			if (object.eClass().getEAnnotation("wrapped") == null) {
				try {
					model.addAllowMultiModel(oid, newObject);
				} catch (IfcModelInterfaceException e) {
					throw new BimserverDatabaseException(e);
				}
			}
		}
		return newObject;
	}

	private IdEObject readWrappedValue(EStructuralFeature feature, ByteBuffer buffer, EClass eClass, QueryInterface query) {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("wrappedValue");
		Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer, query);
		IdEObject eObject = createInternal(eClass, query);
		((IdEObjectImpl) eObject).setLoaded(); // We don't want to go lazy load
												// this
		eObject.eSet(eStructuralFeature, primitiveValue);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
			EStructuralFeature strFeature = eClass.getEStructuralFeature("wrappedValueAsString");
			Object stringVal = readPrimitiveValue(EcorePackage.eINSTANCE.getEString(), buffer, query);
			eObject.eSet(strFeature, stringVal);
		}
		return eObject;
	}

	private IdEObject readEmbeddedValue(EStructuralFeature feature, ByteBuffer buffer, EClass eClass, QueryInterface query) throws BimserverDatabaseException {
		IdEObject eObject = createInternal(eClass, query);
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature.isMany()) {
				// Not implemented
			} else {
				if (eStructuralFeature.getEType() instanceof EDataType) {
					Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer, query);
					((IdEObjectImpl) eObject).setLoaded();
					eObject.eSet(eStructuralFeature, primitiveValue);
				} else {
					buffer.order(ByteOrder.LITTLE_ENDIAN);
					short cid = buffer.getShort();
					buffer.order(ByteOrder.BIG_ENDIAN);
					if (cid == -1) {
						// null, do nothing
					} else if (cid < 0) {
						// non minus one and negative cid means value is embedded in record
						EClass referenceClass = database.getEClassForCid((short) (-cid));
						eObject.eSet(eStructuralFeature, readEmbeddedValue(eStructuralFeature, buffer, referenceClass, query));
					}
				}
			}
		}
		return eObject;
	}

	public void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimserverDatabaseException {
		checkOpen();
		for (IdEObject object : values) {
			store(object, pid, rid);
		}
	}

	public void store(IdEObject object, boolean deep) throws BimserverDatabaseException {
		checkOpen();
		Set<IdEObject> done = new HashSet<IdEObject>();
		storeDeep(object, done);
	}

	private void storeDeep(IdEObject object, Set<IdEObject> done) throws BimserverDatabaseException {
		if (object == null || done.contains(object)) {
			return;
		}
		done.add(object);
		store(object);
		for (EReference eReference : object.eClass().getEAllReferences()) {
			if (eReference.isMany()) {
				List<?> list = (List<?>) object.eGet(eReference);
				for (Object v : list) {
					storeDeep((IdEObject) v, done);
				}
			} else {
				IdEObject reference = (IdEObject) object.eGet(eReference);
				storeDeep(reference, done);
			}
		}
	}

	public long store(IdEObject object) throws BimserverDatabaseException {
		checkOpen();
		return store(object, Database.STORE_PROJECT_ID, Integer.MAX_VALUE);
	}

	public long store(IdEObject object, int pid, int rid) throws BimserverDatabaseException {
		checkOpen();
		if ((objectsToCommit == null || !objectsToCommit.containsObject(object)) && (objectsToDelete == null || !objectsToDelete.contains(object))) {
			objectCache.put(object.getOid(), object);
			boolean wrappedValue = object.eClass().getEAnnotation("wrapped") != null;
			if (!wrappedValue) {
				if (object.getOid() == -1) {
					long newOid = newOid(object.eClass());
					((IdEObjectImpl) object).setOid(newOid);
				}
				object.load();
				((IdEObjectImpl) object).setPid(pid);
				if (rid == Integer.MAX_VALUE) {
					((IdEObjectImpl) object).setRid(object.getRid() + 1);
				} else {
					((IdEObjectImpl) object).setRid(rid);
				}
				addToObjectsToCommit(object);
			}
		}
		return object.getOid();
	}
	
	public void removeFromCommit(IdEObject idEObject) {
		if (objectsToCommit == null) {
			objectsToCommit = new ObjectsToCommit();
		}
		objectsToCommit.remove(idEObject);
	}

	private void writePrimitiveValue(EStructuralFeature feature, Object value, ByteBuffer buffer) throws BimserverDatabaseException {
		EClassifier type = feature.getEType();
		if (type == EcorePackage.eINSTANCE.getEString()) {
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
		} else if (type == EcorePackage.eINSTANCE.getEInt() || type == EcorePackage.eINSTANCE.getEIntegerObject()) {
			if (value == null) {
				buffer.putInt(0);
			} else {
				buffer.putInt((Integer) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getEDouble() || type == EcorePackage.eINSTANCE.getEDoubleObject()) {
			if (value == null) {
				buffer.putDouble(0D);
			} else {
				buffer.putDouble((Double) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getEFloat() || type == EcorePackage.eINSTANCE.getEFloatObject()) {
			if (value == null) {
				buffer.putFloat(0F);
			} else {
				buffer.putFloat((Float) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getELong() || type == EcorePackage.eINSTANCE.getELongObject()) {
			if (value == null) {
				buffer.putLong(0L);
			} else {
				buffer.putLong((Long) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getEShort() || type == EcorePackage.eINSTANCE.getEShortObject()) {
			if (value == null) {
				buffer.putShort((short)0);
			} else {
				buffer.putShort((short) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getEBoolean() || type == EcorePackage.eINSTANCE.getEBooleanObject()) {
			if (value == null) {
				buffer.put((byte) 0);
			} else {
				buffer.put(((Boolean) value) ? (byte) 1 : (byte) 0);
			}
		} else if (type == EcorePackage.eINSTANCE.getEDate()) {
			if (value == null) {
				buffer.putLong(-1L);
			} else {
				buffer.putLong(((Date) value).getTime());
			}
		} else if (type.getName().equals("Tristate")) {
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

	private void writeReference(IdEObject object, Object value, ByteBuffer buffer, EStructuralFeature feature) throws BimserverDatabaseException {
		IdEObject idEObject = (IdEObject) value;
		if (idEObject.getOid() < 0) {
			throw new BimserverDatabaseException("Writing a reference with oid " + idEObject.getOid() + ", this is not supposed to happen, referenced: " + idEObject.getOid() + " " + value + " from " + object.getOid() + " " + object);
		}
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putLong(idEObject.getOid());
		buffer.order(ByteOrder.BIG_ENDIAN);
	}

	private void writeEmbeddedValue(int pid, int rid, Object value, ByteBuffer buffer, PackageMetaData packageMetaData) throws BimserverDatabaseException {
		IdEObject wrappedValue = (IdEObject) value;
		Short cid = database.getCidOfEClass(wrappedValue.eClass());
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) -cid);
		buffer.order(ByteOrder.BIG_ENDIAN);
		
		for (EStructuralFeature eStructuralFeature : wrappedValue.eClass().getEAllStructuralFeatures()) {
			if (eStructuralFeature.isMany()) {
				writeList(wrappedValue, buffer, packageMetaData, eStructuralFeature);
			} else {
				Object val = wrappedValue.eGet(eStructuralFeature);
				if (eStructuralFeature.getEType() instanceof EClass) {
					writeEmbeddedValue(pid, rid, val, buffer, packageMetaData);
				} else {
					writePrimitiveValue(eStructuralFeature, val, buffer);
				}
			}
		}
	}
	
	private void writeWrappedValue(int pid, int rid, Object value, ByteBuffer buffer, PackageMetaData packageMetaData) throws BimserverDatabaseException {
		IdEObject wrappedValue = (IdEObject) value;
		EStructuralFeature eStructuralFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
		Short cid = database.getCidOfEClass(wrappedValue.eClass());
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) -cid);
		buffer.order(ByteOrder.BIG_ENDIAN);
		writePrimitiveValue(eStructuralFeature, wrappedValue.eGet(eStructuralFeature), buffer);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
			EStructuralFeature fe = wrappedValue.eClass().getEStructuralFeature("wrappedValueAsString");
			writePrimitiveValue(fe, wrappedValue.eGet(fe), buffer);
		}
		if (wrappedValue.eClass().getName().equals("IfcGloballyUniqueId")) {
			EClass eClass = packageMetaData.getEClass("IfcGloballyUniqueId");
			if (wrappedValue.getOid() == -1) {
				((IdEObjectImpl) wrappedValue).setOid(newOid(eClass));
			}
			ByteBuffer valueBuffer = convertObjectToByteArray(wrappedValue, ByteBuffer.allocate(getExactSize(wrappedValue, packageMetaData, true)), packageMetaData);
			ByteBuffer keyBuffer = createKeyBuffer(pid, wrappedValue.getOid(), rid);
			try {
				database.getKeyValueStore().storeNoOverwrite(eClass.getEPackage().getName() + "_" + eClass.getName(),
						keyBuffer.array(), valueBuffer.array(), this);
				database.incrementCommittedWrites(1);
				if (bimTransaction != null) {
					bimTransaction.incUpdates(1);
				}
			} catch (BimserverLockConflictException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	public Set<String> getAvailableClassesInRevision(QueryInterface query) throws BimserverDatabaseException {
		IfcModelInterface model = createModel(query);
		return getAvailableClassesInRevision(model, query);
	}

	public Set<String> getAvailableClassesInRevision(IfcModelInterface ifcModel, QueryInterface query) throws BimserverDatabaseException {
		checkOpen();
		try {
			getMap(ifcModel, query);
			Set<String> classes = new HashSet<>();
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

	@SuppressWarnings("unchecked")
	public <T> T create(EClass eClass, int pid, int rid) throws BimserverDatabaseException {
		checkOpen();
		IdEObject idEObject = createInternal(eClass, null);
		EStructuralFeature uuidFeature = eClass.getEStructuralFeature("uuid");
		if (uuidFeature != null) {
			if (idEObject.eGet(uuidFeature) == null) {
				idEObject.eSet(uuidFeature, UUID.randomUUID().toString());
			}
		}
		store(idEObject, pid, rid);
		return (T) idEObject;
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T getSingle(EClass eClass, QueryInterface query) throws BimserverDatabaseException {
		IfcModelInterface model = createModel(query);
		List<T> all = getAllOfType(model, eClass, query).getAll((Class<T>) eClass.getInstanceClass());
		if (all.size() > 0) {
			return all.get(0);
		}
		return null;
	}

	/**
	 * Only call this method when you are sure no other processes are
	 * altering/using the same data. Basically only when the server is starting
	 * 
	 * @throws BimserverDatabaseException
	 * @throws ServiceException
	 */
	public void commit() throws BimserverDatabaseException, ServiceException {
		commit(null);
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T create(Class<T> clazz) throws BimserverDatabaseException {
		return (T) create(database.getEClass(clazz.getPackage().getName(), clazz.getSimpleName()));
	}

	public EObject create(EClass eClass) {
		// checkOpen();
		IdEObjectImpl idEObject = createInternal(eClass, null);
		idEObject.setUuid(UUID.randomUUID());
		try {
			store(idEObject, Database.STORE_PROJECT_ID, Integer.MAX_VALUE);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		return idEObject;
	}

	public <T extends IdEObject> List<T> getAllOfType(EClass eClass, Class<T> clazz, QueryInterface query) throws BimserverDatabaseException {
		IfcModelInterface allOfType = getAllOfType(eClass.getEPackage().getName(), eClass.getName(), query);
		return allOfType.getAllWithSubTypes(clazz);
	}

	public EClass getEClassForOid(long oid) throws BimserverDatabaseException {
		return database.getEClassForOid(oid);
	}

	public long getCounter(EClass eClass) {
		return database.getCounter(eClass);
	}

	public <T extends IdEObject> T querySingle(EAttribute attribute, Object value) throws BimserverLockConflictException, BimserverDatabaseException {
		return querySingle(attribute, value, OldQuery.getDefault().getPid(), OldQuery.getDefault().getRid());
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IdEObject> T querySingle(EAttribute attribute, Object value, int pid, int rid) throws BimserverLockConflictException, BimserverDatabaseException {
		if (attribute.getEAnnotation("singleindex") != null) {
			String indexTableName = attribute.getEContainingClass().getEPackage().getName() + "_" + attribute.getEContainingClass().getName() + "_" + attribute.getName();
			byte[] queryBytes = null;
			if (value instanceof String) {
				queryBytes = ((String)value).getBytes(Charsets.UTF_8);
			} else if (value instanceof Integer) {
				queryBytes = BinUtils.intToByteArray((Integer)value);
			} else {
				throw new BimserverDatabaseException("Unsupported type " + value);
			}
			boolean perRecordVersioning = perRecordVersioning(attribute.getEContainingClass());
			if (!perRecordVersioning) {
				ByteBuffer valueBuffer = ByteBuffer.allocate(queryBytes.length + 8);
				valueBuffer.putInt(pid);
				valueBuffer.putInt(-rid);
				valueBuffer.put(queryBytes);
				queryBytes = valueBuffer.array();
			}
			byte[] firstDuplicate = database.getKeyValueStore().get(indexTableName, queryBytes, this);
			if (firstDuplicate != null) {
				ByteBuffer buffer = ByteBuffer.wrap(firstDuplicate);
				buffer.getInt(); // pid
				long oid = buffer.getLong();
				return (T) get(oid, OldQuery.getDefault());
			}
		} else {
			throw new UnsupportedOperationException(attribute.getContainerClass().getName() + "." + attribute.getName() + " does not have a \"singleindex\"");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IdEObject> List<T> query(EAttribute attribute, Object value) throws BimserverLockConflictException, BimserverDatabaseException {
		List<T> result = new ArrayList<>();
		if (attribute.getEAnnotation("singleindex") != null) {
			String indexTableName = attribute.getEContainingClass().getEPackage().getName() + "_" + attribute.getEContainingClass().getName() + "_" + attribute.getName();
			byte[] queryBytes = null;
			if (value instanceof String) {
				queryBytes = ((String)value).getBytes(Charsets.UTF_8);
			} else if (value instanceof Integer) {
				queryBytes = BinUtils.intToByteArray((Integer)value);
			} else {
				throw new BimserverDatabaseException("Unsupported type " + value);
			}
			List<byte[]> duplicates = database.getKeyValueStore().getDuplicates(indexTableName, queryBytes, this);
			for (byte[] indexValue : duplicates) {
				ByteBuffer buffer = ByteBuffer.wrap(indexValue);
				buffer.getInt(); // pid
				long oid = buffer.getLong();
				result.add((T) get(oid, OldQuery.getDefault()));
			}
		}
		return result;
	}
	
	public byte[] extractFeatureBytes(DatabaseSession databaseSession, ByteBuffer buffer, EClass eClass, EStructuralFeature eStructuralFeature) throws BimserverDatabaseException {
		try {
			PackageMetaData packageMetaData = getMetaDataManager().getPackageMetaData(eClass.getEPackage().getName());
			buffer.position(0);
			
			int fieldCounter = 0;
			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
				if (packageMetaData.useForDatabaseStorage(eClass, feature)) {
					fieldCounter++;
				}
			}
			
			int unsettedLength = (int) Math.ceil(fieldCounter / 8.0);
			byte[] unsetted = new byte[unsettedLength];
			buffer.get(unsetted);
			fieldCounter = 0;
			
			buffer.position(buffer.position() + 16); // UUID
			
			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
				boolean isUnsetted = (unsetted[fieldCounter / 8] & (1 << (fieldCounter % 8))) != 0;
				if (isUnsetted) {
				} else {
					if (eStructuralFeature == feature) {
						if (feature instanceof EReference) {
							return BinUtils.longToByteArrayLittleEndian(buffer.getLong());
						} else {
							return databaseSession.readPrimitiveBytes(feature.getEType(), buffer, OldQuery.getDefault());
						}
					} else {
						databaseSession.fakeRead(buffer, feature);
					}
				}
				fieldCounter++;
			}
			return null;
		} catch (BufferUnderflowException e) {
			throw e;
		}
	}
	
	public SessionState getState() {
		return state;
	}

	@Override
	public int save(VirtualObject object) throws BimserverLockConflictException, BimserverConcurrentModificationDatabaseException, BimserverDatabaseException {
		return save(object, object.getRid());
	}
	
	public int save(VirtualObject object, int newRid) throws BimserverLockConflictException, BimserverConcurrentModificationDatabaseException, BimserverDatabaseException {
		ByteBuffer valueBuffer = object.write();
		EClass eClass = object.eClass();
		ByteBuffer keyBuffer = createKeyBuffer(object.getPid(), object.getOid(), newRid);
		database.getKeyValueStore().storeNoOverwrite(eClass.getEPackage().getName() + "_" + eClass.getName(), keyBuffer.array(), valueBuffer.array(), 0, valueBuffer.position(), this);
		
		processPossibleIndices(keyBuffer, object.getPid(), object.getRid(), object.getOid(), object.eClass(), valueBuffer);
		
		if (bimTransaction != null) {
			bimTransaction.incUpdates(1);
		}
		database.incrementCommittedWrites(1);
		return valueBuffer.position();
	}
	
	@Override
	public int saveOverwrite(VirtualObject object) throws BimserverLockConflictException, BimserverConcurrentModificationDatabaseException, BimserverDatabaseException {
		ByteBuffer valueBuffer = object.write();
		EClass eClass = object.eClass();
		ByteBuffer keyBuffer = createKeyBuffer(object.getPid(), object.getOid(), object.getRid());
		database.getKeyValueStore().store(eClass.getEPackage().getName() + "_" + eClass.getName(), keyBuffer.array(), valueBuffer.array(), 0, valueBuffer.position(), this);

		processPossibleIndices(keyBuffer, object.getPid(), object.getRid(), object.getOid(), object.eClass(), valueBuffer);

		database.incrementCommittedWrites(1);
		if (bimTransaction != null) {
			bimTransaction.incUpdates(1);
		}
		
		return valueBuffer.position();
	}

	public KeyValueStore getKeyValueStore() {
		return database.getKeyValueStore();
	}

	@Override
	public byte[] get(String tableName, byte[] key) throws BimserverLockConflictException, BimserverDatabaseException {
		return database.getKeyValueStore().get(tableName, key, this);
	}

	@Override
	public List<byte[]> getDuplicates(String tableName, byte[] key) throws BimserverLockConflictException, BimserverDatabaseException {
		return database.getKeyValueStore().getDuplicates(tableName, key, this);
	}

	public void clearPostCommitActions() {
		postCommitActions = null;
	}

	private void makeSureCacheExists() {
		if (voCache == null) {
			synchronized (this) {
				if (voCache == null) {
					voCache = new ConcurrentHashMap<>();
				}
			}
		}
	}
	
	public void cache(HashMapVirtualObject object) {
		makeSureCacheExists();
		voCache.put(object.getOid(), object);
	}
	
	public HashMapVirtualObject getFromCache(long oid) {
		makeSureCacheExists();
		return voCache.get(oid);
	}

	public <T extends IdEObject> List<T> getAll(Class<T> class1) throws BimserverDatabaseException {
		EClass eClass = getEClass(class1.getPackage().getName(), class1.getSimpleName());
		IfcModelInterface allOfType = getAllOfType(eClass, OldQuery.getDefault());
		return allOfType.getAll(class1);
	}

	public void delete(HashMapVirtualObject object, int newRid) throws BimserverLockConflictException, BimserverConcurrentModificationDatabaseException, BimserverDatabaseException {
		ByteBuffer keyBuffer = ByteBuffer.allocate(16);
		fillKeyBuffer(keyBuffer, object.getPid(), object.getOid(), newRid);
		EClass eClass = object.eClass();
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		database.getKeyValueStore().storeNoOverwrite(tableName, keyBuffer.array(), new byte[] { -1 }, this);
		if (bimTransaction != null) {
			bimTransaction.incUpdates(1);
		}
		database.incrementCommittedWrites(1);
	}

	public void addStartOid(EClass eClass, long oid) {
		String fullname = eClass.getEPackage().getName() + "." + eClass.getName();
		Long currentStart = startOids.get(fullname);
		if (currentStart == null) {
			 startOids.put(fullname, oid - 65536);
		} else if (oid < currentStart) {
			startOids.put(fullname, oid);
		}
	}
	
	public void setCleanupListener(CleanupListener cleanupListener) {
		this.cleanupListener = cleanupListener;
	}

	@Override
	public UUID newUuid() {
		return UUID.randomUUID();
	}
}