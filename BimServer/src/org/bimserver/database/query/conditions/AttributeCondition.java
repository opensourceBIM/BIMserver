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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

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
	public boolean matches(IdEObject object) {
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