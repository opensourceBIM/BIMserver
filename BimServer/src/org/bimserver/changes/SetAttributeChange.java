package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;

public class SetAttributeChange implements Change {

	private final long oid;
	private final String attributeName;
	private final Object value;
	private final String className;

	public SetAttributeChange(long oid, String className, String attributeName, Object value) {
		this.oid = oid;
		this.className = className;
		this.attributeName = attributeName;
		this.value = value;
	}

	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		IdEObject idEObject = bimDatabaseSession.get(bimDatabaseSession.getEClassForName(className), oid, false, null);
		if (idEObject == null) {
			throw new UserException("No object of type " + className + " found in project with pid " + pid);
		}
		EAttribute eAttribute = bimDatabaseSession.getMetaDataManager().getEAttribute(className, attributeName);
		if (eAttribute == null) {
			throw new UserException("No attribute with the name " + attributeName + " found in class " + className);
		}
		if (eAttribute.isMany()) {
			throw new UserException("Attribute is not of type 'single'");
		}
		if (eAttribute.getEType() instanceof EEnum) {
			EEnum eEnum = (EEnum) eAttribute.getEType();
			idEObject.eSet(eAttribute, eEnum.getEEnumLiteral((String) value).getInstance());
		} else {
			idEObject.eSet(eAttribute, value);
		}
		if (value instanceof Double) {
			idEObject.eSet(idEObject.eClass().getEStructuralFeature(attributeName + "AsString"), String.valueOf((Double)value));
		}
		bimDatabaseSession.store(idEObject);
	}
}