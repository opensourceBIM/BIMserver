package org.bimserver.shared;

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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.CannotStoreReferenceInFieldException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class HashMapVirtualObject extends AbstractHashMapVirtualObject implements VirtualObject {
	private static final Logger LOGGER = LoggerFactory.getLogger(VirtualObject.class);
	private final Map<EStructuralFeature, Object> map = new HashMap<>();
	private EClass eClass;
	private long oid;
	private UUID uuid;
	private QueryContext reusable;
	private Map<EStructuralFeature, Object> useForSerializationFeatures = new HashMap<>();
	private HashMap<EReference, AbstractHashMapVirtualObject> directReferences;
	private HashMap<EReference, Set<HashMapVirtualObject>> directListReferences;

	public HashMapVirtualObject(QueryContext reusable, EClass eClass) {
		this.reusable = reusable;
		this.eClass = eClass;
		this.oid = reusable.getDatabaseInterface().newOid(eClass);
		this.uuid = reusable.getDatabaseInterface().newUuid();
	}

	public HashMapVirtualObject(QueryContext reusable, EClass eClass, long oid, UUID uuid) {
		this.reusable = reusable;
		this.eClass = eClass;
		this.oid = oid;
		this.uuid = uuid;
	}
	
	public void prepareForCopy(QueryContext queryContext) {
		this.reusable = queryContext;
	}

	public long generateNewOid() {
		this.oid = reusable.getDatabaseInterface().newOid(eClass);
		return this.oid;
	}
	
	public void eUnset(EStructuralFeature feature) {
		map.remove(feature);
	}
	
	public QueryContext getReusable() {
		return reusable;
	}

	public void setAttribute(EAttribute eAttribute, Object val) {
		map.put(eAttribute, val);
	}

	public Object eGet(EStructuralFeature feature) {
		return map.get(feature);
	}

	public Object get(String featureName) {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(featureName);
		return map.get(eStructuralFeature);
	}
	
	public boolean eIsSet(EStructuralFeature feature) {
		return map.containsKey(feature);
	}
	
	public EClass eClass() {
		return eClass;
	}
	
	private int getWrappedValueSize(Object val, EReference eReference) {
		if (val == null) {
			return 2;
		}
		if (val instanceof VirtualObject) {
			VirtualObject eObject = (VirtualObject) val;
			if (eReference.getEAnnotation("twodimensionalarray") != null) {
				int refSize = 6;
				EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature("List");
				List<?> l = (List<?>)eObject.eGet(eStructuralFeature);
				for (Object o : l) {
					if (o instanceof VirtualObject) {
						refSize += 8;
					} else if (o instanceof WrappedVirtualObject) {
						refSize += ((WrappedVirtualObject)o).getSize();
					} else {
						refSize += getPrimitiveSize((EDataType) eStructuralFeature.getEType(), o);
					}
				}
				return refSize;
			} else if (eObject.eClass().getEAnnotation("wrapped") != null) {
				VirtualObject wrappedValue = (VirtualObject) val;
				EStructuralFeature wrappedValueFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
				Object wrappedVal = eObject.eGet(wrappedValueFeature);
				return 2 + getPrimitiveSize((EDataType) wrappedValueFeature.getEType(), wrappedVal);
			} else {
				return 8;
			}
		} else if (val instanceof WrappedVirtualObject) {
			WrappedVirtualObject wrappedVirtualObject = (WrappedVirtualObject)val;
			return wrappedVirtualObject.getSize();
		} else if (val instanceof Long) {
			return 8;
		} else {
			throw new RuntimeException("Programming error, should not happen " + val);
		}
	}

	private int getExactSize(VirtualObject virtualObject) {
		int size = 16;
		int lastSize = 0;

		for (EStructuralFeature eStructuralFeature : eClass().getEAllStructuralFeatures()) {
			if (getPackageMetaData().useForDatabaseStorage(eClass, eStructuralFeature)) {
				if (!useUnsetBit(eStructuralFeature)) {
					Object val = eGet(eStructuralFeature);
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
								size += getWrappedValueSize(v, eReference);
							}
						} else {
							size += getWrappedValueSize(val, eReference);
						}
					}
					lastSize = size;
				}
			}
		}

		size += getPackageMetaData().getUnsettedLength(eClass);

		return size;
	}
	
	private boolean useUnsetBit(EStructuralFeature feature) {
		// TODO non-unsettable boolean values can also be stored in these bits
		Object value = eGet(feature);
		if (feature.isUnsettable()) {
			if (!eIsSet(feature)) {
				return true;
			}
		} else {
			if (feature.isMany() && (value == null || ((List<?>)value).isEmpty())) {
				return true;
			}
			if (feature.getDefaultValue() == value || (feature.getDefaultValue() != null && feature.getDefaultValue().equals(value))) {
				return true;
			}
		}
		return false;
	}

	public long getOid() {
		return oid;
	}
	
	public ByteBuffer write() throws BimserverDatabaseException {
		int bufferSize = getExactSize(this);
		ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
		byte[] unsetted = new byte[getPackageMetaData().getUnsettedLength(eClass)];
		int fieldCounter = 0;
		for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {
			if (getPackageMetaData().useForDatabaseStorage(eClass, feature)) {
				if (useUnsetBit(feature)) {
					unsetted[fieldCounter / 8] |= (1 << (fieldCounter % 8));
				}
				fieldCounter++;
			}
		}
		buffer.put(unsetted);
		
		EClass eClass = getDatabaseInterface().getEClassForOid(getOid());
		if (!eClass.isSuperTypeOf(eClass())) {
			throw new BimserverDatabaseException("Object with oid " + getOid() + " is a " + eClass().getName() + " but it's cid-part says it's a " + eClass.getName());
		}

		buffer.putLong(getUuid().getMostSignificantBits());
		buffer.putLong(getUuid().getLeastSignificantBits());
		
		for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {
			if (getPackageMetaData().useForDatabaseStorage(eClass, feature)) {
				if (!useUnsetBit(feature)) {
					if (feature.isMany()) {
						writeList(this, buffer, getPackageMetaData(), feature);
					} else {
						Object value = eGet(feature);
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
							} else if (value instanceof VirtualObject) {
								writeWrappedValue(getPid(), getRid(), (VirtualObject) value, buffer, getPackageMetaData());
							} else if (value instanceof WrappedVirtualObject) {
								writeWrappedValue(getPid(), getRid(), (WrappedVirtualObject) value, buffer, getPackageMetaData());
							} else {
								long referencedOid = (Long)value;
								writeReference(referencedOid, buffer, feature);
							}
						} else if (feature.getEType() instanceof EDataType) {
							writePrimitiveValue(feature, value, buffer);
						}
					}
				}
			}
		}
		if (buffer.position() != bufferSize) {
			throw new BimserverDatabaseException("Value buffer sizes do not match for " + eClass().getName() + " " + buffer.position() + "/" + bufferSize);
		}
		return buffer;
	}
	
	private PackageMetaData getPackageMetaData() {
		return reusable.getPackageMetaData();
	}

	private DatabaseInterface getDatabaseInterface() {
		return reusable.getDatabaseInterface();
	}

	public int getPid() {
		return reusable.getPid();
	}
	
	public int getRid() {
		return reusable.getRid();
	}
	
	private void writeWrappedValue(int pid, int rid, VirtualObject wrappedValue, ByteBuffer buffer, PackageMetaData packageMetaData) throws BimserverDatabaseException {
		EStructuralFeature eStructuralFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
		if (eStructuralFeature == null) {
			throw new BimserverDatabaseException("No wrappedValue on " + wrappedValue.eClass().getName());
		}
		Short cid = getDatabaseInterface().getCidOfEClass(wrappedValue.eClass());
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) -cid);
		buffer.order(ByteOrder.BIG_ENDIAN);
		writePrimitiveValue(eStructuralFeature, wrappedValue.eGet(eStructuralFeature), buffer);
		if (wrappedValue.eClass().getName().equals("IfcGloballyUniqueId")) {
			EClass eClass = packageMetaData.getEClass("IfcGloballyUniqueId");
			if (wrappedValue.getOid() == -1) {
				((VirtualObject) wrappedValue).setOid(getDatabaseInterface().newOid(eClass));
			}
			getDatabaseInterface().save(wrappedValue);
		}
	}

	private void writeWrappedValue(int pid, int rid, WrappedVirtualObject wrappedValue, ByteBuffer buffer, PackageMetaData packageMetaData) throws BimserverDatabaseException {
		Short cid = getDatabaseInterface().getCidOfEClass(wrappedValue.eClass());
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) -cid);
		buffer.order(ByteOrder.BIG_ENDIAN);
		for (EStructuralFeature eStructuralFeature : wrappedValue.eClass().getEAllStructuralFeatures()) {
			Object val = wrappedValue.eGet(eStructuralFeature);
			if (eStructuralFeature.isMany()) {
				List list = (List)val;
				buffer.putInt(list.size());
				for (Object o : list) {
					if (o instanceof HashMapWrappedVirtualObject) {
						writeWrappedValue(pid, rid, (VirtualObject) o, buffer, packageMetaData);
					}
				}
			} else {
				if (eStructuralFeature.getEType() instanceof EDataType) {
					writePrimitiveValue(eStructuralFeature, val, buffer);
				} else {
					writeWrappedValue(pid, rid, (HashMapWrappedVirtualObject) val, buffer, packageMetaData);
				}
			}
		}
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}

	private void writeReference(long referenceOid, ByteBuffer buffer, EStructuralFeature feature) throws BimserverDatabaseException {
		if (referenceOid < 0) {
			throw new BimserverDatabaseException("Writing a reference with oid " + referenceOid + ", this is not supposed to happen, referenced: " + referenceOid + " " + referenceOid + " from " + getOid() + " " + this);
		}
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putLong(referenceOid);
		buffer.order(ByteOrder.BIG_ENDIAN);
	}

	@SuppressWarnings("rawtypes")
	private void writeList(VirtualObject virtualObject, ByteBuffer buffer, PackageMetaData packageMetaData, EStructuralFeature feature) throws BimserverDatabaseException {
		if (feature.getEType() instanceof EEnum) {
			// Aggregate relations to enums never occur... at this
			// moment
		} else if (feature.getEType() instanceof EClass) {
			List list = (List) virtualObject.eGet(feature);
			buffer.putInt(list.size());
			for (Object o : list) {
				if (o == null) {
					buffer.order(ByteOrder.LITTLE_ENDIAN);
					buffer.putShort((short) -1);
					buffer.order(ByteOrder.BIG_ENDIAN);
				} else {
					if (o instanceof VirtualObject) {
						VirtualObject listObject = (VirtualObject)o;
						if (feature.getEAnnotation("twodimensionalarray") != null) {
							Short cid = getDatabaseInterface().getCidOfEClass((EClass) feature.getEType());
							
							buffer.order(ByteOrder.LITTLE_ENDIAN);
							buffer.putShort((short) -cid);
							buffer.order(ByteOrder.BIG_ENDIAN);
							
							EStructuralFeature lf = listObject.eClass().getEStructuralFeature("List");
							writeList(listObject, buffer, packageMetaData, lf);
						} else {
							if (listObject.eClass().getEAnnotation("wrapped") != null || listObject.eClass().getEStructuralFeature("wrappedValue") != null) {
								writeWrappedValue(getPid(), getRid(), listObject, buffer, packageMetaData);
							}
						}
					} else if (o instanceof Long){
						long listObjectOid = (Long) o;
						writeReference(listObjectOid, buffer, feature);
					} else if (o instanceof HashMapWrappedVirtualObject) {
						HashMapWrappedVirtualObject hashMapWrappedVirtualObject = (HashMapWrappedVirtualObject)o;
						writeWrappedValue(-1, -1, hashMapWrappedVirtualObject, buffer, packageMetaData);
					}
				}
			}
		} else if (feature.getEType() instanceof EDataType) {
			List list = (List) virtualObject.eGet(feature);
			if (list == null) {
				buffer.putInt(-1);
			} else {
				buffer.putInt(list.size());
				for (Object o : list) {
					writePrimitiveValue(feature, o, buffer);
				}
			}
		}
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
		} else if (type == EcorePackage.eINSTANCE.getEShort() || type == EcorePackage.eINSTANCE.getEShortObject()) {
			if (value == null) {
				buffer.putShort((short) 0);
			} else {
				buffer.putShort((Short) value);
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
			if (value == null) {
				buffer.putInt(Tristate.UNDEFINED.getValue());
			} else {
				Enumerator eEnumLiteral = (Enumerator) value;
				buffer.putInt(eEnumLiteral.getValue());
			}
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setListItem(EStructuralFeature structuralFeature, int index, Object value) {
		List list = getOrCreateList(structuralFeature, index + 1);
		list.set(index, value);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addListItem(EStructuralFeature structuralFeature, Object value) {
		List list = getOrCreateList(structuralFeature, 0);
		list.add(value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setListItemReference(EStructuralFeature structuralFeature, int index, EClass referenceEClass, Long referencedOid, int bufferPosition) {
		List list = getOrCreateList(structuralFeature, index + 1);
		list.set(index, referencedOid);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List getOrCreateList(EStructuralFeature structuralFeature, int minSize) {
		List list = (List<?>) map.get(structuralFeature);
		if (list == null) {
			list = new ArrayList(minSize == -1 ? 0 : minSize);
			map.put(structuralFeature, list);
		}
		while (list.size() < minSize) {
			list.add(null);
		}
		return list;
	}

	public void save() throws BimserverDatabaseException {
		getDatabaseInterface().save(this);
	}

	@Override
	public int reserveSpaceForReference(EStructuralFeature feature) {
		// Not relevant for HashMap based implementation
		return -1;
	}

	@Override
	public int reserveSpaceForListReference() {
		// Not relevant for HashMap based implementation
		return -1;
	}
	
	@Override
	public void startList(EStructuralFeature feature) {
		// Not relevant for HashMap based implementation		
	}

	@Override
	public void setReference(EReference eReference, long referenceOid, int bufferPosition) throws BimserverDatabaseException {
		EClass definedType = (EClass)eReference.getEType();
		EClass referencedEClass = getDatabaseInterface().getEClassForOid(referenceOid);
		if (!definedType.isSuperTypeOf(referencedEClass)) {
			throw new CannotStoreReferenceInFieldException(DeserializerErrorCode.REFERENCED_OBJECT_CANNOT_BE_STORED_IN_THIS_FIELD, "Cannot store a " + referencedEClass.getName() + " in " + eClass().getName() + "." + eReference.getName() + " of type " + definedType.getName());
		}
		map.put(eReference, referenceOid);
	}

	@Override
	public void setReference(EReference eReference, long referenceOid) throws BimserverDatabaseException {
		this.setReference(eReference, referenceOid, -1);
	}

	@Override
	public void setReference(EReference eReference, WrappedVirtualObject wrappedVirtualObject) throws BimserverDatabaseException {
		EClass definedType = (EClass)eReference.getEType();
		EClass referencedEClass = wrappedVirtualObject.eClass();
		if (!definedType.isSuperTypeOf(referencedEClass)) {
			throw new CannotStoreReferenceInFieldException(DeserializerErrorCode.REFERENCED_OBJECT_CANNOT_BE_STORED_IN_THIS_FIELD, "Cannot store a " + referencedEClass.getName() + " in " + eClass().getName() + "." + eReference.getName() + " of type " + definedType.getName());
		}
		map.put(eReference, wrappedVirtualObject);
	}

	@Override
	public void endList() {
		// Not relevant for HashMap based implementation		
	}

	public long getRoid() {
		return reusable.getRoid();
	}

	public long getCroid() {
		return reusable.getCroid();
	}

	public boolean has(String key) {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(key);
		return map.containsKey(eStructuralFeature) && map.get(eStructuralFeature) != null;
	}

	@SuppressWarnings("unchecked")
	public boolean useFeatureForSerialization(EStructuralFeature feature, int index) {
		if (feature instanceof EAttribute) {
			return true;
		}
		if (useForSerializationFeatures.containsKey(feature)) {
			Object object = useForSerializationFeatures.get(feature);
			if (object instanceof Set) {
				Set<Integer> set = (Set<Integer>) object;
				if (set.contains(index)) {
					return true;
				}
			} else {
				return object == Boolean.TRUE;
			}
		}
		return false;
	}
	
	public boolean useFeatureForSerialization(EStructuralFeature feature) {
		if (feature instanceof EAttribute) {
			return true;
		}
		return useForSerializationFeatures.containsKey(feature);
	}

	public void addUseForSerialization(EStructuralFeature eStructuralFeature) {
		if (eStructuralFeature.getEContainingClass().isSuperTypeOf(eClass)) {
			useForSerializationFeatures.put(eStructuralFeature, true);
		} else {
			throw new IllegalArgumentException(eStructuralFeature.getName() + " does not exist in " + eClass.getName());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addUseForSerialization(EStructuralFeature eStructuralFeature, int index) {
		if (eStructuralFeature.getEContainingClass().isSuperTypeOf(eClass)) {
			Set<Object> set = (Set<Object>) useForSerializationFeatures.get(eStructuralFeature);
			if (set == null) {
				set = new HashSet<>();
				useForSerializationFeatures.put(eStructuralFeature, set);
			}
			set.add(index);
		} else {
			throw new IllegalArgumentException(eStructuralFeature.getName() + " does not exist in " + eClass.getName());
		}
	}

	public void saveOverwrite() throws BimserverDatabaseException {
		getDatabaseInterface().saveOverwrite(this);
	}

	@Override
	public void set(String name, Object val) throws BimserverDatabaseException {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(name);
		if (eStructuralFeature instanceof EAttribute) {
			setAttribute((EAttribute) eStructuralFeature, val);
		} else {
			if (val instanceof Long) {
				setReference((EReference) eStructuralFeature, (Long)val);
			} else {
				setReference((EReference) eStructuralFeature, (WrappedVirtualObject)val);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(eClass.getName() + " " + getOid() + "\n");
		for (EStructuralFeature eStructuralFeature : map.keySet()) {
			sb.append("\t" + eStructuralFeature.getName() + ": " + map.get(eStructuralFeature) + "\n");
		}
		return sb.toString();
	}

	public void setDirectReference(EReference feature2, AbstractHashMapVirtualObject byOid) {
		if (directReferences == null) {
			directReferences = new HashMap<>();
		}
		directReferences.put(feature2, byOid);
	}

	public int addDirectListReference(EReference feature2, HashMapVirtualObject byOid) {
		if (directListReferences == null) {
			directListReferences = new HashMap<>();
		}
		Set<HashMapVirtualObject> set = directListReferences.get(feature2);
		if (set == null) {
			set = new HashSet<>();
			directListReferences.put(feature2, set);
		}
		set.add(byOid);
		return set.size() - 1;
	}

	public AbstractHashMapVirtualObject getDirectFeature(EStructuralFeature representationFeature) {
		if (directReferences == null) {
			return null;
		}
		return directReferences.get(representationFeature);
	}

	public Set<HashMapVirtualObject> getDirectListFeature(EStructuralFeature representationFeature) {
		if (directListReferences == null) {
			return null;
		}
		return directListReferences.get(representationFeature);
	}

	public void addReference(EReference eReference, EClass eClassForOid, long referencedOid) {
		List<Long> list = getOrCreateList(eReference, 0);
		list.add(referencedOid);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
