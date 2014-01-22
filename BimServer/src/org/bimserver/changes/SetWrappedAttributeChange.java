package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class SetWrappedAttributeChange implements Change {

	private Long oid;
	private String attributeName;
	private String type;
	private Object value;

	public SetWrappedAttributeChange(Long oid, String attributeName, String type, Object value) {
		this.oid = oid;
		this.attributeName = attributeName;
		this.type = type;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(IfcModelInterface model, Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession, Map<Long, IdEObject> created, Map<Long, IdEObject> deleted) throws UserException, BimserverLockConflictException,
			BimserverDatabaseException {
		IdEObject idEObject = databaseSession.get(model, oid, new Query(project.getId(), concreteRevision.getId()));
		EClass eClass = databaseSession.getEClassForOid(oid);
		if (idEObject == null) {
			idEObject = created.get(oid);
		}
		if (idEObject == null) {
			throw new UserException("No object of type \"" + eClass.getName() + "\" with oid " + oid + " found in project with pid " + project.getId());
		}
		EReference eReference = databaseSession.getMetaDataManager().getEReference(eClass.getName(), attributeName);
		if (eReference == null) {
			throw new UserException("No reference with the name \"" + attributeName + "\" found in class \"" + eClass.getName() + "\"");
		}
		if (value instanceof List && eReference.isMany()) {
			List sourceList = (List)value;
			if (!eReference.isMany()) {
				throw new UserException("Attribute is not of type 'many'");
			}
			List list = (List)idEObject.eGet(eReference);
			for (Object o : sourceList) {
				if (eReference.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
					List asStringList = (List)idEObject.eGet(idEObject.eClass().getEStructuralFeature(attributeName + "AsString"));
					asStringList.add(String.valueOf(o));
				}
				list.add(o);
			}
			databaseSession.store(idEObject, project.getId(), concreteRevision.getId());
		} else {
			if (eReference.isMany()) {
				throw new UserException("Attribute is not of type 'single'");
			}
			if (eReference.getEType() instanceof EEnum) {
				EEnum eEnum = (EEnum) eReference.getEType();
				idEObject.eSet(eReference, eEnum.getEEnumLiteral(((String) value).toUpperCase()).getInstance());
			} else {
				EClass typeEClass = (EClass) databaseSession.getMetaDataManager().getEClassifier(type);
				if (typeEClass.getEAnnotation("wrapped") == null) {
					throw new UserException("Not a wrapped type");
				}
				EObject wrappedObject = databaseSession.create(typeEClass);
				wrappedObject.eSet(wrappedObject.eClass().getEStructuralFeature("wrappedValue"), value);
				idEObject.eSet(eReference, wrappedObject);
			}
//			if (value instanceof Double) {
//				idEObject.eSet(idEObject.eClass().getEStructuralFeature(attributeName + "AsString"), String.valueOf((Double)value));
//			}
			databaseSession.store(idEObject, project.getId(), concreteRevision.getId());
		}
	}
}
