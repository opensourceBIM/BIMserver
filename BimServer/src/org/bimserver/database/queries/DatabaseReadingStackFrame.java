package org.bimserver.database.queries;

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
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.om.CanInclude;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Include.TypeDef;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.database.queries.om.Reference;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.WrappedVirtualObject;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EEnumImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DatabaseReadingStackFrame extends StackFrame implements ObjectProvidingStackFrame {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseReadingStackFrame.class);
	private final QueryContext reusable;
	private final QueryObjectProvider queryObjectProvider;
	protected HashMapVirtualObject currentObject;
	private final QueryPart queryPart;

	public DatabaseReadingStackFrame(QueryContext reusable, QueryObjectProvider queryObjectProvider, QueryPart queryPart) {
		this.reusable = reusable;
		this.queryObjectProvider = queryObjectProvider;
		this.queryPart = queryPart;
	}
	
	public QueryContext getReusable() {
		return reusable;
	}
	
	@Override
	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
	
	public QueryObjectProvider getQueryObjectProvider() {
		return queryObjectProvider;
	}
	
	public PackageMetaData getPackageMetaData() {
		return reusable.getPackageMetaData();
	}
	
	public QueryPart getQueryPart() {
		return queryPart;
	}
	
	protected void processPossibleIncludes(HashMapVirtualObject object, EClass previousType, CanInclude canInclude) throws QueryException, BimserverDatabaseException {
		if (object != null && canInclude != null) {
			if (canInclude.hasReferences()) {
				for (Reference reference : canInclude.getReferences()) {
					processPossibleInclude(object, canInclude, reference.getInclude());
				}
			}
			if (canInclude.hasIncludes()) {
				for (Include include : canInclude.getIncludes()) {
					processPossibleInclude(object, canInclude, include);
				}
			}
			if (canInclude.isIncludeAllFields()) {
				for (EReference eReference : object.eClass().getEAllReferences()) {
					Include include = new Include(reusable.getPackageMetaData());
					include.addType(object.eClass(), false);
					include.addField(eReference.getName());
					if (canInclude.hasIncludes()) {
						for (Include include2 : canInclude.getIncludes()) {
							include.addInclude(include2);
						}
					}
					processPossibleInclude(object, canInclude, include);
				}
			}
			if (canInclude instanceof Include) {
				processPossibleInclude(object, null, (Include) canInclude);
			}
		}
	}

	protected void processPossibleInclude(HashMapVirtualObject object, CanInclude previousInclude, Include include) throws QueryException, BimserverDatabaseException {
		if (include.hasTypes()) {
			for (TypeDef filterClass : include.getTypes()) {
				// TODO also exclude the possibly excluded types here
				if (!filterClass.geteClass().isSuperTypeOf(object.eClass())) {
//					System.out.println(filterClass.getName() + " / " + currentObject.eClass().getName());
					// TODO too many times queries are spending time here
					return;
				}
			}
		}
		if (include.hasDirectFields()) {
			for (EReference eReference : include.getFieldsDirect()) {
				Object ref = object.get(eReference.getName());
				if (ref != null) {
					if (ref instanceof List) {
						for (Long r : (List<Long>)ref) {
							HashMapVirtualObject byOid = getByOid(r, true);
							int index = object.addDirectListReference(eReference, byOid);
							object.addUseForSerialization(eReference, index);
							processPossibleIncludes(byOid, byOid.eClass(), include);
						}
					} else {
						if (ref instanceof Long) {
							HashMapVirtualObject byOid = getByOid((Long)ref, true);
							if (byOid == null) {
								throw new BimserverDatabaseException("Object with oid " + ref + " not found (" + queryObjectProvider.getDatabaseSession().getEClassForOid((Long)ref).getName() + ")");
							}
							object.setDirectReference(eReference, byOid);
							object.addUseForSerialization(eReference);
							processPossibleIncludes(byOid, byOid.eClass(), include);
						} else {
							object.setDirectReference(eReference, (HashMapWrappedVirtualObject)ref);
						}
					}
				}
			}
		}
		if (include.hasFields() && !include.isExclude()) {
			for (EStructuralFeature eStructuralFeature : include.getFields()) {
				object.addUseForSerialization(eStructuralFeature);
			}
		}

		getQueryObjectProvider().push(new QueryIncludeStackFrame(getQueryObjectProvider(), getReusable(), previousInclude, include, object, queryPart));
	}
	
	public GetResult getMap(EClass originalQueryClass, EClass eClass, ByteBuffer buffer, int keyPid, long keyOid, int keyRid) throws BimserverDatabaseException {
		if (keyPid == getReusable().getPid()) {
			if (keyRid <= getReusable().getRid() && keyRid >= getReusable().getStopRid()) {
				if (!getQueryObjectProvider().hasRead(keyOid)) {
					if (buffer.capacity() == 1 && buffer.get(0) == -1) {
						buffer.position(buffer.position() + 1);
						return GetResult.CONTINUE_WITH_NEXT_OID;
						// deleted entity
					} else {
						 currentObject = convertByteArrayToObject(eClass, keyOid, buffer, keyRid);
					}
				}
				return GetResult.CONTINUE_WITH_NEXT_OID;
			} else {
				return GetResult.CONTINUE_WITH_NEXT_RECORD;
			}
		} else {
			return GetResult.STOP;
		}
	}
	
	protected HashMapVirtualObject convertByteArrayToObject(EClass eClass, long oid, ByteBuffer buffer, int rid) throws BimserverDatabaseException {
		try {
			int unsettedLength = getPackageMetaData().getUnsettedLength(eClass);
			
			byte[] unsetted = new byte[unsettedLength];
			buffer.get(unsetted);
			
			int fieldCounter = 0;
			
			HashMapVirtualObject idEObject = new HashMapVirtualObject(reusable, eClass, oid, new UUID(buffer.getLong(), buffer.getLong()));
			
			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
				try {
					if (getPackageMetaData().useForDatabaseStorage(eClass, feature)) {
						boolean isUnsetted = (unsetted[fieldCounter / 8] & (1 << (fieldCounter % 8))) != 0;
						if (isUnsetted) {
							if (feature.isUnsettable()) {
								idEObject.eUnset(feature);
							} else if (feature.isMany()) {
								// do nothing
							} else if (feature.getDefaultValue() != null) {
								idEObject.setAttribute((EAttribute) feature, feature.getDefaultValue());
							}
						} else {
							Object newValue = null;
							if (feature.isMany()) {
								newValue = readList(idEObject, buffer, feature);
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
										// negative cid means value is embedded in
										// record
										EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass((short) (-cid));
										if (feature.getEAnnotation("dbembed") != null) {
											newValue = readEmbeddedValue(feature, buffer, referenceClass);
										} else {
											newValue = readWrappedValue(feature, buffer, referenceClass);
										}
									} else if (cid > 0) {
										// positive cid means value is reference to
										// other record
										EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass(cid);
										if (referenceClass == null) {
											throw new BimserverDatabaseException("No eClass found for cid " + cid);
										}
										buffer.position(buffer.position() - 2);
										newValue = readReference(buffer, feature, referenceClass);
										if ((Long)newValue != -1) {
											if (queryObjectProvider.hasReadOrIsGoingToRead(((Long)newValue)) || queryObjectProvider.hasReadOrIsGoingToRead(referenceClass)) {
												idEObject.addUseForSerialization(feature);
											}
										}
										// if (eReference.getEOpposite() != null &&
										// ((IdEObjectImpl)
										// newValue).isLoadedOrLoading()) {
										// newValue = null;
										// }
									}
								} else if (feature.getEType() instanceof EDataType) {
									newValue = readPrimitiveValue(feature.getEType(), buffer);
								}
								if (newValue != null) {
									if (feature instanceof EAttribute) {
										idEObject.setAttribute((EAttribute) feature, newValue);
									} else {
										if (newValue instanceof Long) {
											idEObject.setReference((EReference) feature, (Long)newValue);
										} else {
											idEObject.setReference((EReference) feature, (WrappedVirtualObject)newValue);
										}
									}
								}
							}
						}
						fieldCounter++;
					}
				} catch (StringIndexOutOfBoundsException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "." + feature.getName(), e);
				} catch (BufferUnderflowException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "." + feature.getName() + " " + buffer.capacity(), e);
				} catch (BufferOverflowException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "." + feature.getName(), e);
				}
			}
			return idEObject;
		} catch (BufferUnderflowException e) {
			throw new BimserverDatabaseException("Reading " + eClass.getName(), e);
		} catch (BufferOverflowException e) {
			throw new BimserverDatabaseException("Reading " + eClass.getName(), e);
		}
	}
	
	private long readReference(ByteBuffer buffer, EStructuralFeature feature, EClass eClass) throws BimserverDatabaseException {
		if (buffer.capacity() == 1 && buffer.get(0) == -1) {
			buffer.position(buffer.position() + 1);
			return -1;
		}
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		long oid = buffer.getLong();
		buffer.order(ByteOrder.BIG_ENDIAN);
		return oid;
	}

	private HashMapWrappedVirtualObject readWrappedValue(EStructuralFeature feature, ByteBuffer buffer, EClass eClass) throws BimserverDatabaseException {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("wrappedValue");
		Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer);
		HashMapWrappedVirtualObject eObject = new HashMapWrappedVirtualObject(eClass);
		eObject.setAttribute((EAttribute) eStructuralFeature, primitiveValue);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
			EStructuralFeature strFeature = eClass.getEStructuralFeature("wrappedValueAsString");
			Object stringVal = readPrimitiveValue(EcorePackage.eINSTANCE.getEString(), buffer);
			eObject.setAttribute((EAttribute) strFeature, stringVal);
		}
		return eObject;
	}

	private HashMapWrappedVirtualObject readEmbeddedValue(EStructuralFeature feature, ByteBuffer buffer, EClass eClass) throws BimserverDatabaseException {
		HashMapWrappedVirtualObject eObject = new HashMapWrappedVirtualObject(eClass);
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature.isMany()) {
			} else {
				if (eStructuralFeature.getEType() instanceof EDataType) {
					Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer);
					eObject.setAttribute((EAttribute) eStructuralFeature, primitiveValue);
				} else {
					buffer.order(ByteOrder.LITTLE_ENDIAN);
					short cid = buffer.getShort();
					buffer.order(ByteOrder.BIG_ENDIAN);
					if (cid == -1) {
						// null, do nothing
					} else if (cid < 0) {
						// negative cid means value is embedded in
						// record
						EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass((short) (-cid));
						eObject.setReference((EReference) eStructuralFeature, readEmbeddedValue(eStructuralFeature, buffer, referenceClass));
					}
				}
			}
		}
		return eObject;
	}
	
	public Object readPrimitiveValue(EClassifier classifier, ByteBuffer buffer) {
		if (classifier == EcorePackage.eINSTANCE.getEString()) {
			int length = buffer.getInt();
			if (length != -1) {
				return BinUtils.readString(buffer, length);
			} else {
				return null;
			}
		} else if (classifier == EcorePackage.eINSTANCE.getEInt() || classifier == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return buffer.getInt();
		} else if (classifier == EcorePackage.eINSTANCE.getELong() || classifier == EcorePackage.eINSTANCE.getELongObject()) {
			return buffer.getLong();
		} else if (classifier == EcorePackage.eINSTANCE.getEFloat() || classifier == EcorePackage.eINSTANCE.getEFloatObject()) {
			return buffer.getFloat();
		} else if (classifier == EcorePackage.eINSTANCE.getEDouble() || classifier == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return buffer.getDouble();
		} else if (classifier == EcorePackage.eINSTANCE.getEShort() || classifier == EcorePackage.eINSTANCE.getEShortObject()) {
			return buffer.getShort();
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
			EEnum tristateEnum = getPackageMetaData().getEEnum("Tristate");
			return tristateEnum.getEEnumLiteral(ordinal).getInstance();
		} else if (classifier instanceof EEnum) {
			int ordinal = buffer.getInt();
			EEnum eEnum = (EEnum) classifier;
			return eEnum.getEEnumLiteral(ordinal).getInstance();
		} else {
			throw new RuntimeException("Unsupported type " + classifier.getName());
		}
	}
	
	private Object readList(HashMapVirtualObject idEObject, ByteBuffer buffer, EStructuralFeature feature) throws BimserverDatabaseException {
		if (feature.getEType() instanceof EEnum) {
		} else if (feature.getEType() instanceof EClass) {
			if (buffer.capacity() == 1 && buffer.get(0) == -1) {
				buffer.position(buffer.position() + 1);
			} else {
				int listSize = buffer.getInt();

//				// DEBUG
//				int limit = 2000;
//				if (listSize > limit) {
//					LOGGER.warn("List of size " + listSize + " > " + limit + ", probably an error");
//				}

				for (int i = 0; i < listSize; i++) {
					if (feature.getEAnnotation("twodimensionalarray") != null) {
						HashMapVirtualObject newObject = new HashMapVirtualObject(reusable, (EClass) feature.getEType());
						EClass eClass = (EClass)feature.getEType();
						EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("List");
						
						buffer.order(ByteOrder.LITTLE_ENDIAN);
						short cid = buffer.getShort();
						buffer.order(ByteOrder.BIG_ENDIAN);
						EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass((short) (-cid));
						if (referenceClass == null) {
							throw new BimserverDatabaseException("No class found for cid " + (-cid));
						}
						
						Object result = readList(newObject, buffer, eStructuralFeature);
						if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
							result = readList(newObject, buffer, eClass.getEStructuralFeature("ListAsString"));
						}
						idEObject.setListItem(feature, i, newObject);
					} else {
						buffer.order(ByteOrder.LITTLE_ENDIAN);
						short cid = buffer.getShort();
						buffer.order(ByteOrder.BIG_ENDIAN);
						if (cid == -1) {
							// null, do nothing
						} else if (cid < 0) {
							// negative cid means value is
							// embedded
							// in record
							EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass((short) (-cid));
							if (referenceClass == null) {
								throw new BimserverDatabaseException("No class found for cid " + (-cid));
							}
							EStructuralFeature wv = referenceClass.getEStructuralFeature("wrappedValue");
							if (wv != null && wv.isMany()) {
								HashMapVirtualObject eObject = new HashMapVirtualObject(reusable, referenceClass);
								readList(eObject, buffer, wv);
								idEObject.setListItem(feature, i, eObject);
							} else {
								idEObject.setListItem(feature, i, readWrappedValue(feature, buffer, referenceClass));
							}
							idEObject.addUseForSerialization(feature, i);
						} else if (cid > 0) {
							// positive cid means value is a
							// reference
							// to another record
							EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass(cid);
							if (referenceClass == null) {
								throw new BimserverDatabaseException("Cannot find class with cid " + cid);
							}
							buffer.position(buffer.position() - 2);
							long rf = readReference(buffer, feature, referenceClass);
							idEObject.setListItemReference(feature, i, referenceClass, rf, -1);
							if (rf != -1) {
								if (queryObjectProvider.hasReadOrIsGoingToRead((rf)) || queryObjectProvider.hasReadOrIsGoingToRead(referenceClass)) {
									idEObject.addUseForSerialization(feature, i);
								}
							}
//						} else if (cid == 0) {
//							throw new BimserverDatabaseException("Cid cannot be 0");
						}
					}
				}
			}
		} else if (feature.getEType() instanceof EDataType) {
			int listSize = buffer.getInt();
			if (listSize < 0) {
				throw new BimserverDatabaseException("Negative array size for " + feature.getEContainingClass().getName() + "." + feature.getName());
			}
			for (int i = 0; i < listSize; i++) {
				Object reference = readPrimitiveValue(feature.getEType(), buffer);
				if (reference != null) {
					idEObject.setListItem(feature, i, reference);
				}
			}
		}
		return null;
	}
	
	public HashMapVirtualObject getByOid(long oid) throws BimserverDatabaseException {
		return getByOid(oid, false);
	}
	
	public HashMapVirtualObject getByOid(long oid, boolean useCache) throws BimserverDatabaseException {
		HashMapVirtualObject byOid = getQueryObjectProvider().getFromCache((long)oid);
		if (byOid != null) {
			return byOid;
		}
		EClass eClass = getQueryObjectProvider().getDatabaseSession().getEClassForOid(oid);
		ByteBuffer mustStartWith = ByteBuffer.wrap(new byte[12]);
		mustStartWith.putInt(reusable.getPid());
		mustStartWith.putLong(oid);
		ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[16]);
		startSearchWith.putInt(reusable.getPid());
		startSearchWith.putLong(oid);
		startSearchWith.putInt(-reusable.getRid());
	
		SearchingRecordIterator recordIterator = getQueryObjectProvider().getDatabaseSession().getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), mustStartWith.array(),
				startSearchWith.array(), getQueryObjectProvider().getDatabaseSession());
		try {
			Record record = recordIterator.next();
			if (record == null) {
				return null;
			}
			getQueryObjectProvider().incReads();
			ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
			ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
			keyBuffer.getInt(); // pid
			long keyOid = keyBuffer.getLong();
			int keyRid = -keyBuffer.getInt();
			if (keyRid <= reusable.getRid()) {
				if (valueBuffer.capacity() == 1 && valueBuffer.get(0) == -1) {
					valueBuffer.position(valueBuffer.position() + 1);
					return null;
					// deleted entity
				} else {
					byOid = convertByteArrayToObject(eClass, keyOid, valueBuffer, keyRid);
					if (byOid != null && useCache) {
						getQueryObjectProvider().cache(byOid);
					}
					return byOid;
				}
			} else {
				return null;
			}
		} finally {
			recordIterator.close();
		}
	}
}