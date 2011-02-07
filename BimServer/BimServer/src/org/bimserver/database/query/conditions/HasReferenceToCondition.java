package org.bimserver.database.query.conditions;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class HasReferenceToCondition extends Condition {

	private final EObject referencingObject;
	private final EReference reference;

	public HasReferenceToCondition(EReference reference, EObject referencingObject) {
		this.reference = reference;
		this.referencingObject = referencingObject;
	}

	@Override
	public void getEClassRequirements(Set<EClass> classRequirements) {
		classRequirements.add(reference.getEContainingClass());
	}

	@Override
	public boolean matches(EObject object) {
		if (object.eClass().isSuperTypeOf(reference.getEContainingClass())) {
			Object other = object.eGet(reference);
			if (other instanceof EList<?>) {
				EList<?> list = (EList<?>)other;
				for (Object eObject : list) {
					if (eObject == referencingObject) {
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