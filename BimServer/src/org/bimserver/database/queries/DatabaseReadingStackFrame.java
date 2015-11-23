package org.bimserver.database.queries;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Date;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.Reusable;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EEnumImpl;

public abstract class DatabaseReadingStackFrame extends StackFrame implements ObjectProvidingStackFrame {
	private PackageMetaData packageMetaData;
	private Reusable reusable;
	private QueryObjectProvider queryObjectProvider;
	private QueryInterface query;
	protected HashMapVirtualObject currentObject;
	private QueryPart queryPart;

	public DatabaseReadingStackFrame(PackageMetaData packageMetaData, Reusable reusable, QueryObjectProvider queryObjectProvider, QueryInterface query, QueryPart queryPart) {
		this.packageMetaData = packageMetaData;
		this.reusable = reusable;
		this.queryObjectProvider = queryObjectProvider;
		this.query = query;
		this.queryPart = queryPart;
	}
	
	public Reusable getReusable() {
		return reusable;
	}
	
	public QueryInterface getQuery() {
		return query;
	}

	@Override
	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
	
	public QueryObjectProvider getQueryObjectProvider() {
		return queryObjectProvider;
	}
	
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	public QueryPart getQueryPart() {
		return queryPart;
	}
	
	protected void processPossibleIncludes(EClass previousType, QueryPart queryPart) throws QueryException, BimserverDatabaseException {
		// Look for field in the previous query part, could be an opposite we want to set
		// TODO process "fields" as well
//		if (queryPart.has("field")) {
//			String fn = queryPart.get("field").asText();
//			EReference inverseOrOpposite = getPackageMetaData().getInverseOrOpposite(currentObject.eClass(), previousType.getEStructuralFeature(fn));
//			if (inverseOrOpposite != null) {
//				currentObject.addUseForSerialization(inverseOrOpposite);
//			}
//		}
		if (currentObject != null) {
			if (queryPart.hasIncludes()) {
				for (Include include : queryPart.getIncludes()) {
					processPossibleInclude(include);
				}
			} else if (queryPart.isIncludeAllFields()) {
				for (EReference eReference : currentObject.eClass().getEAllReferences()) {
					Include include = new Include();
					include.addType(currentObject.eClass());
					include.addField(eReference.getName());
					processPossibleInclude(include);
				}
			}
		}
	}

	protected void processPossibleInclude(Include include) throws QueryException, BimserverDatabaseException {
		if (include.hasTypes()) {
			for (EClass filterClass : include.getTypes()) {
				if (!filterClass.isSuperTypeOf(currentObject.eClass())) {
					System.out.println(filterClass.getName() + " / " + currentObject.eClass().getName());
					return;
				}
			}
		}
		if (include.hasFields()) {
			for (EStructuralFeature eStructuralFeature : include.getFields()) {
				currentObject.addUseForSerialization(eStructuralFeature);
			}
		}
		
		getQueryObjectProvider().push(new QueryIncludeStackFrame(getQueryObjectProvider(), getQuery(), getPackageMetaData(), getReusable(), include, currentObject, queryPart));
	}
	
	public GetResult getMap(EClass originalQueryClass, EClass eClass, ByteBuffer buffer, int keyPid, long keyOid, int keyRid, QueryInterface query) throws BimserverDatabaseException {
		if (keyPid == query.getPid()) {
			if (keyRid <= query.getRid() && keyRid >= query.getStopRid()) {
				if (!getQueryObjectProvider().hasRead(keyOid)) {
					if (buffer.capacity() == 1 && buffer.get(0) == -1) {
						buffer.position(buffer.position() + 1);
						return GetResult.CONTINUE_WITH_NEXT_OID;
						// deleted entity
					} else {
						 currentObject = convertByteArrayToObject(originalQueryClass, eClass, keyOid, buffer, keyRid, query);
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
	
	protected HashMapVirtualObject convertByteArrayToObject(EClass originalQueryClass, EClass eClass, long oid, ByteBuffer buffer, int rid, QueryInterface query) throws BimserverDatabaseException {
		try {
			HashMapVirtualObject idEObject = new HashMapVirtualObject(reusable, eClass);
			idEObject.setOid(oid);
			
			int unsettedLength = packageMetaData.getUnsettedLength(eClass);
			
			byte[] unsetted = new byte[unsettedLength];
			buffer.get(unsetted);
			
			int fieldCounter = 0;
			
			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
				try {
					if (packageMetaData.useForDatabaseStorage(eClass, feature)) {
						boolean isUnsetted = (unsetted[fieldCounter / 8] & (1 << (fieldCounter % 8))) != 0;
						if (isUnsetted) {
							if (feature.isUnsettable()) {
								idEObject.eUnset(feature);
							} else if (feature.isMany()) {
								// do nothing
							} else if (feature.getDefaultValue() != null) {
								idEObject.setAttribute(feature, feature.getDefaultValue());
							}
						} else {
							Object newValue = null;
							if (feature.isMany()) {
								newValue = readList(idEObject, originalQueryClass, buffer, query, feature);
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
									short cid = buffer.getShort();
									if (cid == -1) {
										// null, do nothing
									} else if (cid < 0) {
										// negative cid means value is embedded in
										// record
										EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass((short) (-cid));
										if (feature.getEAnnotation("dbembed") != null) {
											newValue = readEmbeddedValue(feature, buffer, referenceClass, query);
										} else {
											newValue = readWrappedValue(feature, buffer, referenceClass, query);
										}
									} else if (cid > 0) {
										// positive cid means value is reference to
										// other record
										EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass(cid);
										if (referenceClass == null) {
											throw new BimserverDatabaseException("No eClass found for cid " + cid);
										}
										newValue = readReference(originalQueryClass, buffer, feature, referenceClass, query);
										// if (eReference.getEOpposite() != null &&
										// ((IdEObjectImpl)
										// newValue).isLoadedOrLoading()) {
										// newValue = null;
										// }
									}
								} else if (feature.getEType() instanceof EDataType) {
									newValue = readPrimitiveValue(feature.getEType(), buffer, query);
								}
								if (newValue != null) {
									idEObject.setAttribute(feature, newValue);
								}
							}
						}
						fieldCounter++;
					}
				} catch (StringIndexOutOfBoundsException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "." + feature.getName(), e);
				} catch (BufferUnderflowException e) {
					throw new BimserverDatabaseException("Reading " + eClass.getName() + "." + feature.getName(), e);
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
	
	private long readReference(EClass originalQueryClass, ByteBuffer buffer, EStructuralFeature feature, EClass eClass, QueryInterface query) throws BimserverDatabaseException {
		if (buffer.capacity() == 1 && buffer.get(0) == -1) {
			buffer.position(buffer.position() + 1);
			return -1;
		}
		long oid = buffer.getLong();
		return oid;
	}

	private HashMapWrappedVirtualObject readWrappedValue(EStructuralFeature feature, ByteBuffer buffer, EClass eClass, QueryInterface query) throws BimserverDatabaseException {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("wrappedValue");
		Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer, query);
		HashMapWrappedVirtualObject eObject = new HashMapWrappedVirtualObject(reusable, eClass);
		eObject.setAttribute(eStructuralFeature, primitiveValue);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
			EStructuralFeature strFeature = eClass.getEStructuralFeature("wrappedValueAsString");
			Object stringVal = readPrimitiveValue(EcorePackage.eINSTANCE.getEString(), buffer, query);
			eObject.setAttribute(strFeature, stringVal);
		}
		return eObject;
	}

	private HashMapWrappedVirtualObject readEmbeddedValue(EStructuralFeature feature, ByteBuffer buffer, EClass eClass, QueryInterface query) throws BimserverDatabaseException {
		HashMapWrappedVirtualObject eObject = new HashMapWrappedVirtualObject(reusable, eClass);
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature.isMany()) {
				//
			} else {
				Object primitiveValue = readPrimitiveValue(eStructuralFeature.getEType(), buffer, query);
				eObject.setAttribute(eStructuralFeature, primitiveValue);
			}
		}
		return eObject;
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
	
	private Object readList(HashMapVirtualObject idEObject, EClass originalQueryClass, ByteBuffer buffer, QueryInterface query, EStructuralFeature feature) throws BimserverDatabaseException {
		if (feature.getEType() instanceof EEnum) {
		} else if (feature.getEType() instanceof EClass) {
			if (buffer.capacity() == 1 && buffer.get(0) == -1) {
				buffer.position(buffer.position() + 1);
			} else {
				int listSize = buffer.getInt();

				for (int i = 0; i < listSize; i++) {
					if (feature.getEAnnotation("twodimensionalarray") != null) {
						HashMapVirtualObject newObject = new HashMapVirtualObject(reusable, (EClass) feature.getEType());
						Object result = readList(newObject, originalQueryClass, buffer, query, newObject.eClass().getEStructuralFeature("List"));
						if (result != null) {
							newObject.setAttribute(newObject.eClass().getEStructuralFeature("List"), result);
						}
						idEObject.setListItem(feature, i, newObject);
					} else {
						short cid = buffer.getShort();
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
							idEObject.setListItem(feature, i, readWrappedValue(feature, buffer, referenceClass, query));
						} else if (cid > 0) {
							// positive cid means value is a
							// reference
							// to another record
							EClass referenceClass = queryObjectProvider.getDatabaseSession().getEClass(cid);
							if (referenceClass == null) {
								throw new BimserverDatabaseException("Cannot find class with cid " + cid);
							}
							idEObject.setListItemReference(feature, i, referenceClass, readReference(originalQueryClass, buffer, feature, referenceClass, query), -1);
						}
					}
				}
			}
		} else if (feature.getEType() instanceof EDataType) {
			int listSize = buffer.getInt();
			for (int i = 0; i < listSize; i++) {
				Object reference = readPrimitiveValue(feature.getEType(), buffer, query);
				if (reference != null) {
					idEObject.setListItem(feature, i, reference);
				}
			}
		}
		return null;
	}
	
	public HashMapVirtualObject getByOid(long oid) throws BimserverDatabaseException {
		EClass eClass = getQueryObjectProvider().getDatabaseSession().getEClassForOid(oid);
		ByteBuffer mustStartWith = ByteBuffer.wrap(new byte[12]);
		mustStartWith.putInt(query.getPid());
		mustStartWith.putLong(oid);
		ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[16]);
		startSearchWith.putInt(query.getPid());
		startSearchWith.putLong(oid);
		startSearchWith.putInt(-query.getRid());
	
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
			if (keyRid <= query.getRid()) {
				if (valueBuffer.capacity() == 1 && valueBuffer.get(0) == -1) {
					valueBuffer.position(valueBuffer.position() + 1);
					return null;
					// deleted entity
				} else {
					return convertByteArrayToObject(eClass, eClass, keyOid, valueBuffer, keyRid, query);
				}
			} else {
				return null;
			}
		} finally {
			recordIterator.close();
		}
	}
}
