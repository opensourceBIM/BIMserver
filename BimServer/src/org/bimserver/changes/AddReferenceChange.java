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
import org.eclipse.emf.ecore.EReference;

public class AddReferenceChange implements Change {

	private final long oid;
	private final String referenceName;
	private final long referenceOid;
	private final String className;
	private final String referenceClassName;

	public AddReferenceChange(long oid, String className, String referenceName, long referenceOid, String referenceClassName) {
		this.oid = oid;
		this.className = className;
		this.referenceName = referenceName;
		this.referenceOid = referenceOid;
		this.referenceClassName = referenceClassName;
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
		EReference eReference = bimDatabaseSession.getMetaDataManager().getEReference(className, referenceName);
		if (eReference == null) {
			throw new UserException("No reference with the name " + referenceName + " found in class " + className);
		}
		if (!eReference.isMany()) {
			throw new UserException("Reference is not of type 'many'");
		}
		IdEObject referencedObject = bimDatabaseSession.get(bimDatabaseSession.getEClassForName(referenceClassName), pid, rid, referenceOid, false, null);
		if (referencedObject == null) {
			throw new UserException("Referenced object of type " + referenceClassName + " with oid " + referenceOid + " not found");
		}
		List list = (List) idEObject.eGet(eReference);
		list.add(referencedObject);
		bimDatabaseSession.store(idEObject);
	}
}