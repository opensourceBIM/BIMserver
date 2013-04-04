package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class SetReferenceChange implements Change {

	private final long oid;
	private final String referenceName;
	private final long referenceOid;

	public SetReferenceChange(long oid, String referenceName, long referenceOid) {
		this.oid = oid;
		this.referenceName = referenceName;
		this.referenceOid = referenceOid;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession, Map<Long, IdEObject> created) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		IdEObject idEObject = databaseSession.get(oid, new Query(project.getId(), concreteRevision.getId()));
		EClass eClass = databaseSession.getEClassForOid(oid);
		if (idEObject == null) {
			idEObject = created.get(oid);
		}
		if (idEObject == null) {
			throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found in project with pid " + project.getId());
		}
		EReference eReference = databaseSession.getMetaDataManager().getEReference(eClass.getName(), referenceName);
		if (eReference == null) {
			throw new UserException("No reference with the name " + referenceName + " found in class " + eClass.getName());
		}
		if (eReference.isMany()) {
			throw new UserException("Reference is not of type 'single'");
		}
		if (referenceOid == -1) {
			if (eReference.getEOpposite() != null && idEObject.eGet(eReference) != null) {
				// We should remove the opposite as well
				if (eReference.getEOpposite().isMany()) {
					IdEObject other = (IdEObject) idEObject.eGet(eReference);
					List list = (List)other.eGet(eReference.getEOpposite());
					list.remove(idEObject);
					databaseSession.store(other, project.getId(), concreteRevision.getId());
				} else {
					IdEObject other = (IdEObject) idEObject.eGet(eReference);
					other.eSet(eReference.getEOpposite(), null);
					databaseSession.store(other, project.getId(), concreteRevision.getId());
				}
			}
			idEObject.eSet(eReference, null);
		} else {
			EClass referenceEClass = databaseSession.getEClassForOid(referenceOid);
			IdEObject referencedObject = databaseSession.get(referenceOid, new Query(project.getId(), concreteRevision.getId()));
			if (referencedObject == null) {
				throw new UserException("Referenced object of type " + referenceEClass.getName() + " with oid " + referenceOid + " not found");
			}
			if (eReference.getEOpposite() != null) {
				if (eReference.getEOpposite().isMany()) {
					List list = (List)referencedObject.eGet(eReference.getEOpposite());
					list.add(idEObject);
					databaseSession.store(referencedObject, project.getId(), concreteRevision.getId());
				} else {
					referencedObject.eSet(eReference.getEOpposite(), idEObject);
					databaseSession.store(referencedObject, project.getId(), concreteRevision.getId());
				}
			}
			idEObject.eSet(eReference, referencedObject);
		}
		databaseSession.store(idEObject, project.getId(), concreteRevision.getId());
	}
}