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

import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EClass;

public abstract class LiteralCondition extends Condition {
	public abstract Object getValue();

	@Override
	public void getEClassRequirements(Set<EClass> classRequirements) {
	}
	
	@Override
	public boolean matches(IdEObject object) {
		return false;
	}

	public static LiteralCondition from(Object value) {
		if (value instanceof String) {
			return new StringLiteral((String)value);
		}
		return null;
	}
}