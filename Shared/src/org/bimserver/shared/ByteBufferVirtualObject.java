package org.bimserver.shared;

import java.nio.ByteBuffer;

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
	private Reusable reusable;
	private int currentListStart = -1;
	private int currentListSize;
	private int featureCounter = 0;
	
	public ByteBufferVirtualObject(Reusable reusable, EClass eClass, int capacity) {
		super(capacity);
		this.reusable = reusable;
		this.eClass = eClass;
		this.oid = reusable.getDatabaseInterface().newOid(eClass);

		int unsettedLength = (int) Math.ceil(eClass().getEAllStructuralFeatures().size() / 8.0);
		buffer.put((byte) unsettedLength);
		buffer.put(new byte[unsettedLength]);
	}

	public void eUnset(EStructuralFeature feature) throws BimserverDatabaseException {
		if (feature.isUnsettable()) {
			int pos = 1 + (featureCounter / 8);
			byte b = buffer.get(pos);
			b |= (1 << (featureCounter % 8));
			buffer.put(pos, b);
		} else {
			if (feature instanceof EReference) {
				ensureCapacity(buffer.position(), 2);
				buffer.putShort((short)-1);
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
					buffer.putShort((short) -1);
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
		int nrFeatures = getPackageMetaData().getNrSerializableFeatures(eClass);
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
		ensureCapacity(pos, 10);
		Short cid = getDatabaseInterface().getCidOfEClass(referenceEClass);
		buffer.putShort(pos, cid);
		if (referencedOid < 0) {
			throw new BimserverDatabaseException("Writing a reference with oid " + referencedOid + ", this is not supposed to happen, referenced: " + referencedOid + " " + referencedOid + " from " + getOid() + " " + this);
		}
		buffer.putLong(pos + 2, referencedOid);
		if (bufferPosition == -1) {
			buffer.position(buffer.position() + 10);
		}
	}

	public void save() throws BimserverDatabaseException {
		getDatabaseInterface().save(this);
	}

	@Override
	public int reserveSpaceForReference(EStructuralFeature feature) {
		int pos = buffer.position();
		ensureCapacity(pos, 10);
		buffer.putShort((short)-1);
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
		ensureCapacity(position, 10);
		buffer.putShort((short)-1);
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
		ensureCapacity(pos, 10);
		Short cid = getDatabaseInterface().getCidOfEClass(getDatabaseInterface().getEClassForOid((referenceOid)));
		buffer.putShort(pos, cid);
		if (referenceOid < 0) {
			throw new BimserverDatabaseException("Writing a reference with oid " + referenceOid + ", this is not supposed to happen, referenced: " + referenceOid + " " + referenceOid + " from " + getOid() + " " + this);
		}
		buffer.putLong(pos + 2, referenceOid);
		if (bufferPosition == -1) {
			buffer.position(buffer.position() + 10);
		}
	}
}