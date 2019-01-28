package org.bimserver.plugins;

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

import java.util.List;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class InverseFix {

	private EStructuralFeature eStructuralFeature;
	private IdEObject newObject;

	public InverseFix(EStructuralFeature eStructuralFeature, IdEObject newObject) {
		this.eStructuralFeature = eStructuralFeature;
		this.newObject = newObject;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void apply(IdEObject value) {
		if (eStructuralFeature.isMany()) {
			List list = (List)newObject.eGet(eStructuralFeature);
			list.add(value);
		} else {
			newObject.eSet(eStructuralFeature, value);
		}
	}
}
