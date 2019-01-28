package org.bimserver.database.query.conditions;

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

import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class HasReferenceToInCondition extends Condition {

	private final EReference reference;
	private final Set<? extends EObject> referencingObjects;

	public HasReferenceToInCondition(EReference reference, Set<? extends EObject> referencingObjects) {
		this.reference = reference;
		this.referencingObjects = referencingObjects;
	}

	@Override
	public void getEClassRequirements(Set<EClass> classRequirements) {
		classRequirements.add(reference.getEContainingClass());
	}

	@Override
	public boolean matches(IdEObject object) {
		if (object.eClass().isSuperTypeOf(reference.getEContainingClass())) {
			Object other = object.eGet(reference);
			if (other instanceof EList<?>) {
				EList<?> list = (EList<?>)other;
				for (Object eObject : list) {
					if (referencingObjects.contains(eObject)) {
						return true;
					}
				}
				return false;
			} else {
				return referencingObjects.contains(other);
			}
		}
		return false;
	}
}