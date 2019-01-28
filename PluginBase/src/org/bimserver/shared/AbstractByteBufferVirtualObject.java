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
import java.util.Date;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.google.common.base.Charsets;

public class AbstractByteBufferVirtualObject {
	protected ByteBuffer buffer;
	
	public AbstractByteBufferVirtualObject(int capacity) {
		this.buffer = ByteBuffer.allocate(capacity);
	}
	
	protected void ensureCapacity(int position, int sizeToAdd) {
		int currentPos = buffer.position();
		if (buffer.capacity() < position + sizeToAdd) {
			int newSize = Math.max(currentPos + sizeToAdd, buffer.capacity() * 2);
			ByteBuffer newBuffer = ByteBuffer.allocate(newSize);
			buffer.position(0);
			buffer.get(newBuffer.array(), 0, currentPos);
			buffer = newBuffer;
			buffer.position(currentPos);
		}
	}

	protected void writePrimitiveValue(EStructuralFeature feature, Object value) throws BimserverDatabaseException {
		EClassifier type = feature.getEType();
		if (type == EcorePackage.eINSTANCE.getEString()) {
			if (value == null) {
				ensureCapacity(buffer.position(), 4);
				buffer.putInt(-1);
			} else {
				String stringValue = (String) value;
				byte[] bytes = stringValue.getBytes(Charsets.UTF_8);
				if (bytes.length > Integer.MAX_VALUE) {
					throw new BimserverDatabaseException("String value too long (max length is " + Integer.MAX_VALUE + ")");
				}
				ensureCapacity(buffer.position(), 4 + bytes.length);
				buffer.putInt(bytes.length);
				buffer.put(bytes);
			}
		} else if (type == EcorePackage.eINSTANCE.getEInt() || type == EcorePackage.eINSTANCE.getEIntegerObject()) {
			ensureCapacity(buffer.position(), 4);
			if (value == null) {
				buffer.putInt(0);
			} else {
				buffer.putInt((Integer) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getEDouble() || type == EcorePackage.eINSTANCE.getEDoubleObject()) {
			ensureCapacity(buffer.position(), 8);
			if (value == null) {
				buffer.putDouble(0D);
			} else {
				buffer.putDouble((Double) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getEFloat() || type == EcorePackage.eINSTANCE.getEFloatObject()) {
			ensureCapacity(buffer.position(), 4);
			if (value == null) {
				buffer.putFloat(0F);
			} else {
				buffer.putFloat((Float) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getELong() || type == EcorePackage.eINSTANCE.getELongObject()) {
			ensureCapacity(buffer.position(), 8);
			if (value == null) {
				buffer.putLong(0L);
			} else {
				buffer.putLong((Long) value);
			}
		} else if (type == EcorePackage.eINSTANCE.getEBoolean() || type == EcorePackage.eINSTANCE.getEBooleanObject()) {
			ensureCapacity(buffer.position(), 1);
			if (value == null) {
				buffer.put((byte) 0);
			} else {
				buffer.put(((Boolean) value) ? (byte) 1 : (byte) 0);
			}
		} else if (type == EcorePackage.eINSTANCE.getEDate()) {
			ensureCapacity(buffer.position(), 8);
			if (value == null) {
				buffer.putLong(-1L);
			} else {
				buffer.putLong(((Date) value).getTime());
			}
		} else if (type.getName().equals("Tristate")) {
			ensureCapacity(buffer.position(), 4);
			if (value == null) {
				buffer.putInt(Tristate.UNDEFINED.getValue());
			} else {
				Enumerator eEnumLiteral = (Enumerator) value;
				buffer.putInt(eEnumLiteral.getValue());
			}
		} else if (value instanceof Enumerator) {
			ensureCapacity(buffer.position(), 4);
			Enumerator eEnumLiteral = (Enumerator) value;
			buffer.putInt(eEnumLiteral.getValue());
		} else if (type == EcorePackage.eINSTANCE.getEByteArray()) {
			if (value == null) {
				ensureCapacity(buffer.position(), 4);
				buffer.putInt(0);
			} else {
				byte[] bytes = (byte[]) value;
				ensureCapacity(buffer.position(), 4 + bytes.length);
				buffer.putInt(bytes.length);
				buffer.put(bytes);
			}
		} else {
			throw new RuntimeException("Unsupported type " + type.getName());
		}
	}
}
