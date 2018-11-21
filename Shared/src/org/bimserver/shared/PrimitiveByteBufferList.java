package org.bimserver.shared;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;

public class PrimitiveByteBufferList extends AbstractByteBufferVirtualObject implements ListCapableVirtualObject {

	private QueryContext reusable;
	private EDataType eDataType;
	private int currentListStart = -1;
	private int currentListSize;
	private int featureCounter;
	
	public PrimitiveByteBufferList(QueryContext reusable, EDataType eDataType) {
		super(2);
		this.reusable = reusable;
		this.eDataType = eDataType;
	}

	@Override
	public void startList(EStructuralFeature structuralFeature) {
		ensureCapacity(buffer.position(), 4);
		buffer.putInt(0);
		currentListStart = buffer.position();
		currentListSize = 0;
		incrementFeatureCounter(structuralFeature);
	}

	private void incrementFeatureCounter(EStructuralFeature feature) {
		featureCounter++;
	}
	
	@Override
	public void endList() {
		buffer.putInt(currentListStart - 4, currentListSize);
		currentListStart = -1;
	}

	@Override
	public void setListItem(EStructuralFeature feature, int index, Object value)
			throws BimserverDatabaseException {
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

	@Override
	public int reserveSpaceForListReference() throws BimserverDatabaseException {
		return 0;
	}

	@Override
	public void setListItemReference(EStructuralFeature structuralFeature, int index, EClass referenceEClass,
			Long referencedOid, int i) throws BimserverDatabaseException {
		
	}
	
	public ByteBuffer write() {
		return buffer;
	}
}