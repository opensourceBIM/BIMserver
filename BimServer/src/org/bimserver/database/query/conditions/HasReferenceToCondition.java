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
import org.eclipse.emf.ecore.EReference;

public class HasReferenceToCondition extends Condition {

	private final IdEObject referencingObject;
	private final EReference reference;

	public HasReferenceToCondition(EReference reference, IdEObject referencingObject) {
		this.reference = reference;
		this.referencingObject = referencingObject;
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
					// TODO Actually the first test should suffice (object id), the second should always return the same because caching of the objects should allow only 1 per database session
					if (eObject == referencingObject || ((IdEObject)eObject).getOid() == referencingObject.getOid()) {
						return true;
					}
				}
				return false;
			} else {
				return other == referencingObject;
			}
		}
		return false;
	}
}