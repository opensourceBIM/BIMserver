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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

public class AttributeCondition extends Condition {
	private final EAttribute attribute;
	private final LiteralCondition literal;

	public AttributeCondition(EAttribute attribute, LiteralCondition literal) {
		this.attribute = attribute;
		this.literal = literal;
	}

	public EAttribute getAttribute() {
		return attribute;
	}

	public LiteralCondition getLiteral() {
		return literal;
	}

	@Override
	public void getEClassRequirements(Set<EClass> classRequirements) {
		EClass eClass = attribute.getEContainingClass();
		classRequirements.add(eClass);
		for (EClassifier subClass : eClass.getEPackage().getEClassifiers()) {
			if (subClass instanceof EClass && eClass.isSuperTypeOf((EClass) subClass)) {
				classRequirements.add((EClass) subClass);
			}
		}
	}

	@Override
	public boolean matches(EObject object) {
		if (!attribute.getEContainingClass().isSuperTypeOf(object.eClass())) {
			return false;
		} else {
			if (object.eGet(attribute) == null && literal.getValue() == null) {
				return true;
			}
			if (object.eGet(attribute) == null && literal.getValue() != null) {
				return false;
			}
			if (object.eGet(attribute) != null && literal.getValue() == null) {
				return false;
			}
			return object.eGet(attribute).equals(literal.getValue());
		}
	}
}