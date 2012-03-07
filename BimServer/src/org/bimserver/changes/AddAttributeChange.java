package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.List;
import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EAttribute;

public class AddAttributeChange implements Change {

	private final long oid;
	private final String attributeName;
	private final Object value;
	private final String className;

	public AddAttributeChange(long oid, String className, String attributeName, Object value) {
		this.oid = oid;
		this.className = className;
		this.attributeName = attributeName;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(int pid, int rid, BimDatabaseSession bimDatabaseSession, Map<Long, IdEObject> created) throws UserException, BimDeadlockException, BimDatabaseException {
		IdEObject idEObject = bimDatabaseSession.get(bimDatabaseSession.getEClassForName(className), pid, rid, oid, false, null);
		if (idEObject == null) {
			idEObject = created.get(oid);
		}
		if (idEObject == null) {
			throw new UserException("No object of type " + className + " with oid " + oid + " found in project with pid " + pid);
		}
		EAttribute eAttribute = bimDatabaseSession.getMetaDataManager().getEAttribute(className, attributeName);
		if (eAttribute == null) {
			throw new UserException("No attribute with the name " + attributeName + " found in class " + className);
		}
		if (!eAttribute.isMany()) {
			throw new UserException("Attribute is not of type 'many'");
		}
		List list = (List) idEObject.eGet(eAttribute);
		list.add(value);
		bimDatabaseSession.store(idEObject);
	}
}