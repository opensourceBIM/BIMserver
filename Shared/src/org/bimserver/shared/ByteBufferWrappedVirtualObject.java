package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ByteBufferWrappedVirtualObject extends AbstractByteBufferVirtualObject implements WrappedVirtualObject {

	private EClass eClass;

	public ByteBufferWrappedVirtualObject(QueryContext reusable, EClass eClass) {
		super(10);
		this.eClass = eClass;
		buffer.putShort((short) -reusable.getDatabaseInterface().getCidOfEClass(eClass));
	}

	@Override
	public EClass eClass() {
		return eClass;
	}

	@Override
	public void setAttribute(EStructuralFeature eStructuralFeature, Object value) throws BimserverDatabaseException {
		writePrimitiveValue(eStructuralFeature, value);
	}

	public ByteBuffer write() throws BimserverDatabaseException {
		return buffer;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean useFeatureForSerialization(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(String name, Object value) throws BimserverDatabaseException {
		setAttribute(eClass.getEStructuralFeature(name), value);
	}

	@Override
	public int getSize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean useFeatureForSerialization(EStructuralFeature feature, int index) {
		// TODO Auto-generated method stub
		return false;
	}
}