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