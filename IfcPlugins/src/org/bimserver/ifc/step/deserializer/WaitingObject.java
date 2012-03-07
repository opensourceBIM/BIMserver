package org.bimserver.ifc.step.deserializer;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/*
 * WaitingObject's are used when while reading, a reference is encountered that has not yet been
 * parsed. In that case a WaitingObject is created and stored in a map. As soon as the referenced
 * object get's parsed, all that object's waiting objects are connected to the original object.
 */
public class WaitingObject {

	// The object that has a missing reference
	private final EObject object;

	// The structural feature (usually a reference) on which to 'connect' the object on
	private final EStructuralFeature structuralFeature;
	
	// To keep an eventual order intact, for EList's you can store the index at which it should be placed
	private final int index;

	public WaitingObject(EObject object, EStructuralFeature structuralFeature, int index) {
		this.object = object;
		this.structuralFeature = structuralFeature;
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	public EObject getObject() {
		return object;
	}

	public EStructuralFeature getStructuralFeature() {
		return structuralFeature;
	}
}