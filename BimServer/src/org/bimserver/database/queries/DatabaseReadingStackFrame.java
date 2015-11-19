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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EEnumImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class DatabaseReadingStackFrame extends StackFrame implements ObjectProvidingStackFrame {
	private PackageMetaData packageMetaData;
	private Reusable reusable;
	private QueryObjectProvider queryObjectProvider;
	private QueryInterface query;
	protected HashMapVirtualObject currentObject;
	private ObjectNode jsonQuery;

	public DatabaseReadingStackFrame(PackageMetaData packageMetaData, Reusable reusable, QueryObjectProvider queryObjectProvider, QueryInterface query, ObjectNode jsonQuery) {
		this.packageMetaData = packageMetaData;
		this.reusable = reusable;
		this.queryObjectProvider = queryObjectProvider;
		this.query = query;
		this.jsonQuery = jsonQuery;
	}
	
	public Reusable getReusable() {
		return reusable;
	}
	
	public ObjectNode getJsonQuery() {
		return jsonQuery;
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
	
	protected ObjectNode getRealInclude(JsonNode include) {
		if (include.isTextual()) {
			String includeName = include.asText();
			if (includeName.equals("all")) {
//				getQueryObjectProvider().push(new FollowAllReferencesStackFrame(getQueryObjectProvider(), getPackageMetaData(), getReusable(), getQuery(), getJsonQuery(), currentObject, include));
				setDone(true);
			} else if (queryObjectProvider.getFullQuery().has("defines")) {
				ObjectNode defines = (ObjectNode) queryObjectProvider.getFullQuery().get("defines");
				if (defines.has(includeName)) {
					ObjectNode definedInclude = (ObjectNode) defines.get(includeName);
					return definedInclude;
				}
			}
		} else if (include.isObject()) {
			return (ObjectNode) include;
		}
		return null;
	}
	
	protected void processPossibleIncludes(ObjectNode queryPart) throws QueryException, BimserverDatabaseException {
		if (currentObject != null) {
			if (queryPart.has("include")) {
				ObjectNode realInclude = getRealInclude(queryPart.get("include"));
				if (realInclude.has("inputType")) {
					EClass filterClass = getQueryObjectProvider().getDatabaseSession().getEClassForName(getPackageMetaData().getSchema().name().toLowerCase(), realInclude.get("inputType").asText());
					if (!filterClass.isSuperTypeOf(currentObject.eClass())) {
						return;
					}
				}
				getQueryObjectProvider().push(new QueryIncludeStackFrame(getQueryObjectProvider(), getQuery(), jsonQuery, getPackageMetaData(), getReusable(), realInclude, currentObject));
			} else if (queryPart.has("includes")) {
				ArrayNode includes = (ArrayNode) queryPart.get("includes");
				for (int i = 0; i < includes.size(); i++) {
					JsonNode localInclude = (JsonNode) includes.get(i);
					ObjectNode realInclude = getRealInclude(localInclude);
					if (realInclude.has("inputType")) {
						EClass filterClass = getQueryObjectProvider().getDatabaseSession().getEClassForName(getPackageMetaData().getSchema().name().toLowerCase(), realInclude.get("inputType").asText());
						if (!filterClass.isSuperTypeOf(currentObject.eClass())) {
							return;
						}
					}
					getQueryObjectProvider().push(new QueryIncludeStackFrame(getQueryObjectProvider(), getQuery(), jsonQuery, getPackageMetaData(), getReusable(), realInclude, currentObject));
				}
			}
		}
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
							if (!query.shouldFollowReference(originalQueryClass, eClass, feature)) {
								// we have to do some reading to maintain a correct
								// index
								queryObjectProvider.getDatabaseSession().fakeRead(buffer, feature);
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
