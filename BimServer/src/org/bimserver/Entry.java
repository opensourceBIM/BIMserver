package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import org.eclipse.emf.ecore.InternalEObject;

public class Entry {
	protected EObject eObject;
	protected EStructuralFeature eStructuralFeature;

	public Entry(InternalEObject eObject, EStructuralFeature eStructuralFeature) {
		this.eObject = eObject;
		this.eStructuralFeature = eStructuralFeature;
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof Entry) {
			Entry entry = (Entry) that;
			return eObject == entry.eObject && eStructuralFeature == entry.eStructuralFeature;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return eObject.hashCode() ^ eStructuralFeature.hashCode();
	}
}