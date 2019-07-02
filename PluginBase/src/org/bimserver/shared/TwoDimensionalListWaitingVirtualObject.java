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

import org.eclipse.emf.ecore.EStructuralFeature;

/*
 * WaitingObject's are used when while reading, a reference is encountered that has not yet been
 * parsed. In that case a WaitingObject is created and stored in a map. As soon as the referenced
 * object get's parsed, all that object's waiting objects are connected to the original object.
 */
public class TwoDimensionalListWaitingVirtualObject extends ListWaitingVirtualObject {

	// To keep an eventual order intact, for EList's you can store the index at which it should be placed
	private final int index1;
	private int index2;
	private ListCapableVirtualObject object2;

	public TwoDimensionalListWaitingVirtualObject(long lineNumber, VirtualObject parentObject, ListCapableVirtualObject object, EStructuralFeature structuralFeature, int index1, int index2, int bufferPosition) {
		super(lineNumber, parentObject, structuralFeature, index1, bufferPosition);
		this.object2 = object;
		this.index1 = index1;
		this.index2 = index2;
	}
	
	public ListCapableVirtualObject getObject2() {
		return object2;
	}
	
	public int getIndex1() {
		return index1;
	}
	
	public int getIndex2() {
		return index2;
	}
	
	@Override
	public String toString() {
		return getLineNumber() + ": " + getObject() + " " + getStructuralFeature().getName() + " (index1: " + index1 + ", index2: " + index2 + ")";
	}
}