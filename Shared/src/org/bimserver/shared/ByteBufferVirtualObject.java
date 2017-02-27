package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ByteBufferVirtualObject extends AbstractByteBufferVirtualObject implements VirtualObject {
	private static final Logger LOGGER = LoggerFactory.getLogger(VirtualObject.class);
	private EClass eClass;
	private long oid;
	private QueryContext reusable;
	private int currentListStart = -1;
	private int currentListSize;
	private int featureCounter = 0;
	
	public ByteBufferVirtualObject(QueryContext reusable, EClass eClass, int capacity) {
		super(capacity);
		this.reusable = reusable;
		this.eClass = eClass;
		this.oid = reusable.getDatabaseInterface().newOid(eClass);

		int unsettedLength = reusable.getPackageMetaData().getUnsettedLength(eClass);
		buffer.put(new byte[unsettedLength]);
	}

	private boolean useUnsetBit(EStructuralFeature feature) {
		// TODO non-unsettable boolean values can also be stored in these bits
		if (feature.isUnsettable()) {
			return true;
		} else {
			if (feature.isMany()) {
				return true;
			}
			if (feature.getDefaultValue() == null || (feature.getDefaultValue() != null && feature.getDefaultValue() == null)) {
				return true;
			}
		}
		return false;
	}
	
	public void eUnset(EStructuralFeature feature) throws BimserverDatabaseException {
		if (useUnsetBit(feature)) {
			int pos = featureCounter / 8;
			byte b = buffer.get(pos);
			b |= (1 << (featureCounter % 8));
			buffer.put(pos, b);
		} else {
			if (feature instanceof EReference) {
				if (feature.isMany()) {
					ensureCapacity(buffer.position(), 4);
					buffer.putInt(0);
				} else {
					ensureCapacity(buffer.position(), 2);
					buffer.order(ByteOrder.LITTLE_ENDIAN);
					buffer.putShort((short)-1);
					buffer.order(ByteOrder.BIG_ENDIAN);
				}
			} else if (feature.getEType() instanceof EEnum) {
				writeEnum(feature, null);
			} else {
				writePrimitiveValue(feature, null);
			}
		}
		incrementFeatureCounter(feature);
	}

	public void setAttribute(EStructuralFeature feature, Object value) throws BimserverDatabaseException {
		if (feature.isMany()) {
			throw new UnsupportedOperationException("Feature isMany not supported by setAttribute");
		} else {
			if (feature.getEType() instanceof EEnum) {
				writeEnum(feature, value);
			} else if (feature.getEType() instanceof EClass) {
				if (value == null) {
					ensureCapacity(buffer.position(), 2);
					buffer.order(ByteOrder.LITTLE_ENDIAN);
					buffer.putShort((short) -1);
					buffer.order(ByteOrder.BIG_ENDIAN);
				} else if (value instanceof WrappedVirtualObject) {
					ByteBuffer otherBuffer = ((WrappedVirtualObject) value).write();
					ensureCapacity(buffer.position(), otherBuffer.position());
					buffer.put(otherBuffer.array(), 0, otherBuffer.position());
//					writeWrappedValue(getPid(), getRid(), (WrappedVirtualObject) value, getPackageMetaData());
				} else {
					throw new UnsupportedOperationException("??");
				}
			} else if (feature.getEType() instanceof EDataType) {
				writePrimitiveValue(feature, value);
			}
		}
		incrementFeatureCounter(feature);
	}

	private void incrementFeatureCounter(EStructuralFeature feature) {
		featureCounter++;
	}

	private void writeEnum(EStructuralFeature feature, Object value) {
		if (value == null) {
			ensureCapacity(buffer.position(), 4);
			buffer.putInt(-1);
		} else {
			EEnum eEnum = (EEnum) feature.getEType();
			EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteralByLiteral(((Enum<?>) value).toString());
			ensureCapacity(buffer.position(), 4);
			if (eEnumLiteral != null) {
				buffer.putInt(eEnumLiteral.getValue());
			} else {
				LOGGER.error(((Enum<?>) value).toString() + " not found");
				buffer.putInt(-1);
			}
		}
	}

	public Object eGet(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}
	
	public EClass eClass() {
		return eClass;
	}
	
	public long getOid() {
		return oid;
	}
	
	public ByteBuffer write() throws BimserverDatabaseException {
		EClass eClass = getDatabaseInterface().getEClassForOid(getOid());
		if (!eClass.isSuperTypeOf(eClass())) {
			throw new BimserverDatabaseException("Object with oid " + getOid() + " is a " + eClass().getName() + " but it's cid-part says it's a " + eClass.getName());
		}
		int nrFeatures = getPackageMetaData().getNrDatabaseFeatures(eClass);
		if (featureCounter > nrFeatures) {
			throw new BimserverDatabaseException("Too many features seem to have been set on " + this.eClass.getName() + " " + featureCounter + " / " + nrFeatures);
		} else if (featureCounter < nrFeatures) {
			throw new BimserverDatabaseException("Not all features seem to have been set on " + this.eClass.getName() + " " + featureCounter + " / " + nrFeatures);
		}
		
		return buffer;
//
//		if (buffer.position() != bufferSize) {
//			throw new BimserverDatabaseException("Value buffer sizes do not match for " + eClass().getName() + " " + buffer.position() + "/" + bufferSize);
//		}
//		return buffer;
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
	
//	private void writeWrappedValue(int pid, int rid, WrappedVirtualObject wrappedValue, PackageMetaData packageMetaData) throws BimserverDatabaseException {
//		EStructuralFeature eStructuralFeature = wrappedValue.eClass().getEStructuralFeature("wrappedValue");
//		Short cid = getDatabaseInterface().getCidOfEClass(wrappedValue.eClass());
//		ensureCapacity(buffer.position(), 2);
//		buffer.putShort((short) -cid);
//		writePrimitiveValue(eStructuralFeature, wrappedValue.getValue(eStructuralFeature));
//		if (wrappedValue.eClass().getName().equals("IfcGloballyUniqueId")) {
//			EClass eClass = packageMetaData.getEClass("IfcGloballyUniqueId");
//			if (wrappedValue.getOid() == -1) {
//				((VirtualObject) wrappedValue).setOid(getDatabaseInterface().newOid(eClass));
//			}
//			getDatabaseInterface().save(wrappedValue);
//		}
//	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}

	public void setListItem(EStructuralFeature feature, int index, Object value) throws BimserverDatabaseException {
		if (currentListStart == -1) {
			throw new BimserverDatabaseException("Not currently writing a list");
		}
		if (index + 1 > currentListSize) {
			currentListSize = index + 1;
		}
		if (value instanceof ByteBufferWrappedVirtualObject) {
			ByteBuffer otherBuffer = ((ByteBufferWrappedVirtualObject)value).write();
			ensureCapacity(buffer.position(), otherBuffer.position());
			buffer.put(otherBuffer.array(), 0, otherBuffer.position());
		} else {
			writePrimitiveValue(feature, value);
		}
	}
	
	public void setListItemReference(EStructuralFeature structuralFeature, int index, EClass referenceEClass, Long referencedOid, int bufferPosition) throws BimserverDatabaseException {
		int pos;
		if (bufferPosition == -1) {
			if (currentListStart == -1) {
				throw new BimserverDatabaseException("Not currently writing a list");
			}
			if (index + 1 > currentListSize) {
				currentListSize = index + 1;
			}
			pos = buffer.position();
		} else {
			pos = bufferPosition;
		}
		ensureCapacity(pos, 8);
		if (referencedOid < 0) {
			throw new BimserverDatabaseException("Writing a reference with oid " + referencedOid + ", this is not supposed to happen, referenced: " + referencedOid + " " + referencedOid + " from " + getOid() + " " + this);
		}
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putLong(pos, referencedOid);
		buffer.order(ByteOrder.BIG_ENDIAN);
		if (bufferPosition == -1) {
			buffer.position(buffer.position() + 8);
		}
	}

	public void save() throws BimserverDatabaseException {
		getDatabaseInterface().save(this);
	}

	@Override
	public int reserveSpaceForReference(EStructuralFeature feature) {
		int pos = buffer.position();
		ensureCapacity(pos, 8);
		buffer.putLong(-1);
		incrementFeatureCounter(feature);
		return pos;
	}

	@Override
	public int reserveSpaceForListReference() throws BimserverDatabaseException {
		if (currentListStart == -1) {
			throw new BimserverDatabaseException("Not currently writing a list");
		}
		currentListSize++;
		int position = buffer.position();
		ensureCapacity(position, 8);
		buffer.putLong(-1);
		return position;
	}

	@Override
	public void startList(EStructuralFeature feature) {
		ensureCapacity(buffer.position(), 4);
		buffer.putInt(0);
		currentListStart = buffer.position();
		currentListSize = 0;
		incrementFeatureCounter(feature);
	}

	public void endList() {
		buffer.putInt(currentListStart - 4, currentListSize);
		currentListStart = -1;
	}

	@Override
	public void setReference(EStructuralFeature feature, long referenceOid, int bufferPosition) throws BimserverDatabaseException {
		if (bufferPosition == -1) {
			incrementFeatureCounter(feature);
		}
		int pos = bufferPosition == -1 ? buffer.position() : bufferPosition;
		ensureCapacity(pos, 8);
		if (referenceOid < 0) {
			throw new BimserverDatabaseException("Writing a reference with oid " + referenceOid + ", this is not supposed to happen, referenced: " + referenceOid + " " + referenceOid + " from " + getOid() + " " + this);
		}
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putLong(pos, referenceOid);
		buffer.order(ByteOrder.BIG_ENDIAN);
		if (bufferPosition == -1) {
			buffer.position(buffer.position() + 8);
		}
	}

	@Override
	public boolean useFeatureForSerialization(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object get(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(String name, Object value) throws BimserverDatabaseException {
		setAttribute(eClass.getEStructuralFeature(name), value);
	}

	@Override
	public boolean has(String string) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean useFeatureForSerialization(EStructuralFeature feature, int index) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return "ByteBufferVirtualObject/" + eClass.getName();
	}
}