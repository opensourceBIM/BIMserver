package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.util.List;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import nl.tue.buildingsmart.schema.Attribute;
import nl.tue.buildingsmart.schema.EntityDefinition;
import nl.tue.buildingsmart.schema.InverseAttribute;

public class RemoveReferenceChange implements Change {

	private final long oid;
	private final String referenceName;
	private final int index;
	private final long referencedOid;

	public RemoveReferenceChange(long oid, String referenceName, int index) {
		this.oid = oid;
		this.referenceName = referenceName;
		this.index = index;
		this.referencedOid = -1;
	}

	public RemoveReferenceChange(long oid, String referenceName, long referencedOid) {
		this.oid = oid;
		this.referenceName = referenceName;
		this.referencedOid = referencedOid;
		this.index = -1;
	}
	
	private IdEObject getReferencedObject(List<?> list) {
		if (index != -1) {
			return (IdEObject) list.get(index);
		} else if (referencedOid != -1) {
			for (Object ref : list) {
				if (((IdEObject)ref).getOid() == referencedOid) {
					return (IdEObject) ref;
				}
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(IfcModelInterface model, Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession, Map<Long, IdEObject> created, Map<Long, IdEObject> deleted) throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		PackageMetaData packageMetaData = databaseSession.getMetaDataManager().getPackageMetaData(project.getSchema());
		IdEObject idEObject = databaseSession.get(model, oid, new OldQuery(packageMetaData, project.getId(), concreteRevision.getId(), -1));
		EClass eClass = databaseSession.getEClassForOid(oid);
		if (idEObject == null) {
			idEObject = created.get(oid);
		}
		if (idEObject == null) {
			throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found in project with pid " + project.getId());
		}
		EReference eReference = packageMetaData.getEReference(eClass.getName(), referenceName);
		if (eReference == null) {
			throw new UserException("No reference with the name " + referenceName + " found in class " + eClass.getName());
		}
		if (!eReference.isMany()) {
			throw new UserException("Reference is not of type 'many'");
		}
		List list = (List) idEObject.eGet(eReference);
		EntityDefinition entityBN = packageMetaData.getSchemaDefinition().getEntityBN(idEObject.eClass().getName());
		Attribute attributeBNWithSuper = entityBN.getAttributeBNWithSuper(eReference.getName());
		EReference oppositeReference = eReference.getEOpposite();
		if (oppositeReference != null) {
			IdEObject referenced = getReferencedObject(list);
			if (oppositeReference.isMany()) {
				List oppositeList = (List)referenced.eGet(oppositeReference);
				oppositeList.remove(idEObject);
				((List)idEObject.eGet(eReference)).remove(referenced); // Opposites don't seem to work here, no clue why, let's just delete...
				databaseSession.store(referenced, project.getId(), concreteRevision.getId());
			} else {
				referenced.eSet(oppositeReference, null); // This will automatically remove the object from the list
				databaseSession.store(referenced, project.getId(), concreteRevision.getId());
			}
		} else {
			IdEObject referenced = getReferencedObject(list);
			if (attributeBNWithSuper instanceof InverseAttribute) {
				InverseAttribute inverse = (InverseAttribute) attributeBNWithSuper;
				EReference inverseReference = (EReference) referenced.eClass().getEStructuralFeature(inverse.getInverted_attr().getName());
				if (referenced instanceof List) {
					((List)referenced).remove(idEObject);
				} else {
					referenced.eUnset(inverseReference);
				}
				databaseSession.store(referenced, project.getId(), concreteRevision.getId());
			}
			if (index != -1) {
				list.remove(index);
			} else if (referencedOid != -1) {
				list.remove(referenced);
			}
		}
		databaseSession.store(idEObject, project.getId(), concreteRevision.getId());
	}
}