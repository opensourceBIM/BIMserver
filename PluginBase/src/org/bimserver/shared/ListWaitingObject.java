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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/*
 * WaitingObject's are used when while reading, a reference is encountered that has not yet been
 * parsed. In that case a WaitingObject is created and stored in a map. As soon as the referenced
 * object get's parsed, all that object's waiting objects are connected to the original object.
 */
public class ListWaitingObject extends WaitingObject {

	// To keep an eventual order intact, for EList's you can store the index at which it should be placed
	private final int index;

	public ListWaitingObject(long lineNumber, EObject object, EReference eReference, int index) {
		super(lineNumber, object, eReference);
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
}