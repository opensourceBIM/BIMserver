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

public class WaitingObject {
	// The object that has a missing reference
	private final EObject object;

	// The structural feature on which to 'connect' the object on
	private final EReference eReference;

	private long lineNumber;
	
	public WaitingObject(long lineNumber, EObject object, EReference eReference) {
		this.lineNumber = lineNumber;
		this.object = object;
		this.eReference = eReference;
	}

	public EObject getObject() {
		return object;
	}

	public EReference getEReference() {
		return eReference;
	}
	
	public long getLineNumber() {
		return lineNumber;
	}
	
	@Override
	public String toString() {
		return getObject() + " " + getEReference().getName();
	}
}