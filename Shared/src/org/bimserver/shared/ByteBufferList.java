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

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Ruben de Laat
 *
 *	Used for two-dimensional lists
 */
public class ByteBufferList extends AbstractByteBufferVirtualObject implements ListCapableVirtualObject {

	private int currentListStart = -1;
	private int currentListSize;
	private int featureCounter;
	private EClass eClass;
	private QueryContext reusable;
	
	public ByteBufferList(QueryContext reusable, EClass eClass) {
		super(2);
		this.reusable = reusable;
		this.eClass = eClass;
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort((short) -reusable.getDatabaseInterface().getCidOfEClass(eClass));
		buffer.order(ByteOrder.BIG_ENDIAN);
	}

	private void incrementFeatureCounter(EStructuralFeature feature) {
		featureCounter++;
	}
	
	@Override
	public void startList(EStructuralFeature feature) {
		ensureCapacity(buffer.position(), 4);
		buffer.putInt(0);
		currentListStart = buffer.position();
		currentListSize = 0;
		incrementFeatureCounter(feature);
	}

	@Override
	public void endList() {
		buffer.putInt(currentListStart - 4, currentListSize);
		currentListStart = -1;
	}

	@Override
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
			throw new BimserverDatabaseException("Writing a reference with oid " + referencedOid + ", this is not supposed to happen, referenced: " + referencedOid + " " + referencedOid + " " + this);
		}
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putLong(pos, referencedOid);
		buffer.order(ByteOrder.BIG_ENDIAN);
		if (bufferPosition == -1) {
			buffer.position(buffer.position() + 8);
		}
	}

	public EClass eClass() {
		return eClass;
	}

	public ByteBuffer write() {
		return buffer;
	}

	public int size() {
		return buffer.position();
	}
}